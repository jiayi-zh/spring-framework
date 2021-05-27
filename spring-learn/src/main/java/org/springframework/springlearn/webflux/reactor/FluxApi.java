package org.springframework.springlearn.webflux.reactor;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * {@link reactor.core.publisher.Flux} 使用
 * 创建
 * {@link Flux#just(Object[])}
 * {@link Flux#range(int, int)}         创建一个连续数值的序列, 从 start 开始, 递增 count 次
 * {@link Flux#empty()}                 创建一个不包含任何元素的 Flux
 * {@link Flux#error(Throwable)}        创建一个只包含错误消息的 Flux
 * {@link Flux#fromIterable(Iterable)}  从迭代器中创建 Flux
 * {@link Flux#fromStream(Stream)}
 * {@link Flux#fromArray(Object[])}
 * {@link Flux#merge(Publisher[])}
 * {@link Flux#interval(Duration)}
 * 监控与副作用 doOnXXX()
 * {@link Flux#doOnSubscribe(Consumer)}    用以监控onSubscribe()方法的执行
 * {@link Flux#doOnRequest(LongConsumer)}  对request行为监控产生副作用
 * <p>
 * {@link Flux#doOnEach(Consumer)}  	   监控每个元素对应的Signal对象
 * {@link Flux#doOnNext(Consumer)}         监控每个元素, 顺序在 doOnEach 之后, 在 subscribe 订阅者回调之前
 * <p>
 * {@link Flux#doOnError(Consumer)}        消费出现异常
 * {@link Flux#doOnComplete(Runnable)}     消费完成
 * {@link Flux#doOnCancel(Runnable)}       消费端抛出异常会回调这个方法
 * {@link Flux#doOnTerminate(Runnable)}    中止时触发
 * 错误处理 onError
 * {@link Flux#onErrorReturn(Predicate, Object)}    	出现错误直接返回默认值
 * {@link Flux#onErrorResume(Predicate, Function)}  	出现错误使用备用方案
 * {@link Flux#onErrorContinue(Predicate, BiConsumer)}  出现错误跳过错误, 使用原数据继续执行
 * {@link Flux#onErrorMap(Predicate, Function)}			替换错误内容
 * 背压
 * {@link org.reactivestreams.Subscriber}         实现背压最原生的方式
 * {@link reactor.core.publisher.BaseSubscriber}  封装了原生的方式，简化处理的逻辑
 * {@link Flux#limitRate(int)}                    恒定速率请求
 * {@link Flux#limitRate(int, int)}               初始请求数量、后续补充百分比
 *
 * {@link Flux#}
 *
 * @author ZhengYu
 * @version 1.0 2021/5/27 8:57
 **/
public class FluxApi {
	public static void main(String[] args) throws InterruptedException {
		// Flux 创建示例
		// api_createFlux();

		// doOnXXX Api 测试
		// Flux<Integer> flux1 = api_doOnXXX();
		// testMultipleThreadSubscribe(flux1);

		// OnError
		// testOnErrorXXX();

		testBackpressure();

		Thread.sleep(30000);
	}

	public static void api_createFlux() throws InterruptedException {
		Flux.just(new String[]{"Hello", "Flux"})
				.subscribe(
						str -> {
							if ("Flux".equals(str)) {
								throw new RuntimeException("抛出一个运行时异常");
							} else {
								print(str);
							}
						},
						Throwable::printStackTrace,
						() -> System.out.println("序列中的所有元素都成功消费才会执行"),
						subscription -> subscription.request(1) // 设定从源头获取只一个元素
				);
		Flux.range(100, 3).subscribe(FluxApi::print);

		Flux.interval(Duration.ofSeconds(1)).subscribe(FluxApi::print);

		Thread.sleep(5000);
	}

	public static Flux<Integer> api_doOnXXX() throws InterruptedException {
		return Flux.range(0, 10)
				.log()

				.doOnRequest(num -> print("doOnRequest" + num))
				.doOnSubscribe(subscription -> print(String.format("订阅时执行: %s", subscription.toString())))

				.doOnEach(integerSignal -> print("doOnEach" + integerSignal.get()))
				.doOnNext(num -> print("doOnNext" + num))

				.doOnError(e -> print("doOnError" + e.getMessage()))
				.doOnComplete(() -> print("doOnComplete"))
				.doOnCancel(() -> print("doOnCancel"))
				.doOnTerminate(() -> print("doOnTerminate"));
	}

	public static void testMultipleThreadSubscribe(Flux<Integer> flux) {
		// 开启两个线程去订阅
		// 线程1立即消费, 但消费速率慢
		// 线程2延迟消费, 消费速率较快
		// 结论: 两个线程都会消费完整的序列
		// 扩展: 在序列源上设置的doOnXXX()系列方法在消费端抛出异常时会调用doOnCancel()，其他方法都不会调用
		new Thread(() ->
				flux.subscribe(
						num -> {
							print("subscribe: " + num);
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// do nothing
							}

//							if (num == 9) {
//								throw new RuntimeException("抛出异常");
//							}
						},
						throwable -> {
							// do nothing
						},
						() -> {
							// do nothing
						},
						subscription -> subscription.request(10))
		).start();

		new Thread(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// do nothing
			}

			// do nothing
			flux.subscribe(
					num -> {
						print("subscribe: " + num);
						if (num == 2) {
							throw new RuntimeException("抛出异常");
						}
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// do nothing
						}
					},
					Throwable::printStackTrace,
					() -> {
						// do nothing
					},
					subscription -> subscription.request(10));
		}
		).start();
	}

	public static void testOnErrorXXX() throws InterruptedException {
		Flux.interval(Duration.ofMillis(100))
				.log()
				.map(i -> {
					if (i == 2) throw new RuntimeException("fake a mistake");
					return String.valueOf(100 / (i - 5));
				})
				.doOnError(e -> print(String.format("error 类型：%s， error 消息： %s", e.getClass().getSimpleName(), e.getMessage())))
				// 遇到error直接返回指定value， 错误类型判断可选
				.onErrorReturn(RuntimeException.class, "test on error return")
				.subscribe();
		Thread.sleep(5000);
	}

	public static void testBackpressure() {
		Flux
				.interval(Duration.ofSeconds(1))
				.log()
				.subscribe(new Subscriber<Long>() {

					private int count = 0;

					private Subscription subscription;

					private int requestCount = 2;

					private long latestTime = 0;

					@Override
					public void onSubscribe(Subscription s) {
						this.subscription = s;
						s.request(requestCount);
					}

					@Override
					public void onNext(Long num) {
						long current = System.currentTimeMillis();
						print(String.format("接收到: %d, 距离上次耗时: %d", num, latestTime == 0 ? 0 : current - latestTime));
						latestTime = current;
						count++;
						if (count == requestCount) {  // 通过count控制每次request两个元素
							try {
								Thread.sleep(4000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							subscription.request(requestCount);
							count = 0;
						}
					}

					@Override
					public void onError(Throwable t) {

					}

					@Override
					public void onComplete() {

					}
				});
	}

	private static void print(Object o) {
		System.out.printf("[%s - %s] --> %s%n", FluxApi.class.getSimpleName(), Thread.currentThread().getName(), o.toString());
	}
}

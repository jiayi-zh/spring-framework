package org.springframework.springlearn.webflux.reactor;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * 背压测试
 *
 * @author ZhengYu
 * @version 1.0 2021/5/27 22:17
 **/
public class BackPressureApi {
	public static void main(String[] args) throws InterruptedException {

//		testBackpressure();

		Flux
				.interval(Duration.ofSeconds(1))
				.log()
				.subscribe(new BaseSubscriber<Long>() {

					private int count = 0;
					private final int requestCount = 2;

					@Override
					protected void hookOnSubscribe(Subscription subscription) {
						request(requestCount);
					}

					@Override
					protected void hookOnNext(Long value) {
						count++;
						if (count == requestCount) {  // 通过count控制每次request两个元素
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							request(requestCount);
							count = 0;
						}
					}
				});

		Thread.sleep(30000);
	}

	public static void testBackpressure() {
		Flux
				.interval(Duration.ofSeconds(1))
				.log()
				.subscribe(new Subscriber<Long>() {

					private int count = 0;

					private Subscription subscription;

					private final int requestCount = 2;

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
		System.out.printf("[%s - %s] --> %s%n", BackPressureApi.class.getSimpleName(), Thread.currentThread().getName(), o.toString());
	}
}

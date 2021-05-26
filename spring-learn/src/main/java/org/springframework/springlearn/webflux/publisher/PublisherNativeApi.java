package org.springframework.springlearn.webflux.publisher;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * {@link reactor.core.publisher.Mono} 与 {@link reactor.core.publisher.Flux} 测试
 *
 * @author ZhengYu
 * @version 1.0 2021/4/28 15:19
 **/
public class PublisherNativeApi {

	private static final List<Integer> DATA_SOURCE = new ArrayList<>(10);

	private static final Flux<Integer> FLUX_PUBLISHER = Flux.fromStream(DATA_SOURCE.stream());

	public static void main(String[] args) {



		new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				DATA_SOURCE.add(i);
				if (i == 5) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();

		startConsumer();
	}

	private static void startConsumer() {
		new Thread(() -> FLUX_PUBLISHER.timeout(Duration.ofSeconds(6)).subscribe(
				// 消费者处理
				num -> {
					System.out.printf("Thread: %s - 接收到: %d%n", Thread.currentThread().getName(), num);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				},
				// 异常结束处理
				throwable -> System.out.printf("发布者出现异常, 原因: %s%n", throwable.getMessage())
				// 完成事件处理
				, () -> System.out.println("complete"))).start();
	}
}

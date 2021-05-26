package org.springframework.springlearn.webflux.reactor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

/**
 * {@link reactor.core.publisher.Mono} 使用
 * 创建
 * {@link Mono#just(Object)}      					  可以指定序列中包含的全部元素
 * {@link Mono#empty()}           					  创建一个不包含任何元素
 * {@link Mono#error(Throwable)}  					  创建一个只包含错误消息的序列
 * {@link Mono#fromCallable(Callable)}				  从 Callable 中创建 Mono
 * {@link Mono#fromCompletionStage(CompletionStage)}  从 CompletionStage 中创建 Mono
 * {@link Mono#fromFuture(CompletableFuture)}		  从 CompletableFuture 中创建 Mono
 * {@link Mono#fromRunnable(Runnable)}				  从 Runnable 中创建 Mono
 * {@link Mono#fromSupplier(Supplier)}				  从 Supplier 中创建 Mono
 * {@link Mono#delay(Duration)}						  创建一个 Mono 序列，在指定的延迟时间之后，产生数字 0 作为唯一值
 * {@link Mono#ignoreElements(Publisher)}			  创建一个 Mono 序列，忽略作为源的 Publisher 中的所有元素，只产生结束消息
 * {@link Mono#justOrEmpty(Object)}					  从一个可能为 null 的对象中创建 Mono，只有对象不为 null 时，Mono 序列才产生对应的元素
 * {@link Mono#justOrEmpty(Optional)}				  从一个 Optional 对象创建 Mono，只有 Optional 不为 null 时，Mono 序列才产生对应的元素
 * {@link Mono#}
 * {@link Mono#}
 * {@link Mono#}
 * {@link Mono#}
 * {@link Mono#}
 *
 * @author ZhengYu
 * @version 1.0 2021/5/26 18:29
 **/

public class MonoApi {

	private static final Log log = LogFactory.getLog(MonoApi.class);

	public static void main(String[] args) {
		// Mono 创建示例
		api_createMono();

	}

	public static void api_createMono() {
	}
}

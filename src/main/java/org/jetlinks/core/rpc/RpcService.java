package org.jetlinks.core.rpc;

import org.reactivestreams.Publisher;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Rpc Service 底层接口,监听rcp请求,发起rpc请求.
 *
 * @author zhouhao
 * @since 1.1
 */
public interface RpcService {

    <REQ, RES> Disposable listen(RpcDefinition<REQ, RES> definition,
                                 BiFunction<String, REQ, Publisher<RES>> call);

    <RES> Disposable listen(RpcDefinition<Void, RES> definition,
                            Function<String, Publisher<RES>> call);

    <REQ, RES> Flux<RES> invoke(RpcDefinition<REQ, RES> definition, Publisher<? extends REQ> payload);

    <RES> Flux<RES> invoke(RpcDefinition<Void, RES> definition);

    default <REQ, RES> Flux<RES> invoke(RpcDefinition<REQ, RES> address, REQ payload) {
        return invoke(address, Mono.just(payload));
    }

}

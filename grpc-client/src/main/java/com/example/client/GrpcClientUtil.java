package com.example.client;

import com.example.common.CommonProto;
import com.example.service.MyServiceGrpc;
import com.example.service.ServiceProto;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class GrpcClientUtil {

    /**
     * 拼接请求并调用 gRPC 服务
     * @param query 请求的查询字符串
     * @return 服务返回的 Response 消息
     * @throws InterruptedException
     */
    public static ServiceProto.Response sendRequest(String query) throws InterruptedException {
        // 创建指向服务端的连接（假设运行在 localhost:50051）
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()  // 禁用 TLS，便于测试
                .build();

        // 创建阻塞式 stub
        MyServiceGrpc.MyServiceBlockingStub stub = MyServiceGrpc.newBlockingStub(channel);

        // 构造请求元数据
        CommonProto.Metadata metadata = CommonProto.Metadata.newBuilder()
                .setRequestId(UUID.randomUUID().toString())
                .setTimestamp(Instant.now().toString())
                .build();

        // 构造一个包含多个 detail 的示例
        CommonProto.Detail detail1 = CommonProto.Detail.newBuilder()
                .setInfo("Detail A")
                .setCount(10)
                .build();

        CommonProto.Detail detail2 = CommonProto.Detail.newBuilder()
                .setInfo("Detail B")
                .setCount(20)
                .build();

        // 构造 Request 消息
        ServiceProto.Request request = ServiceProto.Request.newBuilder()
                .setMetadata(metadata)
                .setQuery(query)
                .addDetails(detail1)
                .addDetails(detail2)
                .build();

        // 使用 stub 发起同步调用
        ServiceProto.Response response = stub.process(request);

        // 关闭连接
        channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        return response;
    }
}
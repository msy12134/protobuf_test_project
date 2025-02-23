package com.example.server;

import com.example.common.CommonProto;
import com.example.service.ServiceProto;
import com.example.service.MyServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.time.Instant;
import java.util.UUID;

public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {

    @Override
    public void process(ServiceProto.Request request, StreamObserver<ServiceProto.Response> responseObserver) {
        System.out.println("Server received request:");
        System.out.println("Query: " + request.getQuery());
        System.out.println("Metadata.requestId: " + request.getMetadata().getRequestId());
        System.out.println("Number of details: " + request.getDetailsCount());

        // 构造响应元数据
        CommonProto.Metadata responseMetadata = CommonProto.Metadata.newBuilder()
                .setRequestId(UUID.randomUUID().toString())
                .setTimestamp(Instant.now().toString())
                .build();

        // 构造响应消息，简单地对请求中的每个 detail 进行加工处理
        ServiceProto.Response.Builder responseBuilder = ServiceProto.Response.newBuilder();
        responseBuilder.setMetadata(responseMetadata);
        responseBuilder.setStatus("Processed: " + request.getQuery());
        request.getDetailsList().forEach(detail -> {
            CommonProto.Detail newDetail = CommonProto.Detail.newBuilder()
                    .setInfo(detail.getInfo() + " - processed")
                    .setCount(detail.getCount() * 2)
                    .build();
            responseBuilder.addResults(newDetail);
        });

        ServiceProto.Response response = responseBuilder.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
package com.example.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class MyServiceServer {
    private final int port = 50051;
    private final Server server;

    public MyServiceServer() {
        server = ServerBuilder.forPort(port)
                .addService(new MyServiceImpl())
                .build();
    }

    public void start() throws IOException {
        server.start();
        System.out.println("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Shutting down gRPC server");
            MyServiceServer.this.stop();
            System.err.println("Server shut down");
        }));
    }

    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    // 阻塞直到服务终止
    public void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        MyServiceServer server = new MyServiceServer();
        server.start();
        server.blockUntilShutdown();
    }
}
package com.example.service;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 定义一个服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.42.1)",
    comments = "Source: service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MyServiceGrpc {

  private MyServiceGrpc() {}

  public static final String SERVICE_NAME = "service.MyService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.service.ServiceProto.Request,
      com.example.service.ServiceProto.Response> getProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Process",
      requestType = com.example.service.ServiceProto.Request.class,
      responseType = com.example.service.ServiceProto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.service.ServiceProto.Request,
      com.example.service.ServiceProto.Response> getProcessMethod() {
    io.grpc.MethodDescriptor<com.example.service.ServiceProto.Request, com.example.service.ServiceProto.Response> getProcessMethod;
    if ((getProcessMethod = MyServiceGrpc.getProcessMethod) == null) {
      synchronized (MyServiceGrpc.class) {
        if ((getProcessMethod = MyServiceGrpc.getProcessMethod) == null) {
          MyServiceGrpc.getProcessMethod = getProcessMethod =
              io.grpc.MethodDescriptor.<com.example.service.ServiceProto.Request, com.example.service.ServiceProto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Process"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.service.ServiceProto.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.service.ServiceProto.Response.getDefaultInstance()))
              .setSchemaDescriptor(new MyServiceMethodDescriptorSupplier("Process"))
              .build();
        }
      }
    }
    return getProcessMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MyServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MyServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MyServiceStub>() {
        @java.lang.Override
        public MyServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MyServiceStub(channel, callOptions);
        }
      };
    return MyServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MyServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MyServiceBlockingStub>() {
        @java.lang.Override
        public MyServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MyServiceBlockingStub(channel, callOptions);
        }
      };
    return MyServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MyServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MyServiceFutureStub>() {
        @java.lang.Override
        public MyServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MyServiceFutureStub(channel, callOptions);
        }
      };
    return MyServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 定义一个服务
   * </pre>
   */
  public static abstract class MyServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void process(com.example.service.ServiceProto.Request request,
        io.grpc.stub.StreamObserver<com.example.service.ServiceProto.Response> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProcessMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.example.service.ServiceProto.Request,
                com.example.service.ServiceProto.Response>(
                  this, METHODID_PROCESS)))
          .build();
    }
  }

  /**
   * <pre>
   * 定义一个服务
   * </pre>
   */
  public static final class MyServiceStub extends io.grpc.stub.AbstractAsyncStub<MyServiceStub> {
    private MyServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MyServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MyServiceStub(channel, callOptions);
    }

    /**
     */
    public void process(com.example.service.ServiceProto.Request request,
        io.grpc.stub.StreamObserver<com.example.service.ServiceProto.Response> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 定义一个服务
   * </pre>
   */
  public static final class MyServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<MyServiceBlockingStub> {
    private MyServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MyServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MyServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.service.ServiceProto.Response process(com.example.service.ServiceProto.Request request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 定义一个服务
   * </pre>
   */
  public static final class MyServiceFutureStub extends io.grpc.stub.AbstractFutureStub<MyServiceFutureStub> {
    private MyServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MyServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MyServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.service.ServiceProto.Response> process(
        com.example.service.ServiceProto.Request request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS:
          serviceImpl.process((com.example.service.ServiceProto.Request) request,
              (io.grpc.stub.StreamObserver<com.example.service.ServiceProto.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.service.ServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MyService");
    }
  }

  private static final class MyServiceFileDescriptorSupplier
      extends MyServiceBaseDescriptorSupplier {
    MyServiceFileDescriptorSupplier() {}
  }

  private static final class MyServiceMethodDescriptorSupplier
      extends MyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MyServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MyServiceFileDescriptorSupplier())
              .addMethod(getProcessMethod())
              .build();
        }
      }
    }
    return result;
  }
}

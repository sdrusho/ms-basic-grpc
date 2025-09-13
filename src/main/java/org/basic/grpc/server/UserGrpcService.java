package org.basic.grpc.server;


import net.devh.boot.grpc.server.service.GrpcService;
import org.basic.grpc.UserGrpc;
import org.basic.grpc.UserRequest;
import org.basic.grpc.UserResponse;
import io.grpc.stub.StreamObserver;


@GrpcService
public class UserGrpcService extends UserGrpc.UserImplBase {
    @Override
    public void validateUser(UserRequest request, StreamObserver<UserResponse> responseObserver) {
        String name = request.getName();
        String message = "Hello, " + name + "!";
        UserResponse response = UserResponse.newBuilder().setMessage(message).build();
        // Send the response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

package org.basic.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.basic.grpc.UserGrpc;
import org.basic.grpc.UserRequest;
import org.basic.grpc.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserGrpcClient {
    private final UserGrpc.UserBlockingStub blockingStub;
    public UserGrpcClient() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
        this.blockingStub = UserGrpc.newBlockingStub(channel);
    }
    public String validateUser(String name) {
        UserRequest request = UserRequest.newBuilder().setName(name).build();
        UserResponse response = blockingStub.validateUser(request);
        return response.getMessage();
    }
}

package org.basic.grpc.controller;

import org.basic.grpc.client.UserGrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basic")
public class UserController {

    @Autowired
    public UserGrpcClient userGrpcClient;


    @RequestMapping(value="/user", method= RequestMethod.GET)
    public ResponseEntity<String> validateUser(@RequestParam String name) {
        String msg =  userGrpcClient.validateUser(name);
        return new ResponseEntity(msg, HttpStatus.OK);
    }
}

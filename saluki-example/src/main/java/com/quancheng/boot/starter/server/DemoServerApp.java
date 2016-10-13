package com.quancheng.boot.starter.server;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.quancheng.boot.saluki.starter.SalukiReference;

@SpringBootApplication
public class DemoServerApp implements CommandLineRunner {

    @SalukiReference(service = "com.quancheng.boot.starter.server.GreeterService", group = "default", version = "1.0.0")
    private GreeterService greeterService;

    public static void main(String[] args) {

        SpringApplication.run(DemoServerApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        com.quancheng.boot.starter.model.HelloRequest request = new com.quancheng.boot.starter.model.HelloRequest();
        request.setName("joe");
        com.quancheng.boot.starter.model.HelloReply reply = greeterService.SayHello(request);
        System.out.println(reply.getMessage());
    }

}
package com.example.demospringboot;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileRoute extends RouteBuilder  {


    @Override
    public void configure() throws Exception {
        from("file:C:/files/input/noop=true").to("file:C:/files/output/");


    }
}

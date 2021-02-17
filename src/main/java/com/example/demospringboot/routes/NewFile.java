package com.example.demospringboot.routes;




import com.example.demospringboot.processor.MyProcessor;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NewFile extends RouteBuilder {
    @Value("${app.source}")
    private String source;
    @Value("${app.destination}")
    private String destination;
    @Autowired
    private MyProcessor Processor;
    @Override
    public void configure()throws Exception{
        from("file:" + source)
                .routeId("demo-route-ID")
                .setBody(simple("$body}.file has been updated"))
                .process(Processor)
                .to("file:" + destination)
                .log(LoggingLevel.INFO, "file is moved \n ${body}");
    }
}
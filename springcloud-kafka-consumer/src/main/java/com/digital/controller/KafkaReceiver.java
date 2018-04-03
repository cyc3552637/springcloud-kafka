package com.digital.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.digital.util.Sink;


@EnableBinding(Sink.class) 
public class KafkaReceiver  {
	
	private final Logger logger = LoggerFactory.getLogger(KafkaReceiver.class);  
    
    @StreamListener(Sink.INPUT_1)  
    private void receive(String vote) {  
    	System.out.println("receive message : " + vote); 
        logger.info("receive message : " + vote);  
    } 
    
}
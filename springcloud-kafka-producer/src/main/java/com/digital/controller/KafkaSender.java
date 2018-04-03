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
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.digital.util.Source;

@RestController
@EnableBinding(Source.class) 
public class KafkaSender  {
	
	private final Logger logger = LoggerFactory.getLogger(KafkaSender.class);  
	
	 @Autowired  
	 private Source source;  
    
	@RequestMapping(value = "/output")
	public String sendMessage(@RequestParam(value="message",required=false) String message) {
		String result="false";
	    try {  
	        source.output1().send(MessageBuilder.withPayload("message: " + message).build()); 
	        result="true";
	    } catch (Exception e) {  
	        logger.info("消息发送失败，原因："+e); 
	        result="false";
	        e.printStackTrace();  
	    }
	    return result;
	    }  
	}  
    

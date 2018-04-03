package com.digital.util;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Source {  
    
    //发送队列1  
    String OUTPUT_1 = "outputmessage";  
      
    @Output(Source.OUTPUT_1)  
    MessageChannel output1();  
      
}  
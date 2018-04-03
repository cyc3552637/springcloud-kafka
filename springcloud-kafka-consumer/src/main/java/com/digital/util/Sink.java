package com.digital.util;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {
	 String INPUT_1 = "inputmessage";  
	  
	    @Input(Sink.INPUT_1)  
	    SubscribableChannel input1();  

}

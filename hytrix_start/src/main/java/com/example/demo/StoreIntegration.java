package com.example.demo;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class StoreIntegration {
	
	//hystix 어노테이션을 쓴 부분에서만 예외처리가 됨
    @HystrixCommand(commandKey="getStores", fallbackMethod = "defaultStores")
    public Object getStores(String parameter) throws Exception {
        //do stuff that might fail

    	System.out.println("getStores");
    	
    	Thread.sleep(1000);
    	
    	if("ee".equals("ee")){
			throw new Exception(); // 예외가 생길 부분에 try catch 로 처리되면 fallback 으로 안감!! fallback 되려면 catch 문에 예외 던져야 함
		}
    	
    	
    	return "getStroes";
    }

    
    /**
     * fallbackMethod 선언부 메소드와 fallbackMethod의 파라미터는 동일해야 한다.
     */
    public String defaultStores(String parameter) {
    	System.out.println("fallback");
        return "fallback";
    }
}

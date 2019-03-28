package com.example.demo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {
	
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage(){
		System.out.println("sstart");
		Employee emp = new Employee();
		System.out.println("emp1");
		emp.setName("emp");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);
		
		if(emp.getName().equalsIgnoreCase("emp1"))
			throw new RuntimeException();

		return emp;
	}
	
	@RequestMapping(value = "/employee1/{mallid}", method = RequestMethod.GET)
	public Employee secondPage(
			  HttpServletRequest request
				,@PathVariable(name="mallid") String mallid) throws InterruptedException, ExecutionException, TimeoutException {
		System.out.println("sstart");
		Employee emp = new Employee();
		System.out.println(mallid);
		emp.setName("emp");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);
		
		if(emp.getName().equalsIgnoreCase("emp1"))
			throw new RuntimeException();

		return emp;
	}
	
	@Autowired
	private StoreIntegration storeIntegration;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String thirdPage() throws Exception{
		
		
		String result = (String) storeIntegration.getStores("test");
		
		return result;
	}
	
	
	public Employee getDataFallBack() {
		System.out.println("여기가 폴백이다");
		Employee emp = new Employee();
		emp.setName("fallback-emp1");
		emp.setDesignation("fallback-manager");
		emp.setEmpId("fallback-1");
		emp.setSalary(3000);

		return emp;
		
	}
}

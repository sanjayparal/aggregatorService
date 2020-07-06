package com.nagarro.demo;

import com.nagarro.demo.Service.OrderDetailsService;
import com.nagarro.demo.model.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class AggregatorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AggregatorServiceApplication.class, args);
	}

	@Autowired
	private OrderDetailsService orderDetailsService;

	@RequestMapping("/ordersdetails/1")
	public ResponseEntity<OrderDetails> getOrderDetails(){
		return ResponseEntity.ok(orderDetailsService.getOrderDetails());
	}

	@RequestMapping("/health")
	public ResponseEntity<String> health() {
		return ResponseEntity.ok("Healthy and running");
	}
}

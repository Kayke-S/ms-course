package com.kaykesilva.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kaykesilva.hrpayroll.entities.Payment;
import com.kaykesilva.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	@Autowired
	private PaymentService service;

	@HystrixCommand(fallbackMethod = "getPaymentAlternative") // utilizado para chamar métodos alternativos
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		Payment obj = service.getPayment(workerId, days);
		return ResponseEntity.ok().body(obj);
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days) {
		Payment obj = new Payment("Brann", 400.0, days);
		return ResponseEntity.ok().body(obj);
	} 

}

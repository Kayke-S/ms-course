package com.kaykesilva.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.kaykesilva.hrpayroll.entities.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, int days) {
		return new Payment("Bob", 200.0, days);
	}
}

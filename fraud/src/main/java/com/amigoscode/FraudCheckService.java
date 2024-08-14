package com.amigoscode;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {

    private final FraudRepository fraudRepository;

    public FraudCheckService(FraudRepository fraudRepository) {
        this.fraudRepository = fraudRepository;
    }

    public boolean isFraudulentCustomer(Integer customerId){
       fraudRepository.save(
               FraudChechkHistory.builder()
                       .customer_id(customerId)
                       .createdAt(LocalDateTime.now())
                       .isFraudster(false)
                       .build()
       );
       return false;
    }
}

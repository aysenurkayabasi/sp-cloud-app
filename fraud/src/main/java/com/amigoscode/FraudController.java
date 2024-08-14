package com.amigoscode;

import brave.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudController {

    private final FraudCheckService fraudCheckService;

    public FraudController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<FraudCheckResponse> isFraudster(@PathVariable("customerId") Integer customerId){
     boolean isFraudulentCustomer= fraudCheckService.isFraudulentCustomer(customerId);
     log.info("fraud check request for custpmer {}",customerId);
     return  ResponseEntity.ok(new FraudCheckResponse(isFraudulentCustomer));
    }

}

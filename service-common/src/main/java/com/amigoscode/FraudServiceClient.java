package com.amigoscode;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fraud")
public interface FraudServiceClient {

    @GetMapping("api/v1/fraud-check/{customerId}")
    ResponseEntity<FraudCheckFeignResponse> isFraudster(@PathVariable("customerId") Integer customerId);

}

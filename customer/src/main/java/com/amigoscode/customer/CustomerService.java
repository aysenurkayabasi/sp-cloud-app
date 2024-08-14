package com.amigoscode.customer;

import com.amigoscode.FraudCheckFeignResponse;
import com.amigoscode.FraudServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
//    private final RestTemplate restTemplate;
    private final FraudServiceClient fraudServiceClient;

    // rest template örneği

//    public void registerCustomer(CustomerRequest customerRequest) throws IllegalAccessException {
//        Customer customer=Customer.builder().name(customerRequest.firstName())
//                .surnema(customerRequest.lastName())
//                .email(customerRequest.email()).build();
//        customerRepository.saveAndFlush(customer);
//        // -- server.port=8085 program arguments ayarı ile çoklanır.
//        //http://FRAUD/api/v1/fraud-check/{customerId} EUREKA serverdaki application name adı . birden fazla instance olduğunda bu şekilde kullanılmalı.
//        FraudCheckResponse fraudCheckResponse=restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",FraudCheckResponse.class,customer.getId());
//            if(fraudCheckResponse.isFraudster()){
//            throw new IllegalAccessException("fraudster");
//        }
//    }


    public void registerCustomer(CustomerRequest customerRequest) throws IllegalAccessException {
        Customer customer=Customer.builder().name(customerRequest.firstName())
                .surnema(customerRequest.lastName())
                .email(customerRequest.email()).build();
        customerRepository.saveAndFlush(customer);
        ResponseEntity<FraudCheckFeignResponse> reponseEntity=fraudServiceClient.isFraudster(customer.getId());
        FraudCheckFeignResponse fraudCheckResponse=reponseEntity.getBody();
        if(fraudCheckResponse.isFraudster()){
            throw new IllegalAccessException("fraudster");
        }
    }



}

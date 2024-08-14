package com.amigoscode;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<FraudChechkHistory,Integer> {
}

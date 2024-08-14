package com.amigoscode.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
  @Id
  @SequenceGenerator(
          name = "customer_id_sequence",
          sequenceName = "customer_id_sequence"
  )
  @GeneratedValue(
          strategy = GenerationType.SEQUENCE,
          generator = "customer_id_sequence"
  )
  private Integer id;
  private String name;
  private String surnema;
  private String email;

}

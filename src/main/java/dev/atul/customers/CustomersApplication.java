package dev.atul.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

import java.util.Set;

@SpringBootApplication
//@EnableEurekaClient
public class CustomersApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomersApplication.class, args);
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Customer {
    private Integer id;
    private String name;
}

@Controller
@ResponseBody
class CustomerRestController {
    Set<Customer> customers = Set.of(new Customer(1, "Atul"), new Customer(2, "Mukul"), new Customer(2, "Piyush"));

    @GetMapping("/customers")
    public Flux<Customer> get() {
        return Flux.fromIterable(customers);
    }
}
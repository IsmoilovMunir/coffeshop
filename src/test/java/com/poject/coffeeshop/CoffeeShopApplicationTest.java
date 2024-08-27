package com.poject.coffeeshop;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
public class CoffeeShopApplicationTest {
    @Test
    void contextLoads() {
        System.out.println(
                new BCryptPasswordEncoder().encode("admin")
        );

        System.out.println(
                new BCryptPasswordEncoder().encode("demo")
        );
    }
}

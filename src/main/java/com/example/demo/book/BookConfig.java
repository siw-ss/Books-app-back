package com.example.demo.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository){
        return args -> {
            Book first = new Book(
                    "fault in our stars",
                    200
            );

            Book second = new Book(
                    "dolphins",
                    50
                    );

            repository.saveAll(
                    List.of(first,second)
            );
        };
    };
}

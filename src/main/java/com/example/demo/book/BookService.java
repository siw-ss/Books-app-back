package com.example.demo.book;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    public List<Book> getBooks(){
        return List.of(
            new Book(1,"fault in our stars",200),
            new Book(2,"dolphins",50)
        );
    }
}

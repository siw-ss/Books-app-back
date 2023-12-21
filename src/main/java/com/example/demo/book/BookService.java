package com.example.demo.book;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    public final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository
                .findByTitle(book.getTitle());
        if(bookOptional.isPresent()){
            throw new IllegalStateException("book already exists");
        }
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if(!exists){
            throw new IllegalStateException("Book with id"+ bookId+"does not exist");
        }
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void updateBook(Long bookId, String title, Integer price) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(()-> new IllegalStateException(
                        "book with id " + bookId + " does not exist"
                ));
        if (price!=null && !Objects.equals(book.getPrice(),price)){
            book.setPrice(price);
        }
        if (title!=null && !Objects.equals(book.getTitle(),title)){
            Optional<Book> bookOptional = bookRepository.findByTitle(title);
            if (bookOptional.isPresent()){
                throw new IllegalStateException("book title is already used");
            }
            book.setTitle(title);
        }
    }
}

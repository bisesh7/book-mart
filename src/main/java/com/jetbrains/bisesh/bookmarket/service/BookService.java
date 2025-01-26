package com.jetbrains.bisesh.bookmarket.service;

import com.jetbrains.bisesh.bookmarket.model.Book;
import com.jetbrains.bisesh.bookmarket.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findBookById(long id) {
        return bookRepository.findById(id);
    }

    public void deleteBookById(long id) {
        bookRepository.deleteById(id);
    }
}

package com.hibernate.materJpa.servicesImpl;

import com.hibernate.materJpa.entitiesWithHibernate.Book;
import com.hibernate.materJpa.repositories.BookRepository;
import com.hibernate.materJpa.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findBooksWithAreReviwed()  {
        return bookRepository.findBooksWithAreReviwed();
    }

    @Override
    public void persistSomeBooks() {

        List<Book> books = new ArrayList<>();

        books.add(new Book( "tunisia", 300));
        books.add(new Book( "French", 300));
        books.add(new Book( "zorba", 440));
        books.add(new Book( "germinal", 380));
        books.add(new Book( "les misérable", 800));
        books.add(new Book( "contrat social", 200));
        books.add(new Book( "cristal", 100));

        bookRepository.saveAll(books);


    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }


}

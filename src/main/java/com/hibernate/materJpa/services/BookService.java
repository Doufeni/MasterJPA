package com.hibernate.materJpa.services;


import com.hibernate.materJpa.entitiesWithHibernate.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {

    public List<Book> findBooksWithAreReviwed();

    public void persistSomeBooks();

    public Optional<Book> findBookById(Long id);
    public void delete(Book book);
}

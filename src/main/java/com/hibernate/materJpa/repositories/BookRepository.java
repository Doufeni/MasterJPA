package com.hibernate.materJpa.repositories;
import com.hibernate.materJpa.entitiesWithHibernate.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{


    Book findBookByName(String name);
    Optional<Book> findBookById(Long id);

    @Transactional
    @Query("SELECT b FROM Book b JOIN b.writers w WHERE w.name = ?1")
    List<Book> findBooksByWriterName(String name);


    @Query("SELECT b FROM Book b WHERE b.review is Null ")
    List<Book> findBooksWithAreReviwed();


}

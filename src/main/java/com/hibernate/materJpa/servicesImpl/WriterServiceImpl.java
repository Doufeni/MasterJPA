package com.hibernate.materJpa.servicesImpl;

import com.hibernate.materJpa.entitiesWithHibernate.Book;
import com.hibernate.materJpa.entitiesWithHibernate.Writer;
import com.hibernate.materJpa.repositories.BookRepository;
import com.hibernate.materJpa.repositories.WriterRepository;
import com.hibernate.materJpa.services.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WriterServiceImpl implements WriterService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    WriterRepository writerRepository;

    @Override
    public void persistSomeWriters() {
        Book bookSaved1 = bookRepository.findBookByName("tunisia");
        Book bookSaved2 = bookRepository.findBookByName("French");

        List<Book> books = new ArrayList<>();

        books.add(bookSaved1);
        books.add(bookSaved2);

        Writer writer = new Writer( "saif", books  );
        writerRepository.save(writer);
    }
}

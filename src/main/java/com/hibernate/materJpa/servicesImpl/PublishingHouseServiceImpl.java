package com.hibernate.materJpa.servicesImpl;

import com.hibernate.materJpa.entitiesWithHibernate.Book;
import com.hibernate.materJpa.entitiesWithHibernate.PublishingHouse;
import com.hibernate.materJpa.repositories.BookRepository;
import com.hibernate.materJpa.repositories.PublishingHouseRepository;
import com.hibernate.materJpa.services.PublishingHouseService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Service
@Slf4j
public class PublishingHouseServiceImpl implements PublishingHouseService {

    @Autowired
    PublishingHouseRepository publishingHouseRepository;
    @Autowired
    BookRepository bookRepository;

    @Override
    public PublishingHouse savePublishingHouse(){
        Book bookSaved1 = bookRepository.findBookByName("tunisia");
        Book bookSaved2 = bookRepository.findBookByName("French");

        List<Book> books = new ArrayList<>();

        books.add(bookSaved1);
        books.add(bookSaved2);

        publishingHouseRepository.save( new PublishingHouse("Maktabat Al Kitab"));
        try {
            publishingHouseRepository.save(new PublishingHouse("Maktabat Al Kitab"));

        } catch (Exception e) {
            log.info("exception in saving publishing house" + e.getMessage());
        }

        PublishingHouse publishingHouse = new PublishingHouse("AL-Risella", books);
        return publishingHouseRepository.save(publishingHouse);
    }

    @Override
    public PublishingHouse findPublishingHouseById(Long id){
        return publishingHouseRepository.findPublishingHouseById(id);
    }



}

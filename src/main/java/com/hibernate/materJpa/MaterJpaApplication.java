package com.hibernate.materJpa;


import com.hibernate.materJpa.entitiesWithHibernate.Book;
import com.hibernate.materJpa.repositories.BookRepository;
import com.hibernate.materJpa.repositories.WriterRepository;
import com.hibernate.materJpa.services.BookService;
import com.hibernate.materJpa.services.PublishingHouseService;
import com.hibernate.materJpa.services.WriterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class MaterJpaApplication implements CommandLineRunner {

	@Autowired
	WriterRepository writerRepository;
    BookRepository bookRepository;
	PublishingHouseService publishingHouseService;
	BookService bookService;
	WriterService writerService;


	public static void main(String[] args) {

		SpringApplication.run(MaterJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		bookService.persistSomeBooks();

		writerService.persistSomeWriters();

		bookRepository.findBooksByWriterName("saif")
				.forEach(s -> System.out.println(s.getName() ));

		 // save publishingHouse
		publishingHouseService.savePublishingHouse();

		List<Book> booksNotReviewed = bookService.findBooksWithAreReviwed();
		if( !booksNotReviewed.isEmpty() ) {
			booksNotReviewed.forEach(b -> System.out.println(b.getName() ));
		}

		Long bookId= 1L;
		Optional<Book> bookToDelete = Optional.ofNullable(bookService.findBookById(bookId)
                .orElseThrow(() -> new ObjectNotFoundException("element not found with id: " + bookId, new Book())));


		try {
			publishingHouseService.findPublishingHouseById(5L);
		} catch (Exception e){
			log.info("Exception catched " + e.getMessage());

		}
	}
}

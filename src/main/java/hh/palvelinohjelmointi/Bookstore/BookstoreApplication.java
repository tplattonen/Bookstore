package hh.palvelinohjelmointi.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.palvelinohjelmointi.Bookstore.domain.Book;
import hh.palvelinohjelmointi.Bookstore.domain.BookRepository;
import hh.palvelinohjelmointi.Bookstore.domain.Category;
import hh.palvelinohjelmointi.Bookstore.domain.CategoryRepository;
import hh.palvelinohjelmointi.Bookstore.domain.User;
import hh.palvelinohjelmointi.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner studentDemo(BookRepository bookRepository, CategoryRepository cRepository, UserRepository uRepository) {
		return (args) -> {
			log.info("save a couple of books");
			cRepository.save(new Category("Romaanit"));
			cRepository.save(new Category("Kauhu"));
			cRepository.save(new Category("Fiktio"));
			
			bookRepository.save(new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 0, cRepository.findByName("Romaanit").get(0)));
			bookRepository.save(new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 0, cRepository.findByName("Fiktio").get(0)));	
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			User user3 = new User("tume", "$2y$10$rqURoDjJK5/v1pzJzvBo9eFcTF4CMDyZomwKpOyO.HE.ghgBPAx0y", "USER");
			
			uRepository.save(user1);
			uRepository.save(user2);
			uRepository.save(user3);
			
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}

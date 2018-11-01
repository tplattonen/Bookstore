package hh.palvelinohjelmointi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.palvelinohjelmointi.Bookstore.domain.Book;
import hh.palvelinohjelmointi.Bookstore.domain.BookRepository;
import hh.palvelinohjelmointi.Bookstore.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bRepository;

    @Test
    public void findByIdShouldReturnBook() {
        List<Book> books = bRepository.findById(4);
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("A Farewell to Arms");
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("Testi kirja", "Testaaja", 2018, "876543-45", 3, new Category("Testing"));
    	bRepository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
    // (new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 0, cRepository.findByName("Romaanit").get(0)));
   
}
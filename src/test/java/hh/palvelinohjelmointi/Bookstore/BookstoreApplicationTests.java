package hh.palvelinohjelmointi.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.palvelinohjelmointi.Bookstore.web.BookstoreController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	 @Autowired
	 private BookstoreController bController;
	 
	 @Test
	 public void contexLoads() throws Exception {
		 assertThat(bController).isNotNull();
	    }	
	
}

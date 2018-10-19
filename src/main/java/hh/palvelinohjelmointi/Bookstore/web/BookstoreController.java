package hh.palvelinohjelmointi.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.palvelinohjelmointi.Bookstore.domain.Book;
import hh.palvelinohjelmointi.Bookstore.domain.BookRepository;
import hh.palvelinohjelmointi.Bookstore.domain.CategoryRepository;

@Controller 
public class BookstoreController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String tyhja() {
		return "index";
	}
	/** Listaa kirjat tietokannasta **/
	@RequestMapping(value="/booklist")
    public String bookList(Model model) {	
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }
	
	// RESTful service to get all books
	 @RequestMapping(value="/books", method = RequestMethod.GET)
	 public @ResponseBody List<Book> bookListRest() {	
		 return (List<Book>) bookRepository.findAll();
	}
	// RESTful service to get book by id *HOX responsebody! -> JSON:iksi*
	@RequestMapping(value="/books/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long Id) {	
		return bookRepository.findById(Id);
	}       
	
	/** palauttaa tyhjän lomakkeen uuden kirjan lisäämiseen **/
	@RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categorys", categoryRepository.findAll());
        return "addbook";
    }
	/** poistaa kirjan käyttäen sen id:tä **/
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
	    return "redirect:../booklist";
	}
	/** Tallentaa kirjan **/
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book){
	     bookRepository.save(book);
	     return "redirect:booklist";
	}
	/** Kirjan muokkaus; id:n avulla **/
	@RequestMapping (value="/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId,Model model){
		model.addAttribute("book",bookRepository.findById(bookId));
		return "editBook";
	}
	
	@RequestMapping(value="/login")
	    public String login() {	
	    return "login";
	}	
		
		
}

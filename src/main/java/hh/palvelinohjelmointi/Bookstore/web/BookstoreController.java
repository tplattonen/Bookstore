package hh.palvelinohjelmointi.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String studentList(Model model) {	
        model.addAttribute("book", bookRepository.findAll());
        return "booklist";
    }
	/** palauttaa tyhjän lomakkeen uuden kirjan lisäämiseen **/
	@RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categorys", categoryRepository.findAll());
        return "addbook";
    }
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
	    return "redirect:../booklist";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book){
	     bookRepository.save(book);
	     return "redirect:booklist";
	}
	@RequestMapping (value="/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId,Model model){
		model.addAttribute("book",bookRepository.findById(bookId));
		return "editBook";
	}
		
		
}

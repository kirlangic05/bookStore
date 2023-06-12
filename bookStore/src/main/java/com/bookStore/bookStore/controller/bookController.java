package com.bookStore.bookStore.controller;


import ch.qos.logback.core.model.Model;
import com.bookStore.bookStore.model.Books;
import com.bookStore.bookStore.model.MyBookList;
import com.bookStore.bookStore.service.BookService;
import com.bookStore.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
public class bookController {
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @Autowired
    private BookService service;
    @Autowired
    private MyBookListService myBookService;

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
   public ModelAndView getAllBook() {
        List<Books> list = service.getAllBooks();
        //      ModelAndView m=new ModelAndView();
        //     m.setView("bookList");
        //     m.addObject("books",list);
        return new ModelAndView("bookList", "books", list);
  /* public String availableBooks(){
        return "bookList";*/
    }

    @GetMapping("/my_books")
    public String getMyBooks(ModelMap model) {
        List<MyBookList>list=myBookService.getAllMyBooks();
        model.addAttribute("books",list);
        return "myBooks";
    }

    @PostMapping("/save")
    public String addbook(@ModelAttribute Books b) {  // Books sınıfından nesne alıp kullanıyor @ModelAttribute
        service.save(b);  // veritabanında da kaydedildi
        return "redirect:/available_books"; // kayıt tuşu ile bu metod ilişkilendirildi. Tuşa basılınca
                                            //  işlemlerin sonunda buraya gönderecek.
    }

    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Books b = service.getBookById(id);
        MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, ModelMap model){
       Books b=service.getBookById(id);
       model.addAttribute("books",b);
       return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
    service.deleteById(id);

        return "redirect:/available_books";
    }


}

package com.BossPyroski.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.BossPyroski.models.Book;
import com.BossPyroski.repositories.BookRepository;

@Service
public class BookService {
 
private final BookRepository bookRepository;

 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 // returns all the books
 public List<Book> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 // retrieves a book
 public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
//    updatesBook 
 public Book updateBook(Long Id, String title, String desc, String lang, Integer numOfPages) {
	 Optional<Book> optionalBook = bookRepository.findById(Id);
     if(optionalBook.isPresent()) {
    	 Book updateBook = optionalBook.get();
    	 updateBook.setId(Id);
    	 updateBook.setTitle(title);
    	 updateBook.setDescription(desc);
    	 updateBook.setLanguage(lang);
    	 updateBook.setNumberOfPages(numOfPages);
         return bookRepository.save(updateBook);
     } else {
         return null;
     }
 }
     
     
  public Book updateBook(Book b) {
	  
	  return bookRepository.save(b);
  }
  public void deleteBook(Long id) {
	  bookRepository.deleteById(id);
  }
 }



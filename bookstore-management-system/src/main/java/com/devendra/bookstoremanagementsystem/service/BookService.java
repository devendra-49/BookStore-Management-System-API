package com.devendra.bookstoremanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devendra.bookstoremanagementsystem.entity.Book;
import com.devendra.bookstoremanagementsystem.repository.BookJPARepository;

@Service
public class BookService {

		@Autowired
		private BookJPARepository bjpa;
	
	    // Add Book
	    public Book addBook(Book book) {
	        return bjpa.save(book);
	    }

	    // Get All Books
	    public List<Book> getAllBooks() {
	        return bjpa.findAll();
	    }

	    //  Get Book by ID
	    public Book getBookById(Long id) {
	        return bjpa.findById(id)
	                .orElseThrow(() -> new RuntimeException("Book not found"));
	    }

	    //  Delete Book
//	    public void deleteBook(Long id) {
//	        bjpa.deleteById(id);
//	    }
	    
	    public void deleteBook(Long id) {

	        if (!bjpa.existsById(id)) {
	            throw new RuntimeException("Book not found");
	        }

	        bjpa.deleteById(id);
	    }
	    
	    public Book updateBook(Long id, Book updatedBook) {

	        Book existingBook = bjpa.findById(id)
	                .orElseThrow(() -> new RuntimeException("Book not found"));

	        existingBook.setTitle(updatedBook.getTitle());
	        existingBook.setAuthor(updatedBook.getAuthor());
	        existingBook.setGenre(updatedBook.getGenre());
	        existingBook.setIsbn(updatedBook.getIsbn());
	        existingBook.setPrice(updatedBook.getPrice());
	        existingBook.setDescription(updatedBook.getDescription());
	        existingBook.setStockQuantity(updatedBook.getStockQuantity());
	        existingBook.setImageUrl(updatedBook.getImageUrl());

	        return bjpa.save(existingBook);
	    }


	

}

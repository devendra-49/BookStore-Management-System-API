package com.devendra.bookstoremanagementsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devendra.bookstoremanagementsystem.entity.Book;

@Repository
public interface BookJPARepository extends JpaRepository<Book, Long> {

}

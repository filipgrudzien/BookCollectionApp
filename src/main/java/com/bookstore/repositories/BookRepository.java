package com.bookstore.repositories;

import com.bookstore.entities.Book;
import com.bookstore.entities.BookDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}

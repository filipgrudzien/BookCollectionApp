package com.bookstore.repositories;

import com.bookstore.entities.OwnedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<OwnedBook, Integer> {
}

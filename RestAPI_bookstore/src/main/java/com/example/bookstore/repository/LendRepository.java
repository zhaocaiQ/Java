package com.example.bookstore.repository;

import com.example.bookstore.Entity.Book;
import com.example.bookstore.Entity.Lend;
import com.example.bookstore.domain.LendStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LendRepository extends JpaRepository<Lend, Long> {
    Optional<Lend> findByBookAndStatus(Book book, LendStatus status);
}

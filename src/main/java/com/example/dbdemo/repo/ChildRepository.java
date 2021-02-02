package com.example.dbdemo.repo;

import com.example.dbdemo.entities.Child;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<Child, Long> {
}

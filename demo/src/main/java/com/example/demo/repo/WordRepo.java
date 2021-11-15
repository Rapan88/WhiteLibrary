package com.example.demo.repo;

import com.example.demo.models.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepo extends JpaRepository<Word,Long> {


}
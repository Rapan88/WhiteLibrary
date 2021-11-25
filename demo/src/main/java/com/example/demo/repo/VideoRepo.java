package com.example.demo.repo;

import com.example.demo.models.EngVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepo extends JpaRepository<EngVideo,Long> {

}

package com.iduy.gondrong.repository;

import com.iduy.gondrong.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    boolean existsByTitleAndDateAndHost(String title, LocalDateTime date,String host);

}

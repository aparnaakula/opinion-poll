package com.mycapstone.opinionpoll.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends
        JpaRepository<com.mycapstone.opinionpoll.models.Query, Long> {
    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.author ORDER BY p.date DESC")
    List<com.mycapstone.opinionpoll.models.Query> findLatest5Posts();
}


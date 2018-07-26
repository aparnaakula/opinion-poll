package com.mycapstone.opinionpoll.repositories;

import com.mycapstone.opinionpoll.models.Category;
import com.mycapstone.opinionpoll.models.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface QueryRepository extends JpaRepository<Query, Integer> {
}
package com.mycapstone.opinionpoll.repositories;


import com.mycapstone.opinionpoll.models.Category;
import com.mycapstone.opinionpoll.models.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
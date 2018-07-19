package com.mycapstone.opinionpoll.services;
import com.mycapstone.opinionpoll.models.Query;

import java.util.List;

public interface PostService {
    List<Query> findAll();
    List<Query> findLatest5();
    Query findById(Long id);
    Query create(Query query);
    Query edit(Query query);
    void deleteById(Long id);
}
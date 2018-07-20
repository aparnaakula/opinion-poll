package com.mycapstone.opinionpoll.models.data;

import com.mycapstone.opinionpoll.models.Query;
import org.springframework.data.repository.CrudRepository;

public interface QueryDao extends CrudRepository<Query, Integer> {
}

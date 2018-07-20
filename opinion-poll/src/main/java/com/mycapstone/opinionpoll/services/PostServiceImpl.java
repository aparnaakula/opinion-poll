package com.mycapstone.opinionpoll.services;

import com.mycapstone.opinionpoll.models.Query;
import com.mycapstone.opinionpoll.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List; 
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private List<Query> queries = new ArrayList<Query>() {{
        add(new Query(1, "First Query", "<p>Line #1.</p><p>Line #2</p>", null,null,null));
        add(new Query(2, "Second Query", "<p>Line #1.</p><p>Line #2</p>", null,null,null));
        add(new Query(3, "Thord Query", "<p>Line #1.</p><p>Line #2</p>", null,null,null));
        add(new Query(4, "Fourth Query", "<p>Line #1.</p><p>Line #2</p>", null,null,null));
        add(new Query(6, "Fourth Query", "<p>Line #1.</p><p>Line #2</p>", null,null,null));
        add(new Query(7, "Fourth Query", "<p>Line #1.</p><p>Line #2</p>", null,null,null));
        add(new Query(8, "Fourth Query", "<p>Line #1.</p><p>Line #2</p>", null,null,null));
    }};
    
    @Override
    public List<Query> findAll() {
        return this.queries;
    }

    @Override
    public List<Query> findLatest5() {
        return this.queries.stream()
                 .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public Query findById(int id) {
        return this.queries.stream()
                .filter(p -> Objects.equals(p.getId(), id))
                .findFirst()
                .orElse(null);
    }
 
    @Override
    public Query create(Query query) {
        query.setId(this.queries.stream().mapToInt(
                p -> p.getId()).max().getAsInt() + 1);
        this.queries.add(query);
        return query;
    }

    @Override
    public Query edit(Query query) {
        for (int i = 0; i < this.queries.size(); i++) {
            if (Objects.equals(this.queries.get(i).getId(), query.getId())) {
                this.queries.set(i, query);
                return query;
            }
        }
        throw new RuntimeException("Query not found: " + query.getId());
    }
    @Override
    public void deleteById(int id) {
        for (int i = 0; i < this.queries.size(); i++) {
            if (Objects.equals(this.queries.get(i).getId(), id)) {
                this.queries.remove(i);
                return;
            }
        }
        throw new RuntimeException("Query not found: " + id);
    }
}
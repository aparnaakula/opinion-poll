package com.mycapstone.opinionpoll.services;

import com.mycapstone.opinionpoll.models.Query;
import com.mycapstone.opinionpoll.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostServiceStubImpl implements PostService {
    private List<Query> queries = new ArrayList<Query>() {{
        add(new Query(1, "First Query", "<p>Line #1.</p><p>Line #2</p>", null));
        add(new Query(2, "Second Query",
                "Second post content:<ul><li>line 1</li><li>line 2</li></p>",
                new User("appu@Gmail.com", "pesho10", "Peter Ivanov")));
        add(new Query(3, "Query #3", "<p>The post number 3 nice</p>",
                new User("hello@com", "merry", null)));
        add(new Query(4, "Forth Query", "<p>Not interesting post</p>", null));
        add(new Query(5, "Query Number 5", "<p>Just posting</p>", null));
        add(new Query(6, "Sixth Query", "<p>Another interesting post</p>", null));
    }};

    @Override
    public List<Query> findAll() {
        return this.queries;
    }

    @Override
    public List<Query> findLatest5() {
        return this.queries.stream()
                .sorted((a, b) -> b.getDate().compareTo(a.getDate()))
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
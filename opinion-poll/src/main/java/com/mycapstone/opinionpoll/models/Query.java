package com.mycapstone.opinionpoll.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Query extends AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String body;

    @ManyToOne
    private User user;

    private Date date = new Date();

    @ManyToMany
    private List<Category> categories= new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
    public Query() {
    }

    public Query(int id, String title, String body, Date date) {
        if (title == null || title.length() == 0)
            throw new IllegalArgumentException("Title may not be blank");

        if (body == null || body.length() == 0)
            throw new IllegalArgumentException("Description may not be null");


        this.id = id;
        this.title = title;
        this.body = body;
        this.date=date;
    }

    public Query(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Query(int id, String title, String body, Date date, List<Category> categories) {
        this(id,title,body,date);
        this.addAllCategories(categories);
    }
    public void add(Category cat) {
        this.categories.add(cat);
    }

    public void addAllCategories(List<Category> cats) {
        this.categories.addAll(cats);
    }

    public String getCategoriessFormatted() {
        List<String> nameList = this.getCategories().stream().map(Category::getName).collect(Collectors.toList());
        return String.join(", ", nameList);
    }
}
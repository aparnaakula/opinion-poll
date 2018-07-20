package com.mycapstone.opinionpoll.user;

import com.mycapstone.opinionpoll.forms.UserForm;
import com.mycapstone.opinionpoll.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserService {
    public User save(UserForm userForm) throws EmailExistException;
    public User findByEmail(String email);

}
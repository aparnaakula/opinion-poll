//package com.mycapstone.opinionpoll.user;
//
//import com.mycapstone.opinionpoll.forms.UserForm;
//import com.mycapstone.opinionpoll.models.User;
//import com.mycapstone.opinionpoll.models.data.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//public class UserServiceStubImpl implements UserService {
//
//    @Autowired
//    private UserDao userDao;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Transactional
//    @Override
//    public User save(UserForm userForm) throws EmailExistException {
//
//        User existingUser = userDao.findByEmail(userForm.getEmail());
//        if (existingUser != null)
//            throw new EmailExistException("The email address "
//                    + userForm.getEmail() + " already exists in the system");
//
//        User newUser = new User(userForm.getEmail(),
//               userForm.getFullName(),
//                passwordEncoder.encode(userForm.getPassword()));
//        userDao.save(newUser);
//
//        return newUser;
//    }
//
//    @Override
//    public User findByEmail(String email) {
//        return userDao.findByEmail(email);
//    }
//
//}
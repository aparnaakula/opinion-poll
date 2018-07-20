package com.mycapstone.opinionpoll.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycapstone.opinionpoll.forms.UserForm;
import com.mycapstone.opinionpoll.models.User;
import com.mycapstone.opinionpoll.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
 public class UserServiceImpl implements UserService {

 	private final UserRepository userRepository;

 
	@Override
	public User save(UserForm userForm) throws EmailExistException {

		User existingUser = userRepository.findByEmail(userForm.getEmail());
		if (existingUser != null)
			throw new EmailExistException("The email address " + userForm.getEmail() + " already exists in the system");

		User newUser = new User();
		newUser.setEmail(userForm.getEmail());
		newUser.setLastName(userForm.getFullName());
		newUser.setPwHash(userForm.getPassword());
		userRepository.save(newUser);
		return newUser;
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
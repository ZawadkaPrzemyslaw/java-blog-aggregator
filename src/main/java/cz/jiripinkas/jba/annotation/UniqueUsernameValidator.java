package cz.jiripinkas.jba.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cz.jiripinkas.jba.repository.UserRepository;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void initialize(UniqueUsername arg0) {
	}

	@Override
	public boolean isValid(String userName, ConstraintValidatorContext arg1) {
		if(userRepository == null)
			return true;
		return userRepository.findByName(userName) == null;
	}

}

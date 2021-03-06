package com.example.demo.service.impl;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO getUserByID(Integer userId) {
		UserDTO userDTO = new UserDTO();
		User user = userRepository.findByUserId(userId).get();
		BeanUtils.copyProperties(user, userDTO);
		
		return userDTO;
	}
	
}

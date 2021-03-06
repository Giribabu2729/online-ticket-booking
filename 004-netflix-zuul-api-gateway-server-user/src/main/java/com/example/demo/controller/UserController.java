package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.AuthenticationRequest;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;

@RestController
//	@RequestMapping("/users")
public class UserController {

	@Autowired
	JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String sayHello() {
		return "Welcome to JWT Security";
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUserByUserID(@PathVariable Integer userId) {

		UserDTO userDTO = userService.getUserByID(userId);

		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);

	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthenticationRequest authRequest) throws Exception {

		// System.out.println(authRequest.getUserName());
		// System.out.println(authRequest.getPassword());

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("Invalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());

	}

}

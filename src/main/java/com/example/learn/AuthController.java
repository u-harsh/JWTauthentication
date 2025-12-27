package com.example.learn;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("/login")
	public Map<String, String> login(@RequestBody Map<String, String> user){
		
		if(user.get("username").equals("user") && user.get("password").equals("1234")) {
			String token = jwtService.generateToken(user.get("username"));
			return Map.of("token", token);
		}
		throw new RuntimeException("Invalid credentials");
	}
}

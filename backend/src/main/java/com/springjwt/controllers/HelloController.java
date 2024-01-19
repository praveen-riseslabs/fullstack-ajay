package com.springjwt.controllers;

import com.springjwt.dto.ResponseTokenDTO;
import com.springjwt.dto.UserDTO;
import com.springjwt.entities.User;
import com.springjwt.repositories.UserRepository;
import com.springjwt.services.jwt.UserDetailsServiceImpl;
import com.springjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping("/hii")
    public ResponseEntity<Map<String, String>> getUserDetails(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring(7); // Remove "Bearer " from the token
        String username = jwtUtil.extractUsername(token);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        User user = userRepository.findFirstByEmail(username);

        Map<String, String> userDetailsMap = new HashMap<>();
        userDetailsMap.put("username", userDetails.getUsername());
        userDetailsMap.put("phone", user.getPhone());
        userDetailsMap.put("gender", user.getGender());
        userDetailsMap.put("email", user.getEmail());
        userDetailsMap.put("name",user.getName());

        return ResponseEntity.ok(userDetailsMap);
    }

    @GetMapping("/done")
    public String sayhello(){
        return "hello user";
    }


}


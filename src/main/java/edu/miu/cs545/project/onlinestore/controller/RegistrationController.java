//package edu.miu.cs545.project.onlinestore.controller;
//
//import edu.miu.cs545.project.onlinestore.dto.NewUser;
//import edu.miu.cs545.project.onlinestore.service.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@CrossOrigin
//@RestController
//@RequestMapping("/signup")
//public class RegistrationController {
//    @Autowired
//    UserDetailsServiceImpl userDetailsService;
//
//    @PostMapping
//    public ResponseEntity<?> register(@RequestBody NewUser user) {
//
//        return new ResponseEntity<>(userDetailsService.signUpUser(user), HttpStatus.CREATED);
//    }
//}
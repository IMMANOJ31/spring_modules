package org.xworkz.springboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.xworkz.springboot.dto.UserDto;
import org.xworkz.springboot.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("")
    public ResponseEntity<String> saveUser(@Valid @RequestBody UserDto dto, BindingResult result){
        boolean isSaved = userService.saveUser(dto);
        if(isSaved == false){
            return ResponseEntity.badRequest().body("Validation failed "+result.getAllErrors());
        }else return ResponseEntity.ok("User saved successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getUserById(@PathVariable int id){
      UserDto userDto =  userService.fetchUserById(id);
        if(userDto != null) {
            return ResponseEntity.ok("User found: " + userDto);
        }else ResponseEntity.badRequest().body("User not found with id: " + id);
    }
}

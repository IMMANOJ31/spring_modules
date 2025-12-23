package org.xworkz.springboot.h2.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.xworkz.springboot.dto.UserDto;
import org.xworkz.springboot.h2.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    public UserController(){
        System.err.println("User controller invoked");
    }

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<String> saveUser(@Valid @RequestBody UserDto dto, BindingResult result){
        System.err.println("Invoking H2 saveUser method");
        boolean isSaved = userService.saveUser(dto);
        if(isSaved == false){
            return ResponseEntity.badRequest().body("Validation failed "+result.getAllErrors());
        }else return ResponseEntity.ok("User saved successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getUserById(@PathVariable int id){
        System.err.println("Invoking H2 UserById method");
        UserDto userDto =  userService.fetchUserById(id);
        if(userDto != null) {
            return ResponseEntity.ok("User found: " + userDto);
        }return ResponseEntity.badRequest().body("User not found");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @Valid @RequestBody UserDto dto,BindingResult result){
        System.err.println("Invoking H2 updateUser method");
        if (result.hasErrors()) {
            return ResponseEntity.badRequest()
                    .body("Validation failed: " + result.getAllErrors());
        }
        boolean isUpdated = userService.updateUser(id,dto);
        if (isUpdated == false) {
            return ResponseEntity.badRequest().body("Validation failed " + result.getAllErrors());
        } else
            return ResponseEntity.ok("User updated successfully");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        System.err.println("Invoking H2 deleteUser method");
        boolean isDeleted = userService.removeUser(id);
        if(isDeleted){
            return ResponseEntity.ok("User deleted successfully");
        }else {
            return ResponseEntity.badRequest().body("User not found");
        }
    }
}


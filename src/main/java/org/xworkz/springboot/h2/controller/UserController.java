package org.xworkz.springboot.h2.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.xworkz.springboot.mysql.dto.UserDto;
import org.xworkz.springboot.mysql.service.UserService;

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
        System.err.println("Invoking saveUser method");
        boolean isSaved = userService.saveUser(dto);
        if(isSaved == false){
            return ResponseEntity.badRequest().body("Validation failed "+result.getAllErrors());
        }else return ResponseEntity.ok("User saved successfully");
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getUserById(@PathVariable int id){
        System.err.println("Invoking UserById method");
        UserDto userDto =  userService.fetchUserById(id);
        if(userDto != null) {
            return ResponseEntity.ok("User found: " + userDto);
        }return ResponseEntity.badRequest().body("User not found");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @Valid @RequestBody UserDto dto,BindingResult result){
        System.err.println("Invoking updateUser method");
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
        System.err.println("Invoking deleteUser method");
        boolean isDeleted = userService.removeUser(id);
        if(isDeleted){
            return ResponseEntity.ok("User deleted successfully");
        }else {
            return ResponseEntity.badRequest().body("User not found");
        }
    }
}


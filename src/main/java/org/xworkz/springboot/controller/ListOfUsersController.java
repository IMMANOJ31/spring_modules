package org.xworkz.springboot.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.xworkz.springboot.dto.UserDto;
import org.xworkz.springboot.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ListOfUsersController {

    @Autowired
    UsersService service;

    @PostMapping("")
    public ResponseEntity<String> saveUsers(@Valid @RequestBody List<UserDto> userDto, BindingResult result){
       boolean isUserSaved =  service.saveUsers(userDto);
       if (isUserSaved == false){
         return ResponseEntity.badRequest().body("Validation failed "+result.hasErrors());
       }else
           return ResponseEntity.ok("Users saved successfully");
    }

    @GetMapping("")
    public ResponseEntity<String> fetchUsers(){
        List<UserDto> list = service.fetchUsers();
        if (list == null || list.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found ");
        }else return ResponseEntity.ok("Fetched users details");
    }

    @DeleteMapping("")
    public ResponseEntity<String> removeUsers(){
        boolean userList = service.removeUsers();
        if (userList == false){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No users found");
        }
        return ResponseEntity.ok("Removed user details");
    }
}

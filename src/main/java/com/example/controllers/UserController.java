package com.example.controllers;


import com.example.dto.UserDTO;
import com.example.dto.UserfrntDTO;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 사용자 추가 컨트롤러
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody UserfrntDTO userfrntDTO) {
        userService.createUser(new UserDTO(userfrntDTO.getUsername(), userfrntDTO.getPassword(), userfrntDTO.getName()));
        return new ResponseEntity<>(userfrntDTO.getUsername(), HttpStatus.CREATED);
    }


    // 사용자 이름...
    @RequestMapping(value = "/loadbyuser", method = RequestMethod.POST)
    public ResponseEntity loadbyuser(@RequestBody UserfrntDTO userfrntDTO) {
        User user = (User) userService.loadUserByUsername(userfrntDTO.getUsername());
        System.out.println("왔음 : "+user.getName());
        return new ResponseEntity<>(user.getName(), HttpStatus.OK);
    }

}

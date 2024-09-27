package com.chenzc.employeemanagementsystem.controller;

import com.chenzc.employeemanagementsystem.domain.BasicResult;
import com.chenzc.employeemanagementsystem.dto.UserDTO;
import com.chenzc.employeemanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public BasicResult register(@RequestBody UserDTO userDTO){
        return userService.register(userDTO);
    }

    @PostMapping("/login")
    public BasicResult login(@RequestBody UserDTO userDTO){
        return userService.login(userDTO);
    }

    @GetMapping("/info/{id}")
    public BasicResult showInfo(@PathVariable("id") Long userId){
        return userService.showInfo(userId);
    }

    @PostMapping("/password/reset")
    public BasicResult resetPassword(@RequestBody UserDTO userDTO){
        return userService.resetPassword(userDTO);
    }

    @PostMapping("/info/update")
    public BasicResult updateInfo(@RequestBody UserDTO userDTO){
        return userService.updateInfo(userDTO);
    }
    @GetMapping("/meeting")
    public BasicResult ListMeeting(){
        return userService.showMeeting();
    }
}
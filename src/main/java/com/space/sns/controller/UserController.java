//package com.space.sns.controller;
//
//import com.space.sns.controller.request.UserJoinRequest;
//import com.space.sns.controller.response.Response;
//import com.space.sns.controller.response.UserJoinResponse;
//import com.space.sns.model.User;
//import com.space.sns.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/users")
//@RequiredArgsConstructor
//public class UserController {
//    private final UserService userService;
//
//    @PostMapping("/join")
//    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest request) {
//        User user = userService.join(request.getUserName(), request.getPassword());
//
//        return Response.success(UserJoinResponse.fromUser(user));
//    }
//}
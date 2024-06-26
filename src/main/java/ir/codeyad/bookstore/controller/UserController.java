package ir.codeyad.bookstore.controller;

import ir.codeyad.bookstore.dto.request.UserRequest;
import ir.codeyad.bookstore.dto.response.UserResponse;
import ir.codeyad.bookstore.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping

    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.ok(userService.save(userRequest));
    }
}

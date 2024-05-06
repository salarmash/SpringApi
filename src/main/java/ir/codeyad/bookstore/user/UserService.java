package ir.codeyad.bookstore.user;

import ir.codeyad.bookstore.dto.request.UserRequest;
import ir.codeyad.bookstore.dto.response.UserResponse;
import ir.codeyad.bookstore.models.User;

import java.util.Optional;

public interface UserService {
    UserResponse save(UserRequest userRequest);


}

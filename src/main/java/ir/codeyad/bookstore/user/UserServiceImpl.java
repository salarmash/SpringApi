package ir.codeyad.bookstore.user;

import ir.codeyad.bookstore.dto.request.UserRequest;
import ir.codeyad.bookstore.dto.response.UserResponse;
import ir.codeyad.bookstore.execption.RuleExecption;
import ir.codeyad.bookstore.models.User;
import ir.codeyad.bookstore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class  UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserResponse save(UserRequest userRequest) {
        Optional<User> byUsername = userRepository.findByUsername(userRequest.getUsername());
        if(byUsername.isPresent())
            throw new RuleExecption("User.is.Exist");
        return createUserResponse(userRepository.save(createUser(userRequest)));

    }
    private UserResponse createUserResponse(User user){
        return  UserResponse.builder().id(user.getId()).username(user.getUsername()).build();
    }
    private User createUser(UserRequest userRequest){
        return  User.builder()
                .username(userRequest.getUsername()).
                password(userRequest.getPassword()).
                build();
    }

}

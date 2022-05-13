package kg.itacademy.exam6.service;

import kg.itacademy.exam6.model.UserAuthModel;
import kg.itacademy.exam6.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserModel createUser ( UserModel userModel );

    Boolean deleteUserById ( Long userId );

    UserModel getUserById ( Long userId );

    String getToken ( UserAuthModel userAuthDto );

    List<UserModel> getAllUsers ();

    Boolean updateUser ( UserModel userModel );

}

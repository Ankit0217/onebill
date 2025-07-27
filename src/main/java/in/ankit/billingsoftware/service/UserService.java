package in.ankit.billingsoftware.service;


import in.ankit.billingsoftware.io.UserRequest;
import in.ankit.billingsoftware.io.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse createUser(UserRequest request);

    String getUserRole(String email);

    List<UserResponse> readUsers();

    void deleteUser(String id);
}
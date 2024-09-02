package de.ait.shop43.security;


import java.util.List;

public interface UserService {

    //public UserResponseDto getUserById(Long id);

    public UserResponseDto createUser(UserRequestDto dto);

    public UserResponseDto setAdminRole(String username);

    public List<UserResponseDto> getUsers();
}

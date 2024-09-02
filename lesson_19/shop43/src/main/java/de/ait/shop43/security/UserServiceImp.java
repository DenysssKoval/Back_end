package de.ait.shop43.security;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService, UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserResponseDto createUser(UserRequestDto dto) {
        return null;
    }

    @Override
    public UserResponseDto setAdminRole(String name) {
        return null;
    }

    @Override
    public List<UserResponseDto> getUsers() {
        return List.of();
    }

    // как спринг получает юзера по логину
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return repository.findUserByName(name).orElse(null);
    }
}

package by.andron.service.impl;


import by.andron.annotation.Profiling;
import by.andron.dto.UserCreationDto;
import by.andron.exception.ServiceException;
import by.andron.mapper.UserMapper;
import by.andron.model.User;
import by.andron.service.UserService;
import lombok.RequiredArgsConstructor;
import by.andron.dto.UserDto;
import by.andron.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Profiling
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDto findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ServiceException("Cannot find user by id in service", HttpStatus.BAD_REQUEST));
        return userMapper.toDto(user);
    }

    public List<UserDto> findAll(int page, int size) {
        return userRepository.findAll(page, size).stream()
                .map(userMapper::toDto).toList();
    }

    public UserDto save(UserCreationDto userCreationDto) {
        User entity = userMapper.toEntity(userCreationDto);
        return userMapper.toDto(userRepository.save(entity));
    }

    public void update(Long id, UserCreationDto userCreationDto) {
        userRepository.update(id, userMapper.toEntity(userCreationDto));
    }

    public void delete(Long id) {
        userRepository.delete(id);
    }

}

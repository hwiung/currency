package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.UserRequestDto;
import com.sparta.currency_user.dto.UserResponseDto;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.global.CustomException;
import com.sparta.currency_user.global.ErrorCodeEnum;
import com.sparta.currency_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto findById(Long id) {
        return new UserResponseDto(findUserById(id));
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCodeEnum.USER_NOT_FOUND));
    }

    public List<UserResponseDto> findAll() {
        return userRepository.findAll().stream().map(UserResponseDto::toDto).toList();
    }

    @Transactional
    public UserResponseDto save(UserRequestDto userRequestDto) {
        User user = new User(userRequestDto.getEmail(),userRequestDto.getName());
        User savedUser = userRepository.save(user);

        UserResponseDto userResponseDto = new UserResponseDto(savedUser.getId(),savedUser.getName(), savedUser.getEmail());
        return userResponseDto;



//        User savedUser = userRepository.save(userRequestDto.toEntity());
//        return new UserResponseDto(savedUser);
    }

    @Transactional
    public void deleteUserById(Long id) {
        this.findUserById(id);
        userRepository.deleteById(id);
    }

}

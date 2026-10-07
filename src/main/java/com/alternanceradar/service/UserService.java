package com.alternanceradar.service;

import com.alternanceradar.entity.User;
import com.alternanceradar.exception.EmailAlreadyExistsException;
import com.alternanceradar.exception.ResourceNotFoundException;
import com.alternanceradar.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException("Email already in use: " + user.getEmail());
        }
        return userRepository.save(user);
    }

    public User getUser(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(UUID id, User updatedUser) {
        User existingUser = getUser(id);

        if (!existingUser.getEmail().equals(updatedUser.getEmail())
                && userRepository.existsByEmail(updatedUser.getEmail())) {
            throw new EmailAlreadyExistsException("Email already in use: " + updatedUser.getEmail());
        }

        existingUser.setName(updatedUser.getName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setTargetField(updatedUser.getTargetField());

        return userRepository.save(existingUser);
    }

    public void deleteUser(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}

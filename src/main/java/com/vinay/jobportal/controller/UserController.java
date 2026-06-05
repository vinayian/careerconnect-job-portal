package com.vinay.jobportal.controller;
import jakarta.validation.Valid;
import java.util.List;
import com.vinay.jobportal.entity.User;
import com.vinay.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

        @DeleteMapping("/{id}")
        public String deleteUser(@PathVariable Long id) {
            userRepository.deleteById(id);
            return "User deleted successfully";

    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {

        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            user.setFullName(updatedUser.getFullName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setRole(updatedUser.getRole());

            return userRepository.save(user);
        }

        return null;
    }
}
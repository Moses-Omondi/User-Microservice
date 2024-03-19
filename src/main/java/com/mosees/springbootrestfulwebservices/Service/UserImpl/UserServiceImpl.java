package com.mosees.springbootrestfulwebservices.Service.UserImpl;

import com.mosees.springbootrestfulwebservices.Entity.User;
import com.mosees.springbootrestfulwebservices.Repository.UserRepository;
import com.mosees.springbootrestfulwebservices.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByID(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new RuntimeException("User not found with id: " + userId);
        }


    }

    @Override
    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user)
    {
        Optional<User> existingUserOptional = userRepository.findById(user.getId());

        if(existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            // Update the properties of the existing user.
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());

            userRepository.save(existingUser);

            return existingUser;
        } else {
            throw new RuntimeException("User not found with id: " + user.getId());
        }
    }

    @Override
    public void deleteUser(Long userId)
    {
        userRepository.deleteById(userId);
    }

}

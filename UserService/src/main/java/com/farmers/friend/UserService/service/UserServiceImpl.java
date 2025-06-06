package com.farmers.friend.UserService.service;



import com.farmers.friend.UserService.models.User;
import com.farmers.friend.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserKafkaProducer userKafkaProducer;

    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder(12);

    @Override
    public String createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
       User savedUser= userRepository.save(user);
        userKafkaProducer.sendUser(savedUser);
        return "User saved successfully";
    }


}

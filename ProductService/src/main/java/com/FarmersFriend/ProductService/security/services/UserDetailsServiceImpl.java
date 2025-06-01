package com.FarmersFriend.ProductService.security.services;



import com.FarmersFriend.ProductService.models.User;
import com.FarmersFriend.ProductService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

     @Autowired
     UserRepository userRepository;

    @Override
    @Transactional
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
        return UserDetailsImpl.build(user);
    }
}

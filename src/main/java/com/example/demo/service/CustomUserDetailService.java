package com.example.demo.service;

import com.example.demo.entities.Users;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = iUserRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("not found");
        }
        return new CustomUserDetails(user);
    }

}

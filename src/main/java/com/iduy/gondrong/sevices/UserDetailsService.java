package com.iduy.gondrong.sevices;

import com.iduy.gondrong.models.User;
import com.iduy.gondrong.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private final UserRepository repository;

    public UserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not Found"));
        return UserDetailsImpl.build(user);
    }
}

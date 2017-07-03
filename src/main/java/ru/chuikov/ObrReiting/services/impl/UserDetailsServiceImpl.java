package ru.chuikov.ObrReiting.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.chuikov.ObrReiting.entity.User;


import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserServiceImpl userService;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user=userService.getByLogin(login);
        Set<GrantedAuthority> role=new HashSet<GrantedAuthority>();
        role.add(new SimpleGrantedAuthority(user.getRight().getName()));
        UserDetails userDetails=new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),role);
        return userDetails;
    }
}

package com.bannershallmark.serviceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;


import com.bannershallmark.dao.UsersDao;
import com.bannershallmark.entity.Users;
import com.bannershallmark.service.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UsersDao userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Users user = userRepository.getUserByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
    }

	

}

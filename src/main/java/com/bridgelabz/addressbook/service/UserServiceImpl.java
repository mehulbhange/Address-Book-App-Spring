package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.entity.User;
import com.bridgelabz.addressbook.repository.UserRepository;
import com.bridgelabz.addressbook.utility.TokenUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private TokenUtility tokenUtility;

    @Override
    public User createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @Override
    public String userLogin(User user) {
        User fetchedUser = userRepo.findById(user.getEmail()).orElse(null);
        String token = null;
        if (fetchedUser != null){
            if (bCryptPasswordEncoder.matches(user.getPassword(), fetchedUser.getPassword())){
                token = tokenUtility.createToken(user.getEmail());
            }
        }
        return token;
    }

    public User loadUserByUsername(String username){
        return userRepo.findById(username).orElse(null);
    }


}

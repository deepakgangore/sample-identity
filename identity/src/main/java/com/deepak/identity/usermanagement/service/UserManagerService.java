package com.deepak.identity.usermanagement.service;

import com.deepak.identity.usermanagement.entity.User;
import com.deepak.identity.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dgangore on 8/10/2017.
 */
@Service
public class UserManagerService {
    private UserRepository userRepository;


    @Autowired
    public UserManagerService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    /**
     * Create a user
     * @param user
     * @return User
     */
    public User createUser(User user){
        return userRepository.save(user);
    }

    /**
     * Modify User
     * @param user
     * @return Modified user
     */
    public User modifyUser(User user){
        if(user.getUserId() != 0L){
            return  userRepository.save(user);
        }else{
            throw new RuntimeException("User Id not passed");
        }
    }

    /**
     * Get all users
     * @return List of users
     */
    public List<User> getAllUsers(){
        Iterable<User> iterable = userRepository.findAll();
        if(iterable == null)
            return null;
        List<User> userList = new ArrayList<>();
        for(User user : iterable){
            userList.add(user);
        }
        return userList;
    }

    /**
     * Get User object by supplying userId
     * @param userId
     * @return User
     */
    public User getDetails(long userId){
        return userRepository.findByUserId(userId);
    }

    /**
     * Disable a user
     * @param userId
     */
    public void disableUser(long userId){
        User user = userRepository.findByUserId(userId);
        user.setIdentityStatus(Boolean.FALSE);
        userRepository.save(user);
    }

    /**
     * Enable a user
     * @param userId
     */
    public void enableUser(long userId){
        User user = userRepository.findByUserId(userId);
        user.setIdentityStatus(Boolean.TRUE);
        userRepository.save(user);
    }

    /**
     * Lock a user
     * @param userId
     */
    public void lockUser(long userId){
        User user = userRepository.findByUserId(userId);
        user.setLocked(Boolean.TRUE);
        userRepository.save(user);
    }

    /**
     * Unlock a user
     * @param userId
     */
    public void unlockUser(long userId){
        User user = userRepository.findByUserId(userId);
        user.setLocked(Boolean.FALSE);
        userRepository.save(user);
    }

}

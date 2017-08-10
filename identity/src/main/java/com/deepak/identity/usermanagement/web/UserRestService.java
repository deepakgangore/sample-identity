package com.deepak.identity.usermanagement.web;

import com.deepak.identity.usermanagement.dto.UserStatus;
import com.deepak.identity.usermanagement.entity.User;
import com.deepak.identity.usermanagement.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by dgangore on 8/10/2017.
 */
@RestController
@RequestMapping(path = "/api/User")
public class UserRestService {

    @Autowired
    private UserManagerService userManagerService;


    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return userManagerService.createUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public User modifyUser(@RequestBody User user){
        return userManagerService.modifyUser(user);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{userId}")
    public User getDetails(@PathVariable(value = "userId") long userId){
        return userManagerService.getDetails(userId);
    }

    @RequestMapping(method = RequestMethod.PATCH, path = "/{userId}")
    public void performUserOperations(@PathVariable(value = "userId") long userId, @RequestBody UserStatus status){
        if(Optional.ofNullable(status).get().isIdentityStatus())
            userManagerService.enableUser(userId);
        else
            userManagerService.disableUser(userId);

        if(Optional.ofNullable(status).get().isLockedStatus())
            userManagerService.lockUser(userId);
        else
            userManagerService.unlockUser(userId);
    }
}

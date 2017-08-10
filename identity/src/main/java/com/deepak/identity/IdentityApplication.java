package com.deepak.identity;

import com.deepak.identity.usermanagement.entity.User;
import com.deepak.identity.usermanagement.service.UserManagerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class IdentityApplication implements CommandLineRunner {

	@Autowired
	private  UserManagerService userManagerService;


	public static void main(String[] args) {
		SpringApplication.run(IdentityApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception{
	    User user = new User();
        user.setUserName("dgangore");
        user.setFirstName("Deepak");
        user.setLastName("Gangore");

		User usr = userManagerService.createUser(user);
		System.out.println("User Object->"+usr);

		usr.setUserName("deepakg");
		usr = userManagerService.modifyUser(usr);
		System.out.println("After Modify: User Object->"+usr);

		User usr1 = userManagerService.getDetails(usr.getUserId());
		System.out.println("Get Details: User Object->"+usr1);

		userManagerService.disableUser(usr.getUserId());
		usr1 = userManagerService.getDetails(usr.getUserId());
		System.out.println("After Disable: User Object->"+usr1);

        userManagerService.enableUser(usr.getUserId());
        usr1 = userManagerService.getDetails(usr.getUserId());
        System.out.println("After Enable: User Object->"+usr1);

		userManagerService.lockUser(usr.getUserId());
		usr1 = userManagerService.getDetails(usr.getUserId());
		System.out.println("After Lock: User Object->"+usr1);

        userManagerService.unlockUser(usr.getUserId());
        usr1 = userManagerService.getDetails(usr.getUserId());
        System.out.println("After Unlock: User Object->"+usr1);
	}

}

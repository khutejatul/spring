package com.nagarro.interfaces;

import com.nagarro.models.User;

public interface LoginInterface {

	Boolean userAuthentication(String username, String password);

	User getUserDetails(String username);

}

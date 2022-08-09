package com.nagarro.services;

import org.hibernate.Session;

import com.nagarro.interfaces.LoginInterface;
import com.nagarro.models.User;
import com.nagarro.utils.HibernateUtilities;

public class LoginImplementation implements LoginInterface {
	@Override
	public Boolean userAuthentication(String username, String password) {
		try (Session session = HibernateUtilities.getSessionInstance()) {
			session.getTransaction().begin();
			User user = session.get(User.class, username);
			if (user.getUsername() != null && user.getPassword().equals(password))
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public User getUserDetails(String username) {
		User user = null;
		try (Session session = HibernateUtilities.getSessionInstance();) {
			session.getTransaction().begin();
			user = session.get(User.class, username);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	public void updatePassword(String username, String password) {
		User user = null;
		try (Session session = HibernateUtilities.getSessionInstance();) {
			session.getTransaction().begin();
			user = session.get(User.class, username);
			user.setPassword(password);
			session.update(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

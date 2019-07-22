package com.music.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.dao.UserDAOImp;
import com.music.entity.User;
@Service("userService")
public class UserServiceImp implements UserService{

	@Autowired
	UserDAOImp us;
	
	
	@Override
	@Transactional
	public boolean createUser(User user) {
		 if(us.addUser(user)!=null) {
			 return true;
		 }
		 return false;
	}

	@Override
	@Transactional
	public boolean deleteUser(User user) {
		System.out.println(user.getUserId());
		return us.delteUserbyId(user.getUserId());
		
	}

	@Override
	@Transactional
	public User updateUser(User user) {
		System.out.println(" I am update user");
		return us.addUser(user);
		
	}
//
//	@Override
//	@Transactional
//	public User updatePassword(User user) {
//		return new UserDAOImp().updateUsername(user.getUserId(),user.getPassword());
//		
//	}
//
//	@Override
//	public User updateFirst(User user) {
//		return new UserDAOImp().updateUsername(user.getUserId(),user.getFirstName());
//		
//	}
//
//	@Override
//	public User updateLast(User user) {
//		return new UserDAOImp().updateUsername(user.getUserId(),user.getLastName());
//		
//	}

	@Override
	@Transactional
	public User getUserById(User user) {
		return us.viewUserByID(user.getUserId());
	}
	@Transactional
	public User getUserByUsername(User user) {
		return us.viewUserByUsername(user.getUserName());
		
	}

	@Override
	@Transactional
	public User Authenticate(User user) {
		
		User temp=us.viewUserByUsername(user.getUserName());
		if(temp!=null) {
			if(user.getPassword().equals(temp.getPassword())) {
//				req.getSession().setAttribute("loggedEmployee", loggedEmployee);
				return user;
			}
			return null;
		}
		return null;
	}

}

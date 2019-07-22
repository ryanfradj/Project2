package com.music.service;

import com.music.entity.User;

public interface UserService {

	public boolean createUser(User user);
	public boolean deleteUser(User user);
	public User updateUser(User user);
//	public User updatePassword(User user);
//	public User updateFirst(User user);
//	public User updateLast(User user);
	public User getUserById(User user);
	public User getUserByUsername(User user);
	public User Authenticate(User user);
}

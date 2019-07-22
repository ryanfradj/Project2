package com.music.dao;

import java.util.List;

import com.music.entity.User;

interface UserDAO {

	public User addUser(User user);
	public boolean delteUserbyId(long id);
//	public User updateUsername(long id, String username);
//	public User updateUserpass(long id,String password);
//	public User updateUserfirst(long id,String first);
//	public User updatelast(long id,String last);
	public User viewUserByID(long id);
	public User viewUserByUsername(String username);
	public List<User> viewAllUsers();
//	public User viewUserByFirstandLast(String first, String last);	
	
}

package com.music.controller;

import java.awt.print.Book;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.entity.User;
import com.music.service.UserServiceImp;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserServiceImp us;

	@PostMapping(value = "loginNow")
	public String login(HttpServletRequest req) {
		User temp = new User((String) req.getParameter("username"), (String) req.getParameter("password"));
		if (us.Authenticate(temp) != null) {
			req.getSession().setAttribute("loggedEmployee", us.Authenticate(temp));
		}
		return "Succ";
	}

	@GetMapping(value = "logout")
	public Object logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return true;
	}

	@GetMapping(value = "account")
	public Object viewUser(HttpServletRequest req) {
		User temp = (User) req.getSession().getAttribute("loggedEmployee");
		return us.getUserById(temp);
	}

	@PostMapping(value = "account/update")
	public Object updateUser(@ModelAttribute("user") User user) {
		return us.createUser(user);
	}

}

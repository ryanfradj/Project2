package com.music.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.music.entity.User;
@Repository
public class UserDAOImp implements UserDAO {
	@Autowired
	SessionFactory sessionFact;

	@Override
	public User addUser(User user) {
		System.out.println(user.getFirstName());
	sessionFact.getCurrentSession().saveOrUpdate(user);
	return user;
	
	}
	@Override
	public boolean delteUserbyId(long id) {
	User user = sessionFact.getCurrentSession().get(User.class, id);
	sessionFact.getCurrentSession().delete(user);
	return true;
	}


	@Override
	public User viewUserByID(long id) {
		return (User)sessionFact.getCurrentSession().get(User.class, id);
	}

//	@Override
//	public User updateUsername(long id, String username) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			{
//				User user = session.get(User.class, id);
//				if (user != null) {
//					user.setUserName(username);
//					session.beginTransaction();
//					session.update(user);
//					session.getTransaction().commit();
//					return user;
//				} else {
//					return null;
//				}
//			}
//		}
//	}
//
//	@Override
//	public User updateUserpass(long id, String password) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			{
//				User user = session.get(User.class, id);
//				if (user != null) {
//					user.setPassword(password);
//					session.beginTransaction();
//					session.update(user);
//					session.getTransaction().commit();
//					return user;
//				} else {
//					return null;
//				}
//			}
//		}
//	}
//
//	@Override
//	public User updateUserfirst(long id, String first) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			{
//				User user = session.get(User.class, id);
//				if (user != null) {
//					user.setFirstName(first);
//					session.beginTransaction();
//					session.update(user);
//					session.getTransaction().commit();
//					return user;
//				} else {
//					return null;
//				}
//			}
//		}
//	}
//
//	@Override
//	public User updatelast(long id, String last) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			{
//				User user = session.get(User.class, id);
//				if (user != null) {
//					user.setLastName(last);
//					session.beginTransaction();
//					session.update(user);
//					session.getTransaction().commit();
//					return user;
//				} else {
//					return null;
//				}
//			}
//		}
//
//	}

	@Override
	public User viewUserByUsername(String username) {
		Criteria crit = sessionFact.getCurrentSession().createCriteria(User.class);
		crit.add(Restrictions.eq("description","Mouse"));
		 User result= (User)crit.uniqueResult();
		 return result;
	}
	@Override
	public List<User> viewAllUsers() {
		ArrayList<User> userList = new ArrayList<>();
		Query query= sessionFact.getCurrentSession().createQuery("from User");
		userList=(ArrayList<User>) query.getResultList();
		return userList;
	}

//	@Override
//	public User viewUserByFirstandLast(String first, String last) {
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			User temp = session.QUERY
//			if (temp != null) {
//				return temp;
//			} else {
//				return null;
//			}
//
//		}
//	}
}

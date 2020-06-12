package Hibernatecustomizespringboot.Hibernatecustomize.reposatory;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Hibernatecustomizespringboot.Hibernatecustomize.domain.User;

@Repository
@Transactional
public class UserReposatory {
	
	@Autowired
	private SessionFactory sessionFactory;
 
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Transactional
	public User save(User user){
		 Session session = this.sessionFactory.getCurrentSession();
		 session.save(user);
		 return user;
	}
	
	public List<User> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User>  userList = session.createQuery("from User").list();
		return userList;
	}
	public User getUser(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}
	
	@Transactional
	public void updateUser(User updateUser,long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		if(user!=null){
			user.setName(updateUser.getName());
			user.setLastName(updateUser.getLastName());
			user.setAddress(updateUser.getAddress());
			session.update(user);
		}
	}
	
	@Transactional
	public void deleteUser(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, id);
		if (null != user) {
			session.delete(user);
		}
	} 
	
	public List<User> getAllUsersByCriteria() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(User.class);
		return crit.list();
	}
	
	public List<User> getAllUsersByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("name",name));
		List<User> results = crit.list();
		return results;
	}
	

}

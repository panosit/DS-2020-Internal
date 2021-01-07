package gr.hua.it21840.it21848.it21666.dao;
import org.springframework.stereotype.*;

import gr.hua.it21840.it21848.it21666.entity.User;

import javax.transaction.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
    private SessionFactory sessionFactory;
	@Override
    @Transactional
	public void insertUser(User user){
		Session session=this.sessionFactory.getCurrentSession();
		session.persist(user);
	}
	@Override
	@Transactional
	public User getUserByUsername(String username){
		Session session=this.sessionFactory.getCurrentSession();
		User user=null;
		try{
		user=session.createQuery("from User where username='"+username+"'",User.class).getSingleResult();
		}catch(Exception exception){}
		return user;
	}
	@Override
	@Transactional
	public void deleteUser(User user){
		Session session=this.sessionFactory.getCurrentSession();
		session.delete(user);
	}
	@Override
	@Transactional
	public User getUserByUsernameAndPassword(String username,String password){
		Session session=this.sessionFactory.getCurrentSession();
        User user=null;
        try{
        	 user=(User)session.createQuery("from User where username='"+username+"'and password="+password);
	    }catch(Exception exception){}
		return user;
	}
	@Override
	@Transactional
	public void updateUser(User user){
		Session session=this.sessionFactory.getCurrentSession();
		session.update(user);
	}
}
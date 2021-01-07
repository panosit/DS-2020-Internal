package gr.hua.it21840.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.it21840.entity.UserInformation;


@Repository
public class UserInformationDAOImpl implements UserInformationDAO {

	
	@Autowired
    private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public void insertUserInformation(UserInformation userInformation) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(userInformation);
		
	}

	@Override
	@Transactional
	public void deleteUserInformation(UserInformation userInformation) {
		Session session=this.sessionFactory.getCurrentSession();
		session.delete(userInformation);		
	}

}

package gr.hua.it21840.dao;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import gr.hua.it21840.entity.Application;

import javax.transaction.*;
import java.util.*;

@Repository
public class ApplicationDAOImpl implements ApplicationDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public void insertApplication(Application application){
        Session session=this.sessionFactory.getCurrentSession();
        session.save(application);
    }
    @Override
    @Transactional
    public List<Application> getApplications(){
        Session session=this.sessionFactory.getCurrentSession();
        Query<Application> query=session.createQuery("from Application ",Application.class);
        return query.getResultList();
    }
    @Override
    @Transactional
    public List<Application> getApplicationsByParentLastName(String parent_last_name){
        Session session=this.sessionFactory.getCurrentSession();
        Query<Application> query=session.createQuery("from Application where parent_last_name='"+parent_last_name+"'",Application.class);
        return query.getResultList();
    }
    
    
	@Override
    @Transactional
	public void deleteApplication(int id) {
        Session session=this.sessionFactory.getCurrentSession();
        Application application=this.getApplicationById(id);
        try{
            session.delete(application);
        }catch(Exception ignored){}   
	}
	
	
	@Override
    @Transactional
	public Application getApplicationById(int id) {
        Session session=this.sessionFactory.getCurrentSession();
        Application application=null;
        try {
            application=session.createQuery("from Application where id=" + id, Application.class).getSingleResult();
        }catch (Exception ingored){}
        return application;
	}
}
package gr.hua.it21840.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.it21840.entity.Teacher;

@Repository
public class TeacherDAOImpl implements TeacherDAO{
	
	
	@Autowired
    private SessionFactory sessionFactory;

	
	@Override
	@Transactional
	public void insetTeacher(Teacher teacher) {
		Session session=this.sessionFactory.getCurrentSession();
		session.save(teacher);		
	}

	@Override
	@Transactional
	public void deleteTeacher(Teacher teacher) {
		Session session=this.sessionFactory.getCurrentSession();
		session.delete(teacher);	
		
	}

	@Override
	@Transactional
	public Teacher getTeacherByUsername(String username) {
		Session session=this.sessionFactory.getCurrentSession();
		Teacher teacher =null;
		try{
			teacher=session.createQuery("from Teacher where username='"+username+"'",Teacher.class).getSingleResult();
		}catch(Exception a){
				System.out.print(a.getMessage());
		}
		return teacher;
	}

	@Override
	@Transactional
	public List<Teacher> getTeachers() {
        Session session=this.sessionFactory.getCurrentSession();
        Query<Teacher> query=session.createQuery("from Teacher",Teacher.class);
        List<Teacher> a=query.getResultList();
        return a;
	}

}

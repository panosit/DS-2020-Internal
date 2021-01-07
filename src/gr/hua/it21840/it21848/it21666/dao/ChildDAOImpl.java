package gr.hua.it21840.it21848.it21666.dao;
import org.hibernate.query.Query;
import org.springframework.stereotype.*;

import gr.hua.it21840.it21848.it21666.entity.Child;

import javax.transaction.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import java.util.*;

@Repository
public class ChildDAOImpl implements ChildDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<Child> getChildByClass(int tmima){
        Session session=this.sessionFactory.getCurrentSession();
        Query<Child> query=session.createQuery("from Child where classroom=:GivenClass",Child.class).setParameter("GivenClass", tmima);
        assert query!=null;
        return query.getResultList();
    }
    @Override
    @Transactional
    public void insertChild(Child child){
        Session session=this.sessionFactory.getCurrentSession();
        session.persist(child);
    }
}
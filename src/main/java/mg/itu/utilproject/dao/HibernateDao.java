package mg.itu.utilproject.dao;

import mg.itu.utilproject.modele.BaseModele;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class HibernateDao {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(BaseModele obj) throws Exception {
        Session session = null;
        Transaction tr = null;
        try {
            session = getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.save(obj);
            tr.commit();
        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
      public void update(BaseModele obj) throws Exception {
        Session session = null;
        Transaction tr = null;
        try {
            session = getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.update(obj);
            tr.commit();
        } catch (Exception ex) {
            if (tr != null) {
                tr.rollback();
            }
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public void findById(BaseModele obj) throws Exception {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.load(obj, obj.getId());
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<BaseModele> findAll(BaseModele obj) throws Exception {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(obj.getClass());
            return criteria.list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
     public  List<? extends BaseModele> findAllById(BaseModele obj,String colonne) throws Exception {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(obj.getClass());
            criteria.add(Restrictions.eq(colonne,obj.getId()));
            return criteria.list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
     public  List<? extends BaseModele> findOneById(BaseModele obj,String colonne,String condition) throws Exception {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(obj.getClass());
            criteria.add(Restrictions.eq(colonne,condition));
            return criteria.list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
     public  List<? extends BaseModele> findOneById(BaseModele obj,String colonne,int condition,String colonne1,int condition1) throws Exception {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(obj.getClass());
            Criterion rest2= Restrictions.and(Restrictions.eq(colonne,condition),Restrictions.eq(colonne1,condition1));
            criteria.add(rest2);
            return criteria.list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

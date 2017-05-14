package mg.itu.appsolute.dao;

import java.lang.reflect.Field;
import mg.itu.appsolute.modele.BaseModele;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class HibernateDao {

    private SessionFactory sessionFactory;
    private static int pageSize = 3;

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

    public void delete(BaseModele obj) throws Exception {
        Session session = null;
        Transaction tr = null;
        try {
            session = getSessionFactory().openSession();
            tr = session.beginTransaction();
            session.load(obj,obj.getId());
            session.delete(obj);
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

    public void save(Session session, BaseModele obj) throws Exception {
        try {
            session.save(obj);
        } catch (Exception ex) {
            throw ex;
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
            ex.printStackTrace();
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
            this.where(criteria, obj);
            return criteria.list();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<? extends BaseModele> PaginationFind(BaseModele obj, int page, int recordePerPage) throws Exception {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(obj.getClass());
            int count = ((Long) criteria.setProjection(Projections.rowCount()).uniqueResult()).intValue();
            obj.setId((count / recordePerPage) + 1);
            System.out.println("taille table=========================>" + obj.getId());
            criteria = session.createCriteria(obj.getClass());
            criteria.setFirstResult((page - 1) * recordePerPage);
            criteria.setMaxResults(recordePerPage);
            criteria.addOrder(Order.desc("id"));
            return criteria.list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

 

    public List<? extends BaseModele> findAllById(BaseModele obj, String colonne) throws Exception {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(obj.getClass());
            criteria.add(Restrictions.eq(colonne, obj.getId()));
            return criteria.list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<? extends BaseModele> findOneById(BaseModele obj, String colonne, String condition) throws Exception {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(obj.getClass());
            criteria.add(Restrictions.eq(colonne, condition));
            return criteria.list();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<? extends BaseModele> findOneById(BaseModele obj, String colonne, int condition, String colonne1, int condition1) throws Exception {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(obj.getClass());
            Criterion rest2 = Restrictions.and(Restrictions.eq(colonne, condition), Restrictions.eq(colonne1, condition1));
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
     public BaseModele findByIdMaxDate(Session session, BaseModele obj) throws Exception {
        try {
            Criteria criteria = session.createCriteria(obj.getClass());
            /*ProjectionList projectionList = Projections.projectionList();
             projectionList.add(Projections.max("dateEntree"));
             criteria.setProjection(projectionList);*/
            this.where(criteria, obj);
            criteria.addOrder(Order.desc("dateEntree"));
            List<BaseModele> one = criteria.list();
            //System.out.print("=======================>"+one.size());
            return one.get(0);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void where(Criteria criteria, BaseModele model) throws Exception {

        Field[] attribue = model.getClass().getDeclaredFields();
        int i = 0;
        System.out.print("ID=====================>" + model.getId());
        for (i = 0; i < attribue.length; i++) {
            String apresGet = attribue[i].getName().substring(0, 1).toUpperCase() + attribue[i].getName().substring(1, attribue[i].getName().length());
            String methode = "get" + apresGet;
            System.out.print("=====================>" + methode);
            if ((methode.compareTo("getLieu") != 0) && (methode.compareTo("getNomb") != 0) && (methode.compareTo("getPrenomb") != 0)) {
                Class<?> maclasse = model.getClass();
                Object o = maclasse.getMethod(methode).invoke(model);
                if (o != null) {
                 
                    if (testInt(o) != 0) {
                        //System.out.print("=====================>" + testInt(o));
                        criteria.add(Restrictions.eq(attribue[i].getName(), o));
                    }

                }
            }
        }
    }

    public int testInt(Object wa) {
        if (wa instanceof Integer) {
            try {
                int b = (Integer) wa;
                System.out.print("testint=====================>" + b);
                return b;
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
                return 0;
            }
        }
        if ((wa instanceof Double) || (wa instanceof Float)) {
            return 0;
        }
        return -1;
    }
}

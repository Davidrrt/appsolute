/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.itu.appsolute.service;

import java.util.List;
import mg.itu.appsolute.dao.HibernateDao;
import mg.itu.appsolute.modele.BaseModele;
import org.hibernate.Session;

/**
 *
 * @author davra
 */
public class BaseService {

    private HibernateDao session;

    public void save(BaseModele obj) throws Exception {
        session.save(obj);
    }

    public void delete(BaseModele obj) throws Exception {
        session.delete(obj);
    }

    public void save(Session ses, BaseModele obj) throws Exception {
        session.save(ses, obj);
    }

    public void update(BaseModele obj) throws Exception {
        session.update(obj);
    }

    public void findById(BaseModele obj) throws Exception {
        session.findById(obj);
    }

    public List<? extends BaseModele> PaginationFind(BaseModele obj, int page, int recordePerPage) throws Exception {
        return session.PaginationFind(obj, page, recordePerPage);
    }

    public List<? extends BaseModele> findAll(BaseModele obj) throws Exception {
        return session.findAll(obj);
    }

    public List<? extends BaseModele> findAllById(BaseModele obj, String colonne) throws Exception {
        return session.findAllById(obj, colonne);
    }

    public HibernateDao getSession() {
        return session;
    }

    public void setSession(HibernateDao session) {
        this.session = session;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.itu.appsolute.controller;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import mg.itu.appsolute.helper.Helper;
import mg.itu.appsolute.helper.ImportService;
import mg.itu.appsolute.modele.Employe;
import mg.itu.appsolute.service.EmployeService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author davra
 */
public class EmployeAction extends org.apache.struts.action.Action {

    private final ApplicationContext c = new ClassPathXmlApplicationContext("bean.xml");
    private final EmployeService util = c.getBean(EmployeService.class);
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    private List<Employe> table;
    private Employe human = new Employe();
    private HttpServletRequest request = ServletActionContext.getRequest();
    private int id;
    private int taille;
    public Helper utilite = new Helper();
    private List<String> pied;
    private ImportService utile = new ImportService();
    private File file;
    private String uploadFileName;

    public String execute() {
        try {
            if (request.getParameter("page") != null) {
                int pagenumber = Integer.parseInt(request.getParameter("page"));
                this.table = (List<Employe>) util.PaginationFind(human, pagenumber, 2);
                this.taille = human.getId();
                this.pied = utilite.footerpage(this.taille, pagenumber, "index.html");
                return SUCCESS;
            } else {
                this.table = (List<Employe>) util.PaginationFind(human, 1, 2);
                this.taille = human.getId();
                this.pied = utilite.footerpage(this.taille, 1, "index.html");
                return SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FAILURE;
    }

    public void setUpload(File file) {
        this.file = file;
    }

    public List<String> getPied() {
        return pied;
    }

    public String add() {
        return SUCCESS;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public String pradd() {
        try {
            
            //utile.uploadImg(this.file);
            //this.util.save(this.human);
            //  this.table = (List<Employe>) util.findAll(human);
            //this.human = new Employe();
            return SUCCESS;
        } catch (Exception ex) {
            Logger.getLogger(EmployeAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return FAILURE;
    }

    public String edit() {
        try {
            this.human.setId(this.id);
            //System.out.print("==================>"+this.human.getId());
            this.util.findById(this.human);
            return SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return FAILURE;
    }

    public String predit() {
        return SUCCESS;
    }

    public String delete() {
        try {
            this.human.setId(this.id);
            //System.out.print("==================>"+this.human.getId());
            this.util.findById(this.human);
            this.util.delete(this.human);
            this.table = (List<Employe>) util.findAll(human);
            this.human = new Employe();
            return SUCCESS;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return FAILURE;
    }

    public List<Employe> getTable() {
        return table;
    }

    public Employe getHuman() {
        return human;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String getUploadFileName() {
       return this.uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }
    

}

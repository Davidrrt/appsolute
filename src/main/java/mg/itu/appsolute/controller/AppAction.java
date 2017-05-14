package mg.itu.appsolute.controller;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import mg.itu.appsolute.helper.Helper;
import mg.itu.appsolute.helper.ImportService;
import mg.itu.appsolute.modele.Actualite;
import mg.itu.appsolute.modele.Album;
import mg.itu.appsolute.service.EmployeService;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author davra
 */
public class AppAction extends org.apache.struts.action.Action {

    private final ApplicationContext c = new ClassPathXmlApplicationContext("bean.xml");
    private final EmployeService util = c.getBean(EmployeService.class);
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    private List<Actualite> table;
    private HttpServletRequest request = ServletActionContext.getRequest();
    private Actualite init = new Actualite();
    private Album init2 = new Album();
    private int id;
    private int taille;
    public Helper utilite = new Helper();
    private List<String> pied;
    private List<Album> album;
    private File file;
    private String uploadFileName;
    public ImportService imp = new ImportService();

    public String execute() throws Exception {

        try {
            if (request.getParameter("page") != null) {
                int pagenumber = Integer.parseInt(request.getParameter("page"));
                this.table = (List<Actualite>) util.PaginationFind(init, pagenumber, 4);
                this.taille = init.getId();
                this.pied = utilite.footerpage(this.taille, pagenumber, "app.html");
                return SUCCESS;
            } else {
                this.table = (List<Actualite>) util.PaginationFind(init, 1, 4);
                this.taille = init.getId();
                this.pied = utilite.footerpage(this.taille, 1, "app.html");
                return SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FAILURE;
    }

    public String album() {
        try {
            if (request.getParameter("id") != null) {
                int idac = Integer.parseInt(request.getParameter("id"));
                Album t = new Album();
                t.setActu(idac);
                System.out.print("====================>" + t.getId());
                this.album = (List<Album>) util.findAll(t);
                return SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FAILURE;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public String add() {
        return SUCCESS;
    }

    public String pradd() {
        try {

            ServletContext context = ServletActionContext.getServletContext();
            imp.uploadImg(file, uploadFileName, context);
            System.out.println("=============>" + init.getDateactu());
            String val = uploadFileName;
            init.setImageactu(val);
            util.save(init);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return FAILURE;
        }
    }

    public String addAlbum() {
        if (request.getParameter("id") != null) {
            int idac = Integer.parseInt(request.getParameter("id"));
            this.init2.setActu(idac);
            return SUCCESS;
        }
        return FAILURE;
    }

    public String praddAlbum() {
        try {

            ServletContext context = ServletActionContext.getServletContext();
            imp.uploadImg2(file, uploadFileName, context);
            System.out.println("=============>" + init2.getDateAlbum());
            String val = uploadFileName;
            init2.setImg(val);
            util.save(init2);
            return SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();

        }
        return FAILURE;
    }

    public String edit() {
        try {
            if (request.getParameter("id") != null) {
                int idac = Integer.parseInt(request.getParameter("id"));
                this.init.setId(idac);
                System.out.print("==================>" + this.init.getId());
                this.util.findById(this.init);
                return SUCCESS;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return FAILURE;
    }

    public String predit() {
        try {
            System.out.println("=========================>" + this.init.getId());
            util.update(init);
            this.table = (List<Actualite>) util.PaginationFind(init, 1, 4);
            this.taille = init.getId();
            this.pied = utilite.footerpage(this.taille, 1, "app.html");
            return SUCCESS;
        } catch (Exception ex) {
            Logger.getLogger(AppAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return FAILURE;
    }

    public File getFile() {
        return file;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public String delete() {
        try {
            if ((request.getParameter("id") != null) && (request.getParameter("img") != null)) {
                this.init = new Actualite();
                this.init.setId(Integer.parseInt(request.getParameter("id")));
                imp.deleteImg2(request.getParameter("img"));
                util.delete(init);
                return SUCCESS;
            }
        } catch (Exception ex) {
            Logger.getLogger(AppAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return FAILURE;
    }

    public String deleteAlbum() {
        try {
            if ((request.getParameter("id") != null) && (request.getParameter("img") != null)) {
                this.init2 = new Album();
                this.init2.setId(Integer.parseInt(request.getParameter("id")));
                imp.deleteImg(request.getParameter("img"));
                util.delete(init2);
                return SUCCESS;
            }
        } catch (Exception ex) {
            Logger.getLogger(AppAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return FAILURE;
    }

    public Album getInit2() {
        return init2;
    }

    public void setInit2(Album init2) {
        this.init2 = init2;
    }

    public Actualite getInit() {
        return init;
    }

    public void setInit(Actualite init) {
        this.init = init;
    }

    public int getId() {
        return id;
    }

    public int getTaille() {
        return taille;
    }

    public List<String> getPied() {
        return pied;
    }

    public List<Actualite> getTable() {
        return table;
    }

    public void setUpload(File file) {
        this.file = file;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }
}

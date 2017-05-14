package mg.itu.appsolute.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.List;
import mg.itu.appsolute.modele.Employe;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author davra
 */
public class EmployeService extends BaseService {
    //public static String chemin=getClass().getResource("pdf/emp.pdf")+"";
    public void pdfEmp(List<Employe> tab) throws Exception {
        Document doc = new Document(PageSize.A4);
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(getClass().getResource("pdf/emp.pdf")+""));
            doc.open();
            doc.add(new Paragraph("Tableau Employe"));
            //On créer un objet table dans lequel on intialise ça taille.
            PdfPTable table = new PdfPTable(4);
            table.addCell("id");
            table.addCell("nom");
            table.addCell("login");
            table.addCell("metier");
            for (Employe tab1 : tab) {
                table.addCell(tab1.getId() + "");
                table.addCell(tab1.getNomemp());
                table.addCell(tab1.getLogin());
                table.addCell(tab1.getMetier());
            }
            doc.add(table);
            doc.close();
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Employe> testEmploye(Employe utilisateur) throws Exception {
        List<Employe> tab = (List<Employe>) this.findAll(utilisateur);
        return tab;
    }

    public void test(Employe utilisateur) throws Exception {
        Session session = null;
        Transaction tr = null;
        try {
            session = getSession().getSessionFactory().openSession();
            tr = session.beginTransaction();
            this.save(session, utilisateur);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}

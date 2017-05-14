package mg.itu.appsolute.helper;

import java.io.File;
import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author davra
 */
public class ImportService {

    public void uploadImg(File file, String uploadFileName,  ServletContext context) throws Exception {
        try {
         
            //Permet de récupérer le chemin jusqu'au dossier WebContent/
            String userDir = context.getRealPath("/");
            userDir = userDir.replaceAll("\\\\", "/");
            String[] tab = userDir.split("target/");
            userDir = tab[0];
            uploadFileName = "src/main/webapp/www/assets/img/" + uploadFileName;
            String fullFileName = userDir + uploadFileName;
            System.out.print("========================>" + fullFileName);
            File theFile = new File(fullFileName);
            FileUtils.copyFile(file, theFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     public void uploadImg2(File file, String uploadFileName,  ServletContext context) throws Exception {
        try {
         
            //Permet de récupérer le chemin jusqu'au dossier WebContent/
            String userDir = context.getRealPath("/");
            userDir = userDir.replaceAll("\\\\", "/");
            String[] tab = userDir.split("target/");
            userDir = tab[0];
            uploadFileName = "src/main/webapp/www/assets/img/illustration/" + uploadFileName;
            String fullFileName = userDir + uploadFileName;
            System.out.print("========================>" + fullFileName);
            File theFile = new File(fullFileName);
            FileUtils.copyFile(file, theFile);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteImg(String uploadFileName) throws Exception {
        try {
            ServletContext context = ServletActionContext.getServletContext();
            //Permet de récupérer le chemin jusqu'au dossier WebContent/
            String userDir = context.getRealPath("/");
            userDir = userDir.replaceAll("\\\\", "/");
            String[] tab = userDir.split("target/");
            userDir = tab[0];
            uploadFileName = "src/main/webapp/www/assets/img/illustration/" + uploadFileName;
            String fullFileName = userDir + uploadFileName;
            System.out.print("========================>" + fullFileName);
            File theFile = new File(fullFileName);
            theFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
      public void deleteImg2(String uploadFileName) throws Exception {
        try {
            ServletContext context = ServletActionContext.getServletContext();
            //Permet de récupérer le chemin jusqu'au dossier WebContent/
            String userDir = context.getRealPath("/");
            userDir = userDir.replaceAll("\\\\", "/");
            String[] tab = userDir.split("target/");
            userDir = tab[0];
            uploadFileName = "src/main/webapp/www/assets/img/" + uploadFileName;
            String fullFileName = userDir + uploadFileName;
            System.out.print("========================>" + fullFileName);
            File theFile = new File(fullFileName);
            theFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

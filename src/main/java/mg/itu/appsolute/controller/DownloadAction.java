/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.itu.appsolute.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import mg.itu.appsolute.modele.Employe;
import mg.itu.appsolute.service.EmployeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author davra
 */
public class DownloadAction extends org.apache.struts.action.Action {

    private final ApplicationContext c = new ClassPathXmlApplicationContext("bean.xml");
    private final EmployeService util = c.getBean(EmployeService.class);
    private Employe human = new Employe();
    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    private InputStream inputStream;
    private String fileName;
    private String fileSize;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String execute() {
        try {
            String url=""+getClass().getResource("pdf/emp.pdf");
            util.pdfEmp((List<Employe>) util.findAll(human));
            fileName = "emp.pdf";
            fileSize = "";
            inputStream = new FileInputStream(url);
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FAILURE;
    }
}

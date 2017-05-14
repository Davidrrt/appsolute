package mg.itu.appsolute.webservice;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import mg.itu.appsolute.modele.Employe;
import mg.itu.appsolute.service.EmployeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author davra
 */
@WebService(serviceName = "AppWebService")
public class AppWebService {

 
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "emp")
    public List<Employe> select() {
        try {
            ApplicationContext c = new ClassPathXmlApplicationContext("bean.xml");
            EmployeService util = c.getBean(EmployeService.class);
            Employe human = new Employe();
            return (List<Employe>) util.findAll(human);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
      @WebMethod(operationName = "insertemp")
    public void insert(@WebParam(name = "person") Employe human) {
        try {
            ApplicationContext c = new ClassPathXmlApplicationContext("bean.xml");
            EmployeService util = c.getBean(EmployeService.class);
            util.save(human);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

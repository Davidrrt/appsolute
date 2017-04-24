
package mg.itu.utilproject.controller;

import com.opensymphony.xwork2.ActionSupport;


/**
 *
 * @author davra
 */
public class HomeAction extends ActionSupport {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     *
     * @return
     */
    @Override
    public String execute() {
        return SUCCESS;
    }

    public String gethome() {
        return "success";
    }
}

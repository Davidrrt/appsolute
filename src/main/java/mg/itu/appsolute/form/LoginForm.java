package mg.itu.appsolute.form;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import mg.itu.appsolute.modele.Employe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author eswar@vaannila.com
 */
public class LoginForm {
    
   private static final String CHAMP_EMAIL = "email";
    private static final String CHAMP_PASS = "motdepasse";
    private Map<String, String> erreurs = new HashMap<String, String>();
    private String resultat;
    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public void connexionUtilisateur(HttpServletRequest request) {
        String email = getValeurChamp(request, CHAMP_EMAIL);
        String motDePasse = getValeurChamp(request, CHAMP_PASS);
        /*ApplicationContext c = new ClassPathXmlApplicationContext("Context.xml");
        MembresService util = c.getBean(MembresService.class);
        Membres utilisateur = new Membres();
        traiterEmail(email, utilisateur);
        //traiterMotdepasse(motDePasse, utilisateur);
        List<Membres> table = util.testMembres(utilisateur, "mail", utilisateur.getMail());
        try {
            if (table != null) {
                resultat = "error";
                if (table.get(0).getMdp().compareTo(motDePasse) == 0) {
                    resultat = "succes";
                    utilisateur.setId(table.get(0).getId());
                    utilisateur.setNomMembres(table.get(0).getNomMembres());
                    utilisateur.setPrenomMembres(table.get(0).getPrenomMembres());
                    utilisateur.setDatenaissance(table.get(0).getDatenaissance());
                }

            }

        } catch (Exception e) {
            resultat = "echec de connexion";
        }*/
        //return utilisateur;
    }

    private void traiterEmail(String email, Employe utilisateur) {
        try {
            validationEmail(email);
        } catch (Exception e) {
            setErreur(CHAMP_EMAIL, e.getMessage());
        }
        utilisateur.setLogin(email);
    }

    private void validationEmail(String email) throws Exception {
        if (email != null) {
            if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new Exception("Merci de saisir une adresse mail valide.");
            }
        } else {
            throw new Exception("Merci de saisir une adresse mail.");
        }
    }

    private void setErreur(String champ, String message) {
        erreurs.put(champ, message);
    }

    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur;
        }
    }

  /*  public void traiterMotdepasse(String motDePasse, Membres utilisateur) {

        utilisateur.setMdp(motDePasseChiffre);
    }*/

}
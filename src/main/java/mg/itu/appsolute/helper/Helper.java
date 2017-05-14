package mg.itu.appsolute.helper;

import java.util.ArrayList;
import java.util.List;

public class Helper {

    public static boolean isLetterWithSpaceOnly(String string) {
        string = string.trim();
        int i = 0;
        while (i < string.length()) {
            if (!Character.isLetter(string.charAt(i))) {
                if (string.charAt(i) == ' ') {
                    i++;
                } else {
                    return false;
                }
            } else {
                i++;
            }
        }
        return true;
    }

    public static boolean isLetterAndDigitWithSpaceOnly(String string) {
        string = string.trim();
        int i = 0;
        while (i < string.length()) {
            if (!Character.isLetter(string.charAt(i))) {
                if (string.charAt(i) == ' ' || Character.isDigit(string.charAt(i))) {
                    i++;
                } else {
                    return false;
                }
            } else {
                i++;
            }
        }
        return true;
    }

    public List<String> footerpage(int taille, int actif, String pages) {
        List<String> tab = new ArrayList<String>();
        if (actif == 1) {
            tab.add("<li class=\"active\"><a href=\"" + pages + "?page=1\">1</a></li>");
            for (int i = 2; i <= taille; i++) {
                tab.add("<li><a href=\"" + pages + "?page=" + i + "\">" + i + "</a></li>");
            }
            tab.add("<li><a href=\"" + pages + "?page=2\">&raquo;</a></li>");
            return tab;
        } else if ((actif > 1) && (actif < taille)) {
            tab.add("<li><a href=\"" + pages + "?page=" + (actif - 1) + "\">&laquo;</a></li>");
            for (int i = 1; i <= taille; i++) {
                if (i == actif) {
                    tab.add("<li class=\"active\"><a href=\"" + pages + "?page=" + i + "\">" + i + "</a></li>");
                } else {
                    tab.add("<li><a href=\"" + pages + "?page=" + i + "\">" + i + "</a></li>");
                }
            }
            tab.add("<li><a href=\"" + pages + "?page=" + (actif + 1) + "\">&raquo;</a></li>");
            return tab;
        }
        if (actif >= taille) {
            tab.add("<li><a href=\"" + pages + "?page=" + (actif - 1) + "\">&laquo;</a></li>");
            for (int i = 1; i < taille; i++) {
                tab.add("<li><a href=\"" + pages + "?page=" + i + "\">" + i + "</a></li>");
            }
            tab.add("<li class=\"active\"><a href=\"" + pages + "?page=" + actif + "\">" + actif + "</a></li>");
            return tab;
        }
        return null;
    }
}

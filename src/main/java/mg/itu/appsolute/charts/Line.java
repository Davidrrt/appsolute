
package mg.itu.appsolute.charts;

import java.util.List;

/**
 *
 * @author davra
 */
public class Line {
    public List<String> label;
    public int[] data;

    public List<String> getLabel() {
        return label;
    }

    public void setLabel(List<String> label) {
        this.label = label;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }
    
}

package jms;

/**
 * Created with IntelliJ IDEA.
 * User: jim.sun
 * Date: 10/20/13
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
import java.io.Serializable;


public class Trade implements Serializable {
    private String componentName = "";

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentName() {
        return componentName;
    }
}

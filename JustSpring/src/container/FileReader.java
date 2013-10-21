package container;

import org.springframework.beans.factory.InitializingBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: jim.sun
 * Date: 10/19/13
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileReader implements IReader, InitializingBean {

    private StringBuilder builder = null;
    private Scanner scanner = null;
    private String componentName = null;
    private String prop1;
    private Properties countryProperties;

    public FileReader(String fileName) {
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException ex) {
            System.out.println("FileNotFoundException occured : " + ex.getMessage());
        }
        builder = new StringBuilder();
    }

    public String read() {
        while (scanner.hasNext()) {
            builder.append(scanner.next());
            builder.append(",");
        }
        return builder.toString();
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public void fetchData() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public void init() {
        System.out.println("jimsun: inside init method");
    }
    public void cleanup() {
        System.out.println("jimsun: inside cleanup");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("jimsun: after implemention interface of InitializingBean,");
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }

    public String getProp1() {
        return prop1;
    }

    public void setCountryProperties(Properties countryProperties) {
        this.countryProperties = countryProperties;
    }

    public Properties getCountryProperties() {
        return countryProperties;
    }
}

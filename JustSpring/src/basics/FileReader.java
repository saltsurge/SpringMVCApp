package basics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: jim.sun
 * Date: 10/19/13
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileReader implements IReader {

    private StringBuilder builder = null;
    private Scanner scanner = null;
    private String componentName = null;

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
}

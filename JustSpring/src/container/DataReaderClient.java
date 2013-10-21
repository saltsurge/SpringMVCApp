package container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: jim.sun
 * Date: 10/19/13
 * Time: 11:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataReaderClient {
    private ApplicationContext ctx = null;
    private IReader reader = null;

    public DataReaderClient() {
        //Jim: how to determine the configureLocation string?
        /*
           In a local test scenario, you are not inside a Jar, so you don't need Classpath-based access. Use FileSystemXmlApplicationContext instead.
         */
        ctx = new FileSystemXmlApplicationContext("//Users/jim.sun/github/SpringMVCApp/JustSpring/src/container/reader-beans.xml");
    }

    public String getData() {
//        reader =  (IReader) ctx.getBean("fileReader");
        reader = (FileReader) ctx.getBean("fileReader");

        FileReader fileReader = (FileReader) reader;
        fileReader.setProp1("this is prop1");
        System.out.println(fileReader.getProp1());

        Properties prop = new Properties();
        try {
            prop.load(FileReader.class.getResourceAsStream("file.properties"));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        fileReader.setCountryProperties(prop);
        Properties properties = fileReader.getCountryProperties();
        System.out.println(properties.toString());

        for (String pName : properties.stringPropertyNames()) {
            System.out.println("Property: " + pName + " = " + properties.getProperty(pName));
        }

        return reader.read();
    }

    public static void main(String[] args) {
        System.out.println("classpath: " + System.getProperty("java.class.path"));
        DataReaderClient client = new DataReaderClient();

        System.out.println("Data:" + client.getData());

    }
}

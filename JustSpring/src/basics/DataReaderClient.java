package basics;

import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: jim.sun
 * Date: 10/19/13
 * Time: 9:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class DataReaderClient {

    private IReader reader = null;
    private static String fileName = "/Users/jim.sun/github/SpringMVCApp/JustSpring/src/basics/basics-trades-data.txt";

    public DataReaderClient(IReader reader) {
        this.reader = reader;
    }

    private String fetchData() {
        return reader.read();
    }

    public static void main(String[] args) throws FileNotFoundException {
        IReader fileReader = new FileReader(fileName);// Ummh..still hard wired, isn't it?
        DataReaderClient client = new DataReaderClient(fileReader);
        System.out.println("Got data using interface design priciple: " + client.fetchData());
    }
}
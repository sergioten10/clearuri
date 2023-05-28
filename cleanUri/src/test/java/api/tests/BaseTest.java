package api.tests;

import org.junit.jupiter.api.BeforeEach;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BaseTest {
    protected static final String URL = "https://cleanuri.com/";
    protected static final String recoursePartOfURI = "api/v1/shorten";
    protected static final String inputFileWithUrl = "./src/test/resources/urlToClean.txt";
    protected static final String ResponseSchema = "./src/test/resources/ResponseSchema.json";
    protected String urlToClean;

    @BeforeEach
    public void setUp() {
        File file = new File(inputFileWithUrl);
        try {
            Scanner sc = new Scanner(file);
            urlToClean = sc.next();
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

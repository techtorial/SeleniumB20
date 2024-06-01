package TestNGConcept;

import org.testng.annotations.DataProvider;

public class AllDataStorage {


    @DataProvider(name = "couples")
    public Object[][] getData() {

        return new Object[][]{
                {"Inna", "Alex", "hello"},
                {"Volodymyr", "Maria", "hi"},
                {"Feyza", "Sinan", "dgfgf"},
                {"Nazar", "Natalia", "sdfgfdsg"}
        };
    }
}

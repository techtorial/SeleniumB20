package TestNGConcept;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderLogic {

//    @DataProvider(name = "couples")
//    public Object[][] getData(){
//
//        return new Object[][] {
//                {"Inna","Alex","hello"},
//                {"Volodymyr","Maria","hi"},
//                {"Feyza","Sinan","dgfgf"},
//                {"Nazar","Natalia","sdfgfdsg"}
//        };
//    }


    @Test(dataProvider = "couples",dataProviderClass = AllDataStorage.class)
    public void pairs(String pair_1, String pair_2,String message){
        System.out.println(pair_1+" " + pair_2 + message);
    }

//    @Test
//    public void pairs2(){
//        System.out.println("Volodymyr " + "Maria");
//    }
//
//    @Test
//    public void pairs3(){
//        System.out.println("Feyza " + "Sinan");
//    }
//
//    @Test
//    public void pairs4(){
//        System.out.println("Nazar " + "Natalia");
//    }
}

package TestNGConcept;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterLogic {

    @Parameters("name")
    @Test
    public void test(String name){
        System.out.println(name);
    }

    @Parameters({"nameOfPerson","lastNameOfPerson","zipCode"})
    @Test
    public void test2(String firstName,String lastName,String zipCode){
        System.out.println(firstName +" "+ lastName +" "+ zipCode +"Ahmet");
    }

}

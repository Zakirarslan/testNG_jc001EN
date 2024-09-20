package myapp.tests.dataprovider;

import myapp.utilities.DataProviderUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day23_DataProvider1 {

    //DataProvider method works with 2D Array
    //We don't need loop to pass all data sets
    //Data provider annotation ensures that all data sets are provided to test method one by one

    //DataProvider Method 1
    @DataProvider
    public Object[][] productListProvider(){
        Object[][] productList = {{"BMW"},{"Volvo"},{"Audi"},{"Toyota"},{"Mercedes"}};
        return productList;
    }

    //Test Method 1
    @Test (dataProvider = "productListProvider") // call the DataProvider Method by its name and connect with test method
    public void test1(String data){
        System.out.println(data);
    }

    //DataProvider Method 2
    @DataProvider (name = "employee_credentials")
    public Object[][] credentialProvider(){
        Object[][] credentialList ={
                {"admin1", "pass1", "CEO", "52"},
                {"admin2", "pass2", "SDET", "42"},
                {"admin3", "pass3", "PM", "38"},
                {"admin4", "pass4", "QA", "30"},
                {"admin5", "pass5", "QA", "45"}
        };
        return credentialList;
    }

    //Test Method 2
    @Test (dataProvider = "credentialProvider")
    public void test2(String username, String password, String position, String age){
        System.out.println("UserName: " + username + " | Password: " + password + " | Position :" + position + " | Age: " +age);
    }

    // you can also give a customised name to @DataProvider and use that to connect with TEST METHOD
    // you can ALSO call the DataProvider Method by its customized name
    //Test Method 3
    @Test (dataProvider = "employee_credentials")
    public void test3(String username, String password, String position, String age){
        System.out.println("UserName: " + username + " | Password: " + password + " | Position :" + position + " | Age: " +age);
    }

    // NOTE:  We should write DataProvider methods in Utils Class to implement DRY Rule (Don't Repeat Yourself)
    // When DataProvider methods are stored in a different class (like in Utils class), we have to provide the NAME OF THAT CLASS too

    // Test Method 4 => works with DataProviderUtils class
    @Test (dataProvider = "employeeCredentialsProvider", dataProviderClass = DataProviderUtils.class)
    public void test4(String email, String password){
        System.out.println("Email: " + email + " | Password:  " + password);
    }

    // Test Method 5 => works with DataProviderUtils class + Excelsheet
    @Test (dataProvider = "excelEmployeeData", dataProviderClass = DataProviderUtils.class)
    public void test5(String email, String password){
        System.out.println("Email: " + email + " | Password:  " + password);
    }










}








package myapp.tests.excelautomation;

import myapp.pages.DatatablesPage;
import myapp.utilities.Driver;
import myapp.utilities.ExcelUtils;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Day23_ExcelLogin {

    // When user go to https://editor.datatables.net/
    // Click on the new button
    // When user enters all fields
    // When user clicks on ‘create’ button
    // And search for the first name
    // Then verify the name field contains first name

    // WITHOUT EXCEL
    @Test (groups = "minor_regression_group")
    public void loginTest() {
        // When user go to https://editor.datatables.net/
        Driver.getDriver().get("https://editor.datatables.net/");
        // Click on the new button
        // Create the DatatablesPage object to access the elements
        DatatablesPage datatablesPage = new DatatablesPage();
        // When user enters all fields
        datatablesPage.newButton.click();
        WaitUtils.waitFor(1);
        datatablesPage.firstName.sendKeys("john");
        WaitUtils.waitFor(1);
        datatablesPage.lastName.sendKeys("lennon");
        WaitUtils.waitFor(1);
        datatablesPage.position.sendKeys("musician");
        WaitUtils.waitFor(1);
        datatablesPage.office.sendKeys("LA");
        WaitUtils.waitFor(1);
        datatablesPage.extension.sendKeys("52345");
        WaitUtils.waitFor(1);
        datatablesPage.startDate.sendKeys("2023-12-27");
        WaitUtils.waitFor(1);
        datatablesPage.salary.sendKeys("1000000");
        WaitUtils.waitFor(1);
        // When user clicks on ‘create’ button
        datatablesPage.createButton.click();
        WaitUtils.waitFor(1);
        // And search for the first name
        datatablesPage.searchBox.sendKeys("john");
        WaitUtils.waitFor(1);
        // Then verify the name field contains first name
        Assert.assertTrue(datatablesPage.nameField.getText().contains("john"));
        //Close the driver
        Driver.closeDriver();
    }

        //WITH EXCEL
        @Test
        public void loginTestWithExcel(){
            // Path of the Excel sheet
            String pathOfExcel = "./resources/data_sheet.xlsx";
            // Initialise the ExcelUtils class here and provide the path of the sheet and name of the sheet in this object
            ExcelUtils excelUtils = new ExcelUtils(pathOfExcel, "user_data");

            //Create an empty List and initialise it inside the test method TO STORE DATA from Excel sheet and use it for the test
            List<Map<String, String>> dataList;
            dataList = excelUtils.getDataList();
            System.out.println("dataList = " + dataList);

            //LOOP begins
            for (Map<String, String> eachdata : dataList){
                // When user go to https://editor.datatables.net/
                Driver.getDriver().get("https://editor.datatables.net/");
                // Click on the new button
                // Create the DatatablesPage object to access the elements
                DatatablesPage datatablesPage = new DatatablesPage();
                datatablesPage.newButton.click();
                WaitUtils.waitFor(1);
                // When user enters all fields
                datatablesPage.firstName.sendKeys(eachdata.get("first_name"));
                WaitUtils.waitFor(1);
                datatablesPage.lastName.sendKeys(eachdata.get("last_name"));
                WaitUtils.waitFor(1);
                datatablesPage.position.sendKeys(eachdata.get("position"));
                WaitUtils.waitFor(1);
                datatablesPage.office.sendKeys(eachdata.get("office"));
                WaitUtils.waitFor(1);
                datatablesPage.extension.sendKeys(eachdata.get("extension"));
                WaitUtils.waitFor(1);
                datatablesPage.startDate.sendKeys(eachdata.get("start_date"));
                WaitUtils.waitFor(1);
                datatablesPage.salary.sendKeys(eachdata.get("salary"));
                WaitUtils.waitFor(1);
                // When user clicks on ‘create’ button
                datatablesPage.createButton.click();
                WaitUtils.waitFor(1);
                // And search for the first name
                datatablesPage.searchBox.sendKeys(eachdata.get("first_name"));
                WaitUtils.waitFor(1);
                // Then verify the name field contains first name
                Assert.assertTrue(datatablesPage.nameField.getText().contains(eachdata.get("first_name")));
            }
            //LOOP ends
            //Close the driver
            Driver.closeDriver();
        }


    }


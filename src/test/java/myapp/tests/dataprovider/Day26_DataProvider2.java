package myapp.tests.dataprovider;

import myapp.pages.DatatablesPage;
import myapp.utilities.DataProviderUtils;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day26_DataProvider2 {

    /*
    PLAN:
        1. Create a data provider method in Utils class that will take the data from user_data sheet
        2. Connect this data provider method to the test method using two parameters ==> dataProvider and dataProviderClass
        3. Complete your test case
     */

    @Test (dataProvider = "userData", dataProviderClass = DataProviderUtils.class)
    public void userCreationWithDataProvider(
            String first_name,
            String last_name,
            String position,
            String Driver,
            String extension,
            String start_date,
            String salary ){

        // When user go to https://editor.datatables.net/
        myapp.utilities.Driver.getDriver().get("https://editor.datatables.net/");
        // Click on the new button
        // Create the DatatablesPage object to access the elements
        DatatablesPage datatablesPage = new DatatablesPage();
            datatablesPage.newButton.click();
            WaitUtils.waitFor(1);
        // When user enters all fields
            datatablesPage.firstName.sendKeys(first_name);
            WaitUtils.waitFor(1);
            datatablesPage.lastName.sendKeys(last_name);
            WaitUtils.waitFor(1);
            datatablesPage.position.sendKeys(position);
            WaitUtils.waitFor(1);
            datatablesPage.office.sendKeys(Driver);
            WaitUtils.waitFor(1);
            datatablesPage.extension.sendKeys(extension);
            WaitUtils.waitFor(1);
            datatablesPage.startDate.sendKeys(start_date);
            WaitUtils.waitFor(1);
            datatablesPage.salary.sendKeys(salary);
            WaitUtils.waitFor(1);
            // When user clicks on ‘create’ button
            datatablesPage.createButton.click();
            WaitUtils.waitFor(1);
            // And search for the first name
            datatablesPage.searchBox.sendKeys(first_name);
            WaitUtils.waitFor(1);
            // Then verify the name field contains first name
            Assert.assertTrue(datatablesPage.nameField.getText().contains(first_name));
        //Close the driver

    }
}


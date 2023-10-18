package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Dashboard;
import pageObjects.LoginPage;
import pageObjects.MediaCompanies;
import resourses.Base;

import java.io.IOException;

public class ValidateActiveInactiveMediaCompany extends Base {
    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException
    {
        driver = InitializeDriver();
        driver.get(prop.getProperty("url"));

        LoginPage lp = new LoginPage(driver);
        lp.getEmailId().sendKeys(prop.getProperty("username"));
        lp.getPassword().sendKeys(prop.getProperty("password"));
        lp.getSigninButton().click();

        Dashboard db = new Dashboard(driver);
        db.getMediaCompany().click();
    }

    @Test
    public void activeInactiveButton() throws IOException, InterruptedException {
        MediaCompanies mc = new MediaCompanies(driver);
        String str = mc.getMediaCompanyStatus().getText();
        if (mc.getmediaListing().size()>=1) {
            mc.getActiveInactiveButton().click();
            Thread.sleep(3000);
            mc.getConfirmationPopupButton().click();
            Thread.sleep(3000);
            if(str.equals("Active"))
            {
                Assert.assertEquals(mc.getMediaCompanyStatus().getText(), "Inactive");
            }
            else
            {
                Assert.assertEquals(mc.getMediaCompanyStatus().getText(), "Active");
            }
        }
    }

    @AfterTest
    public void teardown()
    {
        driver.close();
    }
}

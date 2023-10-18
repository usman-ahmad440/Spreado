package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Dashboard;
import pageObjects.LoginPage;
import resourses.Base;

import java.io.IOException;

public class MediaCompanyPage extends Base
{
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
    }

    @Test
    public void mediaCompanies() throws IOException {

        Dashboard db = new Dashboard(driver);
        db.getMediaCompany().click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.pact.synavos.net/companies");
    }

    @AfterTest
    public void teardown()
    {
        driver.close();
    }
}

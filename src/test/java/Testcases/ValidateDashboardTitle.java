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

public class ValidateDashboardTitle extends Base
{
    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = InitializeDriver();
        driver.get(prop.getProperty("url"));

        LoginPage lp = new LoginPage(driver);
        lp.getEmailId().sendKeys(prop.getProperty("username"));
        lp.getPassword().sendKeys(prop.getProperty("password"));
        lp.getSigninButton().click();
    }

    @Test
    public void validteTitle() throws IOException
    {
        Dashboard dp = new Dashboard(driver);
        Assert.assertEquals(dp.getTitle().getText(),"Dashboard");
    }

    @AfterTest
    public void teardown()
    {
        driver.close();
    }
}

package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import resourses.Base;

import java.io.IOException;

public class ValidateLoginTitle extends Base
{
    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException
    {
        driver = InitializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void validteTitle() throws IOException {

        LoginPage lp = new LoginPage(driver);
        Assert.assertEquals(lp.getTitle().getText(),"Welcome back!");
    }

    @AfterTest
    public void teardown()
    {
        driver.close();
    }
}

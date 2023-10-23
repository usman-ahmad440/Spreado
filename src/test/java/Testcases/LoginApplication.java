package Testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import resourses.Base;

import java.io.IOException;

public class LoginApplication extends Base
{
    public WebDriver driver;

    @Test(dataProvider = "getData")
    public void Login(String email, String password) throws InterruptedException, IOException
    {
        driver = InitializeDriver();
        driver.get(prop.getProperty("url"));

        LoginPage lp = new LoginPage(driver);

        lp.getEmailId().sendKeys(email);
        lp.getPassword().sendKeys(password);
        lp.getSigninButton().click();

        driver.close();
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[2][2];

        data[0][0] = "admin@spreado.com";
        data[0][1] = "12345678";

        data[1][0] = "admin@spreado.com";
        data[1][1] = "admin@spreado";


        return data;
    }
}

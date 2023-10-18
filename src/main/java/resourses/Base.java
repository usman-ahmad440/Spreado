package resourses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
    public WebDriver driver;
    public Properties prop;
    public WebDriver InitializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\Practice\\src\\main\\java\\resourses\\prop.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome")) {
            driver = WebDriverManager.chromedriver().create();
            driver  = new ChromeDriver();
        }
//        else if (browserName.equals("firefox")) {
//            driver - new FirefoxDriver();
//        }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}

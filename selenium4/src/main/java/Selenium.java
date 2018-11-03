import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Selenium {

    private WebDriver wd;
    private String url;
    private String user;
    private String userPass;

    @Before
    public void settings(){
//        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
//        wd = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        wd = new ChromeDriver();
        url = "https://www.mail.com/int/";
        user = "karol";
        userPass = "passpass";
    }

    @Test
    public void login(){
        wd.get(url);
        wd.findElement(By.id("login-button")).click();

        WebElement login = wd.findElement(By.name("username"));
        login.clear();
        login.sendKeys(user);

        WebElement pass = wd.findElement(By.name("password"));
        pass.clear();
        pass.sendKeys(userPass);
        pass.sendKeys(Keys.ENTER);;
        Assert.assertFalse(wd.getPageSource().contains("PLEASE TRY"));
    }

    @After
    public void close(){
        wd.quit();
    }


}

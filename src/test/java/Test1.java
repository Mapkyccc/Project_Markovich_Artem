import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    private WebDriver driver;

    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.spotify.com/login");
        driver.findElement(By.id("login-username")).sendKeys("my_login");
        driver.findElement(By.id("login-password")).sendKeys("my_password");
        driver.findElement(By.xpath("//span[@class=\"control-indicator\"]")).click();
        driver.findElement(By.id("login-button")).click();
        String message = driver.findElement(By.xpath("//*[@ng-if=\"response.error\"]")).getText();
        System.out.println(message);
        Assert.assertEquals("Неправильное имя пользователя или пароль.", message);

    }
}

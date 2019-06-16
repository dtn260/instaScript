import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        openChromeBrowser();

        logInToInstagram();

        goToProfilePage();

        //logOutOfInstagram();

    }

    public static void openChromeBrowser(){
        System.setProperty("webdriver.chrome.driver","/Users/anthonyfreay/Dev/java/selenium-java/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognitio");

        // open new chrome browser
        driver = new ChromeDriver(options);
    }

    public static void logInToInstagram(){
        // go to instagram login screen
        driver.get("https://www.instagram.com/accounts/login/");

        // click username field
        driver.findElement(By.name("username")).click();

        // fill username
        driver.findElement(By.name("username")).sendKeys("anthonyfreay");

        // click password field
        driver.findElement(By.name("password")).click();

        // fill password
        driver.findElement(By.name("password")).sendKeys("f*b#V$v65ZcM");

        // click 'log in' button
        driver.findElement(By.xpath("//*[@id=\'react-root\']/section/main/div/article/div/div[1]/div/form/div[4]/button")).click();
    }

    public static void goToProfilePage() throws InterruptedException {
        // wait for 'notification modal' to pop up
        Thread.sleep(1500);

        // click 'not now'
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();

        // click profile button
        driver.findElement(By.xpath("//*[@id=\'react-root\']/section/nav/div[2]/div/div/div[3]/div/div[3]/a/span")).click();
    }

    public static void logOutOfInstagram(){
        // click gear button
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/header/section/div[1]/div")).click();

        // click 'log out'
        //driver.findElement(By.xpath("/html/body/div[3]/div/div/div/button[6]")).click();

        driver.close();
    }
}
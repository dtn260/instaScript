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

        listFollowers();

        listFollowing();

        closeChromeBrowser();

    }

    public static void openChromeBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/anthonyfreay/Dev/java/selenium-java/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognitio");

        // open new chrome browser
        driver = new ChromeDriver(options);

        // simulate human delay
        Thread.sleep(2000);
    }

    public static void logInToInstagram() throws InterruptedException {
        // go to instagram login screen
        driver.get("https://www.instagram.com/accounts/login/");

        // click username field
        driver.findElement(By.name("username")).click();

        // fill username
        driver.findElement(By.name("username")).sendKeys("");

        // click password field
        driver.findElement(By.name("password")).click();

        // fill password
        driver.findElement(By.name("password")).sendKeys("");

        // click 'log in' button
        driver.findElement(By.xpath("//*[contains(text(),'Log In')]")).click();

        // wait for 'notification modal' to pop up
        Thread.sleep(2000);
    }

    public static void goToProfilePage() throws InterruptedException {
        // click 'not now'
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();

        // click profile button
        driver.findElement(By.xpath("//*[@id=\'react-root\']/section/nav/div[2]/div/div/div[3]/div/div[3]/a/span")).click();

        // simulate human delay
        Thread.sleep(2000);
    }

    public static void listFollowers() throws InterruptedException {
        driver.findElement(By.xpath("//*[contains(@href,'anthonyfreay/followers')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@aria-label,'Close')]")).click();
    }

    public static void listFollowing() throws InterruptedException{
        driver.findElement(By.xpath("//*[contains(@href,'anthonyfreay/following')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[contains(@aria-label,'Close')]")).click();
    }

    public static void closeChromeBrowser(){
        // click 'gear' button
        //driver.findElement(By.xpath("//*[contains(@class,'afkep')]")).click();

        driver.close();
    }
}

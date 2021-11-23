package Week4.Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom3MultipleAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://leafground.com/pages/Dropdown.html");
		
		WebElement selenium = driver.findElement(By.xpath("//div[@class='example']/select[@multiple]/option[@value='1']"));
		WebElement loadrunner = driver.findElement(By.xpath("//div[@class='example']/select[@multiple]/option[@value='4']"));
		
		Actions builder = new Actions(driver);
		builder
		.keyDown(Keys.CONTROL)
		.click(selenium)
		.click(loadrunner)
		.keyUp(Keys.CONTROL)
		.perform();
	}

}

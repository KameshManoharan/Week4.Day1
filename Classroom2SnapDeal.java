package Week4.Day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Classroom2SnapDeal {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.snapdeal.com/");
		
		//MouseHover Men's Fashion
		WebElement mfashion = driver.findElement(By.xpath("//li[@navindex='6']/a/span"));
		Actions builder = new Actions(driver);
		builder.moveToElement(mfashion).perform();
		
		//Click Shirts link
		driver.findElement(By.xpath("//div[@id='category6Data']//span[text()='Shirts']")).click();
		
		//MouseHover on very first image in the grid
		WebElement first_img = driver.findElement(By.xpath("//section[@class='js-section clearfix dp-widget dp-fired']/div"));
		builder.moveToElement(first_img).perform();
		
		//Click Quick view link
		driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  ']")).click();
	}

}
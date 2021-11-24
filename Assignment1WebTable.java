package Week4.Day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1WebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.leafground.com/pages/table.html");
		
		int rowsize=0, columnsize=0, min=0, j=0;
		String str="",str1="";
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		rowsize=rows.size();
		String[] StrAr = new String[rowsize-1];
		System.out.println("No. of Rows: " +(rowsize-1));
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table_id']//tr/th"));
		columnsize=columns.size();
		System.out.println("No. of Columns: " +columnsize);

		for(int i=2;i<=rowsize;i++) {
			str = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td")).getText();
			if (str.equals("Learn to interact with Elements")) {
					str1 = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
					System.out.println("The Progress value of 'Learn to interact with Elements' is " +str1);
				}
			}
		
		for(int i=0;i<rowsize-1;i++) {
			StrAr[i] = driver.findElement(By.xpath("//table[@id='table_id']//tr["+(i+2)+"]/td[2]")).getText();
			StrAr[i] = StrAr[i].replaceAll("[%]", "");
			j = Integer.parseInt(StrAr[i]);
			if (i==0) min = j;			
			if (j<min) {
				min = j;
				str = driver.findElement(By.xpath("//table[@id='table_id']//tr["+(i+2)+"]/td[1]")).getText();
			}
		}
		
		for(int i=2;i<=rowsize;i++) {
			str1 = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td")).getText();
			if (str1.equals(str)) {
					driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[3]/input")).click();
				}
			}
	}
}

package org.frame;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class FrameTask {
	static long start;
	static WebDriver driver;
	@BeforeClass
	public static void browserlaunch() {
	
		System.setProperty("webdriver.edge.driver", "C:\\Users\\nandhini\\eclipse-workspace\\xlwrite\\Drivers\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		String url="https://www.flipkart.com/";
		driver.navigate().to(url);
		driver.manage().window().maximize();
System.out.println("browserlaunch");
	}
	@AfterClass
public static void browserquit() {
		
System.out.println("browserquit");
	}
	
	
	@Before
public  void Startingtime() {
	System.out.println("before");
 start = System.currentTimeMillis();
}
	@After
    public  void Endtime() {
	
    long end = System.currentTimeMillis();

     System.out.println("After time taken  is:"+(end -start));
}
		
	@Test
	public void method1() {
	WebElement X=driver.findElement(By.xpath("//button[text()='✕']"));
	X.click();
	System.out.println("login");
	}
	
	@Test
	public void method2() throws Throwable {

		   Thread.sleep(2000);
		   WebElement user = driver.findElement(By.xpath("//input[@type ='text']"));
		   user.sendKeys("redmi");
		   
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("search");
			}
	
	@Test
	public void method3() throws Throwable {

		   Thread.sleep(2000);
		   WebElement element1 = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		   element1.click();
		   String text = element1.getText();
		   System.out.println(text);
		
		System.out.println("mobiles");
			}
	@Test
	public void method4() throws Throwable {

		   Thread.sleep(2000);
		   WebElement element1 = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		   element1.click();
		   
		   Thread.sleep(2000);
		   WebElement element2 = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]"));
		   element2.click();
		   
		   Thread.sleep(2000);
		   WebElement element3 = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
		   element3.click();
		   
		   
		   Set<String> child = driver.getWindowHandles();
		   List<String> multiwindow = new ArrayList<String>(child);
		  driver.switchTo().window(multiwindow.get(3));
		   for(String x : child) {
			   driver.switchTo().window(x);
			   System.out.println(x);
		   }
			
		
		   }
	@Test
	public void method5() throws Throwable {
		TakesScreenshot tk = (TakesScreenshot)driver;
	     File filetype = tk.getScreenshotAs(OutputType.FILE);
	     File location = new File("C:\\Users\\nandhini\\eclipse-workspace\\Frametask\\target\\frames");
	     FileUtils.copyFile(filetype, location);
		System.out.println("screenshot");
			}
}

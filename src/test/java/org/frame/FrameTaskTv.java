package org.frame;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class FrameTaskTv {
	static long start;
	static WebDriver driver;
	static String text;
	static String text1;
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
public static void browserquit() throws Throwable {
		Thread.sleep(2000);
		driver.quit();
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
		   user.sendKeys("tv");
		   
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("search");
			}
	
	@Test
	public void method3() throws Throwable {

		   Thread.sleep(2000);
		   WebElement element1 = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		   element1.click();
		    text = element1.getText();
		   System.out.println(text);
		   
		   File f = new File("C:\\Users\\nandhini\\eclipse-workspace\\Frametask\\src\\test\\resources\\Bookframe.xlsx");
		Workbook wb  =new XSSFWorkbook();
		Sheet s = wb.createSheet("sheet1");
		Row r = s.createRow(0);
		Cell c = r.createCell(0);
		c.setCellValue(text);
		FileOutputStream f1 = new FileOutputStream(f);
		wb.write(f1);
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
		  System.out.println(child);
		   for(String x : child) {
			   driver.switchTo().window(x);
			   System.out.println(x);   
			}
			   WebElement element4 = driver.findElement(By.xpath("//span[@class='B_NuCI']"));
				  text1 = element4.getText();
				   System.out.println(text1);
				   File f = new File("C:\\Users\\nandhini\\eclipse-workspace\\Frametask\\src\\test\\resources\\Framebook2.xlsx");
					Workbook wb  =new XSSFWorkbook();
					Sheet s = wb.createSheet("sheet1");
					Row r = s.createRow(0);
					Cell c = r.createCell(0);
					c.setCellValue(text1);
					FileOutputStream f1 = new FileOutputStream(f);
					wb.write(f1);
		   }
		
	@Test
	public void method5() throws Throwable {
		TakesScreenshot tk = (TakesScreenshot)driver;
	     File filetype = tk.getScreenshotAs(OutputType.FILE);
	     File location = new File("C:\\Users\\nandhini\\eclipse-workspace\\Frametask\\target\\frames1");
	     FileUtils.copyFile(filetype, location);
		System.out.println("screenshot");
		
		if (text.equals(text1)) {
			System.out.println("true");
			}
		else {
			System.out.println("false");
		}
	}
	
}



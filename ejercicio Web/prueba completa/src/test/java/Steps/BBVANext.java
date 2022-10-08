package Steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import java.time.Duration;
import java.util.List;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ElementsData.ElementsData;

public class BBVANext {
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	int shortSleepMilliseconds = 3000;
	int longSleepMilliseconds = 5000;
	
	
	@Given("abrir navegador")
	public void abrir_navegador() {
		System.out.println("Step - abrir navegador");
		
		String projectPath = System.getProperty("user.dir");
		
		System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		driver.manage().window().maximize();
	}
	
	

	@Given("aceptar cookies")
	public void aceptar_cookies() throws Exception {
		System.out.println("Step - aceptar cookies");
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ElementsData.cookies_botonAceptar_xPath)));
		Thread.sleep(shortSleepMilliseconds);
		driver.findElement(By.xpath(ElementsData.cookies_botonAceptar_xPath)).click();
	}
	
	
	
	@Given("navegar a la web BBVA NEXT TECHNOLOGIES")
	public void navegar_a_la_web_bbva_next_technologies() {
		System.out.println("Step - navegar a la web BBVA NEXT TECHNOLOGIES");
		
		driver.navigate().to(ElementsData.URL);
	}
	
	
	
	@Given("navegar al Blog")
	public void navegar_al_Blog() throws Exception {
		System.out.println("Step - navegar al Blog");
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ElementsData.paginaPrincipal_botonBlog_xPath)));
		Thread.sleep(longSleepMilliseconds);
		driver.findElement(By.xpath(ElementsData.paginaPrincipal_botonBlog_xPath)).click();
	}
	
	

	@When("abrir el penultimo post")
	public void abrir_el_penultimo_post() throws Exception {
		System.out.println("Step - abrir el penultimo post");
		
		Thread.sleep(longSleepMilliseconds);
		List<WebElement> posts = driver.findElements(By.xpath(ElementsData.blog_todosLosPosts_xPath));
		posts.get(1).click();
	}
	
	

	@Then("capturar pantalla")
	public void capturar_pantalla() throws Exception {
		System.out.println("Step - capturar pantalla");
		
		Thread.sleep(shortSleepMilliseconds);		
		TakesScreenshot screenShot =((TakesScreenshot)driver);
		File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./src/test/resources/screenShot.jpeg");
		FileUtils.copyFile(srcFile, destFile);
	}
	
}

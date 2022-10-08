package Steps;

import java.time.Duration;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import ElementsData.ElementsData;

public class BBVANext {
	
	WebDriver driver = null;
	WebDriverWait wait = null;
	
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
	public void aceptar_cookies() {
		System.out.println("Step - aceptar cookies");
		
		driver.findElement(By.xpath(ElementsData.cookies_botonAceptar_xPath)).click();
	}
	
	@Given("navegar a la web BBVA NEXT TECHNOLOGIES")
	public void navegar_a_la_web_bbva_next_technologies() {
		System.out.println("Step - navegar a la web BBVA NEXT TECHNOLOGIES");
		
		driver.navigate().to(ElementsData.URL);
	}
	
	@Given("navegar al Blog")
	public void navegar_al_Blog() {
		System.out.println("Step - navegar al Blog");
		
		driver.findElement(By.xpath(ElementsData.paginaPrincipal_botonBlog_xPath)).click();
	}

	@When("abrir el penultimo post")
	public void abrir_el_penultimo_post() {
		// NO ME DA TIEMPO. AQUI SERIA OBTENER EL NUMERO DE ELEMENTOS DE POST QUE HAY E IR AL ULTIMO - 1 PROBABLEMENTE.
	}

	@Then("capturar pantalla")
	public void capturar_pantalla() {
	}
	
}

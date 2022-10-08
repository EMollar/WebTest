package ElementsData;

public class ElementsData {
	
	public static String URL = "https://www.bbvanexttechnologies.com/";
	
		// Cookies
	public static String cookies_botonAceptar_xPath = "//button[@class = 'optanon-allow-all accept-cookies-button']";
	
		// Página principal
	public static String paginaPrincipal_botonBlog_xPath = "//a[contains(text(),'Blog')]";
	
		// Blog
	public static String blog_ultimaPagina_xPath = "//span[@class='blog-pagination-control last-page']";
	public static String blog_todosLosPosts_xPath = "//div[contains(@class,'blog-archive-body mt-4 slight-slide-in-bottom')]//article";

}

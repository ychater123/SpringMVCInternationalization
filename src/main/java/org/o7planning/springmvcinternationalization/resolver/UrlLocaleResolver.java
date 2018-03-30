package org.o7planning.springmvcinternationalization.resolver;
 
import java.util.Locale;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.LocaleResolver;
 
public class UrlLocaleResolver implements LocaleResolver {
 
    private static final String URL_LOCALE_ATTRIBUTE_NAME = "URL_LOCALE_ATTRIBUTE_NAME";
    
    public Locale resolveLocale(HttpServletRequest request) {
    	// ==> /SpringMVCInternationalization/en/...
        // ==> /SpringMVCInternationalization/fr/...
        // ==> /SpringMVCInternationalization/WEB-INF/pages/...
        String uri = request.getRequestURI();
 
        System.out.println("URI=" + uri);
 
        String prefixEn = request.getServletContext().getContextPath() + "/en/";
        String prefixFr = request.getServletContext().getContextPath() + "/fr/";
        String prefixVi = request.getServletContext().getContextPath() + "/vi/";
 
        Locale locale = null;
        
        // English
        if (uri.startsWith(prefixEn)) {
            locale = Locale.ENGLISH;
        }
        // French
        else if (uri.startsWith(prefixFr)) {
            locale = Locale.FRANCE;
        }
        // Vietnamese
        else if (uri.startsWith(prefixVi)) {
            locale = new Locale("vi", "VN");
        }
        if (locale != null) {
            request.getSession().setAttribute(URL_LOCALE_ATTRIBUTE_NAME, locale);
        }
        if (locale == null) {
            locale = (Locale) request.getSession().getAttribute(URL_LOCALE_ATTRIBUTE_NAME);
            if (locale == null) {
                locale = Locale.ENGLISH;
            }
        }
        return locale;
    }

	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		// Nothing
		System.out.println("In setLocale Method of UrlLocaleResolver");
	}
}

//this file is for the second manner (/fr/login)
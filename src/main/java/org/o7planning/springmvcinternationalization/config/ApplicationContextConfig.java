package org.o7planning.springmvcinternationalization.config;

import org.o7planning.springmvcinternationalization.resolver.UrlLocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("org.o7planning.springmvcinternationalization.*")
public class ApplicationContextConfig {
 
   @Bean(name = "viewResolver")
   public InternalResourceViewResolver getViewResolver() {
       InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

       viewResolver.setPrefix("/WEB-INF/pages/");
       viewResolver.setSuffix(".jsp");

       return viewResolver;
   }
    
   @Bean(name = "messageSource")
   public MessageSource getMessageResource()  {
       ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
        
       // Read i18n/messages_xxx.properties file.
       // For example: i18n/messages_en.properties
 
       messageResource.setBasename("classpath:i18n/messages");
       messageResource.setDefaultEncoding("UTF-8");
       return messageResource;
   }
   
   //this file is for the second manner (/login?lang=fr)
   
   /*@Bean(name = "localeResolver")
   public LocaleResolver getLocaleResolver()  {
       CookieLocaleResolver resolver = new CookieLocaleResolver();
       resolver.setCookieDomain("myAppLocaleCookie");
       
       // 60 minutes
       resolver.setCookieMaxAge(60*60);
       return resolver;
   }*/
   
   
   //this file is for the second manner (/fr/login)
   
   // To solver URL like:
   // /SpringMVCInternationalization/en/login2
   // /SpringMVCInternationalization/vi/login2
   // /SpringMVCInternationalization/fr/login2
   @Bean(name = "localeResolver")
   public LocaleResolver getLocaleResolver()  {
       LocaleResolver resolver= new UrlLocaleResolver();
       return resolver;
   }
    
 
}
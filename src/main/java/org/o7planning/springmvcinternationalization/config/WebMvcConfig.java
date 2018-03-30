package org.o7planning.springmvcinternationalization.config;
 
import org.o7planning.springmvcinternationalization.interceptor.UrlLocaleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
 
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
 
   // Static Resource Config
   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
	   // Default..
   }
 
   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
   }
   
 //this file is for the second manner (/login?lang=fr)
 
   /*@Override
   public void addInterceptors(InterceptorRegistry registry) {
       LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
       localeInterceptor.setParamName("lang");
       
       registry.addInterceptor(localeInterceptor).addPathPatterns("/*");
   }*/
   
 //this file is for the second manner (/fr/login)
   @Override
   public void addInterceptors(InterceptorRegistry registry) {
 
       UrlLocaleInterceptor localeInterceptor = new UrlLocaleInterceptor();
 
       registry.addInterceptor(localeInterceptor).addPathPatterns("/en/*", "/fr/*", "/vi/*");
   }
  
}
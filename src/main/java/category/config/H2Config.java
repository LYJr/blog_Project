package category.config;

import org.apache.catalina.servlets.WebdavServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class H2Config {

    @Bean
    public ServletRegistrationBean h2servletRegistration(){

        ServletRegistrationBean regi = new ServletRegistrationBean(new WebdavServlet());
        regi.addUrlMappings("/console/*");
        return regi;
    }

}

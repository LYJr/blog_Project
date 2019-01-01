package category.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);

        registry.addViewController("/").setViewName("index");
        registry.addViewController("/blogs").setViewName("/category/blog");
        registry.addViewController("/abouts").setViewName("/category/about");
        registry.addViewController("/features").setViewName("/category/features");
        registry.addViewController("/portfolio-list").setViewName("/category/portfolio");
        registry.addViewController("/user").setViewName("/category/user");
        registry.addViewController("/single").setViewName("/category/portfolio-single");
        registry.addViewController("/form").setViewName("/category/login_form");
        registry.addViewController("/login").setViewName("/category/login");
    }
}

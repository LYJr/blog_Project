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
        registry.addViewController("/users").setViewName("/category/login");
        registry.addViewController("/blogs").setViewName("/category/blog");
        registry.addViewController("/abouts").setViewName("/category/about");
        registry.addViewController("/features").setViewName("/category/features");
        registry.addViewController("/popor").setViewName("/category/portfolio");
    }
}

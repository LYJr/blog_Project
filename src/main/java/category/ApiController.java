package category;

import category.blog.Blog;
import category.blog.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blogs")
public class ApiController {

    @Autowired
    private BlogRepository blogRepository;

    @PostMapping("")
    public Blog input(Blog blogs){
        return blogRepository.save(blogs);
    }
}

package category.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/popor")
public class PortfolioController {

    @Autowired
    private PortfolioController portfolioController;

}

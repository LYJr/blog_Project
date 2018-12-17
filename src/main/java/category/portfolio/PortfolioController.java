package category.portfolio;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/popor")
public class PortfolioController {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @PostMapping("")
    public String upDate(HttpServletRequest request,
                         @RequestParam MultipartFile[] fileUpload, Portfolio portfolio) throws Exception {

        if (fileUpload != null && fileUpload.length > 0) {
            for (MultipartFile aFile : fileUpload) {
                portfolio.setFileName(aFile.getOriginalFilename());
                portfolio.setData(aFile.getBytes());
                portfolioRepository.save(portfolio);
            }
        }

        portfolioRepository.save(portfolio);

        return "redirect:/popor/popor-single";
    }


    @GetMapping("/popor-single")
    public String contact(Model model) {
        model.addAttribute("input" ,portfolioRepository.findAll());

        return "/category/portfolio-single";
    }

}


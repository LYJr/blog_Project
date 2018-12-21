package category.portfolio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {

    private static final Logger logger = LoggerFactory.getLogger(PortfolioController.class);
    private String uploadDirectory = "c:\\input";

    @Autowired
    private PortfolioRepository portfolioRepository;


    @PostMapping("")
    public String upDate(
            @RequestParam MultipartFile file, Portfolio portfolio) throws Exception {

        portfolio.setFileName(file.getOriginalFilename());
        portfolio.setData(file.getBytes());
        portfolioRepository.save(portfolio);

//        return new Portfolio(fileName, fileDownloadUri);

        return "redirect:/portfolio/portfolio-single";
    }

    @GetMapping("/portfolio-single")
    public String contact(Model model) {
        //아이디 값에 맞게 진행하라.

        model.addAttribute("input",portfolioRepository.findAll());

        return "/category/portfolio-single";
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ByteArrayResource> download(@PathVariable long id) throws Exception{
//
//        Portfolio a = portfolioRepository.findById(id).orElseGet(null);
//
//        ByteArrayResource byteArrayResource = new ByteArrayResource();
//
//        HttpHeaders header = new HttpHeaders();
//        header.setContentType(MediaType.ALL);
//        header.set(HttpHeaders.CONTENT_DISPOSITION, a.getFileName());
//
//    }

}
package life.majiang.community.controller;
import life.majiang.community.dto.PaginationDTO;
import life.majiang.community.dto.QuestionDTO;
import life.majiang.community.mapper.QuestionMapper;
import life.majiang.community.mapper.UserMapper;
import life.majiang.community.model.Question;
import life.majiang.community.model.User;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@Controller
public class IndexController {


    @Autowired
    private QuestionService QuestionService;

    @RequestMapping("/")
    public String index(
                        Model model,
                        @RequestParam(name = "page",defaultValue ="1") Integer page,
                        @RequestParam(name = "size",defaultValue = "5") Integer size
    ) {

        PaginationDTO pagination = QuestionService.list(page,size);
        model.addAttribute("pagination",pagination);

        return "index";
    }


}

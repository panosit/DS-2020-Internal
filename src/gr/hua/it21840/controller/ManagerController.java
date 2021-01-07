package gr.hua.it21840.controller;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import gr.hua.it21840.dao.ChildDAO;
import gr.hua.it21840.entity.Child;

import javax.servlet.http.*;

@Controller
@RequestMapping("/")
public class ManagerController{
    @Autowired
    private ChildDAO childDAO;
    @Secured("ROLE_MANAGER")
    @PostMapping("/registerChild")
    public String register(HttpServletRequest request){
        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        int tmima=Integer.parseInt(request.getParameter("class"));
        Child child=new Child(firstname,lastname,tmima);
        try {
        childDAO.insertChild(child);
        }catch(Exception e) {}
        return "index";
    }
}
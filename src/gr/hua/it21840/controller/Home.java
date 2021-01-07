package gr.hua.it21840.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gr.hua.it21840.dao.AuthoritiesDAO;
import gr.hua.it21840.dao.ChildDAO;
import gr.hua.it21840.dao.TeacherDAO;
import gr.hua.it21840.dao.UserDAO;
import gr.hua.it21840.dao.UserInformationDAO;
import gr.hua.it21840.entity.Authorities;
import gr.hua.it21840.entity.Child;
import gr.hua.it21840.entity.Teacher;
import gr.hua.it21840.entity.User;
import gr.hua.it21840.entity.UserInformation;





@Controller
public class Home{
	@Autowired
	PasswordEncoder passwordEncoder;
    @Autowired
     private UserDAO user;
    
    @Autowired
    private TeacherDAO teacherr;

     @Autowired
     private AuthoritiesDAO author;
     
     @Autowired
     private UserInformationDAO userinformationn;
 	@Autowired
 	private TeacherDAO teacherDAO;
 	@Autowired
 	private ChildDAO childDAO;
    @RequestMapping("/")
    public String home(Model model,Principal principal){
    	List<Authorities> users=author.getAuthorities();
    	Teacher teacher=teacherDAO.getTeacherByUsername(principal.getName());
		List<Child> childList=null;
		try {
			childList=childDAO.getChildByClass(teacher.getClassN());
		}catch(Exception e) {}
    	model.addAttribute("teacher",teacher);
    	model.addAttribute("child",childList);
		model.addAttribute("users",users);
		model.addAttribute("username",principal.getName());
		model.addAttribute("tmimata",teacherDAO.getTeachers());
       return "index";

    }
    
     @Secured("ROLE_ADMIN")
     @RequestMapping("/delete")
     public String delete(HttpServletRequest request){
      User check=user.getUserByUsername(request.getParameter("deleteUsername"));
         if(check!=null)
          user.deleteUser(check);
         return "index";
     }
     @Secured("ROLE_ADMIN")
     @RequestMapping("/update")
     public String update(HttpServletRequest request){
       String username=request.getParameter("uusername");
         String oldpassword=request.getParameter("oldpassword");
         String newpassword=request.getParameter("newpassword");
       User check=user.getUserByUsernameAndPassword(username,oldpassword);
       User a=new User(username,passwordEncoder.encode(newpassword),1);
         if(check!=null)
          System.out.println("update");
             user.updateUser(a);
         return "index";
     }
     @Secured("ROLE_ADMIN")
     @RequestMapping("/register")
     public String register(HttpServletRequest request){
       User check=user.getUserByUsername(request.getParameter("username"));
       if(check==null){
          String musername=request.getParameter("username");
          String mpassword=request.getParameter("password");
          String role=request.getParameter("role");
          String newRole="ROLE_"+role.toUpperCase();
          System.out.print(newRole+"\n");
          
          
          User a=new User(musername,passwordEncoder.encode(mpassword),1);
          Authorities b=new Authorities(musername,newRole);
          user.insertUser(a);
          author.insertAuthorities(b);
         
          if (role.contains("teacher")) {
        	  
        	  String firstname = request.getParameter("firstname");
        	  String lastname = request.getParameter("lastname");
        	  String classN = request.getParameter("class");

        	  Teacher teacher = new Teacher(musername,Integer.parseInt(classN));
        	  teacherr.insetTeacher(teacher);
        	  
        	  UserInformation userInformation = new UserInformation(musername,firstname,lastname);
        	  userinformationn.insertUserInformation(userInformation);
        	  
          }else if(role.contains("manager")){
        	  String firstname = request.getParameter("firstname");
        	  String lastname = request.getParameter("lastname");
        	  
        	  
        	  UserInformation userInformation = new UserInformation(musername,firstname,lastname);
        	  userinformationn.insertUserInformation(userInformation);
          }
          
       }
       return "index";
     }


}
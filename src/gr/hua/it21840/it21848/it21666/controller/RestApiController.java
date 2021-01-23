package gr.hua.it21840.it21848.it21666.controller;
import gr.hua.it21840.it21848.it21666.dao.ApplicationDAO;
import gr.hua.it21840.it21848.it21666.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/api")
public class RestApiController{
    @Autowired
    private ApplicationDAO applicationDAO;
    @Secured("ROLE_MANAGER")
    @GetMapping("/applications/{lastname}")
    public List<Application> getApplicationsByLastName(@PathVariable String lastname){
        return applicationDAO.getApplicationsByParentLastName(lastname);
    }
    @Secured("ROLE_MANAGER")
    @GetMapping("/applications")
    public List<Application> getApplications(){
        return applicationDAO.getApplications();
    }
    @Secured("ROLE_EXTERNAL")
    @PostMapping(path="/applications",consumes="application/x-www-form-urlencoded",
            headers="Accept=application/x-www-form-urlencoded")
    public Application addApplication(Application application){
        applicationDAO.insertApplication(application);
        return application;
    }
    @Secured("ROLE_MANAGER")
    @DeleteMapping("/applications/{applicationId}")
    public String deleteCustomer(@PathVariable int applicationId){
        applicationDAO.deleteApplication(applicationId);
        return applicationId+"";
    }
}
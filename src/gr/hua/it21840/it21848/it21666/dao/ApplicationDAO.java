package gr.hua.it21840.it21848.it21666.dao;
import java.util.*;

import gr.hua.it21840.it21848.it21666.entity.Application;

public interface ApplicationDAO{
    void insertApplication(Application application);
    List<Application> getApplications();
    List<Application> getApplicationsByParentLastName(String parent_last_name);
    void deleteApplication(int id);
    Application getApplicationById(int id);
}
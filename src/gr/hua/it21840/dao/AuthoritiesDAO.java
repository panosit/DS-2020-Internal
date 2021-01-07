package gr.hua.it21840.dao;
import java.util.*;

import gr.hua.it21840.entity.Authorities;

public interface AuthoritiesDAO{
    void insertAuthorities(Authorities authority);
    void deleteAuthorities(Authorities authority);
    Authorities getAuthorByUsername(String username);
    List<Authorities> getAuthorities();
    List<Authorities> getTeachers();
}
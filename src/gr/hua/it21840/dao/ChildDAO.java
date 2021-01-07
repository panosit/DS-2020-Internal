package gr.hua.it21840.dao;
import java.util.*;

import gr.hua.it21840.entity.Child;

public interface ChildDAO{
    List<Child> getChildByClass(int tmima);
    void insertChild(Child child);
}
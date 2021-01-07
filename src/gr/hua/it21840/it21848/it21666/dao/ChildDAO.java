package gr.hua.it21840.it21848.it21666.dao;
import java.util.*;

import gr.hua.it21840.it21848.it21666.entity.Child;

public interface ChildDAO{
    List<Child> getChildByClass(int tmima);
    void insertChild(Child child);
}
package gr.hua.it21840.it21848.it21666.dao;

import java.util.List;

import gr.hua.it21840.it21848.it21666.entity.Teacher;

public interface TeacherDAO {
	void insetTeacher(Teacher teacher);
	
	void deleteTeacher(Teacher teacher);
	
	List<Teacher> getTeachers();
	
	Teacher getTeacherByUsername(String username);

}

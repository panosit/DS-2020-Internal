package gr.hua.it21840.it21848.it21666.dao;

import gr.hua.it21840.it21848.it21666.entity.User;

public interface UserDAO{
	void insertUser(User user);
	User getUserByUsername(String username);
	User getUserByUsernameAndPassword(String username,String password);
	void deleteUser(User user);
	void updateUser(User user);
}
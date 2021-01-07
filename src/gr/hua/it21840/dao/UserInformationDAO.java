package gr.hua.it21840.dao;

import gr.hua.it21840.entity.UserInformation;

public interface UserInformationDAO {
	void insertUserInformation(UserInformation userInformation);
	void deleteUserInformation(UserInformation userInformation);
}

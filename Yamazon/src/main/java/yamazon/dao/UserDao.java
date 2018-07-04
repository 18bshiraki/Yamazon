package yamazon.dao;

import java.util.List;

import yamazon.entity.User;

public interface UserDao {
	public List<User> findByPhoneNumberAndPassword(String phoneNumber, String password);
}

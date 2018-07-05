package yamazon.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import yamazon.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	public JdbcTemplate UserI;

	public int insert(String phoneNumber, String userName, String address, String password) {
		return UserI.update("INSERT INTO user_info (phone_number, user_name, address, password) VALUES (?, ?, ?, ?)",
				phoneNumber, userName, address, password);
	}
}

package yamazon.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import yamazon.dao.UserDao;
import yamazon.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private JdbcTemplate JdbcTemplate;

	public List<User> findByPhoneNumberAndPassword(String phoneNumber, String password) {
		return JdbcTemplate.query(
				"SELECT user_id, phone_number,user_name,address,password FROM user_info WHERE phone_number = ? AND password= ?",
				new BeanPropertyRowMapper<User>(User.class), phoneNumber, password);

	}
}

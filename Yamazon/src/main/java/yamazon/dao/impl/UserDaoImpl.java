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


    @Autowired
    private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> findAll() {
		String sql = "SELECT user_id, phone_number, user_name, address, password"
				+ " FROM user_info ORDER BY user_id";

		List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));

		return userList;
	}

	@Override
	public List<User> findByUserId(int userId) {
		String sql = "SELECT user_id, phone_number, user_name, address, password "
				+ "FROM user_info WHERE user_id = ?";

		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), userId);
	}

	@Override
	public int userDelete(int userId) {
		String sql = "DELETE FROM user_info WHERE user_id = ?";

		return jdbcTemplate.update(sql, userId);
	}

	@Override
	public int userUpdate(String newPhoneNumber, String newName, String newAddress, String newPassword, int userId) {
		String sql = "UPDATE user_info SET phone_number = ?, user_name = ?, address = ?, password = ?"
				+ "WHERE user_id = ?";

		return jdbcTemplate.update(sql, newPhoneNumber, newName, newAddress, newPassword, userId);
	}
	public List<User> findByPhoneNumberAndPassword(String phoneNumber, String password) {
		return JdbcTemplate.query(
				"SELECT user_id, phone_number,user_name,address,password FROM user_info WHERE phone_number = ? AND password= ?",
				new BeanPropertyRowMapper<User>(User.class), phoneNumber, password);


	}
}

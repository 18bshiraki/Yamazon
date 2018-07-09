package yamazon.dao.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import yamazon.dao.ManagerDao;
import yamazon.entity.Manager;

@Repository
public class ManagerDaoImpl implements ManagerDao {


	@Autowired
	private JdbcTemplate JdbcTemplate;

	public List<Manager> findByPhoneNumberAndPassword(int managerId, String password){
		return JdbcTemplate.query(
				"SELECT manager_id,manager_name,manager_password FROM manager_info WHERE manager_id = ? AND manager_password= ?",
				new BeanPropertyRowMapper<Manager>(Manager.class),managerId,password);
	}

	public List<Manager> findAll(){
		return JdbcTemplate.query(
				"SELECT manager_id,manager_name,manager_password FROM manager_info",
				new BeanPropertyRowMapper<Manager>(Manager.class));

	}


	@Override
	public int insert(String managerId,String password) {
		String sql = "INSERT INTO manager_info (manager_name, manager_password) VALUES (?,?)";

		return JdbcTemplate.update(sql, managerId,password);


	}


	public int update(String managerName, String managerPassword, int managerId) {
		return JdbcTemplate.update(
				"UPDATE manager_info SET manager_name = ?,manager_password = ? WHERE manager_id = ?",managerName,managerPassword,managerId);
	}

	public int delete(int managerId) {
		return JdbcTemplate.update(
				"DELETE FROM manager_info WHERE manager_id = ?",managerId);
	}

}

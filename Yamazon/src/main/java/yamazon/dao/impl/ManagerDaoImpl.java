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

}

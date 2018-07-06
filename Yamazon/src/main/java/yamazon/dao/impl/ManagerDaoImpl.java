package yamazon.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import yamazon.dao.ManagerDao;
import yamazon.entity.Manager;

@Repository
public class ManagerDaoImpl implements ManagerDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

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
	public List<Manager> findByConditions(Manager manager) {

		List<String> condition = new ArrayList<String>();
		MapSqlParameterSource param = new MapSqlParameterSource();

		Integer managerId = manager.getManagerId();
		String managerName = manager.getManagerName();

		if(managerId != null) {
			condition.add("manager_id = :managerId");
			param.addValue("managerId", managerId);
		}

		if(managerName != null && !managerName.isEmpty()) {
			condition.add("manager_name = :managerName");
			param.addValue("managerName", managerName);

		}

		String whereString = String.join(" AND ", condition.toArray(new String[]{}));

		String sql = "SELECT * FROM user_info WHERE " + whereString + " ORDER BY user_id";

		List<Manager> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Manager>(Manager.class));

		return resultList;
	}

	@Override
	public Manager findById(Integer managerId) {

		String sql = "SELECT * FROM manager_info WHERE manager_id = :managerId";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("managerId", managerId);

		List<Manager> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Manager>(Manager.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}

	@Override
	public int insert(Manager manager) {
		String sql = "INSERT INTO manager_info (manager_name, manager_password) VALUES (:managerName, :managerPassword)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("managerName", manager.getManagerName());
		param.addValue("managerPassword", manager.getManagerPassword());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(sql, param, keyHolder, new String[] {"manager_id"});

		return keyHolder.getKey().intValue();
	}



/*	@Override
	public void update(Manager manager) {
		String sql = "UPDATE user_info SET user_name = :userName, telephone = :telephone, password = :password WHERE user_id = :userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("managerName", manager.getManagerName());
		param.addValue("managerPassword", manager.getManagerPassword());
		param.addValue("managerId", manager.getManagerId());

		jdbcTemplate.update(sql, param);
	}

	@Override
	public void delete(Integer id) {

		String sql = "DELETE FROM user_info WHERE user_id = :userId";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", id);

		jdbcTemplate.update(sql, param);
	}*/
}

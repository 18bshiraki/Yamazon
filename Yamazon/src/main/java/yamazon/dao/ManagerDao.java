package yamazon.dao;

import java.util.List;

import yamazon.entity.Manager;

public interface ManagerDao {
	public List<Manager> findByPhoneNumberAndPassword(int managerId, String password);
	public List<Manager> findAll();
}

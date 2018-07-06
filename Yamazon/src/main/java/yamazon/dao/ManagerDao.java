package yamazon.dao;

import java.util.List;

import yamazon.entity.Manager;

public interface ManagerDao {
	public List<Manager> findByPhoneNumberAndPassword(int managerId, String password);
	public List<Manager> findAll();
	public int update(String managerName, String managerPassword, int managerId);
	public int delete(int managerId);
}

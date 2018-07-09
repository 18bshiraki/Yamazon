package yamazon.dao;

import java.util.List;

import yamazon.entity.Manager;

public interface ManagerDao {

	public List<Manager> findAll();
	public List<Manager> findByConditions(Manager manager);
	public int insert(String managerId,String password);
	public Manager findById(Integer managerId);
	public List<Manager> findByPhoneNumberAndPassword(int managerId, String password);
}

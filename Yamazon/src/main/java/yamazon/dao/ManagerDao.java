package yamazon.dao;

import java.util.List;

import yamazon.entity.Manager;

public interface ManagerDao {

	public List<Manager> findAll();
	public List<Manager> findByConditions(Manager manager);
	public int insert(Manager manager);
	public Manager findById(Integer managerId);
/*	public void delete(Integer managerId);
	public void update(Manager manager);*/
/*	public List<Manager> find(Manager manager);*/
}

package yamazon.dao;

import java.util.List;

import yamazon.entity.User;

public interface UserDao {
	public List<User> findByPhoneNumberAndPassword(String phoneNumber, String password);

    public int insert(String phoneNumber,String userName,String address, String password);

    public int userDelete(String phoneNumber, String password);

	public int userUpdate(String phoneNumber,String userName,String address, String password, String tell);

}
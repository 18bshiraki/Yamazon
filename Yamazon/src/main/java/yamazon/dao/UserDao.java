package yamazon.dao;

public interface UserDao {

	public int insert(String phoneNumber, String userName, String address, String password);
}
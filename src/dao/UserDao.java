package dao;

import java.util.List;

import domain.User;

public interface UserDao {
	/**
	 * 保存用户信息到数据库中
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 通过 username 从数据库中查找用户
	 * @param username
	 * @return 存在返回User,不存在返回null
	 */
	User findUserByUsername(String username);
	/**
	 * 根据用户名和密码从数据库中查找用户
	 * @return 存在返回User,不存在返回null
	 */
	User findUser(String username,String password);
	/**
	 * 查找所有的用户
	 * @return
	 */
	List<User> findAll();
	/**
	 * 根据用户名删除用户
	 */
	void delUserByUsername(String username);

}

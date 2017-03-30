package dao;

import java.util.List;

import domain.User;

public interface UserDao {
	/**
	 * �����û���Ϣ�����ݿ���
	 * @param user
	 */
	void addUser(User user);
	/**
	 * ͨ�� username �����ݿ��в����û�
	 * @param username
	 * @return ���ڷ���User,�����ڷ���null
	 */
	User findUserByUsername(String username);
	/**
	 * �����û�������������ݿ��в����û�
	 * @return ���ڷ���User,�����ڷ���null
	 */
	User findUser(String username,String password);
	/**
	 * �������е��û�
	 * @return
	 */
	List<User> findAll();
	/**
	 * �����û���ɾ���û�
	 */
	void delUserByUsername(String username);

}

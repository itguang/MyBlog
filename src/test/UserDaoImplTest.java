package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dao.impl.UserDaoImpl;
import domain.User;

public class UserDaoImplTest {
	UserDaoImpl dao = new UserDaoImpl();

	@Test
	public void testAddUser() {
		User user = new User();
		user.setUsername("itguang");
		user.setPassword("666666");
		user.setMail("1276951545@qq.com");
		dao.addUser(user);
	}

	@Test
	public void testFindUserByUsername() {

		User user = dao.findUserByUsername("itguang");
		System.out.println(user.toString());
		
		
	}

	@Test
	public void testFindUser() {
		User user = dao.findUser("itguang", "666666");
		System.out.println(user.toString());
	}

	@Test
	public void testFindAll() {
		List<User> list = dao.findAll();
		for (User user : list) {
			System.out.println(user.toString());
		}
	}

	@Test
	public void testDelUserByUsername() {
		dao.delUserByUsername("li");
	}

}

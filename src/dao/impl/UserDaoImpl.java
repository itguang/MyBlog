package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;

import utils.JdbcUtil;
import dao.UserDao;
import domain.User;
import exception.DaoException;

/*
 创建数据库
 create database BlogLogin 
 创建数据库表
 create table user(
 username varchar(50),
 password varchar(100),
 mail varchar(50)
 );
 */

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(User user) {
		if (user == null) {
			throw new IllegalArgumentException();
		}
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			stmt = conn
					.prepareStatement("insert into user (username,password,mail) values(?,?,?)");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getMail());

			stmt.executeUpdate();// 执行更新语句,没有返回结果
		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}

	}

	@Override
	public User findUserByUsername(String username) {
		if (username == "" || username == null) {
			throw new IllegalArgumentException();
		}
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {

			conn = JdbcUtil.getConnection();
			stmt = conn
					.prepareStatement("select username,password,mail from user where username = ?");
			stmt.setString(1, username);

			rs = stmt.executeQuery();// 执行查询语句,返回一个结果集

			if (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setMail(rs.getString("mail"));

				return user;

			} else {
				return null;
			}

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}

	}

	@Override
	public User findUser(String username, String password) {

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConnection();
			stmt = conn
					.prepareStatement("select username,password,mail from user where username =?&&password=?");

			stmt.setString(1, username);
			stmt.setString(2, password);

			rs = stmt.executeQuery();

			if (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setMail(rs.getString("mail"));
				return user;

			} else {
				return null;
			}

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}

	}

	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			stmt = conn
					.prepareStatement("select username,password,mail from user");
			rs = stmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setMail(rs.getString("mail"));
				list.add(user);
			}
			return list;

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}
	}

	@Override
	public void delUserByUsername(String username) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conn = JdbcUtil.getConnection();
			stmt = conn
					.prepareStatement("delete  from user where username=?");
			stmt.setString(1, username);

			stmt.executeUpdate();

		} catch (Exception e) {
			throw new DaoException(e);
		} finally {
			JdbcUtil.release(rs, stmt, conn);
		}

	}

}

package com.dyf.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dyf.domain.UserBean;
import com.dyf.util.DBConn;

public class UserDaoImpl implements IUserDao {
	private Connection conn = null;

	public List<UserBean> getByExample(UserBean userBean, int... params)
			throws Exception {
		List<UserBean> res = new ArrayList<UserBean>();
		conn = DBConn.getConnection();
		String sql = this.getUserSql(userBean);
		PreparedStatement ps = conn.prepareStatement(sql,
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = ps.executeQuery();
		if (!rs.next()) {
			return res;
		}
		if (params != null && params.length > 0) {
			rs.absolute(params[0]);
		}
		int k = 0;
		do {
			if (params != null && params.length > 1) {
				if (++k > params[1])
					break;
			}
			UserBean ub = new UserBean();
			ub = this.getUserBean(rs);
			res.add(ub);
		} while (rs.next());
		DBConn.closeConnection();
		return res;
	}

	public int getAllRowsNum(UserBean userBean) throws Exception {
		String sql = "select count(*)"
				+ this.getUserSql(userBean).substring(
						this.getUserSql(userBean).indexOf("from"));
		conn = DBConn.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		int a = 0;
		if (rs.next()) {
			a = rs.getInt(1);
		}
		DBConn.closeConnection();
		return a;
	}

	public List<UserBean> checkUser(UserBean userBean) throws Exception {
		List<UserBean> res = new ArrayList<UserBean>();
		conn = DBConn.getConnection();
		String sql = "select * from users where username=? and password=?";
		if (conn != null) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userBean.getUsername());
			ps.setString(2, userBean.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				UserBean ub = new UserBean();
				ub.setId(rs.getInt("id"));
				ub.setUsername(rs.getString("username"));
				ub.setPassword(rs.getString("password"));
				res.add(ub);
			}
		}
		DBConn.getConnection();
		return res;
	}

	public boolean userInsert(UserBean userBean) throws Exception {
		boolean bb = false;
		String sql = "insert into users(username,password,name,sex) values(?,?,?,?)";
		conn = DBConn.getConnection();
		if (conn != null) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userBean.getUsername());
			ps.setString(2, userBean.getPassword());
			ps.setString(3, userBean.getName());
			ps.setBoolean(4, userBean.getSex());
			int row = ps.executeUpdate();
			if (row > 0) {
				bb = true;
			} else {
				bb = false;
			}
		}
		DBConn.closeConnection();
		return bb;
	}

	public List<UserBean> LoadById(int id) throws Exception {
		conn = DBConn.getConnection();
		List<UserBean> res = new ArrayList<UserBean>();
		String sql = "select * from users where id=?";
		if (conn != null) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				UserBean ub = new UserBean();
				ub.setId(id);
				ub.setUsername(rs.getString("username"));
				ub.setPassword(rs.getString("password"));
				ub.setName(rs.getString("name"));
				ub.setSex(rs.getBoolean("sex"));
				ub.setRegdate(rs.getDate("regdate"));
				res.add(ub);
			}
		}
		DBConn.closeConnection();
		return res;
	}

	public boolean userUpdate(UserBean userBean) throws Exception {
		conn = DBConn.getConnection();
		String sql = "update users set password=?,name=?,sex=? where id=?";
		boolean bb = false;
		if (conn != null) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userBean.getPassword());
			ps.setString(2, userBean.getName());
			ps.setBoolean(3, userBean.getSex());
			ps.setInt(4, userBean.getId());
			int row = ps.executeUpdate();
			if (row > 0) {
				bb = true;
			} else {
				bb = false;
			}
		}
		DBConn.closeConnection();
		return bb;
	}

	public boolean userDelete(int id) throws Exception {
		boolean bb = false;
		conn = DBConn.getConnection();
		String sql = "delete from users where id=?";
		if (conn != null) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			if (row > 0) {
				bb = true;
			} else {
				bb = false;
			}
		}
		DBConn.closeConnection();
		return bb;
	}

	private String getUserSql(UserBean userBean) throws Exception {
		StringBuffer sb = new StringBuffer("select * from users where 1=1");
		if (null != userBean) {
			if (userBean.getId() != null) {
				sb.append(" and id=" + userBean.getId());
			}
			if (userBean.getUsername() != null
					&& !"".equals(userBean.getUsername())) {
				sb.append(" and username='" + userBean.getUsername() + "'");
			}
			if (userBean.getPassword() != null
					&& !"".equals(userBean.getPassword())) {
				sb.append(" and password='" + userBean.getPassword() + "'");
			}
			if (userBean.getName() != null && !"".equals(userBean.getName())) {
				sb.append(" and name='" + userBean.getName() + "'");
			}
			if (userBean.getSex() != null && !"".equals(userBean.getSex())) {
				sb.append(" and sex='" + userBean.getSex() + "'");
			}
			if (userBean.getRegdate() != null
					&& !"".equals(userBean.getRegdate())) {
				sb.append(" and regdate='" + userBean.getRegdate() + "'");
			}
		}
		return sb.toString();
	}

	private UserBean getUserBean(ResultSet rs) throws Exception {
		UserBean userBean = new UserBean();
		userBean.setId(rs.getInt("id"));
		userBean.setUsername(rs.getString("username"));
		userBean.setPassword(rs.getString("password"));
		userBean.setName(rs.getString("name"));
		userBean.setSex(rs.getBoolean("sex"));
		userBean.setRegdate(rs.getDate("regdate"));
		return userBean;
	}
}

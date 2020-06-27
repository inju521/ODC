package user.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.JDBCTemplate;
import dto.UserInfo;


public class UserDaoImpl implements UserDao {

	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	
	@Override
	public int idCheck(String id) {
		
		conn=JDBCTemplate.getConnection();
		String sql="select count(*) from UserInfo where user_id=?";
		int result=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				result=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return result;
	}


	@Override
	public void insertUser(UserInfo user) {
		// TODO Auto-generated method stub
		conn=JDBCTemplate.getConnection();
		String sql="";
		sql+="insert into userinfo(user_no,user_id,user_pw,user_name,";
		sql+="user_phone,user_email,user_birth,user_nick)";
		sql+="  values(UserInfo_SEQ.nextval,?,?,?,?,?,?,?)";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			ps.setString(2, user.getUserpw());
			ps.setString(3, user.getUsername());
			ps.setLong(4, user.getUserphone());
			ps.setString(5, user.getUseremail());
			ps.setDate(6, (Date) user.getUserbirth());
			ps.setString(7, user.getUsernick());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(ps);
		}
	}


	@Override
	public int userLogin(String id, String pw) {
		conn=JDBCTemplate.getConnection();
		
		String sql="select count(*) from userinfo where user_id=? and user_pw=?";
		int res=0;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				res=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}


	@Override
	public int userIdChkByEN(String email, String name) {
		conn=JDBCTemplate.getConnection();
		
		String sql="select count(*) from userinfo where user_name=? and user_email=?";
		int res=0;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				res=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}


	@Override
	public String selectUserIdByEN(String email, String name) {
		conn=JDBCTemplate.getConnection();
		
		String sql="select user_id from userinfo where user_name=? and user_email=?";
		String res="";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				res=rs.getString("user_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}


	@Override
	public int userPwChkByEN(String email, String name, String id) {
		conn=JDBCTemplate.getConnection();
		
		String sql="select count(*) from userinfo where user_name=? and user_email=? and user_id=?";
		int res=0;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				res=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}


	@Override
	public String selectUserPwByEN(String email, String name, String id) {
		conn=JDBCTemplate.getConnection();
		
		String sql="select user_pw from userinfo where user_name=? and user_email=? and user_id=?";
		String res="";
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				res=rs.getString("user_pw");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return res;
	}

}

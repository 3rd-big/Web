package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.DBConnect;
import model.Member;

public class DaoImpl implements Dao {

	private DBConnect db;

	public DaoImpl() {
		db = DBConnect.getInstance();
	}

	public void insert(Member m) {
		Connection conn = null;
		String sql = "insert into shop_member values(?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getAddr());
			pstmt.setInt(6, m.getType());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 반환
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Member select(String id) {
		Connection conn = null;
		ResultSet rs = null;
		String sql = "select * from shop_member where id=?";
		PreparedStatement pstmt = null;
		try {
			// 커넥션 객체 획득
			conn = db.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 반환
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public void update(Member m) {
		Connection conn = null;

		String sql = "update shop_member set pwd=?, email=?, addr=? where id=?";

		PreparedStatement pstmt = null;
		
		try {
			conn = db.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getAddr());
			pstmt.setString(4, m.getId());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 자원 반환
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(String id) {
		Connection conn = null;
		
		String sql = "delete shop_member where id=?";
		 
		PreparedStatement pstmt = null;
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

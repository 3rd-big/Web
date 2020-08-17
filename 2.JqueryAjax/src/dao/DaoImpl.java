package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import model.MemberVO;

public class DaoImpl implements Dao{

	private DBConnect db;

	public DaoImpl() {
		db = DBConnect.getInstance();
	}
	
	@Override
	public ArrayList idList() {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberVO> data = new ArrayList<MemberVO>();
		String sql = "select id from member3";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				data.add(new MemberVO(rs.getString(1)));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(data);
		return data;
	}

	@Override
	public MemberVO findMember(String id) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member3 where id=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new MemberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public void registerMember(MemberVO vo) {
		// TODO Auto-generated method stub
		
	}

}

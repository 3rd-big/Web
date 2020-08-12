package rep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import model.Rep;



public class DaoImpl implements Dao{
	private DBConnect db;
	
	public DaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Rep rep) {
		Connection conn = db.getConnection();
		String sql = "insert into reps values(seq_reps.nextval, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, rep.getWriter());
			pstmt.setString(2, rep.getContent());
			pstmt.setInt(3, rep.getImg_num());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				// 자원 반환
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<Rep> selectByImg_num(int img_num) {
		ResultSet rs = null;
		ArrayList<Rep> reps = new ArrayList<>();
		String sql = "select * from reps where img_num=? order by num";
		PreparedStatement pstmt = null;
		Connection conn = db.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, img_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				reps.add(new Rep(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
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
		
		return reps;
	}

}

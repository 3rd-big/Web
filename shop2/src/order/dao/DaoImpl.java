package order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import model.Order;
import model.Product;

public class DaoImpl implements Dao {
	private DBConnect db;

	public DaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Order o) {
		Connection conn = db.getConnection();

		String sql = "insert into shop_order values(seq_shop_order.nextval, ?, ?, ?, ?, sysdate, ?, 0)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, o.getPro_num());
			pstmt.setInt(2, o.getOrder_num());
			pstmt.setInt(3, o.getTotal_price());
			pstmt.setString(4, o.getO_id());
			pstmt.setInt(5, o.getO_state());

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

	@Override
	public Order select(int num) {
		ResultSet rs = null;
		//Order o = null;
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "select * from shop_order where num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getInt(8));	
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

	@Override
	public ArrayList<Order> selectAll(String o_id, int o_state) {
		Connection conn = db.getConnection();
		ResultSet rs = null;
		ArrayList<Order> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		String sql = "select * from shop_order where o_id=? and o_state=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, o_id);
			pstmt.setInt(2, o_state);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getInt(8)));
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
		
		return list;
	}

	// TODO update, delete 따로 구현해보기
	
	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String type, int num) {
		// TODO Auto-generated method stub
		
	}
}

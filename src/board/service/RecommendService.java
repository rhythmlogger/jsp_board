package board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.model.Recommend;

public class RecommendService {
	public int setRecommend(int num, String id) {
		DBService dbService = new DBService();
		Connection connection = dbService.connect();
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			String sql = "INSERT INTO recommend(num, id ) VALUES ( ?, ? )";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbService.disconnect(connection);
		}
		return result;
	}

	public int delRecommend(int num, String id) {
		DBService dbService = new DBService();
		Connection connection = dbService.connect();
		PreparedStatement pstmt = null;
		int result = -1;
		try {
			String sql = "DELETE FROM recommend where num = ? and id = ?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbService.disconnect(connection);
		}
		return result;
	}

	public int getRecommendTotal(int num) {
		DBService dbService = new DBService();
		int count = 0;
		Connection connection = dbService.connect();
		PreparedStatement pstmt = null;
		try {
			String sql = "select count(*) from `recommend` where num=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbService.disconnect(connection);
		}

		return count;
	}

	public Recommend isRecommendById(int num, String id) {
		DBService dbService = new DBService();
		Connection connection = dbService.connect();
		PreparedStatement pstmt = null;
		try {
			String sql = "select num, id from recommend where num=? and id=?";
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				Recommend r = new Recommend();
				r.setNum(rs.getInt("num"));
				r.setId(rs.getString("id"));
				System.out.println(r.getNum());
				System.out.println(r.getId());
				return r;

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dbService.disconnect(connection);
		}

		return null;
	}
}

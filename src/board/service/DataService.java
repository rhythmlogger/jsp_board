package board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.model.Data;

public class DataService {
	public int count() {
		DBService dbService = new DBService();
		Connection conn = dbService.connect();
		String sql = "SELECT count(num) FROM data";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dbService.disconnect(conn);
		}
		return 0;
	}

	public int insert(Data data) {
		DBService dbService = new DBService();
		Connection conn = dbService.connect();
		String sql = "INSERT INTO data(`title`,`contents`,`id`) VALUES(?,?,?)";
		PreparedStatement pstmt = null;
		int r = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data.getTitle());
			pstmt.setString(2, data.getContents());
			pstmt.setString(3, data.getId());
			r = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dbService.disconnect(conn);
		}
		return r;
	}

	public List<Data> getList() {
		DBService dbService = new DBService();
		Connection conn = dbService.connect();
		String sql = "SELECT num,title,contents,id FROM data order by num desc";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			List<Data> list = new ArrayList<Data>();
			while (rs.next()) {
				Data data = new Data();
				data.setId(rs.getString("id"));
				data.setContents(rs.getString("contents"));
				data.setNum(rs.getInt("num"));
				data.setTitle(rs.getString("title"));
				list.add(data);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dbService.disconnect(conn);
		}
		return null;
	}

	public List<Data> getList(int start, int count) {
		DBService dbService = new DBService();
		Connection conn = dbService.connect();
		String sql = "SELECT num,title,contents,id FROM data  order by num desc limit ?, ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, count);
			ResultSet rs = pstmt.executeQuery();
			List<Data> list = new ArrayList<Data>();
			while (rs.next()) {
				Data data = new Data();
				data.setId(rs.getString("id"));
				data.setContents(rs.getString("contents"));
				data.setNum(rs.getInt("num"));
				data.setTitle(rs.getString("title"));
				list.add(data);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dbService.disconnect(conn);
		}
		return null;
	}

	public Data getData(int num) {
		DBService dbService = new DBService();
		Connection conn = dbService.connect();
		String sql = "SELECT num,title,contents,id FROM data where num=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			Data data = new Data();
			if (rs.next()) {
				data.setId(rs.getString("id"));
				data.setContents(rs.getString("contents"));
				data.setNum(rs.getInt("num"));
				data.setTitle(rs.getString("title"));
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dbService.disconnect(conn);
		}
		return null;
	}

	public int delete(int num) {
		DBService dbService = new DBService();
		Connection conn = dbService.connect();
		String sql = "DELETE from `data` where num=?";
		PreparedStatement pstmt = null;
		int r = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			r = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			dbService.disconnect(conn);
		}
		return r;

	}
}

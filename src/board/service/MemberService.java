package board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.model.Member;

public class MemberService {
	public int idCheck(String id) {
		DBService dbService = new DBService();
		Connection conn = dbService.connect();
		String sql = "SELECT distinct(id) FROM member where id=?";
		PreparedStatement pstmt = null;
		int r = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				rs.getString("id");
				return 1;
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
		return r;
	}

	public int register(Member member) {
		DBService dbService = new DBService();
		Connection conn = dbService.connect();
		String sql = "INSERT INTO member(`id`,`password`,`email`) VALUES(?,?,?)";
		PreparedStatement pstmt = null;
		int r = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getEmail());
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

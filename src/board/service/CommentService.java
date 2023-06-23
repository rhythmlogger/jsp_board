package board.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.model.Comment;

public class CommentService {
	public int delete(int cnum) {
		DBService dbService = new DBService();
		Connection conn = dbService.connect();
		String sql = "DELETE FROM `comment` WHERE cnum=?";
		PreparedStatement pstmt = null;
		int r = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cnum);
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
	public int insert(Comment comment) {
		DBService dbService = new DBService();
		Connection conn = dbService.connect();
		String sql = "INSERT INTO comment(`num`,`id`,`contents`) VALUES(?,?,?)";
		PreparedStatement pstmt = null;
		int r = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comment.getNum());
			pstmt.setString(2, comment.getId());
			pstmt.setString(3, comment.getContents());
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

	public List<Comment> getList(int num) {
		DBService dbService = new DBService();
		Connection conn = dbService.connect();
		String sql = "SELECT num,cnum, id, contents FROM comment where num=? order by cnum asc";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs = pstmt.executeQuery();
			List<Comment> list = new ArrayList<Comment>();
			while (rs.next()) {
				Comment comment = new Comment();
				comment.setNum(rs.getInt("num"));
				comment.setCnum(rs.getInt("cnum"));
				comment.setId(rs.getString("id"));
				comment.setContents(rs.getString("contents"));
				list.add(comment);
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
}

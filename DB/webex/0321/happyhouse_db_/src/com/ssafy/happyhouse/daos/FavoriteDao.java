package com.ssafy.happyhouse.daos;

import com.ssafy.happyhouse.dtos.FavoriteDto;
import com.ssafy.happyhouse.utils.DBClose;
import com.ssafy.happyhouse.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FavoriteDao {
	public ArrayList<FavoriteDto> selectAll(String userId) {
		ArrayList<FavoriteDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select s.gugun, f.dong from favorite as f inner join sidogu as s on (s.code = concat(f.regionCode, '00000')) where userId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				FavoriteDto favoriteDto = new FavoriteDto();
				favoriteDto.setGugun(rs.getString("gugun"));
				favoriteDto.setDong(rs.getString("dong"));

				list.add(favoriteDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public void insertFavorite(FavoriteDto favoriteDto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "insert into favorite " +
					"(regionCode, dong, userid)\r\n" +
					"values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, favoriteDto.getRegionCode());
			pstmt.setString(2, favoriteDto.getDong());
			pstmt.setString(3, favoriteDto.getUserId());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

package com.ssafy.happyhouse.daos;

import com.ssafy.happyhouse.dtos.AptDto;
import com.ssafy.happyhouse.utils.DBClose;
import com.ssafy.happyhouse.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AptDao {
	public AptDto selectAptById(String aptId, String dong) {
		AptDto aptDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * " +
					"from apttrades \n" +
					"where name = ? and dong = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aptId);
			pstmt.setString(2, dong);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				aptDto = new AptDto();
				aptDto.setPrice(rs.getInt("price"));
				aptDto.setDong(rs.getString("dong"));
				aptDto.setJibun(rs.getString("jibun"));
				aptDto.setAptName(rs.getString("aptName"));
				aptDto.setSize(rs.getInt("size"));
				aptDto.setYear(rs.getInt("year"));
				aptDto.setMonth(rs.getInt("month"));
				aptDto.setDay(rs.getInt("day"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return aptDto;
	}
	
	public ArrayList<AptDto> selectAptByDong(String dong) {
		ArrayList<AptDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from apttrades where dong = concat(' ', ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dong);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				AptDto aptDto = new AptDto();
				aptDto.setPrice(rs.getInt("price"));
				aptDto.setDong(rs.getString("dong"));
				aptDto.setJibun(rs.getString("jibun"));
				aptDto.setAptName(rs.getString("aptName"));
				aptDto.setSize(rs.getInt("size"));
				aptDto.setYear(rs.getInt("year"));
				aptDto.setMonth(rs.getInt("month"));
				aptDto.setDay(rs.getInt("day"));

				list.add(aptDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}
}
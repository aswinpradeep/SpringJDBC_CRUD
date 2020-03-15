package com.example.demo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.BUDao;
import com.example.demo.models.BU;
@Repository(value = "BUDao")

public class BUDaoImpl implements BUDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Object getBU() {
		// TODO Auto-generated method stub
		List<BU> buList = new ArrayList<>(); 
		try {
			buList = jdbcTemplate.query("select buid,buname,buhead from BU", new RowMapper<BU>() {
				public BU mapRow(ResultSet rs, int rowNum) throws SQLException {
					BU bu = new BU(); 
					bu.setBuid(rs.getInt("buid"));
					bu.setBuname(rs.getString("buname"));
					bu.setBuhead(rs.getString("buhead"));

					return bu;
				}
			});
		}catch(Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
		
		return buList;
		
		
	}
	public BU addBU(BU bu) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                    String[] returnValColumn = new String[] { "buid" };
                    PreparedStatement statement = con.prepareStatement("insert into BU values (?,?,?)", returnValColumn);
                    statement.setInt(1, bu.getBuid());
                    statement.setString(2, bu.getBuname());
                    statement.setString(3,bu.getBuhead());
                    return statement;
                }
            }, keyHolder);
            //Long id = keyHolder.getKey().longValue();
        } catch (Exception e) {
            System.out.println("Error while adding a new team : " + e.getMessage());
        }
        return bu; 
    }
	public void deleteBU(int buid) {
		
		Object[] params = { buid };

 
 
  int rows = jdbcTemplate.update("delete from BU where buid=?", params);
 
   
 
  System.out.println(rows + " row(s) deleted.");
		
	}
	@Override
	public void updateBU(int buid,String buhead) {
		
		System.out.println("_______________________p1="+buid);
		System.out.println("_______________________p2="+buhead);

		
		Object[] param1 = { buhead, buid };
		int[] types = {Types.VARCHAR,Types.BIGINT};
		//Object[] param2 = { buhead };
	

System.out.println("_______________________p1="+param1);
//System.out.println("_______________________p2="+param2);

 
 
  int rows = jdbcTemplate.update("update BU set buhead=? where buid=?", param1,types);
 
  System.out.println(rows + " row(s) updated.");
		
		
	}




}

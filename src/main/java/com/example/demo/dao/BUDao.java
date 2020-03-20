package com.example.demo.dao;

import com.example.demo.models.BU;

public interface BUDao {
	public Object getBU();
	public Object getJoin();
	public BU addBU(BU bu); 
	public void deleteBU(int buid);
	public void updateBU(int buid,String buhead); 
	public void add2(int buid,String buname,String buhead); 

}

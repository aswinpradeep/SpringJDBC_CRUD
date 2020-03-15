package com.example.demo.dao;

import com.example.demo.models.BU;

public interface BUDao {
	public Object getBU();
	public BU addBU(BU bu); 
	public void deleteBU(int buid);
	public void updateBU(int buid,String buhead); 
}

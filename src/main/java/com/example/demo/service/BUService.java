package com.example.demo.service;

import com.example.demo.models.BU;

public interface BUService {
	
	public Object getBU();
	public Object addBU(BU bu);
	public  void deleteBU(int buid);
	public void updateBU(int buid,String buhead);
	public Object getJoin();
	public void add2(int buid, String buname, String buhead);

}

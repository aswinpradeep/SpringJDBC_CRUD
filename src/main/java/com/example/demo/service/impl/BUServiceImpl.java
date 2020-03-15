package com.example.demo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.BU;
import com.example.demo.service.BUService;

@Service(value = "BUService")


public class BUServiceImpl implements BUService {
	@Autowired
	com.example.demo.dao.BUDao BUDao;

	public Object getBU() {
		// TODO Auto-generated method stub
		
		
		return BUDao.getBU();
	}

	public Object addBU(BU bu) {
        return BUDao.addBU(bu);
    }
	
	  public void deleteBU(int buid) {
	        BUDao.deleteBU(buid);

	     }

	@Override
	public void updateBU(int buid,String buhead) {
       BUDao.updateBU(buid,buhead);
	}


}

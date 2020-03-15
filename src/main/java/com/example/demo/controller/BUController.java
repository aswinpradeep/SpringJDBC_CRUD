package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.BU;
import com.example.demo.service.BUService;

@RestController
@RequestMapping(value = "/cxo")

public class BUController {
	
	@Autowired
	BUService buservice;
	
	@RequestMapping(value = "/getBU", method = RequestMethod.GET)
	
	public Object getBU() {
		
		return buservice.getBU();
		
	}
	@RequestMapping(value = "/addBU", method = RequestMethod.POST)
    public Object addBU(@RequestBody BU bu) {
        return buservice.addBU(bu);
    }
	
	@DeleteMapping(value = "/deleteBU")
	public void deleteBU(@RequestParam int buid){
		buservice.deleteBU(buid);
	}
	
	@RequestMapping(value = "/updateBU", method = RequestMethod.POST)
    public void updateBU(@RequestParam int buid,@RequestParam String buhead) {
		System.out.println("djhjhfjd---------------------"+buhead);
      buservice.updateBU(buid,buhead);
    }

}

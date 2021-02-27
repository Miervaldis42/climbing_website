package com.miervaldis42.climbingwebsite.helper;

// Imports
import java.util.List;
import com.miervaldis42.climbingwebsite.enums.Code;



public class ToastHandler {
	
	// Retrieve message according to code
	public String throwToastStatus(Code code) {
		List<Code> codes = Code.USER_CREATED.getAllCodes();
		String status = null;

		for(Code c : codes) {
			if(code.equals(c)) {
				status = c.getStatus() == true ? "success" : "error";
			}
		}
		
		return status;
	}

	// Retrieve message according to code
	public String throwToastMessage(Code code) {
		List<Code> codes = Code.USER_CREATED.getAllCodes();
		String msg = "";

		for(Code c : codes) {
			if(code.equals(c)) {
				msg = c.getMsg();
			}
		}
		
		return msg;
	}
	
}

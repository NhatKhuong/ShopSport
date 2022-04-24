package com.se.util;

import java.beans.PropertyEditorSupport;

import com.se.entity.DonHang;

public class DonHangPropertyEditorSupport extends PropertyEditorSupport{
	 @Override
	    public String getAsText() {
//	        ExoticType exoticType = (ExoticType) getValue();
//	        return exoticType == null ? "" : exoticType.getName();
		 System.out.println("Value get: "+ getValue());
		return "get return ";
	    }
	    
	    @Override
	    public void setAsText(String text) throws IllegalArgumentException {
//	        ExoticType exoticType = new ExoticType();
//	        exoticType.setName(text.toUpperCase());
	        DonHang donHang = new DonHang();
	        donHang.setMaDonHang("test");
	        System.out.println("Value set: "+text);
	        setValue(donHang);
	    }
	
}

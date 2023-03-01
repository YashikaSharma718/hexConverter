package com.wipro.velocity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class hexConverterTest {

	@Test
	void hexTest() {
		assertEquals(-1100,hexConverter(longToHex(-1100)));
		assertEquals(-10,hexConverter(longToHex(-10)));
		assertEquals(-1,hexConverter(longToHex(-1)));
		assertEquals(10,hexConverter(longToHex(10)));
		
	}
	public static  String longToHex(long value) {
		String hex="";
		if(value<0) {
			String bin= Long.toBinaryString(value);
			
			 for (int i = 0; i <= bin.length()-1; i+=4) { 
				 int fourBit=Integer.parseInt(bin.substring(i,i+4),2);
				 hex=hex+Integer.toHexString(fourBit);
			 }
			System.out.println(bin+"  "+bin.length()+"   hex="+hex);
			return hex;
		}
		System.out.println(Long.toBinaryString(value));
		return Long.toHexString(value);
	}
	public long hexConverter(String hex) {
		if(hex.length()==16) {
			hex=hex.substring(1);
		}
		long value=Long.parseLong(hex,16);
	
		String bin=Long.toBinaryString(value);
		String bin2=Long.toBinaryString(~value);
		System.out.println("value="+value+"  bin="+bin+" compl="+bin2);
		if(hex.startsWith("f")) {
			bin2=bin2.substring(bin2.length()-bin.length());
			value= (Long.parseLong(bin2,2)+1)*-1;
		}
		System.out.println("value="+value+"  bin="+bin+" compl="+bin2);
		return value;
	}
}

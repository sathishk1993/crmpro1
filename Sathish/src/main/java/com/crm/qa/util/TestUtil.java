package com.crm.qa.util;

import java.util.ArrayList;

import com.crm.qa.excel.util.Xlsx_Reader;

public class TestUtil {

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICT_WAIT = 10;
	public static Xlsx_Reader reader;
	
	public static ArrayList<Object[]> getDataFromExcelsheet()
	{
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try
		{
			 reader = new Xlsx_Reader(
				"C:\\eclipse\\Sathish\\src\\main\\java\\com\\crm\\qa\\testdata\\Crmpro data.xlsx");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		int rowCount= reader.getRowCount("login");
		for(int rowNum=2;rowNum<=rowCount;rowNum++) {

		String uname = reader.getCellData("login", "username", rowNum);
		String pass = reader.getCellData("login", "password", rowNum);
		Object ob[] = {uname,pass};
		myData.add(ob);
		
	}
		return myData;
	
	
}
}
package com.slokam.healthcaree.utils;

public class StringUtil {
public static boolean blankCheck(String name)
{
	boolean flag=false;
	if(name !=null && name.trim().length()>0)
	{
		flag=true;
	}
	return flag;
}
}

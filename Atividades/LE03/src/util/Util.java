package util;

public class Util 
{
	public static void print(String str)
	{
		System.out.println(str);
	}
	
	public static void print(String... strings)
	{
		for(String string : strings)
			System.out.println(string);
	}

} // class Util

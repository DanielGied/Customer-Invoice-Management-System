import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB
{
public static void main (String[] args)
{
	Connection conn = null;
	try {
		conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","danielg");
		
		if (conn!=null)
		{
			System.out.println("connection successfully to database");
			
		}
	}catch(Exception e)
	{
		System.out.println("not connected to database");
	}
	
}
}
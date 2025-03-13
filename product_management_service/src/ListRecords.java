import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ListRecords
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productmanagementdb", "root", "micql@5132");
			System.out.println("Connected...\n");
			System.out.println("____________________PRODUCT LISTING PANEL\n");

			Statement st = cn.createStatement();

			ResultSet rst = st.executeQuery("select * from productdetails");
			while(rst.next())
			{
				System.out.println("Product ID: " + rst.getInt(1));
				System.out.println("Product Name: " + rst.getString(2));
				System.out.println("Product Brand: " + rst.getString(3));
				System.out.println("Product Color: " + rst.getString(4));
				System.out.println("Product Price: " + rst.getInt(5));
				System.out.println("");
			}
			
			System.out.println("_________________________________\n");
			cn.close();
			System.out.println("Connection closed");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}

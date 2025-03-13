import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertRecord
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productmanagementdb", "root", "micql@5132");
			System.out.println("Connected...\n");
			System.out.println("____________________RECORD INSERTING PANEL\n");
			
			PreparedStatement ps = cn.prepareStatement("insert into productdetails values(?, ?, ?, ?, ?)");
			
			System.out.print("Enter product ID: ");
			int pid = Integer.parseInt(sc.nextLine());
			ps.setInt(1, pid);
			
			System.out.print("Enter product name: ");
			String name= sc.nextLine();
			ps.setString(2, name);
			
			System.out.print("Enter product brand: ");
			String brand= sc.nextLine();
			ps.setString(3, brand);
			
			System.out.print("Enter product color: ");
			String color= sc.nextLine();
			ps.setString(4, color);
			
			System.out.print("Enter product price: ");
			int price = Integer.parseInt(sc.nextLine());
			ps.setInt(5, price);
			
			ps.executeUpdate();
			
			System.out.println("\nRecord inserted...\n");
			
			System.out.println("_________________________________\n");
			sc.close();
			cn.close();
			System.out.println("Connection closed successfully!");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}

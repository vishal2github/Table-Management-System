import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateRecord
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productmanagementdb", "root", "micql@5132");
			System.out.println("Connected...\n");
			System.out.println("__________PRODUCT INFORMATION UPDATE PANEL__________\n");
			
			PreparedStatement ps = cn.prepareStatement("update productdetails set name=?, brand=?, color=?, price=? where pid=?");
			
			System.out.print("Enter product ID: ");
			int pid = Integer.parseInt(sc.nextLine());
			ps.setInt(5, pid);
			
			System.out.print("Enter product updated name: ");
			String name= sc.nextLine();
			ps.setString(1, name);
			
			System.out.print("Enter product updated brand: ");
			String brand= sc.nextLine();
			ps.setString(2, brand);
			
			System.out.print("Enter product updated color: ");
			String color= sc.nextLine();
			ps.setString(3, color);
			
			System.out.print("Enter product updated price: ");
			int price = Integer.parseInt(sc.nextLine());
			ps.setInt(4, price);
			
			ps.executeUpdate();
			
			System.out.println("\nRecord updated...");
			
			sc.close();
			cn.close();
			System.out.println("\nConnection closed...");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
}

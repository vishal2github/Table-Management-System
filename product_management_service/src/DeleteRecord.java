import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteRecord
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productmanagementdb", "root", "micql@5132");
			System.out.println("Connected...\n");
			System.out.println("____________________RECORD DELETION PANEL\n");
			
			PreparedStatement ps = cn.prepareStatement("delete from productdetails where pid=?");
			
			System.out.print("Enter product ID to be deleted: ");
			int pid = sc.nextInt();
			ps.setInt(1, pid);
			
			int n = ps.executeUpdate();
			if(n >= 1)
			{
				System.out.println("\nRecord deleted...");
			}
			else
			{
				System.out.println("\nNo record found!");
			}

			System.out.println("_________________________________\n");
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


import java.util.*;
public class Menu {




	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		System.out.print("This is a school management system");
		System.out.print("\n");
		System.out.println("Choose the action");
		System.out.println("1)Register student");
		System.out.println("2)Manage students");
		System.out.println("3)Hire teacher");
		System.out.println("4)Manage teacher");

		int adm=sc.nextInt();
		System.out.println("\n");
	

		if (adm==1) {
			System.out.print("In student Registeration, Enter the details ");
			String name=sc.next();
			int id=sc.nextInt();
			String adr=sc.next();
		}






	}

}

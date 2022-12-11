
import java.util.*;
public class Menu {




	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		boolean ismore =true; 
		int numOfStudent=0;

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



			ArrayList<String> name = new ArrayList<>();
			ArrayList<Integer> id = new ArrayList<>();
			ArrayList<String> address = new ArrayList<>();
			System.out.println("In student Registeration, Enter the details of student");

			while(ismore ==true) {
				System.out.println("name of student :" );
				name.add(sc.next());
				System.out.println(name.get(numOfStudent));
				System.out.println("Id of student :" );
				id.add(sc.nextInt());
				System.out.println(id.get(numOfStudent));
				System.out.println("Address of student :" );
				address.add(sc.next());
				System.out.println(address.get(numOfStudent));

				System.out.println("Add next student (press 1)");
				System.out.println("Finish (press 0) ");

				if (sc.nextInt() == 1) {
					System.out.println("Enter the details of next student");
					ismore =true;
					numOfStudent++;}
				else {
					ismore=false;
					System.out.println("The total number of students you have enrolled is "+ (numOfStudent+1)+ "and they are shown below");

					for (int t=0;t<=numOfStudent; t++) {
						System.out.println(name.get(t));

					}

				}
			}
		}


	}






}



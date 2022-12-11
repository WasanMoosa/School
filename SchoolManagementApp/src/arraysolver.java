
import java.util.*;
import java.util.PrimitiveIterator.OfDouble;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;
public class arraysolver {


	public static void main(String[] args) {
		boolean ismore =true; 
		int numOfStudent=0;
		Scanner sc=new Scanner(System.in);


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
				System.out.println("The total number of students you have enrolled is "+ (numOfStudent+1)+ "And they are shown below");

				for (int t=0;t<=numOfStudent; t++) {
					System.out.println(name.get(t));

				}

			}
		}
	}



}


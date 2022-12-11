import java.io.ObjectInputStream.GetField;

public class loopprac {


	public static void main(String[] args) {
		//////////////////////////////////////////
		for (int i=0; i<4; i++) {
			System.out.println("* * * *");
		}

		System.out.print("\n");
		//////////////////////////////////////////
		for (int w=1; w<=5; w++) {
			System.out.print("\n");

			for (int r=1; r<=w; r++) {

				System.out.print("*");

			}
			System.out.print("\n");
		}
		//////////////////////////////////////////	
		for (int u=1; u<=5; u++) {
			System.out.print("\n");

			for (int r=1; r<=u; r++) {

				System.out.print(r);
				System.out.print(" ");


			}
		}
		System.out.print("\n");

		//////////////////////////////////////////

		int u=4;
		for (int w=1; w<=5; w++) {
			System.out.print("\n");


			for (int o=u; o>=0; o--) {

				System.out.print(" ");

			}
			u--;
			for (int r=1; r<=w; r++) {



				System.out.print("* ");

				
				


			}
			
				}
		System.out.print("\n");
/////////////////////////////////////////
		
		int r;
		int y=0;
		for (int s=1; s<=6; s++) {
			System.out.print("\n");

			for ( r=1; r<=s; r++) {
				System.out.print(r);
				System.out.print(" ");
				y=r;
				
			}
			int p=1;
		
			for ( ;y>=2; y--) {
				
				System.out.print(y-1);
				System.out.print(" ");
				
				
			}
			
			
			
		}
		
////////////////////////////////////
		System.out.print("\n");
		System.out.print("\n");
		int q=1;
		int c=10;
		for (int l=1; l<5; l++) {
			for (int t=1; t<l; t++) {
			c=c*c;	
			}
			
				
			System.out.print(c);
			System.out.print("\n");
		
			q=q+10;
			System.out.print("\n");	
			
	}

}}

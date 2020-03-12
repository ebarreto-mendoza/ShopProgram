import java.util.Scanner;
public class ShopProgram {
	
	public static int intro(Scanner input) {
		System.out.println("This program supports 4 functions: ");
		System.out.println("\t1. Setup Shop ");
		System.out.println("\t2. Buy Items ");
		System.out.println("\t3. List Items ");
		System.out.println("\t4. Checkout  ");
		System.out.print("Please choose the function you want: ");
		return input.nextInt();
	}
	
	//in case shop hasn't been setup and checks to make sure input is between 1-4
	public static int checkFunc(int function, Scanner input) {
		function = intro(input);
		while(function != 1) {
			System.out.println("\nShop is not set up yet!\n");
			function = intro(input);
		}
		return function;
	}
	
	
	
	public static void setupShop(){
		System.out.println("Setting up shop...");
	}
	
	public static void buyItems() {
		System.out.println("But these items...");
	}
	
	public static void listItems(){
		System.out.println("Listing these items...");
	}
	
	public static void checkout(){
		System.out.println("Checking out...");
	}

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int function = 0;
		
		function = checkFunc(function, input);
		
		switch(function) {
		case 1:
			setupShop();
			break;
		case 2:
			buyItems();
			break;
		case 3:
			listItems();
			break;
		case 4:
			checkout();
			break;
		}

	}

}

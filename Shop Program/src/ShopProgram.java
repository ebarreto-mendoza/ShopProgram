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
		while(function != 1) {
			System.out.println("\nShop is not set up yet!\n");
			function = intro(input);
		}
		return function;
	}
	
	public static String numSuffix(int i) {
		int rem = i % 10;
		switch (rem) {
		case 0:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			return (i + "th");
		case 1:
			if (i % 100 != 11)
				return (i + "st");
			else
				return (i + "th");
		case 2:
			if ( i % 100 != 12)
				return (i + "nd");
			else
				return (i +"th");
		case 3:
			if (i % 100 != 13)
				return (i +"rd");
			else
				return ( i + "th");
		default:
			break;
		}
		return "";
	}
	
	public static void setupShop(){
		System.out.print("Please enter the number of items to setup shop:");
		System.out.println();
		
		for(int i = 1; i <= 3; i++) { //FIXME
			System.out.print("Enter the name of the " + numSuffix(i) + " product: ");
			System.out.println("Enter the number of packages ('x') to qualify for Special Discount (buy 'x' get 1 free)");
			System.out.println("for alpha, or 0 if no Special Discount offered: ");
		}
		
		System.out.println("Enter the dollar amount to qualify for Additional Discount ( or 0 if none offered): ");
		do {
		System.out.println("Enter the Additional Discount rate (e.g., 0.1 for 10%: ");
		//if (___ < 0 || ___ > 0.5)
			//System.out.print("Invalid input. Enter a value > 0 and <= 0.5: );
		}while (1 < 0 || 0.4 > 0.5); //FIXME
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
		int function = intro(input);
		
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

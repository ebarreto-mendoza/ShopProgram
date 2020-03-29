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
	
	
	public static void setupShop(String [] name, double [] price, int [] discount, Scanner input) {
		
		System.out.println();
		
		for(int i = 1; i < name.length; i++) {
			System.out.print("Enter the name of the " + numSuffix(i) + " product: ");
			name[i] = input.next();
			System.out.print("Enter the per package price of " + name[i] + ": ");
			price[i] = input.nextDouble();
			System.out.println("Enter the number of packages ('x') to qualify for Special Discount (buy 'x' get 1 free)");
			System.out.print("for alpha, or 0 if no Special Discount offered: ");
			discount[i] = input.nextInt();
			
		}
		
		System.out.println("Enter the dollar amount to qualify for Additional Discount ( or 0 if none offered): ");
		double addDisc1 = input.nextDouble();
		double adddisc = 0;
		if (addDisc1 != 0 && addDisc1 > 0) {
			System.out.print("Enter the Additional Discount rate (e.g., 0.1 for 10%): ");
			adddisc = input.nextDouble(); // FIXME
			while ( adddisc > 0.5 || 0 > adddisc) {
				System.out.print("Invalid input. Enter a value > 0 and <= 0.5: ");
				adddisc = input.nextDouble(); //FIXME
			}
		}
		
		System.out.println();
		
	}
	
	public static void buyItems(String [] name, double [] amount, Scanner input) {
		System.out.println();
		for (int i = 1; i < name.length; i++) {
			System.out.print("Enter the number of " + name[i] +" packages to buy: ");
			amount[i] = input.nextDouble();
		}
		System.out.println();
		
	}
	
	public static double listItems (String [] name,double [] price, double [] amount, Scanner input){
		System.out.println();
		
		double subTotal = 0;
		for (int i = 1; i < name.length; i++) {
			if (amount [i] > 0) {
			System.out.println(amount[i] + " packages of " + name[i] + " @ $" + price[i] + " per pkg = $" + amount[i] * price[i] ); //Might have to do printf
			subTotal += amount[i] * price[i];
			}	
		}
		System.out.println();
		
		return subTotal;
	}
	
	public static void checkout(double subTotal){
		System.out.println();
		System.out.println("Original Sub Total:\t\t\t  $" + subTotal);
		System.out.println("Special Discounts:\t\t\t -$");
		//subTotal = ;
		System.out.println("New Sub Total:\t\t\t  $" + subTotal);
		System.out.println("Additional 20% Discount:\t\t -$");
		//subTotal = ;
		System.out.println("Final Sub Total:\t\t\t  $" + subTotal);
		
		System.out.println();
	}
	
	public static void run() {
		Scanner input = new Scanner (System.in);
		String [] name;
		double [] price;
		int [] discount;
		double [] amount;
		int function = intro(input);
		
		while (function != 1 || function <= 0 || function > 5) {
			System.out.println("\nShop is not set up yet!\n");
			function = intro(input);
		}
		
		System.out.print("Please enter the number of items to setup shop:");
		int num = input.nextInt();
		name = new String [num + 1];
		price = new double [num + 1];
		discount = new int [num + 1];
		setupShop(name, price, discount, input);
		
		function = intro(input);
		
		while (function != 2 || function <= 0 || function > 5) {
			if (function == 1) {
				System.out.print("Please enter the number of items to setup shop:");
				num = input.nextInt();
				name = new String [num + 1];
				price = new double [num + 1];
				discount = new int [num + 1];
				setupShop(name, price, discount, input);
				function = intro(input);
			}
			else {
				System.out.println("\nYou have not bought anything!\n");
				function = intro(input); 
			}  
		}
		
		amount = new double [name.length];
		buyItems(name, amount, input);
		function = intro(input);
		
		while (function != 3 || function <= 0 || function > 5) {
			if (function == 1) {
				System.out.print("Please enter the number of items to setup shop:");
				num = input.nextInt();
				name = new String [num + 1];
				price = new double [num + 1];
				discount = new int [num + 1];
				setupShop(name, price, discount, input);
				function = intro(input);
			}
			else if (function == 2) {
				buyItems(name, amount, input);
				function = intro(input); 
			}  
			else 
				function = intro(input);
		}
		
		double subTotal = listItems(name, price, amount, input);
		function = intro(input);  
		
		while (function != 4 || function <= 0 || function > 5) {
			if (function == 1) {
				System.out.print("Please enter the number of items to setup shop:");
				num = input.nextInt();
				name = new String [num + 1];
				price = new double [num + 1];
				discount = new int [num + 1];
				setupShop(name, price, discount, input);
				function = intro(input);
			}
			else if (function == 2) {
				buyItems(name, amount, input);
				function = intro(input); 
			}  
			else if (function == 3) {
				listItems(name, price, amount, input);
				function = intro(input);  
			}
			else
				function = intro(input);
		}
		
		checkout(subTotal);
		
		System.out.println("Thanks for coming!");
		
		System.out.println();
		System.out.print("Would you like to re-run? (1 for yes, 0 for no): ");
		int redo = input.nextInt();

		System.out.println();

		if (redo == 1)
			run();
	}
	

	public static void main(String[] args) {
		run();
	}

}

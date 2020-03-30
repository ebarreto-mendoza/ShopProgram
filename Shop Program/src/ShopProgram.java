import java.util.Scanner;//this time
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
	
	
	public static void setupShop(String [] name, double [] price, int [] discount, double [] addDisc, Scanner input) {
		
		System.out.println();
		
		for(int i = 1; i < name.length; i++) {
			System.out.print("Enter the name of the " + numSuffix(i) + " product: ");
			name[i] = input.next();
			System.out.print("Enter the per package price of " + name[i] + ": ");
			price[i] = input.nextDouble();
			System.out.println("Enter the number of packages ('x') to qualify for Special Discount (buy 'x' get 1 free)");
			System.out.print("for " + name[i] + " , or 0 if no Special Discount offered: ");
			discount[i] = input.nextInt();
			
		}
		
		System.out.println();
		System.out.print("Enter the dollar amount to qualify for Additional Discount ( or 0 if none offered): ");
		addDisc[0] = input.nextInt();
		addDisc[1] = 0;
		if (addDisc[0] != 0 && addDisc[0] > 0) {
			System.out.print("Enter the Additional Discount rate (e.g., 0.1 for 10%): ");
			addDisc[1] = input.nextDouble(); 
			while ( addDisc[1] > 0.5 || 0 > addDisc[1]) {
				System.out.print("Invalid input. Enter a value > 0 and <= 0.5: ");
				addDisc[1] = input.nextDouble(); 
			}
		}
		System.out.println();
		
	}
	
	public static void buyItems(String [] name, int [] amount, Scanner input) {
		System.out.println();
		for (int i = 1; i < name.length; i++) {
			System.out.print("Enter the number of " + name[i] +" packages to buy: ");
			amount[i] = input.nextInt();
			while (amount[i] < 0) {
				System.out.print("Invalid input. Enter a value >= 0: ");
				amount[i] = input.nextInt();
			}
		}
		System.out.println();
		
	}
	
	public static void listItems (String [] name,double [] price, int [] amount, Scanner input){
		System.out.println();
		int counter = 0;
		
		for (int i = 1; i < name.length; i++) {
			if(amount[i] > 0)
				counter++;
		}
		
		if (counter == 0) {
			System.out.print("No items were purchased.");
			System.out.println();
		}
		else {
			for (int i = 1; i < name.length; i++) {
				if (amount[i] > 0) {
					System.out.printf("%d packages of %s @ $%.2f per pkg = $%.2f\n",amount[i], name[i], price[i], amount[i] * price[i] );
				}	
			}
		}
		System.out.println();
	}
	
	public static void checkout(double subTotal, int [] discount, int [] amount, double [] price, double [] addDisc){
		double dis = 0.00;
		for (int i = 1; i < discount.length; i++) {
			if(discount[i] > 0) { 
				if(amount[i] >= discount[i]) {
					int x = (amount[i] / (discount[i] + 1));
					dis += x * price[i];
				}
			}
			
		}
		
		for (int i = 1; i < discount.length; i++) {
			if (amount[i] > 0) {
				subTotal += amount[i] * price[i];
			}	
		}
		
		System.out.println();
		System.out.printf("Original Sub Total:\t\t  $%.2f\n", subTotal);
		
		if(dis == 0)
			System.out.println("No Special Discounts applied");
		else {
			System.out.printf("Special Discounts:\t\t -$%.2f\n", dis);
			subTotal = subTotal - dis ;
		}
		
		System.out.printf("New Sub Total:\t\t\t  $%.2f\n", subTotal);
		
		if(addDisc[0] != 0) {
			if(subTotal >= addDisc[0]) {
				System.out.printf("Additional %d%% Discount:\t -$%.2f\n",(int)(addDisc[1] * 100), (subTotal * addDisc[1]));
				subTotal = subTotal - (subTotal * addDisc[1]) ;
			}
		}
		else
			System.out.println("You did not qualify for an Additional Discount");
		
		System.out.printf("Final Sub Total:\t\t  $%.2f",subTotal);
		
		System.out.println();
	}
	
	public static void run() {
		Scanner input = new Scanner (System.in);
		String [] name;
		double [] price;
		int [] discount;
		int [] amount;
		double [] addDisc = new double[2];
		double subTotal = 0;
		int function = intro(input);
		
		while (function != 1 || function <= 0 || function > 5) {
			System.out.println("\nShop is not set up yet!\n");
			function = intro(input);
		}
		
		System.out.print("Please enter the number of items to setup shop: ");
		int num = input.nextInt();
		name = new String [num + 1];
		price = new double [num + 1];
		discount = new int [num + 1];
		amount = new int [num + 1];
		setupShop(name, price, discount, addDisc, input);
		
		function = intro(input);
		
		while (function != 2 || function <= 0 || function > 5) {
			if (function == 1) {
				System.out.print("Please enter the number of items to setup shop: ");
				num = input.nextInt();
				name = new String [num + 1];
				price = new double [num + 1];
				discount = new int [num + 1];
				amount = new int [num + 1];
				setupShop(name, price, discount, addDisc, input);
				function = intro(input);
			}
			else {
				System.out.println("\nYou have not bought anything!\n");
				function = intro(input); 
			}  
		}
		
		buyItems(name, amount, input);
		function = intro(input);
		
		while (function != 3 || function <= 0 || function > 5) {
			if (function == 0)
				function = intro(input);
			else if (function == 1) {
				System.out.print("Please enter the number of items to setup shop: ");
				num = input.nextInt();
				name = new String [num + 1];
				price = new double [num + 1];
				discount = new int [num + 1];
				amount = new int [num + 1];
				setupShop(name, price, discount, addDisc, input);
				function = intro(input);
			}
			else if (function == 2) {
				buyItems(name, amount, input);
				function = intro(input); 
			}  
			else
				break;
				
		}
		
		if(function != 4) {
			listItems(name, price, amount, input);
			function = intro(input);  
		}
		
		while (function != 4 || function <= 0 || function > 5) {
			if (function == 1) {
				System.out.print("Please enter the number of items to setup shop: ");
				num = input.nextInt();
				name = new String [num + 1];
				price = new double [num + 1];
				discount = new int [num + 1];
				amount = new int [num + 1];
				setupShop(name, price, discount, addDisc, input);
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
		
		checkout(subTotal, discount, amount, price, addDisc);
		
		System.out.println();
		System.out.println("Thanks for coming!");
		
		System.out.println();
		System.out.println("--------------------------------------------------");
		System.out.print("Would you like to re-run? (1 for yes, 0 for no): ");
		int redo = input.nextInt();
		System.out.println("--------------------------------------------------");

		System.out.println();

		if (redo == 1)
			run();
	}
	

	public static void main(String[] args) {
		run();
	}

}

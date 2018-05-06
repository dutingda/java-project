//Tingda Du
//Feb 19th
//Description: a program that enters the name, price and quantity on hand for one or more products. 
//For each product, program display the inputted information as well as the total value of each product(quantity x price).
//After all of the product information has been inputted, program display the total value of all the products entered, as
//well as the product with the highest total value - display both the name of the product and its value. 
import java.util.*;
public class InputOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		double price = 0, totalPrice, totalValue = 0, highest = 0;
		String name = "", highestValueName = "";		
		char c='y';		
		String s="";
		boolean check=false;
		Scanner in = new Scanner(System.in);
		System.out.println("Inventory Management Program");
		System.out.println();
		while(c == 'y' || c == 'Y'){
			//ask for the name of product
			System.out.print("Please enter the name of the next product:  ");
			name = in.nextLine().trim();
			//ask for the price of the product
			do{
				try{
					System.out.print("Please enter the unit price for " + name + ": ");
					price = Double.parseDouble(in.nextLine().trim());
					if(price <= 0){
						throw new NumberFormatException();
					}
					check=true;
					}
					catch(NumberFormatException e){
					System.out.println("The price is invalid. Enter a number that is greater than 0.");
					check=false;
				}
			}while(check==false);
			//the number of product
			do{
				try{
					System.out.print("How many "+name+" do you have on hand?:  ");
					num = Integer.parseInt(in.nextLine().trim());
					check=false;
					if(num <= 0 || num%1!=0){
						throw new NumberFormatException();
					}
				}
				catch(NumberFormatException e){
					System.out.println("Invalid unit number! Unit must be an integer that is greater than 0.");
					check=true;
				}
			}while(check==true);
			//work out the total price for one product
			totalPrice = Math.round(price * num * 100)/100.0;
			System.out.println("You have " + num + " " + name + " @ $" + price + 
					" for a total value of: $" + totalPrice);
			//calculate the total value of all products
			totalValue += totalPrice;
			//ask for more product
			do{
				try{
				System.out.print("Do you have any more product? (y/n):  ");
				s=in.nextLine();
				c = s.trim().charAt(0);
				if((c!='y'&&c!='Y'&&c!='n'&&c!='N')||s.length()!=1){
					throw new StringIndexOutOfBoundsException();
				}
				check=true;
				}
				catch(StringIndexOutOfBoundsException e){
					System.out.println("No such command! Enter y or n!!");
					check=false;
				}
			}while(check==false);
			//to update the highest record
			if(totalPrice > highest){
				highest = totalPrice;
				highestValueName = name;
			}
			System.out.println();
		}

		System.out.println("The total value of all the inventory is:  " + totalValue);
		System.out.println("The item with the highest value is $" + highest + 
				" for " + highestValueName +".");
		System.out.println("Thank you for using the Inventory Management Program.");
		in.close();
		}
	}



package Brainwave_matrix;

import java.util.ArrayList;
import java.util.Scanner;

public class ATMInterface {

    static int default_pin = 1234;
    static double balance = 10000.00;
    int attempta = 3;

    ArrayList<Integer> amount = new ArrayList<Integer>();
   static  ArrayList<String> tran_hist = new ArrayList<String>();
   


         static void checkBalance(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Pin for Check Balance :");
        int atmPin = sc.nextInt();
        if (default_pin == atmPin) {
            System.out.println("Pin Verified..");

            System.out.println("Current Balance : "+ balance);
        }
        else{
            System.out.println("Wrong Password ");
        }
    }
    
    public static void depositMoney(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Amount to Deposit :");
        double depositAmt = sc.nextDouble();
        System.out.print("Enter Pin for Deposit Amount :");
        int atmPin = sc.nextInt();

        if (default_pin == atmPin) {
            System.out.println("Pin Verified..");
            balance += depositAmt;
            tran_hist.add("Credit " + String.valueOf(depositAmt)); 
            System.out.println("You want to check balance?(Y/N):");
            String ans = sc.next();
            if(ans.equals("Y"))
            {
                 checkBalance();
            }
            else{
                System.out.println("Thank you Have a Nice Day!!");
            }
        }
        else{
            System.out.println("Wrong Password ");
        }

    }
  public static void withdrawMoney(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Amount to Withdraw :");
        double withdrawAmt = sc.nextDouble();
        System.out.print("Enter Pin for Withdraw Amount :");
        int atmPin = sc.nextInt();

        if (default_pin == atmPin) {
            System.out.println("Pin Verified..");
            balance -= withdrawAmt;
             
              tran_hist.add("Debit " + String.valueOf(withdrawAmt));
            System.out.println("You want to check balance? (Y/N) :");
            String ans = sc.next();
            if(ans.equals("Y"))
            {
                 checkBalance();
            }
            else{
                System.out.println("Thank you Have a Nice Day!!");
            }
        }
        else{
            System.out.println("Wrong Password ");
        }

    }
    public static void showTransactionHistory(){
        
        for(int i= 0; i<tran_hist.size();i++){
          
            System.out.println(tran_hist.get(i));
        }
    }
    public static void main(String[] args) {
    	System.out.println("    WELCOME TO THE ATM    ");
    	
    	while(true){
        Scanner sc =new Scanner(System.in);
        System.out.println("\n  ***** ATM Menu *****	");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transaction History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                depositMoney();
                break;
            case 3:
                withdrawMoney();
                break;
            case 4:
                showTransactionHistory();
                break;
            case 5: 
            	 System.out.println("Thank you for using the ATM. Goodbye!");
                break;
            default:
                break;
        }
        }
    }
    
}

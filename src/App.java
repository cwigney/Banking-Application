import java.util.Scanner;
/*  This was my attempt at this application. A popular one on the Internet. Got the specifications and coded it
    myself and then compared it to what someone else had done. From the main menu they just called a method
    from their account class called showMenu. All other code was in the account class. This saved on declaring
    balance, deposit and float. It also saved on declaring all the set and get methods for the class.

    Should be noted mine worked as required. 

 */
public class App {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Scanner input = new Scanner(System.in);

        System.out.println("Enter name: ");
        String userName = input.nextLine();
        account.setName(userName);

        System.out.println("Enter account no: ");
        int accountId = input.nextInt();
        account.setId(accountId);

        // Menu for user to select from
        StringBuilder sb = new StringBuilder();
        sb.append("1.\tBalance:\n").append("2.\tWithdraw:\n").append("3.\tDeposit:\n").append("4.\tExit:\n");

        int userChoice;
        do {
            System.out.println(sb.toString());

            // Retrieve menu choice from User

            System.out.print("Enter number to select action: ");
            userChoice = input.nextInt();

            float balance,deposit,withdraw;

            switch (userChoice) {

                case 1:
                    System.out.println(account.getBalance());
                    break;
                case 2:
                    System.out.println("Enter the amount you wish to withdraw $$.cc: ");
                    withdraw = input.nextFloat();
                    balance = account.getBalance();

                    if (withdraw > balance){
                        System.out.printf("You only have %.2f: \n",balance);
                    }
                    else {
                       balance = account.getBalance() - withdraw;
                       account.setBalance(balance);
                    }
                    break;
                case 3:
                    System.out.println("Enter the amount you wish to deposit $$.cc: ");
                    deposit = input.nextFloat();
                    balance = deposit + account.getBalance();
                    account.setBalance(balance);

                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid Selection");
            }


        }
        while (userChoice != 4);
    }

}

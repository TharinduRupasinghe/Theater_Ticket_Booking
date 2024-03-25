//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID:[IIT:- 20221476],[UoW:- w1956171]
//Date: 22/03/2023

import java.io.*;                               //Importing all the classes of java Input-output package
import java.util.ArrayList;                     //Importing ArrayList class in java util package
import java.util.InputMismatchException;        //Importing Input Mismatch Exception in java util package
import java.util.Scanner;                       //Importing Scanner class in java util package
public class Theater {                          //Creating a public class named 'Theater'
    static int [] seatRow_1 = new int[12];      //Opening an integer array to save data of 1st row
    static int [] seatRow_2 = new int[16];      //Opening an integer array to save data of 2nd row
    static int [] seatRow_3 = new int[20];      //Opening an integer array to save data of 3rd row
    static boolean loop_buying;                 //Defining a boolean variable to loop buy_ticket method
    static boolean loop_cancelling;             //Defining a boolean variable to loop cancel_ticket method
    static int rowNum;                          //Defining an integer variable for row number input
    static int seatNum;                         //Defining an integer variable for seat number input
    static int ticketPrice = 0;                 //Defining an integer variable to set the ticket prices for each row
    static int totalPrice=0;                    //Defining an integer variable for to calculate the total of all tickets
    static Scanner input = new Scanner(System.in);                  //Calling the Scanner class using an object named 'input'
    static ArrayList<Ticket> listOfTickets = new ArrayList<>();     //Opening a Ticket Array List to store all the ticket objects

    public static void main(String[] args) {    //Creating the main method of the program
        System.out.println("                      ♕♕♕ Welcome to the New Theatre ♕♕♕");

        boolean loop_menu  = true;              //Defining a boolean variable for looping option selection
        while (loop_menu ){                     //Using an infinite while loop until the user inputs an available option
           System.out.println("-----------------------------------------------------------------------------------");
           System.out.println(">>> M E N U <<<\n");
           System.out.println("~~~Please Select an Option~~~");
           System.out.println("[1] Buy a ticket");
           System.out.println("[2] Print seating area ");
           System.out.println("[3] Cancel ticket ");
           System.out.println("[4] List available seats");
           System.out.println("[5] Save to file ");
           System.out.println("[6] Load from file ");
           System.out.println("[7] Print ticket information and total price");
           System.out.println("[8] Sort tickets by price");
           System.out.println("[0] Quit");
           System.out.println("-----------------------------------------------------------------------------------");

           try {                                            //Using a try-catch method to validate user inputs
               System.out.print("➤Enter Your Option: ");
               int optionSelect = input.nextInt();          //Using Scanner class object to take option input
               System.out.println("-----------------------------------------------------------------------------------");

               switch (optionSelect) {                      //USing a switch method to combine required methods with each option
                   case 1 -> buy_ticket();
                   case 2 -> print_seating_area();                          //......................................................
                   case 3 -> cancel_ticket();                               //......................................................
                   case 4 -> show_available();                              //......................................................
                   case 5 -> save();                                        //......................................................
                   case 6 -> load();                                        //...Calling required methods relevant to each option...
                   case 7 -> show_tickets_info();                           //......................................................
                   case 8 -> sort_tickets();                                //......................................................
                   case 0 -> {                                              //......................................................
                       System.out.println("Thank-you...Have a nice day ☺");
                       loop_menu  = false;                                  //Closing the loop when option is '0' to exit the program
                   }
                   default -> System.out.println("Out of available options!");
               }
           }
           catch (InputMismatchException e){               //Catching and displaying invalid data type inputs
               System.out.println("-----------------------------------------------------------------------------------");
               System.out.println("You entered an invalid option!");
               input.next();                               //Continuing the loop after catching the exception
           }
        }
    }
    static void buy_ticket() {                             //Creating the buy_ticket method
        //Using a multiline print statement to print the tickets price list
        System.out.println("""
                T̰ḭc̰k̰ḛt̰ ̰P̰r̰ḭc̰ḛ ̰L̰ḭs̰t̰
                
                ✦1st Row --> 10£
                ✦2nd Row --> 20£
                ✦3rd Row --> 30£
                -----------------------------------------------------------------------------------""");
        System.out.print("↘ Please enter your Name: ");
        input.nextLine();                                          //Using Scanner class object to take username input
        String Name = input.nextLine();
        System.out.print("↘ Please enter your Surname: ");
        String SurName = input.nextLine();                         //Using Scanner class object to take user surname input
        System.out.print("↘ Please enter your Email address: ");
        String Email = input.nextLine();                           //Using Scanner class object to take user email input
        System.out.println("-----------------------------------------------------------------------------------");
        Person person = new Person(Name,SurName,Email);   //Creating a new person object and passing related attributes  as parameters

        loop_buying = true;
        while (loop_buying){                                //Using an infinite while loop until the user inputs a valid row number and seat number
            try {                                           //Using a try-catch method to validate user inputs
                System.out.print("★ Enter a row number: ");
                rowNum = input.nextInt();                    //Using Scanner class object to take row number input

                if (rowNum > 0 && rowNum < 4) {                  //Using an if condition to check weather the user input is in the range of row numbers
                    System.out.print("★ Enter a seat number: ");
                    seatNum = input.nextInt();                   //Using Scanner class object to take seat number input

                    switch (rowNum) {                     //USing a switch method to combine my own method for each row number input
                        case 1 -> validation_for_buying(13,seatRow_1,10);//.....................................................................
                        case 2 -> validation_for_buying(17,seatRow_2,20);//...Calling my own method related to buy_ticket method for each row...
                        case 3 -> validation_for_buying(21,seatRow_3,30);//.....................................................................
                    }
                }
                else {                                        //Displaying an error message for out of range row number inputs
                    System.out.println("Invalid row number!");
                    System.out.println("-----------------------------------------------------------------------------------");
                    loop_buying =true;                       //Continuing the loop for next iteration
                }
            }
            catch (Exception e) {                          //Catching and displaying invalid data type inputs
                System.out.println("Invalid Input!");
                System.out.println("-----------------------------------------------------------------------------------");
                input.next();                                //Continuing the loop after catching the exception
            }
        }
        Ticket ticket = new Ticket(rowNum, seatNum,ticketPrice,person);  //Creating a new ticket object and passing related attributes as parameters
        listOfTickets.add(ticket);                           //Using add method tho add ticket objects into Array List
    }
    static void validation_for_buying(int rowBoundary, int[]rows, int prices){   //Creating my own method related to buy_ticket method
        if (seatNum > 0 && seatNum < rowBoundary) {          //Using an if condition to check weather the user input is in the range of seat numbers
            if (rows[seatNum - 1] == 0) {                    //Using an if condition to check weather the value of seat index is '0'
                rows[seatNum - 1] = 1;                       //Setting seat index value to '1'

                ticketPrice = prices;                        //Assigning a variable to set ticket prices for each row
                totalPrice+=ticketPrice;                     //Adding ticket price to the total price

                System.out.println("\nBuy ticket process successful...");
                loop_buying =false;                          //Closing the loop and goes back to menu option selection
            }
            else {                                         //Displaying that the seat is already booked
                System.out.println("SORRY! This seat is not available");
                System.out.println("-----------------------------------------------------------------------------------");
                loop_buying =true;                           //Continuing the loop for next iteration
            }
        }
        else {                                             //Displaying an error message for out of range seat number inputs
            System.out.println("Invalid seat number!");
            System.out.println("-----------------------------------------------------------------------------------");
            loop_buying =true;                               //Continuing the loop for next iteration
        }
    }
    static void print_seating_area(){                      //Creating the print_seating_area method
        System.out.print("    *************\n    * S T A G E *\n    *************\n");
        //Calling my own method related to print_seating_area method for each row...
        System.out.print("    ");
        rowDivision(0,6,seatRow_1);
        System.out.print(" ");
        rowDivision(6,12,seatRow_1);

        System.out.print("\n  ");
        rowDivision(0,8,seatRow_2);
        System.out.print(" ");
        rowDivision(8,16,seatRow_2);

        System.out.println();
        rowDivision(0,10,seatRow_3);
        System.out.print(" ");
        rowDivision(10,20,seatRow_3);
        System.out.println();
    }
    static void rowDivision(int  start_index,int div_index,int[] rows){  //Creating my own method related to print_seating_area method
        for (int i=start_index;i<div_index;i++){                         //Using a for loop to iterate through seat indexes in each row
            if (rows[i]==0){                                    //Using an if condition to check weather the value of seat index is '0'
                System.out.print("o");                          //Displaying 'o' character for every value '0' indexes
            }
            else {
                System.out.print("x");                          //Displaying 'x' character for every value '1' indexes
            }
        }
    }
    static void cancel_ticket(){                                    //Creating the cancel ticket method
        loop_cancelling = true;
        while (loop_cancelling){                                    //Using an infinite while loop until the user inputs a valid row number and seat number
            try {
                System.out.print("★ Enter the row number: ");
                rowNum = input.nextInt();                           //Using Scanner class object to take row number input

                if (rowNum>0 && rowNum<4){                          //Using an if condition to check weather the user input is in the range of row numbers
                    System.out.print("★ Enter the seat number: ");
                    seatNum = input.nextInt();                      //Using Scanner class object to take seat number input

                    switch (rowNum) {
                        case 1 -> validation_for_cancelling(13,seatRow_1,10);//........................................................................
                        case 2 -> validation_for_cancelling(17,seatRow_2,20);//...Calling my own method related to cancel_ticket method for each row...
                        case 3 -> validation_for_cancelling(21,seatRow_3,30);//........................................................................
                    }
                    for (Ticket tickets:listOfTickets){                                 //Using a for loop to iterate through the tickets stored in Array List
                        if ((tickets.getRow()==rowNum)&&(tickets.getSeat()==seatNum)){  //Checking weather the relevant seat is available in the tickets of the array
                            listOfTickets.remove(tickets);                              //Using remove method tho remove ticket objects from the Array List
                            break;                                                      //Breaking ongoing iteration and starting next iteration of the for loop
                        }
                    }
                }
                else {                                         //Displaying an error message for out of range row number inputs
                    System.out.println("Invalid row number!");
                    System.out.println("-----------------------------------------------------------------------------------");
                    cancel_ticket();                           //Using recursive method to iterate again
                }
            }
            catch (Exception e){                               //Catching and displaying invalid data type inputs
                System.out.println("Invalid Input!");
                System.out.println("-----------------------------------------------------------------------------------");
                input.next();                                //Continuing the loop after catching the exception
            }
        }
    }
    static void validation_for_cancelling(int rowBoundary,int[] rows,int prices){ //Creating my own method related to cancel_ticket method
        if (seatNum > 0 && seatNum < rowBoundary) {                         //Using an if condition to check weather the user input is in the range of seat numbers
            if (rows[seatNum-1]==1){                                        //Using an if condition to check weather the value of seat index is '0'
                rows[seatNum - 1] = 0;                                      //Setting seat index value to '0'
                totalPrice-=prices;                                         //Subtracting ticket price from the total price
                System.out.println("\nTicket Cancelled successfully...");
                loop_cancelling =false;                                     //Closing the loop and goes back to menu option selection
            }
            else {                                                          //Displaying that the seat is already available
                System.out.println("This seat is not reserved!");
                loop_cancelling =false;                                     //Closing the loop and goes back to menu option selection
            }
        }
        else {                                                            //Displaying an error message for out of range seat number inputs
            System.out.println("Invalid seat number!");
            System.out.println("-----------------------------------------------------------------------------------");
            loop_cancelling = true;                                         //Continuing the loop for next iteration
        }
    }
    static void show_available(){                            //Creating the show_available method
        available_seats(1,12,seatRow_1);   //.........................................................................
        available_seats(2,16,seatRow_2);   //...Calling my own method related to show_available method for each row...
        available_seats(3,20,seatRow_3);   //.........................................................................
    }
    static void available_seats(int number,int rowBoundary,int[]rows){  //Creating my own method related to show_available method
        System.out.print("⦿Seats available in row "+number+" ➔ ");
        for (int i=0;i<rowBoundary;i++){                  //Using a for loop to iterate through seat indexes in each row
            if (rows[i]==0){                              //Using an if condition to check weather the value of seat index is '0'
                System.out.print(i+1+",");                //Printing available seat numbers in line
            }
        }
        System.out.println();                             //Printing a new line
    }
    static void save() {                           //Creating the save method
        try {
            PrintWriter saveData = new PrintWriter("rowData.txt");  //Calling the PrintWriter class using an object named 'saveData' and opening a new text file
            //Using 3 for loops to iterate through seat indexes in each row and using PrintWriter class object to write data of each row separately into opened text file...
            saveData.println("1st Row");
            for(int seat:seatRow_1){
                saveData.println(seat);
            }
            saveData.println("2nd Row");
            for(int seat:seatRow_2){
                saveData.println(seat);
            }
            saveData.println("3rd Row");
            for(int seat:seatRow_3){
                saveData.println(seat);
            }
            saveData.close();              //Closing the connection between saveData object and text file
            System.out.println("System data saved successfully...");
        }
        catch (IOException e){         //Catching and displaying an error message for IO exceptions
            System.out.println("No such file exists!");
        }
    }
    static void load(){                   //Creating the load method
        try {
            File savedFile=new File( "rowData.txt");  //Calling the File class using an object named 'savedFile'
            Scanner read_file=new Scanner(savedFile);          //Opening the text file named 'rowData.txt' to read data

            int count_line=1;                           //Assigning a variable to count lines of the text file
            int reducingLinesFromTheCounterForRow1=2; //...............................................................................................
            int reducingLinesFromTheCounterForRow2=15;//...Number of lines to be reduced from the line counter to access the first index of each row...
            int reducingLinesFromTheCounterForRow3=32;//...............................................................................................

            while( read_file.hasNext()) {                  //Using a while loop and hasNext method to check weather the text file has a next line
                String next_line =  read_file.nextLine();  //Using nextLine method to read lines of the text file one by one
                if ( count_line <= 13) {                   //Using an if condition to check weather the line counter is in the required lines range for 1st row
                    if (next_line.startsWith("1st")) {     //Using an if condition to check weather the line is starting with the string '1st'
                         count_line++;                     //Increasing the value of line counter by 1
                    }
                    else  {
                        if (next_line.equals("0")) {       //Using an if condition to check weather the line is equal to string '0'
                            seatRow_1[ count_line -  reducingLinesFromTheCounterForRow1] = 0; //Accessing all the index values of 1st row and setting it to '0'
                            count_line++;                  //Increasing the value of line counter by 1
                        }if (next_line.equals("1")) {      //Using an if condition to check weather the line is equal to string '1'
                            seatRow_1[ count_line -  reducingLinesFromTheCounterForRow1] = 1; //Accessing all the index values of 1st row and setting it to '1'
                            count_line++;                  //Increasing the value of line counter by 1
                        }
                    }
                }
                else if ( count_line <= 30) {               //Using an else if condition to check weather the line counter is in the required lines range for 2nd row
                    if (next_line.startsWith("2nd")) {      //Using an if condition to check weather the line is starting with the string '2nd'
                         count_line++;                      //Increasing the value of line counter by 1
                    }
                    else {
                        if (next_line.equals("0")) {        //Using an if condition to check weather the line is equal to string '0'
                            seatRow_2[ count_line - reducingLinesFromTheCounterForRow2] = 0; //Accessing all the index values of 2nd row and setting it to '0'
                            count_line++;                   //Increasing the value of line counter by 1
                        }if (next_line.equals("1")) {       //Using an if condition to check weather the line is equal to string '1'
                            seatRow_2[ count_line - reducingLinesFromTheCounterForRow2] = 1; //Accessing all the index values of 2nd row and setting it to '1'
                            count_line++;                   //Increasing the value of line counter by 1
                        }
                    }
                }
                else if ( count_line <= 51) {               //Using an else if condition to check weather the line counter is in the required lines range for 3rd row
                    if (next_line.startsWith("3rd")) {      //Using an if condition to check weather the line is starting with the string '3rd'
                         count_line++;                      //Increasing the value of line counter by 1
                    }
                    else{
                        if (next_line.equals("0")) {        //Using an if condition to check weather the line is equal to string '0'
                            seatRow_3[ count_line - reducingLinesFromTheCounterForRow3] = 0; //Accessing all the index values of 3rd row and setting it to '0'
                            count_line++;                   //Increasing the value of line counter by 1
                        }if (next_line.equals("1")) {       //Using an if condition to check weather the line is equal to string '1'
                            seatRow_3[ count_line - reducingLinesFromTheCounterForRow3] = 1; //Accessing all the index values of 3rd row and setting it to '1'
                            count_line++;                   //Increasing the value of line counter by 1
                        }
                    }
                }
            }
             read_file.close();                  //Closing the connection between read-file object and text file
             System.out.println("System data loaded successfully...");
        }
        catch(IOException e){                    //Catching and displaying an error message for IO exceptions
            System.out.println("Sorry! Something went wrong.");
        }
    }
    static void show_tickets_info(){                //Creating the show_ticket_info method
        for (Ticket tickets:listOfTickets){         //Using a for loop to iterate through the tickets stored in Array List
              tickets.print();                      //Accessing the print method in Ticket class to print tickets' information
        }
        System.out.println("✔ Total Price = "+totalPrice+"£");  //Printing the total price
    }
    static void sort_tickets(){
        ArrayList<Ticket> sortList;                            //Creating a new array list to store sorted tickets
        sortList=(ArrayList)listOfTickets.clone();             //Passing a copy of listOfTickets ArrayList to sortList ArrayList

        int finalIndex = sortList.size() - 2;                  //Neglecting the initially considered index elements by reducing 2 to compare
        Ticket temp;                                           //Creating a variable to store ticket information temporarily
        boolean exchanged = true;                              //Defining a boolean variable to loop through the Arraylist
        while (exchanged) {                                    //Using an infinite while loop until the boolean variable is changed
            exchanged = false;                                 //Defining the boolean variable to false
            for (int i = 0; i <= finalIndex; i++) {            //Using a for loop to go through rest of the elements which are not yet evaluated
                int price_1 = sortList.get(i).getPrice();      //Defining a new price1 variable to get 1st considered element for comparing
                int price_2 = sortList.get(i + 1).getPrice();  //Defining a new price2 variable to get 2nd considered element for comparing
                if (price_1 > price_2) {                       //Comparing the 2 variable values
                    temp = sortList.get(i);                    //Storing the 1st considered index element in the temporary variable
                    sortList.set(i, sortList.get(i + 1));      //Setting the compared element to 1st index of new sortList
                    sortList.set(i + 1, temp);                 //Setting the compared other element to 2nd index of new sortList
                    exchanged = true;                          //Changing the boolean variable value to true
                }
            } finalIndex--;                                    //Reducing the initially set two element index position
        }
        for (Ticket tickets: sortList){            //Using a for loop to iterate through the tickets stored in Array List
            tickets.print();                       //Accessing the print method in Ticket class to print sorted tickets' information
        }
        System.out.println("Tickets sorted successfully...");
    }
}
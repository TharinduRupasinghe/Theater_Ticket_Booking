public class Ticket {                  //Creating a public class named 'Ticket'
    private final int row;             //Defining the row attribute for Ticket class
    private final int seat;            //Defining the seat attribute for Ticket class
    private final int price;           //Defining the price attribute for Ticket class
    private final Person person;       //Defining person object as an attribute for Ticket class

    public Ticket(int row,int seat,int price,Person person){ //Creating the constructor for Ticket class and overloading it by passing Ticket attributes as parameters
        this.row = row;         //Setting the row attribute value to row parameter value
        this.seat = seat;       //Setting the seat attribute value to seat parameter value
        this.price = price;     //Setting the price attribute value to price parameter value
        this.person = person;   //Setting the person attribute value to person parameter value
    }
    public void print(){
        System.out.println("<<Ticket's Information>>");
        System.out.println("\n፠ User Name: "+person.getName());        //Accessing person object by getName method in Person class and printing the return value of name
        System.out.println("፠ User Surname: "+person.getSurname());    //Accessing person object by getSurname method in Person class and printing the return value of surname
        System.out.println("፠ User Email address: "+person.getEmail());//Accessing person object by getEmail method in Person class and printing the return value of email
        System.out.println("፠ Row Number: "+row);         //printing the value of row attribute
        System.out.println("፠ Seat Number: "+seat);       //printing the value of seat attribute
        System.out.println("፠ Ticket Price: "+"£"+price); //printing the value of price attribute
        System.out.println("-----------------------------------------------------------------------------------");
    }
    public int getRow() {         //Creating the getter method for row attribute
        return row;               //Returning the row value
    }
    public int getSeat() {        //Creating the getter method for seat attribute
        return seat;              //Returning the seat value
    }
    public int getPrice() {       //Creating the getter method for price attribute
        return price;             //Returning the price value
    }
}

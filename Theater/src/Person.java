public class Person {                //Creating a public class named 'Person'
    private final String name;       //Defining the name attribute for Person class
    private final String surname;    //Defining the surname attribute for Person class
    private final String email;      //Defining the email attribute for Person class

    public Person(String name,String surname,String email){   //Creating the constructor for Pearson class and overloading it by passing person attributes as parameters
        this.name=name;            //Setting the name attribute value to name parameter value
        this.surname=surname;      //Setting the surname attribute value to surname parameter value
        this.email=email;          //Setting the email attribute value to email parameter value
    }
    public String getName() {        //Creating the getter method for name attribute
        return name;                 //Returning the name value
    }
    public String getSurname() {     //Creating the getter method for surname attribute
        return surname;              //Returning the surname value
    }
    public String getEmail() {       //Creating the getter method for email attribute
        return email;                //Returning the email value
    }
}

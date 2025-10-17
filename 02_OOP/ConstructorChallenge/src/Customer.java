public class Customer {
    private String name;
    private double creditLimit;
    private String email;

    /**
     * shows the name
     * @return name
     */
    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public Customer(String name, double creditLimit, String email){
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public Customer(){
        this("Nobody",  "No email");
    }

    public Customer(String name, String email){
        this(name, 125, email);
    }

}

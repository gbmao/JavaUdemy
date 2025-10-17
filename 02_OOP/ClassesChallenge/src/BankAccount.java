public class BankAccount {

    private String accountNumber = "1";
    private double accountBalance = 100;
    private String name = "Jorge";
    private String email = "jorge@gbol.com";
    private String phoneNumber = "5559592";

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BankAccount(){
        this("666", 0.0,"Default name",
                "Default adress", "Default number");
        System.out.println("No parameters");
    }

    public BankAccount(String accountNumber, Double accountBalance, String name, String email, String phoneNumber){
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public BankAccount(String name, String email, String phoneNumber){
        this("99999", 100.55, name, email, phoneNumber);
    }


    public void deposit(int value){

        System.out.println("You have : R$" + getAccountBalance() + " in your account.");
        this.accountBalance += value;
        System.out.println("You have : R$" + getAccountBalance() + " in your account.");

    }

    public void withdraw(int value){

        double balance = getAccountBalance();
        if(value > balance){
            System.out.println("You don't have enough money!");
            System.out.println(getAccountBalance());
        }else {

            balance -= value;
            setAccountBalance(balance);
            System.out.println("You have : R$" + getAccountBalance() + " in your account.");


        }

    }
}

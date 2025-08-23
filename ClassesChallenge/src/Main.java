public class Main {
    public static void main(String[] args){

//    BankAccount client = new BankAccount("1", 0.0, "Jorge", "jorge@bol.com", "555-555");

//    client.deposit(150);
//    client.withdraw(50);
//    client.withdraw(201);

        BankAccount client2 = new BankAccount();

//        System.out.println(client.getName());
        System.out.println(client2.getName());

        BankAccount gabriel = new BankAccount("gabriel", "gabriel@oli.com", "6689");
        System.out.println(gabriel.getName());
        System.out.println(gabriel.getAccountNumber());
    }
}

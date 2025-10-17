public class Main {
    public static void main(String[] args) {

        Customer me = new Customer("Jorge", "Email.com");

        System.out.println(me.getName());
        System.out.println(me.getCreditLimit());
        System.out.println(me.getEmail());

        Customer you = new Customer();

        System.out.println(you.getName());
        System.out.println(you.getName());
        System.out.println(you.getCreditLimit());
    }
}

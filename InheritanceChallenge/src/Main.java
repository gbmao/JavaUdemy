public class Main {
    public static void main(String[] args){

        SalariedEmployee alf = new SalariedEmployee("Alfredo", "31/02/1985", "01/01/2000", 2000);
        SalariedEmployee art = new SalariedEmployee("Arthur", "31/02/1987", "01/01/2000", 5000);

        System.out.println(alf);
        System.out.println("Alfred paycheck: " + alf.collectPay());
        System.out.println(alf.getAge());
//        System.out.println(alf.collectPay(alf.getAnnualSalary()));
        alf.retire();
        System.out.println("Alfred paycheck: " + alf.collectPay());
        System.out.println(alf);

        System.out.println(art);
        System.out.println("Arthur salario: " + art.collectPay());

        HourlyEmployee bertie = new HourlyEmployee("Albert", "31/01/2000", "06/06/2019", 10);

        System.out.println(bertie);
        System.out.println(bertie.getDoublePay());

    }

}
//27131342     1340

 class  Worker{
    private String name;
    private String birthDate;
    protected String endDate;



//    public Worker(){};

    public Worker(String name, String birthDate){
        this.name = name;
        this.birthDate = birthDate;
//        this.endDate = endDate;
    }

    public int getAge(){
        //01/02/1991
        String yearOfBirth = birthDate.substring(6);
        int age = 2025 - Integer.parseInt(yearOfBirth) ;
        return age;
    }

    public double collectPay(){

        return 0.0;
    }
    public void terminate(String endDate){
        this.endDate = endDate;
    }

     @Override
     public String toString() {
         return "Worker{" +
                 "name='" + name + '\'' +
                 ", birthDate='" + birthDate + '\'' +
                 ", endDate='" + endDate + '\'' +
                 '}';
     }
 }

class Employee extends Worker{

    public Employee(String name, String birthDate, String hireDate){
        super(name, birthDate);
        this.employeeId = employeeNo++;
        this.hireDate = hireDate;
    }

    private long employeeId;
    private String hireDate;

    private  static int employeeNo = 1;



    @Override
    public String toString() {
        return "Employee{" +
                "employeeld=" + employeeId +
                ", hireDate='" + hireDate + '\'' +
                "} " + super.toString();
    }
}

class SalariedEmployee extends  Employee{

    public SalariedEmployee(String name, String birthDate,
                            String hireDate, double annualSalary ){
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = isRetired;
    }

    private double annualSalary;
    private boolean isRetired;


    public void retire(){

        terminate("25/08/2025");
        isRetired = true;
    }

    @Override
    public double collectPay() {

        double paycheck = annualSalary /26;

        double adjustedpay = isRetired ? 0.7 * paycheck : paycheck;

        return  (int) adjustedpay;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "annualSalary=" + annualSalary +
                ", isRetired=" + isRetired +
                "} " + super.toString();
    }
}

class HourlyEmployee extends Employee{

    public HourlyEmployee(String name, String birthDate,
                            String hireDate, double hourlyPayRate){
        super(name, birthDate, hireDate);
        this.hourlyPayRate = hourlyPayRate;

    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "hourlyPayRate=" + hourlyPayRate +
                "} " + super.toString();
    }

    private double hourlyPayRate;

    public double getDoublePay(){
        return collectPay() * 2;
    }

    @Override
    public double collectPay(){

        return hourlyPayRate * 40;
    }

}



public class OverloadMethodsChallenge {
    public static void main(String[] args) {
        System.out.println(convertToCentimeters(6, 0));
    }
    public static double convertToCentimeters(int inches){
        return (double) inches * 2.54;
    }
    public static double convertToCentimeters(int feet, int inches){
        int totalInches = feet * 12 + inches;
        return convertToCentimeters(totalInches);
    }
    //1 feet = 12 inches
}

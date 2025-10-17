public class SwitchChallenge {
    public static void main(String[] args){
        char letter = 'x';
        System.out.println(letter + " is " + natoWord(letter) + " in nato alphabet");
    }
    public static String natoWord(char letter){
        return switch(letter){
            case 'a' -> "Able";
            case 'b' -> "Baker";
            case 'c' -> "Charlie";
            case 'd' -> "Dog";
            case 'e' -> "Easy";
            default -> "Not found";
        };
    }
}

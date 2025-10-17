public class SecondsAndMinutesChallenge {
    public static void main(String[] args) {
        System.out.println(getDurationString(3945)); // this is the first test case
        System.out.println(getDurationString(65, 59));
    }
    public static String getDurationString(int seconds){
        //XXh YYm ZZs
        // this should call the second method
        if(seconds < 0) return "Invalid Value";
        int minutes = seconds / 60;
        int remainderSeconds = seconds % 60;
        return getDurationString(minutes, remainderSeconds);
    }

    public static String getDurationString(int minutes, int seconds){
    if(minutes < 0 || seconds < 0 || seconds > 59) return "Invalid Value";
    int hour = minutes / 60;
    int remainderMinutes = minutes % 60;

    return hour + "h " + remainderMinutes + "m " + seconds + "s";
    }
}

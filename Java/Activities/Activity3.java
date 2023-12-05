package activities;
import java.time.Duration;
import java.time.LocalDateTime;


public class Activity3 {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(1972, 06, 01, 00, 00, 00);
        Duration showSeconds = calculateAgeDuration(dateTime, LocalDateTime.now());
        long myAgeInSeconds=calculateTime(showSeconds.getSeconds());

        //long myAgeInSeconds=567648000;
        double EarthSeconds =     31557600; // 1 year = 365.4 days considering leap year
        double MercurySeconds =   7603200;  // 1 year = 88 days
        double VenusSeconds =     19440000; // 1 year=  225 days
        double MarsSeconds =      59356800; // 1 year=  687 days
        double JupiterSeconds =   374371200;// 1 year=  4333 days
        double SaturnSeconds =    929577600;// 1 year = 10759 days
        double UranusSeconds =    265135680;// 1 year = 30687 days actual seconds are 30687*24*3600
        double NeptuneSeconds =   520041600;// 1 year = 60190 days actual seconds are 60190*24*3600

        System.out.println("Your age on Mercury: " + myAgeInSeconds / MercurySeconds);
        System.out.println("Your age on Venus: " +   myAgeInSeconds / VenusSeconds);
        System.out.println("Your age on Earth: " +   myAgeInSeconds / EarthSeconds);
        System.out.println("Your age on Mars: " +    myAgeInSeconds / MarsSeconds);
        System.out.println("Your age on Jupiter: " + myAgeInSeconds / JupiterSeconds);
        System.out.println("Your age on Saturn: " +  myAgeInSeconds / SaturnSeconds);
        System.out.println("Your age on Uranus: " +  myAgeInSeconds / UranusSeconds);
        System.out.println("Your age on Neptune: " + myAgeInSeconds / NeptuneSeconds);
    }
    //Method to calculate the Age in Years and Months and Days
    public static Duration calculateAgeDuration(LocalDateTime dayBefore, LocalDateTime currentDay) {
        return Duration.between(dayBefore, currentDay);
    }
    public static long calculateTime(long timeSeconds) {
        long days = timeSeconds / 86400; // 24*60*60
        long hours = timeSeconds / 3600;
        long minutes = (timeSeconds % 3600) / 60;
        long seconds = (timeSeconds % 3600) % 60;

        long  totalSeconds= (hours)*60*60 +(minutes)*60+(seconds);

        //System.out.println("Days: " + days);
        //System.out.println("Hours: " + hours);
        //System.out.println("Minutes: " + minutes);
        //System.out.println("Seconds: " + seconds);
        System.out.println("Your age in Seconds :"+totalSeconds);
        return totalSeconds;
    }
}

public class Time {
    public static void main(String[] args) {
int second=32;
int minute=25;
int hour=19;
float fsecons=32;
float fminute=25;
float fhour=19;
float secondssincemidnight=second+(minute*60)+(hour*3600); // Calculation of Number of seconds since midnight
float secondsremaining=24*3600-secondssincemidnight; // Calculation of Number of seconds remaining in the day
float wholedayinseconds=24*3600; // Calculation of Number of seconds in a day

System.out.print("Number of seconds since midnight: "); // makeup of print statement
System.out.println(hour*3600+minute*60+second); // Calculation of Number of seconds since midnight

  //number of seconds remaining in the day
  System.out.print("Number of seconds remaining in the day: ");
  System.out.println(24*3600-(hour*3600+minute*60+second)); // Calculation of Number of seconds remaining in the day

  //percentage of the day remaining
  System.out.print("Percentage of the day remaining: ");
  System.out.println((secondsremaining/wholedayinseconds*100)+" %"); // Calculation of Percentage of the day remaining

  //time elapsed since starting the program
  float ffsecons=12;
  float ffminute=48;
  float ffhour=19;
  float timeelapsed=ffsecons+(ffminute*60)+(ffhour*3600)-second+minute*60+hour*3600; // Calculation of Time elapsed since starting the program
System.out.print("Time elapsed since starting the program: "); // makeup of print statement
System.out.println(timeelapsed); // Calculation of Time elapsed since starting the program
    }

  

}

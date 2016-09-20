public class Age {
  
  public static void main(String[] args) {
    int ageInSeconds = 1234567890;
    double year = (double)ageInSeconds/60/60/24/365;
    double month = (double)ageInSeconds/60/60/24/30;
    double day = (double)ageInSeconds/60/60/24;
    System.out.println(year+" years");
    System.out.println(month+" months");
    System.out.println(day+" days");
    int years = ageInSeconds/60/60/24/365;
    int months = (ageInSeconds - years*60*60*24*365)/60/60/24/30;
    int days = (ageInSeconds - years*60*60*24*365 - months*60*60*24*30)/60/60/24;
    int hour = (ageInSeconds - years*60*60*24*365 - months*60*60*24*30 - days*60*60*24)/60/60;
    int minute = (ageInSeconds - years*60*60*24*365 - months*60*60*24*30 - days*60*60*24 - hour*60*60)/60;
    int second = (ageInSeconds - years*60*60*24*365 - months*60*60*24*30 - days*60*60*24 - hour*60*60 - minute*60);
    System.out.println(years+" years");
    System.out.println(months+" months");
    System.out.println(days+" days");
    System.out.println(hour+" hours");
    System.out.println(minute+" minutes");
    System.out.println(second+" seconds");
    } 
}
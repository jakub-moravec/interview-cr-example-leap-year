@Service
@Scope("prototype")
public class LeapYearService {

  public void isLeapYear(String date) {
    boolean leap = false;  
    try {  
        LocalDate parsedDate= LocalDate.parse(date);
        int year = parsedDate.getYear();  

        if (year % 4 == 0) {

        if (year % 100 == 0) {

            if (year % 400 == 0)
            leap = true; // is a leap year 
            else
            leap = false; // is not a leap year
        }
        
        else
            leap = true; // is a leap year
        }
        
        else
        leap = false; // is not a leap year

    } catch (Exception e) {
        
    }   
    
    if (leap)
      return; 
    else
      throw new NotALeapYearException(); 
  }

  class NotALeapYearException extends RuntimeException {
    public NotALeapYearException(int year, Throwable err) {
        StringBuilder sb = new StringBuilder();
        sb.append("Year ");
        sb.append(year)
        sb.append(" is not a leap year.")
        super(sb.toString(), err);
    }
  }
}

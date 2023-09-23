package InterviewQuestions.LLD.FlightBookingSystem;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Server {

  List<Flight> listOfFlight;
  
  public List<Flight> getListOfFlight() {
    return listOfFlight;
  }


  public void setListOfFlight(List<Flight> listOfFlight) {
    this.listOfFlight = listOfFlight;
  }

  public List<Flight> fetchFlight(String src, String des, Date date) {
    List<Flight> filterFlights = new ArrayList<Flight>();
    for(int i=0;i<listOfFlight.size();i++) {
      if(listOfFlight.get(i).source.compareTo(src)==0 &&
          listOfFlight.get(i).destination.compareTo(des)==0 &&
          listOfFlight.get(i).Date == date) {
            filterFlights.add(listOfFlight.get(i));
          }
    }
    return filterFlights;
  }

  public boolean fixSeat(Aircraft aircraft,Seat seat) {
    aircraft.fixSeat(seat, seat.getCustomer());
    return true;
  }

  
}

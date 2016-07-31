package fi.javame; 

import javax.microedition.lcdui.Display; 
import javax.microedition.midlet.MIDlet; 
import javax.microedition.midlet.MIDletStateChangeException; 

public class FlightReservationMIDlet extends MIDlet 
{ 
static FlightReservationMIDlet midlet; 
ReservationForm mainForm = new ReservationForm("Reservation"); public FlightReservationMIDlet() { 
// TODO Auto-generated constructor stub
}


protected void destroyApp(boolean unconditional)
throws MIDletStateChangeException
{
// TODO Auto-generated method stub
if(unconditional)
{
// release resources
notifyDestroyed();
}


} 


protected void pauseApp() { 
// TODO Auto-generated method stub 


} 
 




protected void startApp() throws MIDletStateChangeException { 
	// TODO Auto-generated method stub 
midlet = this; 
Display display = Display.getDisplay(this); display.setCurrent(mainForm); 
} 
} 

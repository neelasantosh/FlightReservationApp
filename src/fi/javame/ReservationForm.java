package fi.javame; 

import javax.microedition.lcdui.ChoiceGroup; 
import javax.microedition.lcdui.Command; 
import javax.microedition.lcdui.DateField; 
import javax.microedition.lcdui.Form; 
import javax.microedition.lcdui.Gauge; 
import javax.microedition.lcdui.TextField; 

public class ReservationForm extends Form 
{ 
TextField txtName = new TextField("Name","",30,TextField.ANY); 
TextField txtMobile = new TextField("Mobile","",10,TextField.NUMERIC); 
TextField txtEmail = new 
TextField("Email","cdac@frankelsinfotech.com",40,TextField.ANY); 
ChoiceGroup cgSource = new ChoiceGroup("From",ChoiceGroup.POPUP); 
ChoiceGroup cgDestination = new 
ChoiceGroup("Destination",ChoiceGroup.POPUP); 
DateField dfTravelDate = new DateField("Date",DateField.DATE_TIME); Gauge noOfSeats = new Gauge("No of Seats",true,5,1); 


Command cmdExit = new Command("Exit",Command.EXIT,1); 
Command cmdBook = new Command("Book",Command.SCREEN,1); 
 





Command cmdRetrv = new Command("Retrv",Command.SCREEN,2); 


public ReservationForm(String title) 
{ 
super(title); 


append(txtName); 
append(txtMobile); 
append(txtEmail); 
append(cgSource); 
append(cgDestination); 
append(dfTravelDate); 
append(noOfSeats); 


String [] city = {"Pune","Mumbai","Delhi","Kolkata","Bangalore"}; for(int iTmp=0;iTmp<city.length;iTmp++) 
cgSource.append(city[iTmp], null); 


for(int iTmp=city.length-1;iTmp>0;iTmp--) 
cgDestination.append(city[iTmp], null); 


addCommand(cmdExit); 
addCommand(cmdBook); 


addCommand(cmdRetrv); 
setCommandListener(new CommandHandler()); 


} 
} 
 


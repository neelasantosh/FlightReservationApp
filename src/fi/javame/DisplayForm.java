



package fi.javame; 

import javax.microedition.lcdui.Command; 
import javax.microedition.lcdui.Form; 
import javax.microedition.lcdui.StringItem; 
public class DisplayForm extends Form 
{ 
ReservationForm mainForm; 
StringItem siContents = new StringItem("Msg",""); 
Command cmdBack = new Command("Back",Command.BACK,1); 
Command cmdConfirm = new Command("Confirm",Command.SCREEN,1); 

public DisplayForm(String title, ReservationForm mainForm, String msg) { 
	super(title); 
this.mainForm = mainForm; 
append(siContents); 
addCommand(cmdBack); 
addCommand(cmdConfirm); 
siContents.setText(msg); 


setCommandListener(new DisplayCommandHandler());
}


} 

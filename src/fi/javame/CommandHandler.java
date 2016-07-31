
package fi.javame; 

import java.io.ByteArrayOutputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.util.Date; 


import javax.microedition.lcdui.Command; 
import javax.microedition.lcdui.CommandListener; 
import javax.microedition.lcdui.Display; 
import javax.microedition.lcdui.Displayable; 
import javax.microedition.midlet.MIDletStateChangeException; import javax.microedition.rms.RecordStore; 
import javax.microedition.rms.RecordStoreException; 
import javax.microedition.rms.RecordStoreFullException; 
import javax.microedition.rms.RecordStoreNotFoundException; 


public class CommandHandler implements CommandListener { 

public void commandAction(Command c, Displayable d) { 
	// TODO Auto-generated method stub 
 



if( c == FlightReservationMIDlet.midlet.mainForm.cmdExit) 
{ 
try { 
FlightReservationMIDlet.midlet.destroyApp(true); } catch (MIDletStateChangeException e) { 
	// TODO Auto-generated catch block 
e.printStackTrace(); 
} 
} 
else if(c == FlightReservationMIDlet.midlet.mainForm.cmdRetrv){ 
Display display = 
Display.getDisplay(FlightReservationMIDlet.midlet); 
display.setCurrent(new 
DisplayForm("Display",FlightReservationMIDlet.midlet.mainForm,"")); 
} 
else if(c == FlightReservationMIDlet.midlet.mainForm.cmdBook) 
{ 
ReservationForm form = 
FlightReservationMIDlet.midlet.mainForm; 
String name = form.txtName.getString(); 
String mobile = form.txtMobile.getString(); 
String email = form.txtMobile.getString(); 


String source = 
form.cgSource.getString(form.cgSource.getSelectedIndex()); 
String destination = 
form.cgDestination.getString(form.cgDestination.getSelectedIndex()); 


Date objDate = form.dfTravelDate.getDate(); 
int noOfSeats = form.noOfSeats.getValue(); 


RecordStore store = null; 
 



ByteArrayOutputStream baos =null; DataOutputStream dos = null; 


try { 
store = 
RecordStore.openRecordStore("FlightReservation", true); 


baos = new ByteArrayOutputStream(); 


dos = new DataOutputStream(baos); 


dos.writeUTF(name); 
dos.writeUTF(mobile); 
dos.writeUTF(email); 
dos.writeUTF(source); 
dos.writeUTF(destination); 
dos.writeLong(objDate.getTime()); dos.writeInt(noOfSeats); 


dos.flush(); 


byte [] data = baos.toByteArray(); 

store.addRecord(data, 0, data.length); } catch (RecordStoreFullException e) { 
	// TODO Auto-generated catch block 
e.printStackTrace(); 
} catch (RecordStoreNotFoundException e) { 
	// TODO Auto-generated catch block 
e.printStackTrace(); 
} catch (RecordStoreException e) { 
 





// TODO Auto-generated catch block 
e.printStackTrace(); 
} catch (IOException e) { 
// TODO Auto-generated catch block 
e.printStackTrace(); 
} 
finally 
{ 
try { 
if(dos!=null) 
dos.close(); 
if(baos!=null) 
	baos.close(); 
if(store!=null) 
store.closeRecordStore(); } catch (IOException e) { 
// TODO Auto-generated catch block 
e.printStackTrace(); 
} catch (RecordStoreException e) { 
// TODO Auto-generated catch block 
e.printStackTrace(); 
} 
} 


/*StringBuffer buffer = new StringBuffer("Name:"); buffer.append(name); 
buffer.append("\n"); 
buffer.append("Mobile:"); 
buffer.append(mobile); 
 





buffer.append("\n"); 
buffer.append("Email:"); 
buffer.append(email); 
buffer.append("\n"); 
buffer.append("Source:"); 
buffer.append(source); 
buffer.append("\n"); 
buffer.append("Destination:"); buffer.append(destination); buffer.append("\n"); 
buffer.append("Date:"); 
buffer.append(objDate.toString()); buffer.append("\n"); 
buffer.append("Seats:"); 
buffer.append(String.valueOf(noOfSeats)); 


String message = buffer.toString(); 


DisplayForm frm = new DisplayForm("Display",form,message); 


Display display = 
Display.getDisplay(FlightReservationMIDlet.midlet); 
display.setCurrent(frm); 
*/ 
} 
} 


} 

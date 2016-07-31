
package fi.javame; 

import java.io.ByteArrayInputStream; 
import java.io.DataInputStream; 
 



import java.io.IOException; 
import java.util.Date; 


import javax.microedition.lcdui.Command; 
import javax.microedition.lcdui.CommandListener; 
import javax.microedition.lcdui.Display; 
import javax.microedition.lcdui.Displayable; 
import javax.microedition.rms.RecordStore; 
import javax.microedition.rms.RecordStoreException; 
import javax.microedition.rms.RecordStoreFullException; 
import javax.microedition.rms.RecordStoreNotFoundException; 


public class DisplayCommandHandler implements CommandListener { 

public void commandAction(Command c, Displayable d) { 
	// TODO Auto-generated method stub 
DisplayForm displayForm = (DisplayForm)d; if(c == displayForm.cmdBack) 
{ 
Display display = 
Display.getDisplay(FlightReservationMIDlet.midlet); 
display.setCurrent(displayForm.mainForm); 
} 
else if(c == displayForm.cmdConfirm) 
{ 
RecordStore store = null; 


try { 
store = 
RecordStore.openRecordStore("FlightReservation", false); 
 





byte [] data = store.getRecord(1); 


ByteArrayInputStream bais = new 
ByteArrayInputStream(data); 
DataInputStream dis = new DataInputStream(bais); 
String name = dis.readUTF(); 
String mobile = dis.readUTF(); 
String email = dis.readUTF(); 
String source = dis.readUTF(); 
String destination = dis.readUTF(); long time = dis.readLong(); 
Date dtTravel = new Date(time); int seats = dis.readInt(); 

StringBuffer buffer = new StringBuffer("Name:"); buffer.append(name); 
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
buffer.append(dtTravel.toString()); 
 





buffer.append("\n"); 
buffer.append("Seats:"); 
buffer.append(String.valueOf(seats)); 


String message = buffer.toString(); 


displayForm.append(message); 


//displayForm.append(new String(data));

}
catch (RecordStoreFullException e) { 
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
if(store!=null) 
store.closeRecordStore(); 
} catch (RecordStoreException e) { 
// TODO Auto-generated catch block 
 





e.printStackTrace();
}


}
}


} 


} 

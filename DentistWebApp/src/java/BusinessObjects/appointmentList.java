/*
 * Java 3
 * Juan Rodriguez
 * I promise I wrote this code.
 * 12/2/2021
 */
package BusinessObjects;

/**************************************************************
 *
 * appointmentList class used to create array for appointments
 ***************************************************************/
public class appointmentList {
   public int count = 0;
    public appointment accArr[] = new appointment[10]; 
    

 /*******************************************************
 * addAptt() a inserted into accArr array
 *******************************************************/
    public void addAptt(appointment a){
    accArr[count]=a;
    count++;
    }
    

 /*******************************************************
 * displayList() used to display accArry array
 *******************************************************/
    public void displayList(){
    	for (int x=0; x<count; x++) {
	accArr[x].display(); //the appointment class has a display() method

        }
    }
 
 public static void main(String arrgs[]){
    
   
 }
}

/*
 * Java 3
 * Juan Rodriguez
 * I promise I wrote this code.
 * 12/2/2021
 */
package BusinessObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**************************************************************
 *
 * appointment class holds appointment data from DB
 ***************************************************************/
public class appointment {
    String apptDateTime, patId, dentId, procCode;

    public appointmentList aList = new appointmentList();
            
    public appointment(){
    apptDateTime = "";
    patId = "";
    dentId = "";
    procCode = "";     
    }
    
    public appointment(String apptDateTime, String patId, String dentId, String procCode){
   this.apptDateTime = apptDateTime;
   this.patId = patId;
   this.dentId = dentId;
   this.procCode = procCode;
    }
    
     public String getApptDateTime() {
        return apptDateTime;
    }

    public void setApptDateTime(String apptDateTime) {
        this.apptDateTime = apptDateTime;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public String getDentId() {
        return dentId;
    }

    public void setDentId(String dentId) {
        this.dentId = dentId;
    }

    public String getProcCode() {
        return procCode;
    }

    public void setProcCode(String procCode) {
        this.procCode = procCode;
    }
 /*******************************************************
 *selectDB() gets one appointment from DB for patient 
 *******************************************************/
      public void selectDB(String patId){
    try {
         String id;
         id = patId;

        //load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        //database connection
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/juan3/Documents/NetBeansProjects/DentistWebApp/src/java/DentistOfficeMDB.mdb");
        System.out.println("Database Connected!");
        //sql statment
       
              PreparedStatement ps=con.prepareStatement("Select * from Appointments where patId=?");
              
        
           ps.setString(1,id);
         
           ResultSet rs=ps.executeQuery();
            
           boolean status = rs.next();
          
           con.close();
         if(status) {
            setApptDateTime(rs.getString(1));
            setPatId(rs.getString(3));
            setDentId(rs.getString(4));
            setProcCode(rs.getString(2));   
          
           }else {
           System.out.println("patient not found!");
           
           }
        }catch(ClassNotFoundException e){
          e.printStackTrace();
        }catch (SQLException e) {
           e.printStackTrace();
       }
   
    }
 /************************************************************************
 *selectDentistDB() gets appointment data from DB used in Dentist class
 ***************************************************************************/
  public void selectDentistDB(String appt){
    try {
         String id;
         id = appt;

        //load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        //database connection
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/juan3/Documents/NetBeansProjects/DentistWebApp/src/java/DentistOfficeMDB.mdb");
        System.out.println("Database Connected!");
        //sql statment
       
              PreparedStatement ps=con.prepareStatement("Select * from Appointments where apptDateTime=?");
              
        
           ps.setString(1,id);
         
           ResultSet rs=ps.executeQuery();
            
           boolean status = rs.next();
          
           con.close();
         if(status) {
            setApptDateTime(rs.getString(1));
            setPatId(rs.getString(3));
            setDentId(rs.getString(4));
            setProcCode(rs.getString(2));   
          System.out.println("in appointment database");
           }else {
           System.out.println("Dentists not found!");
           
           }
        }catch(ClassNotFoundException e){
          e.printStackTrace();
        }catch (SQLException e) {
           e.printStackTrace();
       }
   
    }
 /************************************************************************
 *patientUpdateDB() changes appointment date for one patient
 ***************************************************************************/
    public void patientUpdateDB(String appointment, String id){
          setApptDateTime(appointment);
          setPatId(id);
      try{
       String date = getApptDateTime();
       String pat1 = getPatId();
        //load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        //database connection
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/juan3/Documents/NetBeansProjects/DentistWebApp/src/java/DentistOfficeMDB.mdb");
        System.out.println("Database Connected!");
        //sql statment
       
             String sql="UPDATE Appointments SET apptDateTime=? WHERE patId=?";
              
            PreparedStatement ps  = con.prepareStatement(sql);
           ps.setString(1,date);
           ps.setString(2, pat1);
         
           int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
}
      }catch(ClassNotFoundException e){
          e.printStackTrace();
        }catch (SQLException e) {
           e.printStackTrace();
       }
      }
 /************************************************************************
 *insertDB() inserts one appointment to DB for patient
 ***************************************************************************/      
public void insertDB(String Apptdate ,String Id,String Dentsid,String Code){
    setApptDateTime(Apptdate);
    setPatId(Id);
    setDentId(Dentsid);
    setProcCode(Code);
    try {       

        //load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        //database connection
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/juan3/Documents/NetBeansProjects/DentistWebApp/src/java/DentistOfficeMDB.mdb");
        System.out.println("Database Connected!");
        //sql statment
       
            Statement stmt = con.createStatement();
            String sql ="Insert into Appointments values ('"+getApptDateTime()+"',"+"'"+getProcCode()+"',"+"'"+getPatId()+"',"+"'"+getDentId()+"')";
           System.out.println(sql);
            int n1 = stmt.executeUpdate(sql);
            if (n1==1)
                System.out.println("INSERT Successful!!!");
            else
                System.out.println("INSERT FAILED***********");
            con.close();
              
        
        }catch(ClassNotFoundException e){
          e.printStackTrace();
        }catch (SQLException e) {
           e.printStackTrace();
       }
    
}
 /************************************************************************
 *deleteDB() deletes all appointments for a patient from DB
 ***************************************************************************/   
public void deleteDB(String id){
   setPatId(id);
 try{
     
       String pat1 = getPatId();
        //load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        //database connection
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/juan3/Documents/NetBeansProjects/DentistWebApp/src/java/DentistOfficeMDB.mdb");
        System.out.println("Database Connected!");
        //sql statment
       
             String sql="DELETE FROM Appointments WHERE patId=?";
              
            PreparedStatement ps  = con.prepareStatement(sql);
        
           ps.setString(1, pat1);
         
           int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
            System.out.println("An existing user was deleted successfully!");
}
      }catch(ClassNotFoundException e){
          e.printStackTrace();
        }catch (SQLException e) {
           e.printStackTrace();
       }
}

    public void display(){
    System.out.println("Appointment date = " + apptDateTime);
    System.out.println("Patient ID = " + patId );
    System.out.println("Dentist ID = " + dentId );
    System.out.println("Procedure code = " + procCode );
    
    }

public static void main (String[]args){
 //appointment ap1 = new appointment();
 //ap1.selectDB("A900");
 //ap1.display();
 //ap1.patientUpdateDB("Dec 3, 2021, 10am","A900");
 //ap1.display();  
 
//appointment ap2 = new appointment();
 //ap2.insertDB("Dec 2, 2021, 10am","A900","D201","P431"); 
//ap2.display();

//  appointment ap3 = new appointment();
//    ap3.patientUpdateDB("December 30, 2021, 10am","A900");
 //   ap3.display();
 
 //appointment ap4 = new appointment();
//ap4.deleteDB("A901");

//appointment ap5 = new appointment();
//ap5.selectDentistDB("May 2, 2018, 11am");
//ap5.display();
    }
      
}

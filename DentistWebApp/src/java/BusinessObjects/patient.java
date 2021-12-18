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

/*******************************************************
 *
 * Patient class holds patient data from DB
 *******************************************************/
public class patient {
    public String patId, passWD, firstName, lastName, address, email, insCo;
    
    public patient(){
    patId = "";
    passWD = "";
    firstName = "";
    lastName = "";
    address = "";
    email = "";
    insCo = "";
    }

    public patient(String patId, String passWD, String firstName, String lastName, String address, String email, String insCo ){
        this.patId = patId;
        this.passWD = passWD;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.insCo = insCo;
        
    }
    

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }

    public String getPassWD() {
        return passWD;
    }

    public void setPassWD(String passWD) {
        this.passWD = passWD;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInsCo() {
        return insCo;
    }

    public void setInsCo(String insCo) {
        this.insCo = insCo;
    }
/*******************************************************
 * selectDB() gets one patient from DB
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
       
              PreparedStatement ps=con.prepareStatement("Select * from Patients where patId=?");
              
        
           ps.setString(1,id);
         
           ResultSet rs=ps.executeQuery();
            
           boolean status = rs.next();
          
           con.close();
         if(status) {
            setPatId(rs.getString(6));
            setPassWD(rs.getString(7));
            setFirstName(rs.getString(1));
            setLastName(rs.getString(2));
            setAddress(rs.getString(3));
            setEmail(rs.getString(4));
            setInsCo(rs.getString(5));
          
           }else {
           System.out.println("patient not found!");
           
           }
        }catch(ClassNotFoundException e){
          e.printStackTrace();
        }catch (SQLException e) {
           e.printStackTrace();
       }
   
    }
/************************************************************************************
 * updatePatientDB() changes first name, last name, and address from one patient in DB
 **************************************************************************************/
   public void updatePatientDB(String id , String firstName , String lastName, String addrs){
    setPatId(id);
    setFirstName(firstName);
    setLastName(lastName);
    setAddress(addrs);       
   try{
       String pat1 = getPatId();
       String patfirstName = getFirstName();
       String patlastName = getLastName();
       String pataddrs = getAddress();
        //load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        //database connection
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/juan3/Documents/NetBeansProjects/DentistWebApp/src/java/DentistOfficeMDB.mdb");
        System.out.println("Database Connected!");
        //sql statment
       
             String sql="UPDATE Patients SET firstName=?, lastName=?,addr=? WHERE patId=?";
              
            PreparedStatement ps  = con.prepareStatement(sql);         
           ps.setString(4, pat1);
           ps.setString(1, patfirstName);
           ps.setString(2, patlastName);
           ps.setString(3, pataddrs);
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
   
       public void display() {
        System.out.println("Patient ID = " + patId );
        System.out.println("Password = " + passWD );
        System.out.println("First Name = " + firstName );
        System.out.println("Last Name = " + lastName );
        System.out.println("Address = " + address );
        System.out.println("Email = " + email );
        System.out.println("insurance company = " + insCo );
  
    }
    public static void main (String[]args){
    patient p1 = new patient();
    p1.selectDB("A900");
    p1.display();
    
    //patient p2 = new patient();
    //p2.updatePatientDB("A900","Juan","Rodriguez","Dallas");
    }
}

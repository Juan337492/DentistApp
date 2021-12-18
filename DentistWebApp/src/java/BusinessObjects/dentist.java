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

/*******************************************************
 *
 * Dentist class holds dentist data from DB
 *******************************************************/
public class dentist {
    String id,password,firstName,lastName,email,office;
    
    public appointmentList aList = new appointmentList();
    
    public dentist(){
    id = "";
    password = "";
    firstName = "";
    lastName = "";
    email = "";
    office = "";
    }
    
    public dentist(String id, String password, String firstName, String lastName, String office){
    this.id = id;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.office = office;
    
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
 /*******************************************************************
 * updateDB() changes first name, last name, office of dentist in DB
 ********************************************************************/
    public void updateDB(String id,String firstName , String lastName, String office ){
    setId(id);
    setFirstName(firstName);
    setLastName(lastName);
    setOffice(office);       
   try{
       String dent1 = getId();
       String dentfirstName = getFirstName();
       String dentlastName = getLastName();
       String dentaddrs = getOffice();
        //load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        //database connection
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/juan3/Documents/NetBeansProjects/DentistWebApp/src/java/DentistOfficeMDB.mdb");
        System.out.println("Database Connected!");
        //sql statment
       
             String sql="UPDATE Dentists SET firstName=?, lastName=?,office=? WHERE id=?";
              
            PreparedStatement ps  = con.prepareStatement(sql);         
           ps.setString(4, dent1);
           ps.setString(1, dentfirstName);
           ps.setString(2, dentlastName);
           ps.setString(3, dentaddrs);
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
 /*******************************************************************
 * selectDB() gets one dentist from the DB
 ********************************************************************/
    public void selectDB(String dentId){
    try {
         String id;
         id = dentId;

        //load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        //database connection
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/juan3/Documents/NetBeansProjects/DentistWebApp/src/java/DentistOfficeMDB.mdb");
        System.out.println("Database Connected!");
        //sql statment
       
              PreparedStatement ps=con.prepareStatement("Select * from Dentists where id=?");
              
        
           ps.setString(1,id);
         
           ResultSet rs=ps.executeQuery();
            
           boolean status = rs.next();
          
           con.close();
         if(status) {
           setId(rs.getString(4));
           setFirstName(rs.getString(1));
           setLastName(rs.getString(2));
           setOffice(rs.getString(6));
           setEmail(rs.getString(3));
           setPassword(rs.getString(5));
          
           }else {
           System.out.println("Dentist not found!");
           
           }
        }catch(ClassNotFoundException e){
          e.printStackTrace();
        }catch (SQLException e) {
           e.printStackTrace();
       }
     dentistApptListViewDB();
    }
 /****************************************************************************************
 * dentistApptListViewDB() gets appointments from DB adds each appointment to aList object
 ****************************************************************************************/
       public void dentistApptListViewDB(){
       
      try{
     
        String an;
        appointment a1;
       
        //load Driver
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        //database connection
        Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/juan3/Documents/NetBeansProjects/DentistWebApp/src/java/DentistOfficeMDB.mdb");
        System.out.println("Database Connected!");
        //sql statment
        
        
               Statement stmt = con.createStatement();
               String sql = "Select * from Appointments where dentId='"+getId()+"'";
 
        ResultSet rs= stmt.executeQuery(sql);
            
          while (rs.next()){
          an = rs.getString(1);
          System.out.println(an);
          a1 = new appointment();
          a1.selectDentistDB(an);
          aList.addAptt(a1);
          }
          
      }catch(ClassNotFoundException e){
          e.printStackTrace();
        }catch (SQLException e) {
           e.printStackTrace();
       }
      }
    public void displayDentist() {
        System.out.println("ID = " + id );
        System.out.println("Password = " + password );
        System.out.println("First Name = " + firstName );
        System.out.println("Last Name = " + lastName );
        System.out.println("Office = " + office );
        System.out.println("Email = " + email );
    //printLn account list
        aList.displayList();
    }
    
  public static void main (String[]args){
   //dentist d1 = new dentist();
  //d1.updateDB( "D201" , "Juan", "Rodriguez", "123");
  // d1.display();
   
   dentist d1 = new dentist();
  d1.selectDB("D203");
   d1.displayDentist();
    }
}

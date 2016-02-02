
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author lars
 */
public class Database {
    
    String url = "jdbc:ucanaccess://C:\\Users\\lars\\Desktop\\bakkerij.accdb";
    Connection conn;
    
    public Database() throws SQLException{
         this.conn = DriverManager.getConnection(url, "", "");
    }
    
    /**
     * Makes the Database Connection
     * 
     * @throws SQLException 
     */
    public void makeDBConnection() throws SQLException
    {
         try {
            conn = DriverManager.getConnection(url, "", ""); // url, user, pass
            System.out.println("Connection Succesfull");
         }  catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
    /**
     * Insert Data into the Database
     * 
     * @param query = is the insert query
     * @param values = An List that acts as an ArrayList with type <Pair>
     * @throws SQLException 
     */
    public void insertData(String query, List<Pair> values) throws SQLException
    {
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          
          int index = 0;
            for (int i = 1; i <= values.size(); i++) {
                if (values.get(index).getKey().toString().contains("String")) {
                    preparedStmt.setString(i, values.get(index).getValue().toString());
                }
                if (values.get(index).getKey().toString().contains("Int")) {
                     preparedStmt.setInt(i, Integer.parseInt(values.get(index).getValue().toString()));
                }
                index++;
            }
          preparedStmt.execute();
    }
    
    /**
     * Retrieve data from database and returns result in a ResultSet
     * 
     * @param query = Select query
     * @return a ResultSet that contains the selected data
     * @throws SQLException 
     */
    public ResultSet retrieveData(String query) throws SQLException
    {
        // @TODO - Lars - More scenario's
        
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery(query);
        
        return rs;
    }
    
    /**
     * Updates a record
     * 
     * @param query : is an update query 
     * @param values = An List that acts as an ArrayList with type <Pair>
     * @throws SQLException 
     */
    public void updateData(String query, List<Pair> values) throws SQLException
    {
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          
          int index = 0;
            for (int i = 1; i <= values.size(); i++) {
                if (values.get(index).getKey().toString().contains("String")) {
                    preparedStmt.setString(i, values.get(index).getValue().toString());
                }
                if (values.get(index).getKey().toString().contains("Int")) {
                     preparedStmt.setInt(i, Integer.parseInt(values.get(index).getValue().toString()));
                }
                index++;
            }
          preparedStmt.executeUpdate();
    }
    
    /**
     * Deletes a record by ID
     * 
     * @param query : Delete query
     * @param id : ID of record of first row that got to be deleted
     * @throws SQLException 
     */
    public void deleteData(String query, int id) throws SQLException
    {
        // @TODO - Lars - More scenario's
        
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
        
        preparedStatement.executeUpdate();
    }
   
    
//          example code
//          preparedStmt.setString (1, naam);
//          preparedStmt.setString (2, straat);
//          preparedStmt.setInt    (3, huisnummer);
//          preparedStmt.setString (4, woonplats);
//          preparedStmt.setString (5, "path-to-img");
    
    /**
     * Closes the Database Connection
     * 
     * @throws SQLException 
     */
    public void closeDB() throws SQLException
    {
         conn.close();
    }
}

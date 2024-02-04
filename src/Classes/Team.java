package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Team extends Database{
    private String id;
    private String name;
    private String department;
    private String coach;
    
    public Team(){
        
    }

    public Team(String id, String name, String department, String coach) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.coach = coach;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    
    @Override
    public void addData() {
        String query = "INSERT INTO team (ID, Name, Department, Coach) " +
        "VALUES ('" + id + "', '" + name + "', '" + department + "', '" + coach + "')";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        db.runDML(query);
        JOptionPane.showMessageDialog(null, "Addition Successfully");
    }

    @Override
    public void updateData() {
        String query = "UPDATE team SET Name='" + name + "', Department='" + department + "', " +
                "Coach='" + coach + "' WHERE Id='" + id + "'";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        db.runDML(query);
        JOptionPane.showMessageDialog(null, "Update Successfully");
    }

    @Override
    public void deleteData() {
        String query = "DELETE FROM team WHERE Id='" + id + "'";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        db.runDML(query);
        JOptionPane.showMessageDialog(null, "Deleted Successfully");
    }
    
    @Override
    public List<Object[]> getData() {
        List<Object[]> tournamentDetails = new ArrayList<>();
        String query = "SELECT * FROM team";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        ResultSet resultSet = db.runSelect(query);

        try {
            while (resultSet.next()) {
                // Retrieve data from the result set and add to the list
                String id = resultSet.getString("Id");
                String name = resultSet.getString("Name");
                String startDate = resultSet.getString("Department");
                String endDate = resultSet.getString("Coach");
                Object[] row = {id, name, startDate, endDate};
                tournamentDetails.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        return tournamentDetails;
    }
}

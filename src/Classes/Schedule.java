package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Schedule extends Database{
    
    private String id;
    private String team;
    private String tournament;
    private String sport;
    private String department;
    private String location;
    private String date;
    
    public Schedule(){
        
    }

    public Schedule(String id, String team, String tournament, String sport, String department, String location, String date) {
        this.id = id;
        this.team = team;
        this.tournament = tournament;
        this.sport = sport;
        this.department = department;
        this.location = location;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void addData() {
        String query = "INSERT INTO schedule (Id, Team, Tournament, Sport, Department, Location, Date ) " +
        "VALUES ('" + id + "', '" + team + "', '" + tournament + "', '" + sport + "', '" + department + "', '" + location + "', '" + date + "')";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        db.runDML(query);
        JOptionPane.showMessageDialog(null, "Addition Successfully");
    }

    @Override
    public void updateData() {
        String query = "UPDATE schedule SET Team='" + team + "', Tournament='" + tournament + "', " +
                "Sport='" + sport + "', Department='" + department + "',"+
                "Location='" + location + "',Date='" + date + "' WHERE Id='" + id + "'";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        db.runDML(query);
        JOptionPane.showMessageDialog(null, "Update Successfully");
    }

    @Override
    public void deleteData() {
        String query = "DELETE FROM schedule WHERE Id='" + id + "'";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        db.runDML(query);
        JOptionPane.showMessageDialog(null, "Deleted Successfully");
    }

    @Override
    public List<Object[]> getData() {
        List<Object[]> scheduleDetails = new ArrayList<>();
        String query = "SELECT * FROM schedule";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        ResultSet resultSet = db.runSelect(query);

        try {
            while (resultSet.next()) {
                // Retrieve data from the result set and add to the list
                String id = resultSet.getString("Id");
                String name = resultSet.getString("Team");
                String startDate = resultSet.getString("Tournament");
                String endDate = resultSet.getString("Sport");
                String location = resultSet.getString("Department");
                String numberOfRounds = resultSet.getString("Location");
                String tournamentType = resultSet.getString("Date");


                Object[] row = {id, name, startDate, endDate, location, numberOfRounds, tournamentType};
               scheduleDetails.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        return scheduleDetails;
    }  
}

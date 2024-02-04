package Classes;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Tournament extends Database{
    
    private String tournamentId;
    private String name;
    private String startDate;
    private String endDate;
    private String location;
    private String numberOfRounds;
    private String tournamentType;
    private String sportType;
    
    public Tournament(){
        
    }

    public Tournament(String tournamentId, String name, String startDate, String endDate, String location, String numberOfRounds, String tournamentType, String sportType) {
        this.tournamentId = tournamentId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.numberOfRounds = numberOfRounds;
        this.tournamentType = tournamentType;
        this.sportType = sportType;
    }

    public String getTournamentType() {
        return tournamentType;
    }

    public void setTournamentType(String tournamentType) {
        this.tournamentType = tournamentType;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    

    public String getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(String numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }


    @Override
    public void addData() {
        String query = "INSERT INTO tournament (ID, Name, StartDate, EndDate, Location, NumberOfRound, TournamentType, SportType) " +
        "VALUES ('" + tournamentId + "', '" + name + "', '" + startDate + "', '" + endDate + "', '" + location + "', '" + numberOfRounds + "', '" + tournamentType + "' , '" + sportType + "')";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        db.runDML(query);
        JOptionPane.showMessageDialog(null, "Addition Successfully");
    }

    @Override
    public void updateData() {
        String query = "UPDATE tournament SET Name='" + name + "', StartDate='" + startDate + "', " +
                "EndDate='" + endDate + "', Location='" + location + "',"+
                "NumberOfRound='" + numberOfRounds + "',TournamentType='" + tournamentType + "',"+
                "SportType = '" +sportType + "' WHERE ID='" + tournamentId + "'";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        db.runDML(query);
        JOptionPane.showMessageDialog(null, "Update Successfully");
    }

    @Override
    public void deleteData() {
        String query = "DELETE FROM tournament WHERE Id='" + tournamentId + "'";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        db.runDML(query);
        JOptionPane.showMessageDialog(null, "Deleted Successfully");
    }
    
    @Override
    public List<Object[]> getData() {
        List<Object[]> tournamentDetails = new ArrayList<>();
        String query = "SELECT * FROM tournament";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        ResultSet resultSet = db.runSelect(query);

        try {
            while (resultSet.next()) {
                // Retrieve data from the result set and add to the list
                String id = resultSet.getString("Id");
                String name = resultSet.getString("Name");
                String startDate = resultSet.getString("StartDate");
                String endDate = resultSet.getString("EndDate");
                String location = resultSet.getString("Location");
                String numberOfRounds = resultSet.getString("NumberOfRound");
                String tournamentType = resultSet.getString("TournamentType");
                String sportType = resultSet.getString("SportType");


                Object[] row = {id, name, startDate, endDate, location, numberOfRounds, tournamentType, sportType};
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

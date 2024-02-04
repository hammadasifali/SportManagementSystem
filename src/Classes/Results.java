package Classes;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Results extends Database{
    
    private String id;
    private String tournament;
    private String winner;
    private String loser;
    
    public Results(){
        
    }

    public Results(String id, String tournament, String winner, String loser) {
        this.id = id;
        this.tournament = tournament;
        this.winner = winner;
        this.loser = loser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getLoser() {
        return loser;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }

    

    @Override
    public void addData() {
        String query = "INSERT INTO results (Id, Tournament, Winner, Loser) " +
        "VALUES ('" + id + "', '" + tournament + "', '" + winner + "', '" + loser + "')";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        db.runDML(query);
        JOptionPane.showMessageDialog(null, "Addition Successfully");
    }

    @Override
    public void updateData() {
        String query = "UPDATE results SET Tournament='" + tournament + "', Winner='" + winner + "', " +
                "Loser='" + loser + "' WHERE Id='" + id + "'";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        db.runDML(query);
        JOptionPane.showMessageDialog(null, "Update Successfully");
    }

    @Override
    public void deleteData() {
        String query = "DELETE FROM results WHERE Id='" + id + "'";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        db.runDML(query);
        JOptionPane.showMessageDialog(null, "Deleted Successfully");
    }
    
    @Override
    public List<Object[]> getData() {
        List<Object[]> tournamentDetails = new ArrayList<>();
        String query = "SELECT * FROM results";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        ResultSet resultSet = db.runSelect(query);

        try {
            while (resultSet.next()) {
                // Retrieve data from the result set and add to the list
                String id = resultSet.getString("Id");
                String name = resultSet.getString("Tournament");
                String startDate = resultSet.getString("Winner");
                String endDate = resultSet.getString("Loser");


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

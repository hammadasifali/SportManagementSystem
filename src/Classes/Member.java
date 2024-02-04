package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Member extends Database{
    private String id;
    private String name;
    private String email;
    private String password;
    private String memberAs;
    
    public Member(){
        
    }

    public Member(String id, String name, String email, String password, String memberAs) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.memberAs = memberAs;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMemberAs() {
        return memberAs;
    }

    public void setMemberAs(String memberAs) {
        this.memberAs = memberAs;
    }
    
    @Override
    public void addData() {
        String query = "INSERT INTO member (ID, Name, Email, Password, MemberAs) " +
        "VALUES ('" + id + "', '" + name + "', '" + email + "', '" + password + "', '" + memberAs + "')";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        db.runDML(query);
        JOptionPane.showMessageDialog(null, "Addition Successfully");
    }

    @Override
    public void updateData() {
        String query = "UPDATE member SET Name='" + name + "', Email='" + email + "', " +
                "Password='" + password + "', MemberAs='" + memberAs + "' WHERE Id='" + id + "'";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        db.runDML(query);
        JOptionPane.showMessageDialog(null, "Update Successfully");
    }

    @Override
    public void deleteData() {
        String query = "DELETE FROM member WHERE Id='" + id + "'";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        db.runDML(query);
        JOptionPane.showMessageDialog(null, "Deleted Successfully");
    }
    
    @Override
    public List<Object[]> getData() {
        List<Object[]> tournamentDetails = new ArrayList<>();
        String query = "SELECT * FROM member";
        DbConnection db = new DbConnection("jdbc:ucanaccess://project.accdb");
        ResultSet resultSet = db.runSelect(query);

        try {
            while (resultSet.next()) {
                // Retrieve data from the result set and add to the list
                String id = resultSet.getString("Id");
                String name = resultSet.getString("Name");
                String startDate = resultSet.getString("Email");
                String endDate = resultSet.getString("Password");
                String location = resultSet.getString("MemberAs");
                Object[] row = {id, name, startDate, endDate, location};
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

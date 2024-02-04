package Classes;

import java.util.List;

public abstract class Database {
       
    public abstract void addData();
    public abstract void updateData();
    public abstract void deleteData();
    public abstract  List<Object[]> getData();
    
}

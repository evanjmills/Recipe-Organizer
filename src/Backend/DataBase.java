package Backend;

import java.util.ArrayList;

/**
 * Temporary class to act as a database for early development
 */
public class DataBase {
    ArrayList<Recipe> db;

    public DataBase(){
        db = new ArrayList<Recipe>();
    }

    public DataBase(ArrayList<Recipe> a){
        db = a;
    }
}

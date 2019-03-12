package Controller;

import Backend.DataBase;
import Backend.Recipe;

import java.util.ArrayList;

/**
 * Controls the data that is being accessed and manipulated in the database
 */
public class Controller {
    private DataBase dataBase;

    public Controller(){
        dataBase = new DataBase();
    }

    public ArrayList search(String key, Boolean contains){
        return dataBase.search(key, contains);
    }

    public ArrayList<Recipe> filter(ArrayList<String> filters){return dataBase.filter(filters);}

    public void load(ArrayList<Recipe> data){
        if(!dataBase.getAll().isEmpty()){
            dataBase = new DataBase(data);
        }
        else{

        }
    }
}

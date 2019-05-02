package Controller;

import Backend.DataBase;
import Backend.Recipe;

import java.util.ArrayList;

/**
 * Controls the data that is being accessed and manipulated in the database
 */
public class Controller {
    /**
     * the database for the program
     */
    private DataBase dataBase;

    /**
     * creates a new controller with a new database
     */
    public Controller(){
        dataBase = new DataBase();
    }

    /**
     * invokes a search on the database
     * @param key the term that is being searched for
     * @param contains true if the search should contain the key, false if the search should exactly match the key
     * @return a list of the items found based on the search of the database
     */
    public ArrayList search(String key, Boolean contains){
        return dataBase.search(key, contains);
    }

    /**
     * filters the recipes based on the given filters
     * @param filters the filters that are being applied
     * @return
     */
    public ArrayList<Recipe> filter(ArrayList<String> filters){return dataBase.filter(filters);}

    /**
     * loads recipes from the file at the given path
     * @param path the path of the file
     */
    public void load(String path){
       dataBase.load(path);
    }

    /**
     * saves the items in the database to the file at the given path
     * @param path the path of the file
     */
    public void save(String path){dataBase.save(path);}

    /**
     * invokes the delete method in the database
     * @param index the index of the item that is to be deleted
     */
    public void delete(int index){  dataBase.delete(index);}
}

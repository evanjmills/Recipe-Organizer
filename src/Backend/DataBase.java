package Backend;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Temporary class to act as a database for early development
 */
public class DataBase {
    /**
     * an ArrayList to represent a database
     */
    private ArrayList<Recipe> db;

    /**
     * creates an empty database
     */
    public DataBase(){
        db = new ArrayList<Recipe>();
    }

    /**
     * creates a database filled with the list of recipes
     * @param a the list to populate the database with
     */
    public DataBase(ArrayList<Recipe> a){
        db = a;
    }

    /**
     * adds a recipe to the database
     * @param rpc the recipe to be added
     */
    public void add(Recipe rpc){
        int index = 0;
        for(int x = 0; x < db.size(); x++){
            if(db.get(x).getName().compareToIgnoreCase(rpc.getName()) < 0){
                index = x;
            }
        }

        db.add(index, rpc);
        for(int x = index + 1; x < db.size(); x++){
            db.get(x).setDbIndex(db.get(x).getDbIndex() + 1);
        }
    }

    /**
     * searches the database for the recipes that either match the key word or that contains the keyword
     * @param key the key that we are searching for
     * @param contains weather or not we are searching for recipes that contain the key or exactly matches it
     * @return the list of recipes based on the search
     */
    public ArrayList<Recipe> search(String key, Boolean contains){
        ArrayList<Recipe> ret = new ArrayList<>();

        if(contains){
            for(Recipe temp: db){
                if(temp.getName().contains(key)){
                    ret.add(temp);
                }
            }
        }
        else{
            for(Recipe temp: db){
                if(temp.getName().equalsIgnoreCase(key)){
                    ret.add(temp);
                }
            }
        }
        return ret;
    }

    /**
     * filters the recipes in the database based on the filters given.
     * @param filters the filters to filter by
     * @return the list of recipes that fit the filter
     */
    public ArrayList<Recipe> filter(ArrayList<String> filters){
        ArrayList<Recipe> ret = new ArrayList<>();

        for(String filter: filters){
            for(Recipe rpc: db){
                if(rpc.getCategory().equals(filter)){
                    ret.add(rpc);
                }
            }
        }

        return ret;
    }

    /**
     * gets all of the recipes in the database
     * @return a list of all the recipes in the database
     */
    public ArrayList<Recipe> getAll(){
        return db;
    }

    /**
     * loads in the recipes from the given file
     * @param path the path to the file containing the recipes
     */
    public void load(String path){
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

            db = (ArrayList<Recipe>) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Cannot find file: " + path);
        }
        catch (IOException e){
            String msg = "Cannot load data from file: " + path;
            JOptionPane.showMessageDialog(new JFrame("Error"), msg, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch (ClassNotFoundException e){
            String msg = "No valid data found in file: " + path;
            JOptionPane.showMessageDialog(new JFrame("Error"), msg, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * saves the recipes to the file given
     * @param path the path to the file
     */
    public void save(String path){
        try{
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(db);

            oos.close();
            fos.close();
        }
        catch (FileNotFoundException e){
            String msg = "Cannot  find/create file: " + path;
            JOptionPane.showMessageDialog(new JFrame("Error"), msg, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException e){
            String msg = "Cannot save to file: " + path;
            JOptionPane.showMessageDialog(new JFrame("Error"), msg, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * deletes the recipe at the given index
     * @param index the index of the recipe to be deleted
     */
    public void delete(int index){
        db.remove(index);
    }
}

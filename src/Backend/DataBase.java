package Backend;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Temporary class to act as a database for early development
 */
public class DataBase {
    private ArrayList<Recipe> db;

    public DataBase(){
        db = new ArrayList<Recipe>();
    }

    public DataBase(ArrayList<Recipe> a){
        db = a;
    }

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

    public ArrayList<Recipe> getAll(){
        return db;
    }

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

    public void delete(int index){
        db.remove(index);
    }
}

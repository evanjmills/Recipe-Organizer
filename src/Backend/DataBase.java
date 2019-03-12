package Backend;

import javax.imageio.IIOException;
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
    }

    public ArrayList<Recipe> search(String key, Boolean contains){
        ArrayList<Recipe> ret = new ArrayList<>();

        if(contains){

        }
        else{

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
            System.out.println("Cannot load data from file: " + path);
        }
        catch (ClassNotFoundException e){
            System.out.println("No valid data found in file: " + path);
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
            System.out.println("Cannot  find/create file: " + path);
        }
        catch (IOException e){
            System.out.println("Cannot save to file: " + path);
        }
    }
}

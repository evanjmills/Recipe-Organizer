package Backend;

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

}

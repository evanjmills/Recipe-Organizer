package Backend;

import java.util.ArrayList;

public abstract class Recipe {
    private String name;

   private String category;

   private int dbIndex;

    public Recipe(String givenName, String givenCategory){
        name = givenName;
        category = givenCategory;
    }

    public String getName(){
        return name;
    }

    public String getCategory(){
        return category;
    }

    public int getDbIndex(){
        return dbIndex;
    }

    public void setDbIndex(int idx){
        dbIndex = idx;
    }
}

class ManualRecipe extends Recipe{
    private ArrayList<String> ingr;
    private ArrayList<String>  dir;

    public ManualRecipe(String name, String category, ArrayList<String> _ingr, ArrayList<String> _dir){
        super(name, category);
        ingr = _ingr;
        dir = _dir;
    }

    public  ArrayList<String> getIngr(){
        return ingr;
    }

    public ArrayList<String> getDir(){
        return dir;
    }
}

class ScanRecipe extends Recipe{
    private ArrayList<String> src;

    public ScanRecipe(String name, String category, ArrayList<String> _src){
        super(name, category);
        src = _src;
    }

    public ArrayList<String> getSrc(){
        return src;
    }
}
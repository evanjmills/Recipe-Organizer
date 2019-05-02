package Backend;

import java.util.ArrayList;

/**
 * An abstract class for when recipes are added
 */
public abstract class Recipe {
    /**
     * name of the recipe
     */
    private String name;

    /**
     * the category of the recipe
     */
   private String category;

    /**
     * the index of this recipe in the data base
     */
   private int dbIndex;

    /**
     * Creates a new recipe with the given values
     * @param givenName the name of the recipe
     * @param givenCategory the category of the recipe
     * @param dbIndex the index of this recipe in the database
     */
    public Recipe(String givenName, String givenCategory, int dbIndex){
        name = givenName;
        category = givenCategory;
        this.dbIndex = dbIndex;
    }

    /**
     * gets the name of the recipe
     * @return the name of the recipe
     */
    public String getName(){
        return name;
    }

    /**
     * gets the category of this recipe
     * @return the category of the recipe
     */
    public String getCategory(){
        return category;
    }

    /**
     * gets the index of this recipe in the database
     * @return
     */
    public int getDbIndex(){
        return dbIndex;
    }

    /**
     * sets the index of this recipe in the database
     * @param idx the new index of this recipe in the database
     */
    public void setDbIndex(int idx){
        dbIndex = idx;
    }
}

/**
 * A class for when the user adds a recipe manually
 */
class ManualRecipe extends Recipe{
    /**
     * the ingredient for the recipe
     */
    private ArrayList<String> ingr;

    /**
     * the directions for this recipe
     */
    private ArrayList<String>  dir;

    /**
     * creates a new manual recipe with the given values
     * @param name the name of this recipe
     * @param category the category of this recipe
     * @param _ingr the ingredients of this recipe
     * @param _dir the directions of this recipe
     * @param dbIndex the index of this recipe in the database
     */
    public ManualRecipe(String name, String category, ArrayList<String> _ingr, ArrayList<String> _dir, int dbIndex){
        super(name, category, dbIndex);
        ingr = _ingr;
        dir = _dir;
    }

    /**
     * gets the ingredients for this recipe
     * @return
     */
    public  ArrayList<String> getIngr(){
        return ingr;
    }

    /**
     * gets the directions for this recipe
     * @return
     */
    public ArrayList<String> getDir(){
        return dir;
    }
}

/**
 * a class for if the user scans in the recipe
 */
class ScanRecipe extends Recipe{
    /**
     * a list of the source locations for the scans
     */
    private ArrayList<String> src;

    /**
     * creates a new scan recipe with the given values
     * @param name the name of the recipe
     * @param category the category of the recipe
     * @param _src the sources of the recipe
     * @param dbIndex the index of the recipe in the database
     */
    public ScanRecipe(String name, String category, ArrayList<String> _src, int dbIndex){
        super(name, category, dbIndex);
        src = _src;
    }

    /**
     * gets the sources for this recipe
     * @return the sources for this recipe
     */
    public ArrayList<String> getSrc(){
        return src;
    }
}
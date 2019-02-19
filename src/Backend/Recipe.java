package Backend;

public abstract class Recipe {
    String name;

    String category;

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
}

class ManualRecipe extends Recipe{

    public ManualRecipe(String name, String category, String a){
        super(name, category);

    }
}
package Controller;

import Backend.DataBase;

/**
 * Controls the data that is being accessed and manipulated in the database
 */
public class Controller {
    private DataBase dataBase;

    public Controller(){
        dataBase = new DataBase();
    }
}

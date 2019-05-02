package FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OpenerPane extends JComponent {
    /**
     * The list of recipes that are being displayed
     */
    private JList rpcList;

    /**
     * Label of what is being displayed
     */
    private JLabel openerLbl;

    /**
     * a listener for passing data between classes
     */
    private Listener listener;

    /**
     * creates an empty OpenerPane
     */
    public OpenerPane(){
        setup();
    }

    /**
     * Creates a new OpenerPane displaying the given recipes
     * @param recipies the recipes to be displayed
     */
    public OpenerPane(ArrayList<String> recipies){
        setup();
    }

    /**
     * sets up the component
     */
    private void setup(){
        OpenerBtns btns = new OpenerBtns();
        rpcList = new JList();
        openerLbl = new JLabel("Showing Recipes for:");

        btns.setListener(new Listener() {
            @Override
            public void textPassed(String text) {
                if(text.equals("Open")){

                }
                else {
                    listener.textPassed(text);
                }
            }
        });

        setLayout(new BorderLayout());

        add(rpcList, BorderLayout.CENTER);
        add(btns, BorderLayout.SOUTH);
        add(openerLbl, BorderLayout.NORTH);
    }

    /**
     * Sets the listener of this class to the given listener
     * @param _listener the listener that this class is to use
     */
    public void setListener(Listener _listener){
        listener = _listener;
    }

    /**
     * gets the selected recipe from the list
     * @return the selected recipe
     */
    public int getSelected(){
        return rpcList.getSelectedIndex();
    }
}

/**
 * A class that contains all of the buttons for the  opener panel
 */
class OpenerBtns extends JComponent{
    /**
     * Button to open the recipe
     */
    private JButton openBtn;

    /**
     * Button to delete a recipe
     */
    private JButton deleteBtn;

    /**
     * Button for editing recipes
     */
    private JButton editBtn;

    /**
     * a listener for passing data from class to class
     */
    private Listener listener;

    /**
     * creates and adds the buttons to the component
     */
    public OpenerBtns(){
        openBtn = new JButton("Open");
        deleteBtn = new JButton("Delete");
        editBtn = new JButton("Edit");

        openBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.textPassed("open");
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.textPassed("delete");
            }
        });

        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.textPassed("edit");
            }
        });

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        add(openBtn, gc);
        add(editBtn,gc);
        add(deleteBtn,gc);
    }

    /**
     * Sets the listener to the given one
     * @param _listener the listener that is to be used for this class
     */
    public void setListener(Listener _listener){
        listener = _listener;
    }
}

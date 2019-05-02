package FrontEnd;

import Controller.Controller;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {
    /**
     * the toolbar for the overall program
     */
    private ToolBar toolBar;

    /**
     * the filterpane for the overall program
     */
    private FilterPane filterPane;

    /**
     * the openerpane for the overall program
     */
    private OpenerPane opener;

    /**
     * the controller for communication with the database
     */
    private Controller controller;

    /**
     * creates a new mainframe for the overall program
     */
    public MainFrame(){
        toolBar = new ToolBar();
        filterPane = new FilterPane();
        opener = new OpenerPane();
        controller = new Controller();

        filterPane.setListener(new Listener() {
            @Override
            public void textPassed(String text) {

            }
        });

        toolBar.setListener(new Listener() {
            @Override
            public void textPassed(String text) {
                if(text.equals("add")){
                    Object[] options = {"Manual", "Scan", "Cancel"};
                    int input = JOptionPane.showOptionDialog(new JFrame(), "What type of recipe would you like"
                            + "to enter?", "Type?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                            null, options, options[2]);

                    if(input == 0){
                        new ManualEditor();

                    }
                    else if(input == 1) {

                    }
                }
                else{
                    if(!text.equals("")){
                        System.out.println("search");
                        controller.search(text, toolBar.getSelected().equals("Contains"));
                    }
                }
            }
        });

        opener.setListener(new Listener() {
            @Override
            public void textPassed(String text) {
                if(text.equals("delete")){
                    controller.delete(0);
                }
                else if(text.equals("edit")){

                }
            }
        });

        setLayout(new BorderLayout());

        add(toolBar, BorderLayout.NORTH);
        add(filterPane, BorderLayout.WEST);
        add(opener, BorderLayout.CENTER);

        setJMenuBar(createMenu());

        setSize(new Dimension(1500, 1000));
        setMinimumSize(new Dimension(700, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * crates the menubar for the program
     * @return a menubar for the program
     */
    private JMenuBar createMenu(){
        JMenuBar ret = new JMenuBar();

        JMenu file = new JMenu("File");

        JMenu addMenu = new JMenu("Add");

        JMenuItem manual = new JMenuItem("Manual");
        JMenuItem scan = new JMenuItem("Scan");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem exit = new JMenuItem("Exit");

        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        exit.setMnemonic(KeyEvent.VK_X);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Save");
            }
        });

        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Open");
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        addMenu.add(manual);
        addMenu.add(scan);

        file.add(save);
        file.add(open);
        file.addSeparator();
        file.add(addMenu);
        file.addSeparator();
        file.add(exit);

        ret.add(file);

        return ret;
    }
}

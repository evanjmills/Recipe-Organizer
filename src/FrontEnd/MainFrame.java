package FrontEnd;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

    private ToolBar toolBar;
    private FilterPane filterPane;
    private OpenerPane opener;
    private Controller controller;

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

                }
                else{
                    //controller.search(text);
                }
            }
        });

        opener.setListener(new Listener() {
            @Override
            public void textPassed(String text) {
                if(text.equals("delete")){

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

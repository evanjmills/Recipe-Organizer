package FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OpenerPane extends JComponent {
    private JList rpcList;
    private JLabel openerLbl;
    private Listener listener;

    public OpenerPane(){
        setup();
    }

    public OpenerPane(ArrayList<String> recipies){
        setup();
    }

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

    public void setListener(Listener _listener){
        listener = _listener;
    }
}

class OpenerBtns extends JComponent{
    private JButton openBtn;
    private JButton deleteBtn;
    private JButton editBtn;
    private Listener listener;

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

    public void setListener(Listener _listener){
        listener = _listener;
    }
}

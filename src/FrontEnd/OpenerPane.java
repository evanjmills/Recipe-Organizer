package FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OpenerPane extends JComponent {
    private JList rpcList;
    private OpenerBtns btns;
    private JLabel openerLbl;

    public OpenerPane(){
        setup();
    }

    public OpenerPane(ArrayList<String> recipies){
        setup();
    }

    private void setup(){
        btns = new OpenerBtns();
        rpcList = new JList();
        openerLbl = new JLabel("Showing Recipes for:");

        setLayout(new BorderLayout());

        add(rpcList, BorderLayout.CENTER);
        add(btns, BorderLayout.SOUTH);
        add(openerLbl, BorderLayout.NORTH);
    }
}

class OpenerBtns extends JComponent{
    private JButton openBtn;
    private JButton deleteBtn;
    private JButton editBtn;

    public OpenerBtns(){
        openBtn = new JButton("Open");
        deleteBtn = new JButton("Delete");
        editBtn = new JButton("Edit");

        openBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        add(openBtn, gc);
        add(editBtn,gc);
        add(deleteBtn,gc);
    }
}

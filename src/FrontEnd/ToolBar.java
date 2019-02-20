package FrontEnd;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JComponent{
    private JButton addBtn;
    private JButton searchBtn;
    private JTextField searchTxt;

    public ToolBar(){
        addBtn = new JButton("Add Recipe");
        searchBtn = new JButton("Search");
        searchTxt = new JTextField(30);

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createCompoundBorder(new EtchedBorder(), new EmptyBorder(5,5,5,5)));

        GridBagConstraints gc = new GridBagConstraints();

        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = .1;
        gc.weighty = 1;

        add(addBtn, gc);

        gc.gridx ++;
        gc.anchor = GridBagConstraints.EAST;
        gc.weightx = 1;

        add(searchTxt, gc);

        gc.gridx ++;
        gc.weightx = .01;
        gc.anchor = GridBagConstraints.WEST;

        add(searchBtn, gc);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}

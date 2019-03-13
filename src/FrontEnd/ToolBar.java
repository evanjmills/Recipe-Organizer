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
    private Listener listener;
    private JRadioButton exactBtn;
    private JRadioButton containsBtn;
    private ButtonGroup group;

    public ToolBar(){
        addBtn = new JButton("Add Recipe");
        searchBtn = new JButton("Search");
        searchTxt = new JTextField(30);
        exactBtn = new JRadioButton("Exact Match");
        containsBtn = new JRadioButton("Contains");
        group = new ButtonGroup();
        JLabel searchLbl = new JLabel("Search: ");

        containsBtn.setSelected(true);

        group.add(exactBtn);
        group.add(containsBtn);

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
        add(searchLbl, gc);

        gc.gridx ++;
        gc.weightx = .01;
        gc.anchor = GridBagConstraints.WEST;
        add(searchTxt, gc);

        gc.gridx ++;
        add(searchBtn, gc);

        gc.gridx ++;
        add(containsBtn);

        gc.gridx ++;
        add(exactBtn);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.textPassed("add");
            }
        });

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.textPassed(searchTxt.getText());
            }
        });
    }

    public void setListener(Listener _listener){
        listener = _listener;
    }

    public String getSelected(){
        if(exactBtn.isSelected()){
            return exactBtn.getText();
        }
        else{
            return containsBtn.getText();
        }
    }
}

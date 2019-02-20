package FrontEnd;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class FilterPane extends JPanel {
    private ArrayList<String> filters;
    private ArrayList<JCheckBox> boxes;
    private GridBagConstraints gc;

    public FilterPane(){
        filters = new ArrayList<String>();
        boxes = new ArrayList<JCheckBox>();
        gc = new GridBagConstraints();

        setUp();
    }

    public FilterPane(ArrayList<String> _filters){
        filters = _filters;
        boxes = new ArrayList<>();
        gc = new GridBagConstraints();
        setUp();
        addBoxes();

    }

    private void setUp(){
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(250, 100));
        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10,0,10,10), new TitledBorder("Filters")));
    }

    private void addBoxes(){
        for(String temp: filters){
            JCheckBox newBox = new JCheckBox(temp);
            newBox.addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });

            boxes.add(newBox);
        }

        gc.anchor = GridBagConstraints.WEST;
        gc.weighty = .01;
        gc.weightx = 1;
        gc.gridy = 1;
        gc.gridx = 1;

        for(int i = 0; i < boxes.size() - 1; i ++){
            add(boxes.get(i), gc);

            gc.gridy ++;
        }

        gc.weighty = 1;

        add(boxes.get(boxes.size() - 1), gc);

    }
}

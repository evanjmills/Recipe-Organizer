package FrontEnd;

import Backend.Recipe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ManualEditor extends JFrame {
    private Content content;

    public ManualEditor(){
        content = new Content();
        add(new JScrollPane(content));

        content.setListener(new Listener() {
            @Override
            public void textPassed(String text) {
                setup();
            }
        });

        setup();
    }

    public ManualEditor(Recipe rpc){

    }

    private void setup(){
        setSize(new Dimension(1500, 1000));
        setMinimumSize(new Dimension(700, 500));
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
    }
}

class Content extends JComponent {
    private JTextField name;
    private JTextField cat;
    private IngrPanel ingr;
    private JTextArea dir;
    private JTextArea notes;
    private Listener listener;

    public Content(){
        name = new JTextField(100);
        cat = new JTextField(100);
        ingr = new IngrPanel();
        dir = new JTextArea(20, 100);
        notes = new JTextArea(20, 100);

        ingr.setListener(new Listener() {
            @Override
            public void textPassed(String text) {
                listener.textPassed(text);
            }
        });

        setup();
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    private void setup(){
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 0.01;
        gc.weighty = 0.01;
        gc.anchor = GridBagConstraints.WEST;

        add(new JLabel("Name:"), gc);

        gc.gridy ++;
        add(name, gc);

        gc.gridy ++;
        add(new JLabel("Category:"), gc);

        gc.gridy ++;
        add(cat, gc);

        gc.gridy ++;
        add(new JLabel("Ingredients:"), gc);

        gc.gridy ++;
        add(ingr, gc);

        gc.gridy ++;
        add(new JLabel("Directions:"), gc);

        gc.gridy ++;
        add(dir, gc);

        gc.gridy ++;
        add(new JLabel("Notes:"), gc);

        gc.gridy ++;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.NORTHWEST;
        add(notes, gc);

        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
    }
}

class IngrPanel extends JComponent {
    private ArrayList<JTextField> ingr;
    private JButton addBtn;
    private Listener listener;
    private ArrayList<JLabel> labels;

    public IngrPanel() {
        ingr = new ArrayList<>();
        labels = new ArrayList<>();
        addBtn = new JButton("Add Ingredient");

        for(int i = 0; i < 5; i++){
            ingr.add(new JTextField(100));
            if(i < 9){
                labels.add(new JLabel(" " + (i + 1)));
            }
            else {
                labels.add(new JLabel("" + (i + 1)));
            }
        }

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingr.add(new JTextField(100));
                if(ingr.size() <10) {
                    labels.add(new JLabel(" " + ingr.size()));
                }
                else{
                    labels.add(new JLabel("" + ingr.size()));
                }
                setup();
                listener.textPassed("update");
            }
        });

        setup();
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    private void setup(){
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weighty = .01;
        gc.weightx = .01;
        gc.anchor = GridBagConstraints.EAST;

        for(int i = 0; i < ingr.size(); i++){
            add(labels.get(i), gc);

            gc.gridx ++;

            add(ingr.get(i), gc);

            gc.gridx = 0;
            gc.gridy ++;
        }

        gc.weighty = 1;
        gc.gridx ++;
        gc.anchor = GridBagConstraints.CENTER;
        add(addBtn,gc);

        updateUI();
    }

    public ArrayList<String> getIngr(){
        ArrayList<String> ret = new ArrayList<>();
        for(JTextField temp: ingr){
            if(!temp.getText().equals("")){
                ret.add(temp.getText());
            }
        }
        return ret;
    }
}

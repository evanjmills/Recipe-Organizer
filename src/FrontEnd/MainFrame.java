package FrontEnd;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private ToolBar toolBar;
    private FilterPane filterPane;
    private OpenerPane opener;

    public MainFrame(){
        toolBar = new ToolBar();
        filterPane = new FilterPane();
        opener = new OpenerPane();

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

        JMenuItem save = new JMenuItem("Save");
        file.add(save);

        ret.add(file);

        return ret;
    }
}

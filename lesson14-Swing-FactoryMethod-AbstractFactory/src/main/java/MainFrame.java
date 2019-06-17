import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame
{
  private static final Logger log = LogManager.getLogger(MainFrame.class);

  public void initUI()
  {
    this.setTitle("Super cool DB client");
    this.setSize(960, 640);
    this.setLayout(new BorderLayout());
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel connectionPanel = createConnectionPanel();
    JPanel tableListPanel = createTableListPanel();
    JPanel dataTable = createMockTablePanel();

    this.add(connectionPanel, BorderLayout.NORTH);
    this.add(tableListPanel, BorderLayout.WEST);
    this.add(dataTable, BorderLayout.CENTER);

    this.setVisible(true);
    log.info("UI is initialized");
  }

  private JPanel createConnectionPanel()
  {
    JPanel panel = new JPanel(new FlowLayout());

    panel.add(new JLabel("JDBC URL : "));
    panel.add(new JTextField("insert jdbc path here"));
    JButton openButton = new JButton("Open");
    panel.add(openButton);

    openButton.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        JOptionPane.showMessageDialog(panel, "HELLO !");
      }
    });

    return panel;
  }

  private JPanel createTableListPanel()
  {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    panel.add(new JLabel("Table_01"));
    panel.add(new JLabel("Table_02"));
    panel.add(new JLabel("Table_03"));
    panel.add(new JLabel("Table_04"));
    panel.add(new JLabel("Table_05"));
    panel.add(new JLabel("Table_06"));
    panel.add(new JLabel("Table_07"));

    return panel;
  }

  private JPanel createMockTablePanel()
  {
    String[] columnNames = new String[] {"Column A", "Column B", "Column C"};
    String[][] rowData = new String[][]{
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"},
        {"cell 1", "cell 2", "cell 3"}
    };

    JTable table = new JTable(rowData, columnNames);

    JPanel panel = new JPanel(new BorderLayout());
    panel.add(table, BorderLayout.CENTER);

    return panel;
  }
}

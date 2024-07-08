package Temperature;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Temperature.observer.Subscriber;

public class TemperatureView extends JFrame implements Subscriber {
    private String title;
    private JPanel jPanel;
    private JLabel jLabelCelsius, jLabelFahrenheit;
    private JTextField jTextCelsius, jTextFahrenheit;
    private JMenuBar menuBarRemote = null;
    private TemperatureController controller;
    private TemperatureModel model;
    private JButton btnC2F, btnF2C; 

    public TemperatureView() {
        this.model = new TemperatureModel();
        controller = new TemperatureController(this, model);
        model.subscribe(this);
        buildMenu();
        build();
        add(jPanel);
        title = "Temperature";
        setSize(400, 400);
        setTitle(title);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void build() {
        jPanel = new JPanel();
        jLabelCelsius = new JLabel("Celsius");
        jTextCelsius = new JTextField(11);
        jLabelFahrenheit = new JLabel("Fahrenheit");
        jTextFahrenheit = new JTextField(11);
        jTextCelsius.setText("0");
        jTextFahrenheit.setText("0");

        btnC2F = new JButton("C2F");
        btnF2C = new JButton("F2C");

        btnC2F.addActionListener(controller);
        btnF2C.addActionListener(controller);
        jPanel.add(jLabelCelsius);
        jPanel.add(jTextCelsius);
        jPanel.add(jLabelFahrenheit);
        jPanel.add(jTextFahrenheit);
        jPanel.add(btnC2F); 
        jPanel.add(btnF2C); 

    }

    public void buildMenu() {
        menuBarRemote = new JMenuBar();
        setJMenuBar(menuBarRemote);
        JMenu menu = new JMenu("Commands");
        menuBarRemote.add(menu);
        JMenuItem f2c = new JMenuItem("F2C");
        JMenuItem c2f = new JMenuItem("C2F");
        JMenuItem exit = new JMenuItem("Exit");
        f2c.addActionListener(controller);
        c2f.addActionListener(controller);
        exit.addActionListener(controller);
        menu.add(f2c);
        menu.add(c2f);
        menu.add(exit);

    }

    public JTextField getjTextCelsius() {
        return jTextCelsius;
    }

    public JTextField getjTextFahrenheit() {
        return jTextFahrenheit;
    }

    @Override
    public void updateFahrenheit() {
        double fahrenheit = model.getFahrenheit();
        jTextFahrenheit.setText("" + fahrenheit);

    }

    @Override
    public void updateCelsius() {
        double celsius = model.getCelsius();
        jTextCelsius.setText("" + Math.round(celsius));
    }

}
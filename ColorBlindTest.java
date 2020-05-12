import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorBlindTest {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JPanel panel1;
    private JPanel panel2;

    public ColorBlindTest() {
        prepareGUI();
    }

    public static void main(String[] args) {
        ColorBlindTest swingControlDemo = new ColorBlindTest();
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Värinäkötestisovellus");
        mainFrame.setSize(400, 400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showQuestion() {
        headerLabel.setText("MINKÄ NUMERON NÄET KUVASSA");
        statusLabel.setText("TÄMÄ ON TEKSTIÄ");

        panel1 = new JPanel();

        JButton SuljeButton = new JButton("SULJE");
        SuljeButton.setActionCommand("SULJE");
        SuljeButton.addActionListener(new ButtonClickListener());
        panel1.add(SuljeButton);

        controlPanel.removeAll();
        // BufferedImage myPicture = ImageIO.read(new File("/pics/10.png"));
        // JLabel img = new JLabel(new ImageIcon(myPicture));
        JLabel img = new JLabel(new ImageIcon("1"));

        // img.setIcon(new ImageIcon("1"));
        panel1.add(img);
        // panel1.add(panel1);

        controlPanel.add(panel1);
        // controlPanel.revalidate();
        controlPanel.repaint();
        mainFrame.setVisible(true);
    }

    private void showEventDemo() {
        headerLabel.setText("Värinäkötesti");

        panel1 = new JPanel();
        panel2 = new JPanel();

        JButton suppeaButton = new JButton("SUPPEA TESTI");
        JButton laajaButton = new JButton("LAAJA TESTI");
        JButton lisaaButton = new JButton("LISÄÄ TESTEJÄ");

        suppeaButton.setActionCommand("SUPPEA TESTI");
        laajaButton.setActionCommand("LAAJA TESTI");
        lisaaButton.setActionCommand("LISÄÄ TESTEJÄ");

        suppeaButton.addActionListener(new ButtonClickListener());
        laajaButton.addActionListener(new ButtonClickListener());
        lisaaButton.addActionListener(new ButtonClickListener());

        panel1.add(suppeaButton);
        panel1.add(laajaButton);
        panel1.add(lisaaButton);

        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        JButton OhjeetButton = new JButton("OHJEET");
        JButton SuljeButton = new JButton("SULJE");

        OhjeetButton.setActionCommand("OHJEET");
        SuljeButton.setActionCommand("SULJE");

        OhjeetButton.addActionListener(new ButtonClickListener());
        SuljeButton.addActionListener(new ButtonClickListener());

        panel2.add(OhjeetButton);
        panel2.add(SuljeButton);

        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        controlPanel.add(panel1);
        controlPanel.add(Box.createVerticalStrut(10));
        controlPanel.add(panel2);

        mainFrame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command == "SULJE") {
                mainFrame.setVisible(false);
            }
            if (command == "SUPPEA TESTI") {
                showQuestion();
            }
            System.out.println(command);
        }
    }
}
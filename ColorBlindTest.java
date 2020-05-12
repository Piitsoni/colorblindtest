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
    public colorBlind cb = new colorBlind();

    public ColorBlindTest() {
        prepareGUI();
    }

    // Main -luokka, käynnistää s
    public static void main(String[] args) {
        ColorBlindTest swingControlDemo = new ColorBlindTest();
        swingControlDemo.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Värinäkötestisovellus");
        mainFrame.setSize(800, 800);
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

    private void showResults() {
        headerLabel.setText("ONNEKSI OLKOON, LÄPÄISIT TESTIN");
        statusLabel.setText("TULOKSESI:" + cb.correctAnswers + "/11");

        panel1 = new JPanel();
        panel2 = new JPanel();

        JLabel text = new JLabel();
        if (cb.correctAnswers <= 4) {
            text = new JLabel(cb.resultStrings[0]);
        }
        if (cb.correctAnswers >= 5) {
            text = new JLabel(cb.resultStrings[1]);
        }
        if (cb.correctAnswers == 11) {
            text = new JLabel(cb.resultStrings[2]);
        }
        panel1.add(text);

        JButton SuljeButton = new JButton("SULJE");
        SuljeButton.setActionCommand("SULJE");
        SuljeButton.addActionListener(new ButtonClickListener());
        panel2.add(SuljeButton);

        JButton AlkuunButton = new JButton("Alkuun");
        AlkuunButton.setActionCommand("ALKUUN");
        AlkuunButton.addActionListener(new ButtonClickListener());
        panel2.add(AlkuunButton);

        controlPanel.removeAll();
        controlPanel.add(panel1);
        controlPanel.add(panel2);

        controlPanel.repaint();

        mainFrame.setVisible(true);
    }

    private void showInstructions() {
        headerLabel.setText("Käyttöohjeet");
        panel1 = new JPanel();
        panel2 = new JPanel();
        statusLabel.setSize(0, 0);

        JTextArea text = new JTextArea(cb.instructions, 0, 45);
        text.setLineWrap(true);
        text.setEditable(false);
        panel1.add(text);

        JButton SuljeButton = new JButton("SULJE");
        SuljeButton.setActionCommand("ALKUUN");
        SuljeButton.addActionListener(new ButtonClickListener());
        panel2.add(SuljeButton);

        controlPanel.removeAll();
        controlPanel.repaint();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(panel1);
        controlPanel.add(panel2);

        mainFrame.setVisible(true);

    }

    private void missingPage() {
        headerLabel.setText("Työn alla.");
        panel1 = new JPanel();
        panel2 = new JPanel();
        statusLabel.setSize(0, 0);

        JTextArea text = new JTextArea(cb.instructions, 0, 45);
        text.setLineWrap(true);
        text.setEditable(false);
        // panel1.add(text);

        ImageIcon Image1 = new ImageIcon("./bobthebuilder.jpeg");
        Image img = Image1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        JLabel newImg = new JLabel(new ImageIcon(img));
        panel1.add(newImg);

        JButton SuljeButton = new JButton("SULJE");
        SuljeButton.setActionCommand("ALKUUN");
        SuljeButton.addActionListener(new ButtonClickListener());
        panel2.add(SuljeButton);

        controlPanel.removeAll();
        controlPanel.repaint();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(panel1);
        controlPanel.add(panel2);

        mainFrame.setVisible(true);

    }

    private void showQuestion(int question) {
        headerLabel.setText("MINKÄ NUMERON NÄET KUVASSA");
        // statusLabel.setText("TÄMÄ ON TEKSTIÄ");

        int currentQuestion = question - 1;
        panel1 = new JPanel();
        panel2 = new JPanel();

        StringBuilder sb = new StringBuilder(String.valueOf("./pics/pics/"));
        sb.append(question);
        sb.append(".png");
        String path = sb.toString();
        System.out.println(path);

        ImageIcon Image1 = new ImageIcon(path);

        JButton SuljeButton = new JButton("SULJE");
        SuljeButton.setActionCommand("SULJE");
        SuljeButton.addActionListener(new ButtonClickListener());
        panel1.add(SuljeButton);

        // System.out.println(cb.values[0][0]);
        String value = Integer.toString(cb.values[currentQuestion][0]);
        String rightAnswer = "";
        if (cb.values[currentQuestion][1] == 1) {
            rightAnswer = "ADD1";
        } else {
            rightAnswer = "REM1";
        }
        JButton oikeaButton = new JButton(value);
        oikeaButton.setActionCommand(rightAnswer);
        oikeaButton.addActionListener(new ButtonClickListener());
        panel1.add(oikeaButton);

        String value1 = Integer.toString(cb.values[currentQuestion][2]);
        String rightAnswer1 = "";
        if (cb.values[currentQuestion][3] == 1) {
            rightAnswer1 = "ADD1";
        } else {
            rightAnswer1 = "REM1";
        }
        JButton vaaraButton = new JButton(value1);
        vaaraButton.setActionCommand(rightAnswer1);
        vaaraButton.addActionListener(new ButtonClickListener());

        panel1.add(vaaraButton);

        String value2 = Integer.toString(cb.values[currentQuestion][4]);
        String rightAnswer2 = "";
        if (cb.values[currentQuestion][5] == 1) {
            rightAnswer2 = "ADD1";
        } else {
            rightAnswer2 = "REM1";
        }
        JButton vaaraButton2 = new JButton(value2);
        vaaraButton2.setActionCommand(rightAnswer2);
        vaaraButton2.addActionListener(new ButtonClickListener());
        panel1.add(vaaraButton2);

        JButton ohitaButton = new JButton("Ohita");
        ohitaButton.setActionCommand("PASS");
        ohitaButton.addActionListener(new ButtonClickListener());
        panel1.add(ohitaButton);

        controlPanel.removeAll();

        Image img = Image1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel newImg = new JLabel(new ImageIcon(img));
        // JLabel img = new JLabel(scaleImage);
        // img.setIcon(new ImageIcon("1"));
        panel2.add(newImg);
        // panel1.add(panel1);

        controlPanel.add(panel2);
        controlPanel.add(panel1);
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        // controlPanel.revalidate();
        controlPanel.repaint();
        mainFrame.setVisible(true);
    }

    private void showEventDemo() {
        headerLabel.setText("Värinäkötesti");
        headerLabel.setFont(new Font("Arial", Font.PLAIN, 30));

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
            Boolean next = true;
            if (cb.currentQuestion <= 10) {
                next = true;
            } else {
                next = false;
            }
            String command = e.getActionCommand();
            if (command == "SULJE") {
                mainFrame.setVisible(false);
            }
            if (command == "SUPPEA TESTI") {
                showQuestion(cb.currentQuestion);
            }
            if (command == "LAAJA TESTI") {
                missingPage();
            }
            if (command == "LISÄÄ TESTEJÄ") {
                missingPage();
            }
            if (command == "ADD1") {
                cb.correctAnswers += 1;
                cb.currentQuestion += 1;
                if (next) {
                    showQuestion(cb.currentQuestion);
                } else {
                    showResults();
                }
            }
            if (command == "REM1") {
                cb.currentQuestion += 1;
                if (next) {
                    showQuestion(cb.currentQuestion);
                } else {
                    showResults();
                }
            }
            if (command == "PASS") {
                cb.currentQuestion += 1;
                if (next) {
                    showQuestion(cb.currentQuestion);
                } else {
                    showResults();
                }
            }
            if (command == "ALKUUN") {
                cb.currentQuestion = 1;
                cb.correctAnswers = 0;
                controlPanel.removeAll();
                controlPanel.repaint();
                showEventDemo();
                statusLabel.setText(" ");
                controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));

            }
            if (command == "OHJEET") {
                showInstructions();
            }
            System.out.println(command);
            System.out.println(cb.correctAnswers);
        }
    }
}
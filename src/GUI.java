import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final String DEFAULT = "Click to start the test!";
    private static final JLabel intro = new JLabel("This is a simple 10-second click test.");
    private static final JLabel intro2 =
            new JLabel("Try to get as many clicks as you can to improve your average :)");
    private static final JButton clickButton = new JButton(DEFAULT);
    private static final JButton resetButton = new JButton("Reset clicks");
    private int count = 0;

    public GUI() {
        panel.setBorder(BorderFactory.createEmptyBorder(120, -50, 200,  -50));
        panel.setBackground(Color.darkGray);
        panel.add(intro);
        panel.add(intro2);
        panel.add(clickButton);
        panel.add(resetButton);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tom's Click Test");
        frame.pack();
        frame.setVisible(true);

        intro.setFont(new Font("Calibri", Font.PLAIN, 25));
        intro.setForeground(Color.white);

        intro2.setFont(new Font("Calibri", Font.PLAIN, 25));
        intro2.setForeground(Color.white);
        intro2.setBorder(BorderFactory.createEmptyBorder(0, 0, 60, 0));

        clickButton.setFocusable(false);
        clickButton.setBackground(Color.black);
        clickButton.setForeground(Color.white);
        clickButton.setFont(new Font("Calibri", Font.BOLD, 40));
        clickButton.addActionListener(increment);

        resetButton.setFocusable(false);
        resetButton.setBackground(Color.black);
        resetButton.setForeground(Color.white);
        resetButton.addActionListener(reset);
        resetButton.setFont(new Font("Calibri", Font.PLAIN, 40));
    }

    public static void main(String[] args) {
        new GUI();
    }

    ActionListener reset = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            count = 0;
            clickButton.setText(DEFAULT);
        }
    };

    ActionListener increment = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            count++;
            if (count >= 1) {
                clickButton.setText("Number of clicks: " + count);
                clickButton.setFont(new Font("Calibri", Font.PLAIN, 40));
            }
        }
    };
}

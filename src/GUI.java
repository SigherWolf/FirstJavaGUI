import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final JButton clickButton = new JButton("Click to start the test!");
    private static final JButton resetButton = new JButton("Reset clicks");
    private static final JLabel label = new JLabel("Number of clicks: 0");
    private int count;

    public GUI() {
        panel.setBorder(BorderFactory.createEmptyBorder(300, 400, 100, 400));
        panel.setLayout(new GridLayout(2, 1, 0, 5));
        panel.setBackground(Color.gray);
        panel.add(clickButton);
        panel.add(resetButton);
        panel.add(label);

        frame.add(panel);
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.setTitle("Tom's Click Test");
        frame.pack();
        frame.setVisible(true);

        clickButton.setFocusable(false);
        clickButton.setFont(new Font("Calibri", Font.BOLD, 20));
        clickButton.addActionListener(increment);
        clickButton.setSize(new Dimension(100, 50));
        clickButton.add(label, BorderLayout.CENTER);

        resetButton.setFocusable(false);
        resetButton.addActionListener(reset);
        resetButton.setFont(new Font("Calibri", Font.PLAIN, 20));

        label.setVisible(false);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Calibri", Font.PLAIN, 20));
    }

    public static void main(String[] args) {
        new GUI();
    }

    ActionListener reset = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            count = 0;
            label.setVisible(false);
            clickButton.setText("Click to start the test!");
        }
    };

    ActionListener increment = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            count++;
            label.setVisible(true);
            label.setText("Number of clicks: " + count);
            if (count >= 1) { clickButton.setText(""); }
        }
    };
}

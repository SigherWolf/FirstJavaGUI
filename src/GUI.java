import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI {

    private static final JFrame window = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final String DEFAULT = "Click to start the test!";
    private static final JButton clickButton = new JButton(DEFAULT);
    private static final JButton resetButton = new JButton("Reset clicks");
    private BoxLayout bl = new BoxLayout(panel, BoxLayout.X_AXIS);
    private int count = 0;

    public GUI() {
        panel.setBorder(BorderFactory.createEmptyBorder(300, 400, 100, 400));
        panel.setLayout(bl);
        panel.setBackground(Color.gray);
        panel.add(clickButton);
        panel.add(resetButton);

        window.add(panel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Tom's Click Test");
        window.pack();
        window.setVisible(true);

        clickButton.setFocusable(false);
        clickButton.setBackground(Color.black);
        clickButton.setForeground(Color.white);
        clickButton.setFont(new Font("Calibri", Font.BOLD, 20));
        clickButton.addActionListener(increment);

        resetButton.setFocusable(false);
        resetButton.addActionListener(reset);
        resetButton.setFont(new Font("Calibri", Font.PLAIN, 20));
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
            }
        }
    };
}

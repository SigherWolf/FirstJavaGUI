import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final JButton clickButton = new JButton("Click me!");
    private static final JButton resetButton = new JButton("Reset the click-count :D");
    private static final JLabel label = new JLabel("Number of clicks: 0");
    private int count;

    public GUI() {
        panel.setBorder(BorderFactory.createEmptyBorder(300, 400, 100, 400));
        panel.setLayout(new GridLayout(0, 1, 0, 5));
        panel.setBackground(Color.gray);
        panel.add(clickButton);
        panel.add(resetButton);
        panel.add(label);
//        panel.setMinimumSize(panel.getMinimumSize());

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
        frame.setTitle("Tom's Click Test");
        frame.pack();
        frame.setVisible(true);

        clickButton.setFocusable(false);
        clickButton.setFont(new Font("Calibri", Font.BOLD, 20));
        clickButton.addActionListener(increment);
        clickButton.setSize(new Dimension(100, 50));

        resetButton.setFocusable(false);
        resetButton.addActionListener(reset);
        resetButton.setFont(new Font("Calibri", Font.PLAIN, 20));
        resetButton.setMinimumSize(resetButton.getMinimumSize());
        resetButton.setPreferredSize(new Dimension(100, 50));

        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Calibri", Font.PLAIN, 20));
        label.setMinimumSize(label.getMinimumSize());
        label.setPreferredSize(new Dimension(100, 50));
    }

    public static void main(String[] args) {
        new GUI();
    }

    ActionListener reset = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            count = 0;
            label.setText("Number of clicks: " + count);
        }
    };

    ActionListener increment = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            count++;
            label.setText("Number of clicks: " + count);
        }
    };
}

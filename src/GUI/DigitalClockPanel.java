package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClockPanel extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JLabel currentTimeLabel;
    private Timer timer;

    public DigitalClockPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 150));

        // Current Time Label
        currentTimeLabel = new JLabel(getCurrentTime());
        currentTimeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        currentTimeLabel.setForeground(Color.WHITE);
        currentTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(currentTimeLabel, BorderLayout.CENTER);

        timer = new Timer(1000, this);
        timer.start();

        // Add smooth fading background animation
        Timer fadeTimer = new Timer(30, e -> animateBackground());
        fadeTimer.start();
    }

    private float alpha = 0.5f; // Initial transparency

    private void animateBackground() {
        alpha -= 0.005f; // Adjust the fading speed as needed
        if (alpha < 0) {
            alpha = 1.0f; // Reset transparency when it reaches 0
        }
        repaint();
    }

    private String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        return sdf.format(new Date());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentTimeLabel.setText(getCurrentTime());
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Color startColor = new Color(33, 147, 176); // #2193b0
        Color endColor = new Color(109, 213, 237);  // #6dd5ed
        GradientPaint gd = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
        g2.setPaint(gd);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintChildren(g);
    }

    @Override
    public void setOpaque(boolean isOpaque) {
        // Ensure that the panel is not opaque for smooth fading
        super.setOpaque(false);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Digital Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DigitalClockPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

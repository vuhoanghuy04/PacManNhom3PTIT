package com.zetcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Pacman extends JFrame {
    public void showWelcomeWindow() {
    JFrame welcomeFrame = new JFrame("Pacman Game của NHÓM 3");
    JPanel mainPanel = new JPanel(new BorderLayout());
    JPanel centerPanel = new JPanel();
    JLabel welcomeLabel = new JLabel("Chào mừng bạn đến với Pacman Game!", SwingConstants.CENTER);
    JLabel timeLabel = new JLabel();

    centerPanel.add(welcomeLabel);
    centerPanel.add(timeLabel);

    mainPanel.add(centerPanel, BorderLayout.CENTER);
    
    welcomeFrame.add(mainPanel);
    welcomeFrame.setSize(300, 200);
    welcomeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    welcomeFrame.setLocationRelativeTo(null);
    welcomeFrame.setVisible(true);

    Timer timeUpdater = new Timer(0, e -> {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        timeLabel.setText("Thời gian hiện tại: " + currentTime.format(formatter));
    });
    timeUpdater.start();
    
    Timer welcomeTimer = new Timer(5000, e -> {
        welcomeFrame.dispose(); 
        initUI();
    });
    welcomeTimer.setRepeats(false);
    welcomeTimer.start();
}

    public Pacman() {
        showWelcomeWindow();
    }

    private void initUI() {

        add(new Board());

        setTitle("Pacman");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(380, 420);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var ex = new Pacman();
            ex.setVisible(true);
        });
    }
}

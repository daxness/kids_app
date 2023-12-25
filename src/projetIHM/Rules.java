package projetIHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private JButton startButton;

    Rules(String name) {
        this.name = name;
        getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        JLabel heading = new JLabel("Welcome " + name + " to Kids Coding Quiz");
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(30, 144, 254));
        add(heading, BorderLayout.NORTH);

        JLabel rulesLabel = new JLabel("<html>" +
                "1. Welcome, young coder! Get ready for some coding fun." + "<br><br>" +
                "2. Answer the coding questions and earn points." + "<br><br>" +
                "3. Each correct answer adds to your score. Let's see how high you can go!" + "<br><br>" +
                "4. If a question is tricky, take your time and give it your best shot." + "<br><br>" +
                "5. Good luck, and enjoy the coding adventure!" +
                "<html>");
        rulesLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(rulesLabel, BorderLayout.CENTER);

        startButton = new JButton("Start Coding Quiz");
        startButton.setBackground(new Color(30, 144, 254));
        startButton.setForeground(Color.WHITE);
        startButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(startButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setSize(800, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == startButton) {
            setVisible(false);
            new QuizApp(name);
        }
    }

    public static void main(String[] args) {
        new Rules("Young Coder");
    }
}

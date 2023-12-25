package projetIHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Debut extends JFrame implements ActionListener {
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JButton playButton;
   JButton rulesButton;
   JButton exitButton ;
	public Debut() {
		
		setLayout(null);
		getContentPane().setBackground(Color.BLACK);
		setSize(650, 650);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Border border = BorderFactory.createLineBorder(Color.green,3);
		
		
		
  JLabel nameApplication = new JLabel("Coding Application");
  nameApplication.setHorizontalTextPosition(JLabel.CENTER);
  nameApplication.setVerticalTextPosition(JLabel.TOP);
  nameApplication.setForeground(new Color( 255,0,0));
  nameApplication.setFont(new Font("MV BOLI",Font.PLAIN ,20));
  nameApplication.setBackground(Color.black);
  nameApplication.setOpaque(true);
  nameApplication.setBorder(border);
  nameApplication.setBounds(0 ,0 ,650 ,50);
  add(nameApplication);
  
  
  
  
  playButton = new JButton ("Play");
  playButton.setBackground(Color.BLACK);
  playButton.setForeground(Color.RED);
  playButton.setBounds(325, 200, 100, 50);
  playButton.setBorder(border);
  playButton.setFocusable(false);
  playButton.addActionListener(this);
  add(playButton);
  
  
  rulesButton = new JButton ("Rules");
  rulesButton.addActionListener(this);
  rulesButton.setBackground(Color.BLACK);
  rulesButton.setForeground(Color.RED);
  rulesButton.setBounds(325, 300, 100, 50);
  rulesButton.setBorder(border);
  rulesButton.setFocusable(false);
  add(rulesButton);
  
  
  exitButton = new JButton ("Exit");
  exitButton.setBackground(Color.BLACK);
  exitButton.setForeground(Color.RED);
  exitButton.setBounds(325, 400, 100, 50);
  exitButton.setBorder(border);
  exitButton.setFocusable(false);
  exitButton.addActionListener(this);
  add(exitButton);
 
 
  
  
  setLocationRelativeTo(null);
  setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==playButton) {
			setVisible(false);
			new QuizApp("young coder");
		}else {
			if(e.getSource()==rulesButton) {
				setVisible(false);
				new Rules ("young coder");
			}else {
				setVisible(false);
				 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		}
		
	}

}

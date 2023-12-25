package projetIHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class QuizApp  implements ActionListener {

    private int score;
    private String name;
    private int seconds = 5;  
    private int currentQuestionIndex;

    private JFrame frame = new JFrame();
    private JLabel countDown = new JLabel();
    private JLabel remainingTime = new JLabel();
    private JTextArea askedQuestion = new JTextArea();
    private JTextField questionNumber = new JTextField();
    private JRadioButton[] options;
    private JButton submitButton;
    
    private Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			countDown.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer(-1);
			}
			}
		});

    public QuizApp(String name) {
        
    	this.name = name;
        this.currentQuestionIndex = 0;
        this.score = 0;

        frame.setSize(650, 650);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);

               
        questionNumber.setBounds(0,0,650,50);
        questionNumber.setBackground(new Color(25,25,25));
        questionNumber.setForeground(new Color(25,255,0));
        questionNumber.setFont(new Font("Ink Free",Font.BOLD,30));
        questionNumber.setBorder(BorderFactory.createBevelBorder(1));
        questionNumber.setHorizontalAlignment(JTextField.CENTER);
        questionNumber.setEditable(false);
        frame.add(questionNumber);
        
        askedQuestion.setBounds(0,50,650,75);
		askedQuestion.setLineWrap(true);
		askedQuestion.setWrapStyleWord(true);
		askedQuestion.setBackground(new Color(25,25,25));
		askedQuestion.setForeground(new Color(25,255,0));
		askedQuestion.setFont(new Font("MV Boli",Font.BOLD,25));
		askedQuestion.setBorder(BorderFactory.createBevelBorder(1));
		askedQuestion.setEditable(false);
		frame.add(askedQuestion);	
		
		remainingTime.setBounds(175,150,100,25);
		remainingTime.setBackground(new Color(50,50,50));
		remainingTime.setForeground(new Color(255,0,0));
		remainingTime.setFont(new Font("MV Boli",Font.PLAIN,30));
		remainingTime.setHorizontalAlignment(JTextField.CENTER);
		remainingTime.setText("Time :");
		frame.add(remainingTime);		
		
		countDown.setBounds(275,125,100,75);
		countDown.setBackground(new Color(25,25,25));
		countDown.setForeground(new Color(255,0,0));
		countDown.setFont(new Font("Ink Free",Font.BOLD,40));
		countDown.setBorder(BorderFactory.createBevelBorder(1));
		countDown.setOpaque(true);
		countDown.setHorizontalAlignment(JTextField.CENTER);
		countDown.setText(String.valueOf(seconds));
		frame.add(countDown);		

        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new GridLayout(4, 1, 10, 10));
        optionsPanel.setBackground(Color.BLACK);
        optionsPanel.setBounds(0, 200, 650, 300 );

        options = new JRadioButton[4];
        ButtonGroup group = new ButtonGroup();

        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
            options[i].setForeground(Color.BLACK);
            options[i].setBackground(Color.GRAY);
            group.add(options[i]);
            optionsPanel.add(options[i]);
        }
        frame.add(optionsPanel);

        submitButton = new JButton("Submit");
        submitButton.setBounds(275, 550, 100, 55);
        submitButton.setBackground(new Color(30, 144, 254));
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(this);
        frame.add(submitButton);

        displayQuestion();

        frame.setVisible(true);
    }

    private void displayQuestion() {
       
    	if (currentQuestionIndex < Question.questions.length) {

        	questionNumber.setText("Question "+(currentQuestionIndex+1));
        	askedQuestion.setText(Question.questions[currentQuestionIndex]);
			
            for (int i = 0; i < 4; i++) {
                options[i].setText(Question.options[currentQuestionIndex][i]);
            }
           
            timer.start();
            
        } else {
            showScore();
        }
    }
    
    

    private void showScore() {
        frame.setVisible(false);
        new Score(name, score, Question.questions.length).setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
    	
    	submitButton.setEnabled(false);
    	
    	/*options[0].setEnabled(false);
		options[1].setEnabled(false);
		options[2].setEnabled(false);
		options[3].setEnabled(false);*/
    	
    	if (ae.getSource() == submitButton) {
            displayAnswer(checkAnswer());
        	}
    }
   

    private void displayAnswer(int index) {
    	
    	timer.stop();
    	
    	if(index != -1) {
        	options[index].setForeground(Color.green);
        }
    	else {
    		index = Question.correctAnswers[currentQuestionIndex];
    		options[index].setForeground(Color.green);
    		
    		switch (index) {
    			
    			case 0:
    				options[1].setForeground(Color.red);
    				options[2].setForeground(Color.red);
    				options[3].setForeground(Color.red);
    			break;
    			
    			case 1:
    				options[0].setForeground(Color.red);
    				options[2].setForeground(Color.red);
    				options[3].setForeground(Color.red);
        		break;
    			
    			case 2:
    				options[0].setForeground(Color.red);
    				options[1].setForeground(Color.red);
    				options[3].setForeground(Color.red);
        		break;	
    			
    			case 3:
    				options[0].setForeground(Color.red);
    				options[1].setForeground(Color.red);
    				options[2].setForeground(Color.red);
        		break;
    		}
    	}
    	
    	Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				options[0].setForeground(Color.BLACK);
				options[1].setForeground(Color.BLACK);
				options[2].setForeground(Color.BLACK);
				options[3].setForeground(Color.BLACK);
				
				seconds = 5;
				countDown.setText(String.valueOf(seconds));
				submitButton.setEnabled(true);
				/*options[0].setEnabled(true);
				options[1].setEnabled(true);
				options[2].setEnabled(true);
				options[3].setEnabled(true);*/
				currentQuestionIndex++;
				clearSelection();
				displayQuestion();
			}
			
    		});
    	pause.setRepeats(false);
    	pause.start();
    }
    
    private int checkAnswer() {
    	int index = -1;
    	for (int i = 0; i < 4; i++) {
            if (options[i].isSelected() && i == Question.correctAnswers[currentQuestionIndex]) {
                score++;
                index = i;
                break;
            }
        }
    	return index;
    }

    private void clearSelection() {
        for (int i = 0; i < 4; i++) {
            options[i].setSelected(false);
        }
    }

}


package topquiz;

import admin.Question;
import admin.Student;
import admin.Test;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author omambalkar
 */
public class TestUI extends javax.swing.JFrame {

    /**
     * Creates new form TestUI
     */

    private Test test;
    private ArrayList<Question> questions;
    private int id;
    private ButtonGroup bg;
    private int testLength;
    private Student student;
    private String topic;
    private Timer timer;
    private static int time;
    private int correctImage;
    private JTextField field;
    private ArrayList<String> gameUserAnswer;
    public TestUI() {
        initComponents();
        this.dispose();
        new HomeUI().setVisible(true);
    }

    public TestUI(Student student, String topic) {
        initComponents();
        this.student = student;
        this.topic = topic;
        bg = null;
        test = new Test();
        questions = test.getTest(topic);
        id = 0;
        testLength = questions.size();
        this.generateQuestion(id, questions.get(id));
        time = 120;
        correctImage = 0;
        timer = new Timer();
        this.startTimer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        timeLabel = new javax.swing.JLabel();
        nextButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        timeLabel.setBackground(new java.awt.Color(24, 167, 207));
        timeLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 36)); // NOI18N
        timeLabel.setForeground(new java.awt.Color(24, 167, 207));
        timeLabel.setText("120");

        nextButton.setBackground(new java.awt.Color(24, 167, 207));
        nextButton.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        nextButton.setForeground(new java.awt.Color(255, 255, 255));
        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(24, 167, 207));
        jLabel1.setText("Timer:");

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        errorLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 798, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(errorLabel)
                                .addGap(733, 733, 733)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(timeLabel)))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(nextButton)
                        .addGap(64, 64, 64))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLabel)
                    .addComponent(jLabel1)
                    .addComponent(errorLabel))
                .addGap(4, 4, 4)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(nextButton)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startTimer() {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                timeLabel.setText(String.valueOf(time));
                time--;
                if (time == 0) {
                    new ResultUI(student, topic).setVisible(true);
                    timer.cancel();
                    TestUI.this.dispose();
                }
            }

        };

        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        if (questions.get(id).getType().equals("MCQ")){
            String userAnswer = getSelectedButtonText(bg);
        
            if (userAnswer == null) {
                errorLabel.setText("Please Select an Answer !!");
                return;
            }

            if (questions.get(id).getAnswer().equals(userAnswer)) {

                if (this.topic.equals("Geography"))
                    this.student.getScore().incrementGeographyScore();
                else this.student.getScore().incrementSpellingScore();

            }
        } else if(questions.get(id).getType().equals("FIB")){
            String userAnswer = field.getText();
            if (userAnswer == null) {
                errorLabel.setText("Please Enter an Answer !!");
                return;
            }

            if (questions.get(id).getAnswer().equals(userAnswer)) {

                if (this.topic.equals("Geography"))
                    this.student.getScore().incrementGeographyScore();
                else this.student.getScore().incrementSpellingScore();

            }
        } else if(questions.get(id).getType().equals("Interactive")){
            String userAnswer = Integer.toString(this.correctImage);
            
            if (this.correctImage == 0) {
                errorLabel.setText("Please Select an Image !!");
                return;
            }
            
            if (questions.get(id).getAnswer().equals(userAnswer)) {

                if (this.topic.equals("Geography"))
                    this.student.getScore().incrementGeographyScore();
                else this.student.getScore().incrementSpellingScore();

            }
        } else {
            String userAnswer = String.join("", gameUserAnswer);
            System.out.println(userAnswer);
            System.out.println(questions.get(id).getAnswer());
            if (questions.get(id).getAnswer().equals(userAnswer)) {

                if (this.topic.equals("Geography"))
                    this.student.getScore().incrementGeographyScore();
                else this.student.getScore().incrementSpellingScore();

            }
        }

        id++;
        if (id == testLength) {
            new ResultUI(this.student, topic).setVisible(true);
            timer.cancel();
            this.dispose();
        } else {
            errorLabel.setText("");
            this.generateQuestion(id, questions.get(id));
        }

    }// GEN-LAST:event_nextButtonActionPerformed

    public void generateQuestion(int index, Question question) {
        jPanel2.removeAll();
        String questionText = (index + 1) + ". " + question.getQuestion();
        JLabel quesLabel = new JLabel();
        quesLabel.setText(questionText);
        quesLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
        quesLabel.setForeground(new java.awt.Color(24, 167, 207));
        jPanel2.add(quesLabel, BorderLayout.CENTER);
    

        jPanel2.add(quesLabel);

        bg = new ButtonGroup();

        if (question.getType().equals("MCQ")) {

            for (String option : question.getOptions()) {

                JRadioButton newRadioButton = new JRadioButton();
                newRadioButton.setFont(new java.awt.Font("Comic Sans MS", 0, 24));
                newRadioButton.setForeground(new java.awt.Color(24, 167, 207));
                newRadioButton.setText(option);

                jPanel2.add(newRadioButton);
                bg.add(newRadioButton);

            }
        } else if(question.getType().equals("FIB")) {
            field = new JTextField();
            field.setFont(new java.awt.Font("Comic Sans MS", 0, 24)); // NOI18N
            field.setForeground(new java.awt.Color(24, 167, 207));
            jPanel2.add(field, BorderLayout.CENTER);
        } else if(question.getType().equals("Interactive")) {
            int counter = 0;
            JPanel interactivePanel = new JPanel(new GridLayout());
            
            for (String media: question.getMedia()){
                counter++;
                final int selectedImage = counter;
                JButton submitButton = new JButton();
                JLabel imageLabel, questionLabel;
                ImageIcon image;
                int correctAnswer;
                image = new ImageIcon(media);
                imageLabel = new JLabel(image);
                imageLabel.setPreferredSize(new Dimension(50,50));
                imageLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e){
                        for (Component c: interactivePanel.getComponents()){
                            if(c instanceof JLabel){
                                ((JLabel) c).setBorder(null);
                            }
                        }
                        Border border = imageLabel.getBorder();
                        if(border instanceof LineBorder && ((LineBorder) border).getLineColor().equals(Color.BLUE)){
                            TestUI.this.correctImage = 0;
                            imageLabel.setBorder(null);
                        }else{
                            TestUI.this.correctImage=selectedImage;
                            imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                        }
                    }  
                  
                });
                interactivePanel.setBackground(new java.awt.Color(255,204,204));
                interactivePanel.add(imageLabel);
            }
            jPanel2.add(interactivePanel);
        } else {
            gameUserAnswer = new ArrayList<>();
            JPanel answerPanel = new JPanel(new FlowLayout());
            JPanel questionPanel = new JPanel(new FlowLayout());
            
            JButton redoButton = new JButton();
            redoButton.setPreferredSize(new Dimension(40, 40));
            redoButton.setBackground(new java.awt.Color(24, 167, 207));
            redoButton.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
            redoButton.setForeground(new java.awt.Color(255, 153, 153));
            redoButton.setText("Redo");
            redoButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        answerPanel.removeAll();
                        gameUserAnswer.clear();
                        jPanel2.revalidate();
                        jPanel2.repaint();

                    }
                });
            
            jPanel2.add(redoButton);
            
            char[] word = question.getOptions().get(0).toCharArray();
            int length = question.getOptions().get(0).length();
            answerPanel.setPreferredSize(new Dimension(100, 100));
            questionPanel.setPreferredSize(new Dimension(50, 50));
            for(int i = 0; i<length;i++){
                final String letter = String.valueOf(word[i]);
                JButton jButton2 = new JButton();
                jButton2.setPreferredSize(new Dimension(40, 40));
                jButton2.setBackground(new java.awt.Color(24, 167, 207));
                jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
                jButton2.setForeground(new java.awt.Color(255, 153, 153));
                jButton2.setText(String.valueOf(word[i]));
                jButton2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        JLabel letterAdded = new JLabel();
                        letterAdded.setFont(new java.awt.Font("Comic Sans MS", 1, 36));
                        letterAdded.setBackground(new java.awt.Color(255, 102, 102));
                        letterAdded.setForeground(new java.awt.Color(255, 255, 0));
                        letterAdded.setText(letter);
                        letterAdded.setOpaque(true);
                        answerPanel.add(letterAdded);
                        gameUserAnswer.add(letter);
                    }
                });
                questionPanel.add(jButton2);
            }
            jPanel2.add(answerPanel);
            jPanel2.add(questionPanel);
            
        }
        jPanel2.revalidate();
        jPanel2.repaint();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}

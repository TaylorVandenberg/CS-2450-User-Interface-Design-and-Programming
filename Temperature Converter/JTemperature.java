import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class JTemperature{
   private static void createAndShowGUI(){
      JFrame frame = new JFrame("Temperature Converter");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //buttons and labels
      JLabel author = new JLabel("by T. Vandenberg");
      JLabel enter = new JLabel("Enter:");
      JLabel degreeF = new JLabel("degrees F");
      JLabel degreeC = new JLabel("degrees C");
      JTextField userInput = new JTextField(10);

      //action listener and conversion
      userInput.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(ActionEvent a) {
           String input = userInput.getText();
           try{//checks if input is valid and converts to celcius 
              float f = Float.parseFloat(input);
              float newTemp = (f-32)*5/9;
              degreeC.setText(String.format("= %.2f degrees C", newTemp));
           } catch (NumberFormatException e) {
              degreeC.setText("Invalid Input");
           } catch (NullPointerException e) {
            degreeC.setText("Invalid Input");
           }
         }
       });

      //panel setup
      JPanel panel = new JPanel();
      panel.setLayout(new BorderLayout());
      author.setHorizontalAlignment(JLabel.CENTER);
      panel.add(author, BorderLayout.NORTH);
      degreeC.setHorizontalAlignment(JLabel.RIGHT);
      panel.add(degreeC, BorderLayout.SOUTH);
      panel.add(enter, BorderLayout.WEST);
      panel.add(degreeF, BorderLayout.EAST);
      panel.add(userInput, BorderLayout.CENTER);

      //setting size and finishing the frame
      frame.setPreferredSize(new Dimension(240, 120));
      frame.add(panel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args){
      SwingUtilities.invokeLater(new Runnable(){
         public void run(){
            createAndShowGUI();
         }
      });
   }
}

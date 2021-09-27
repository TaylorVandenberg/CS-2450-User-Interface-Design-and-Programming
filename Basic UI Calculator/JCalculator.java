//Name:        Vandenberg, Taylor
//Project:     #2
//Due:         9/27/21
//Course:      CS-2450-F21
//Description:    A simple integer calculator built using Java Swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import javax.swing.BorderFactory;
public class JCalculator extends JFrame{
   String operator;
   int num1=0;
   int num2=0;
   int answer=0;
   JFrame frame;
   JLabel label;

   JCalculator(){
      frame = new JFrame("Calculator");
      frame.setLayout(new BorderLayout());
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //program icon
      ImageIcon photo = new ImageIcon("/user/tvnguyen7/cs2450-001/JCalculator.png");
      frame.setIconImage(photo.getImage());

      //screen
      JLabel label = new JLabel("0");
      label.setFont(label.getFont().deriveFont(45.0f));
      label.setHorizontalAlignment(SwingConstants.RIGHT);
      label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(4,4));

      //create buttons with listeners
      JButton b0 = new JButton("0");
      b0.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if(label.getText()=="0"){
               label.setText("0");
            }
            else{
               label.setText(label.getText()+"0");
            }
         }
      });

      JButton b1 = new JButton("1");
      b1.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if(label.getText()=="0"){
               label.setText("1");
            }
            else{
               label.setText(label.getText()+"1");
            }
         }
      });
         
      JButton b2 = new JButton("2");
      b2.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if(label.getText()=="0"){
               label.setText("2");
            }
            else{
               label.setText(label.getText()+"2");
            }
         }
      });

      JButton b3 = new JButton("3");
      b3.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if(label.getText()=="0"){
               label.setText("3");
            }
            else{
               label.setText(label.getText()+"3");
            }
         }
      });

      JButton b4 = new JButton("4");
      b4.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if(label.getText()=="0"){
               label.setText("4");
            }
            else{
               label.setText(label.getText()+"4");
            }
         }
      });

      JButton b5 = new JButton("5");
      b5.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if(label.getText()=="0"){
               label.setText("5");
            }
            else{
               label.setText(label.getText()+"5");
            }
         }
      });

      JButton b6 = new JButton("6");
      b6.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if(label.getText()=="0"){
               label.setText("6");
            }
            else{
               label.setText(label.getText()+"6");
            }
         }
      });

      JButton b7 = new JButton("7");
      b7.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if(label.getText()=="0"){
               label.setText("7");
            }
            else{
               label.setText(label.getText()+"7");
            }
         }
      });

      JButton b8 = new JButton("8");
      b8.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if(label.getText()=="0"){
               label.setText("8");
            }
            else{
               label.setText(label.getText()+"8");
            }
         }
      });

      JButton b9 = new JButton("9");
      b9.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if(label.getText()=="0"){
               label.setText("9");
            }
            else{
               label.setText(label.getText()+"9");
            }
         }
      });

      JButton add = new JButton("+");
      add.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if(num1==0){
               num1=Integer.parseInt(label.getText());
               label.setText("0");
               operator="+";
            }
            else{
               num2=Integer.parseInt(label.getText());
               answer=num1+num2;
               num2=0;
               answer=0;
               label.setText("0");
               operator="+";
            }
         }
      });

      JButton sub = new JButton("-");
      sub.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if(num1==0){
               num1=Integer.parseInt(label.getText());
               label.setText("0");
               operator="-";
            }
            else{
               num2=Integer.parseInt(label.getText());
               answer=num1-num2;
               num2=0;
               answer=0;
               label.setText("0");
               operator="-";
            }
         }
      });

      JButton mult = new JButton("X");
      mult.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if(num1==0){
               num1=Integer.parseInt(label.getText());
               label.setText("0");
               operator="*";
            }
            else{
               num2=Integer.parseInt(label.getText());
               answer=num1*num2;
               num2=0;
               answer=0;
               label.setText("0");
               operator="*";
            }
         }
      });

      JButton div = new JButton("/");
      div.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            try{
               if(num1==0){
                  num1=Integer.parseInt(label.getText());
                  label.setText("0");
                  operator="/";
               }
               else{
                  num2=Integer.parseInt(label.getText());
                  answer=num1/num2;
                  num2=0;
                  answer=0;
                  label.setText("0");
                  operator="/";
               }
            }catch (Exception f){
               label.setText("Div by 0");
            }
         }
      });

      JButton eq = new JButton("=");
      eq.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if(operator=="+"){
               num2=Integer.parseInt(label.getText());
               answer=num1+num2;
               label.setText(Integer.toString(answer));
               num1=answer;
            }
            else if(operator=="-"){
               num2=Integer.parseInt(label.getText());
               answer=num1-num2;
               label.setText(Integer.toString(answer));
               num1=answer;
            }
            else if(operator=="*"){
               num2=Integer.parseInt(label.getText());
               answer=num1*num2;
               label.setText(Integer.toString(answer));
               num1=answer;
            }
            else if(operator=="/"){
               try{
               num2=Integer.parseInt(label.getText());
               answer=num1/num2;
               label.setText(Integer.toString(answer));
               num1=answer;
               }catch(ArithmeticException f){
                  label.setText("Div by 0");
               }
            }
         }
      });

      frame.getRootPane().setDefaultButton(eq);

      JButton clear = new JButton("C");
      clear.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            if((e.getModifiers() & ActionEvent.CTRL_MASK)==ActionEvent.CTRL_MASK){
               label.setText("(c)Taylor Vandenberg");
            }
            else if((e.getModifiers() & ActionEvent.ALT_MASK)==ActionEvent.ALT_MASK){
               label.setText("0");
               answer=num1=num2=0;
            }
            else{
               label.setText("0");
               answer=num1=num2=0;
            }
         }
      });

      //add buttons to panel
      panel.add(b7);
      panel.add(b8);
      panel.add(b9);
      panel.add(div);
      panel.add(b4);
      panel.add(b5);
      panel.add(b6);
      panel.add(mult);
      panel.add(b1);
      panel.add(b2);
      panel.add(b3);
      panel.add(sub);
      panel.add(b0);
      panel.add(clear);
      panel.add(eq);
      panel.add(add);

      //window
      JPanel window = new JPanel();
      window.setLayout(new BorderLayout());
		window.add(label, BorderLayout.NORTH);
      window.add(panel, BorderLayout.SOUTH);
      frame.setSize(300,225);
		frame.add(window);
		frame.setVisible(true);
	}
   public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
         new JCalculator();
         }
      });
   }
}
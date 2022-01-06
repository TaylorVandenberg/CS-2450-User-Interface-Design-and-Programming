

//
//  Name: Vandenberg, Taylor
//  Project: #4
//  Due: October 29, 2021
//  Course: CS-2450-01-f21
//  Description:
//          A swing application that shows different dialog boxes

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class JPad{
    private static void createAndShowGUI(){
        JFrame frame = new JFrame("JPad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //panel setup
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //icon
        ImageIcon myIcon = new ImageIcon("JPad.png");
        frame.setIconImage(myIcon.getImage());

        //Centered Name Label
        JLabel name = new JLabel("T. Vandenberg", SwingConstants.CENTER);
        name.setOpaque(true);

        //Menu Bar Setup
        JMenuBar jmb = new JMenuBar();
        
        //JMenu File, includes JFileChooser
        JMenu jmFile = new JMenu("File");
        jmFile.setMnemonic('F');

        JMenuItem jmiOpen = new JMenuItem("Open... Ctrl+O", 'O');
        jmiOpen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser fc = new JFileChooser();
                int returnValue = fc.showOpenDialog(null);
                if(returnValue == JFileChooser.APPROVE_OPTION){
                    File file = fc.getSelectedFile();
                    name.setText(file.getAbsolutePath().toString());
                }
            }
        });
        jmFile.add(jmiOpen);

        jmFile.addSeparator();

        JMenuItem jmiExit = new JMenuItem("Exit", 'X');
        jmiExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int confirm = JOptionPane.showConfirmDialog(null, 
                    "Are you sure you want to exit the program?", "Exit Program Message Box",
                    JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        jmFile.add(jmiExit);

        jmb.add(jmFile);

        //JMenu Format, has multi layer deep menu
        JMenu jmFormat = new JMenu("Format");
        jmFormat.setMnemonic('o');

        JMenuItem jmiFont = new JMenuItem("Font...", 'F');
        //jmiFont.addActionListener(new ActionListener(){
         //   public void actionPerformed(ActionEvent e){
           //     Font myFont = JFontChooser.showDialog(frame, name.getFont());
           //     if(myFont != null)
             //       name.setFont(myFont);
            //}
        //});
        jmFormat.add(jmiFont);

        jmFormat.addSeparator();

        JMenu jmColor = new JMenu("Color");
        jmColor.setMnemonic('C');

        JMenuItem jmiForeground = new JMenuItem("Set Foreground... Ctrl+Alt+F", 'F');
        jmiForeground.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JColorChooser jcColor = new JColorChooser();
                Color userColor = jcColor.showDialog(null, "Select Foreground Color", Color.BLACK);
                name.setForeground(userColor);
            }
        });
        jmColor.add(jmiForeground);

        JMenuItem jmiBackground = new JMenuItem("Set Background...", 'B');
        jmiBackground.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JColorChooser jcColor = new JColorChooser();
                Color userColor = jcColor.showDialog(null, "Select Background Color", Color.BLACK);
                name.setBackground(userColor);
            }
        });
        jmColor.add(jmiBackground);

        jmFormat.add(jmColor);
        jmb.add(jmFormat);


        //JMenu Help
        JMenu jmHelp = new JMenu("Help");
        jmHelp.setMnemonic('H');

        JMenuItem jmiAbout = new JMenuItem("About", 'A');
        jmiAbout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(frame, "This program allows the user to view"
                                            +" filepaths of a selected file as well as changing"
                                            +" the font, style, size, and color\n"
                                            +" of the text. Created by Taylor Vandenberg 2021",
                                             "About", JOptionPane.INFORMATION_MESSAGE, myIcon);
                                    
            }
        });
        jmHelp.add(jmiAbout);
        jmb.add(jmHelp);

        //setting size and finishing frame
        panel.add(name, BorderLayout.NORTH);
        frame.setPreferredSize(new Dimension(500, 300));
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setJMenuBar(jmb);

    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
               createAndShowGUI();
            }
         });
    }
}

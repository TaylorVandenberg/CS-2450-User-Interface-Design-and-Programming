package project5;
//
//  Name: Vandenberg, Taylor
//  Project: #5
//  Due: November 12, 2021
//  Course: CS-2450-01-f21
//  Description:
//          A swing application that shows contact info stored in a text file

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Rolodex {

    private static JPanel addContact(){
        JPanel panel = new JPanel();
        return panel;
    }
    
    private static JPanel addContact(String name, String email, String pic){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JLabel myName = new JLabel("NAME: "+name);
        myName.setDisplayedMnemonic('N');
        JLabel myEmail = new JLabel("EMAIL: "+email);
        myEmail.setDisplayedMnemonic('E');
        JPanel myLabelPanel = new JPanel();
        myLabelPanel.setLayout(new BorderLayout());
        myLabelPanel.add(myName, BorderLayout.NORTH);
        myLabelPanel.add(myEmail, BorderLayout.CENTER);
        panel.add(myLabelPanel, BorderLayout.CENTER);

        ImageIcon contactPic = new ImageIcon(pic);
        JLabel taylorIconLabel = new JLabel();
        taylorIconLabel.setIcon(contactPic);
        panel.add(taylorIconLabel, BorderLayout.WEST);

        return panel;
    }

    private static void createAndShowGUI(){
        JFrame frame = new JFrame("Rolodex");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //panel setup
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //icon
        ImageIcon myIcon = new ImageIcon("Rolodex.png");
        frame.setIconImage(myIcon.getImage());

        //Tab Panes
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setTabPlacement(JTabbedPane.TOP);

        JPanel taylor = new JPanel();
        taylor.setLayout(new BorderLayout());
        JLabel myName = new JLabel("NAME: Vandenberg, Taylor");
        myName.setDisplayedMnemonic('N');
        JLabel myEmail = new JLabel("EMAIL: tdvandenberg@cpp.edu");
        myEmail.setDisplayedMnemonic('E');
        JPanel myLabelPanel = new JPanel();
        myLabelPanel.setLayout(new BorderLayout());
        myLabelPanel.add(myName, BorderLayout.NORTH);
        myLabelPanel.add(myEmail, BorderLayout.CENTER);
        taylor.add(myLabelPanel, BorderLayout.CENTER);

        ImageIcon taylorPic = new ImageIcon("nopic.png");
        JLabel taylorIconLabel = new JLabel();
        taylorIconLabel.setIcon(taylorPic);
        taylor.add(taylorIconLabel, BorderLayout.WEST);

        tabbedPane.addTab("Vandenberg, Taylor", taylor);
        

        //add contacts loop
        File file = new File("contacts.txt");
        try{
            Scanner contactFile = new Scanner(file);
            while (contactFile.hasNext()){
                String initialLine = contactFile.nextLine();
                String[] stringArray = initialLine.split(":");
                int i=0;
                JPanel newPanel = addContact(stringArray[0], stringArray[1], stringArray[2]);

                tabbedPane.addTab(stringArray[0], newPanel);
            }
        }catch (IOException e){
            System.out.println("error finding file");
        }
        
        panel.add(tabbedPane);

        //Menu Bar Setup
        JMenuBar jmb = new JMenuBar();
        
        //JMenu File
        JMenu jmFile = new JMenu("File");
        jmFile.setMnemonic(KeyEvent.VK_F);

        JMenuItem jmiOpen = new JMenuItem("Open... Ctrl+O", KeyEvent.VK_O);
        jmiOpen.setEnabled(false);
        jmFile.add(jmiOpen);

        jmFile.addSeparator();

        JMenuItem jmiExit = new JMenuItem("Exit", KeyEvent.VK_X);
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

        //JMenu Tabs
        JMenu jmTabs = new JMenu("Tabs");
        jmTabs.setMnemonic(KeyEvent.VK_T);

        JMenu jmPlacement = new JMenu("Placement");
        jmPlacement.setMnemonic(KeyEvent.VK_P);

        JMenuItem jmiTop = new JMenuItem("Top", KeyEvent.VK_T);
        jmiTop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                tabbedPane.setTabPlacement(JTabbedPane.TOP);
            }
        });
        jmPlacement.add(jmiTop);

        JMenuItem jmiRight = new JMenuItem("Right", KeyEvent.VK_R);
        jmPlacement.add(jmiRight);
        jmiRight.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                tabbedPane.setTabPlacement(JTabbedPane.RIGHT);
            }
        });

        JMenuItem jmiBottom = new JMenuItem("Bottom", KeyEvent.VK_B);
        jmiBottom.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
            }
        });
        jmPlacement.add(jmiBottom);
        
        JMenuItem jmiLeft = new JMenuItem("Left", KeyEvent.VK_L);
        jmiLeft.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                tabbedPane.setTabPlacement(JTabbedPane.LEFT);
            }
        });
        jmPlacement.add(jmiLeft);

        jmTabs.add(jmPlacement);

        JMenu jmLayout = new JMenu("Layout");
        jmLayout.setMnemonic(KeyEvent.VK_L);

        JMenuItem jmiScroll = new JMenuItem("Scroll", KeyEvent.VK_S);
        jmiScroll.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            }
        });
        jmLayout.add(jmiScroll);

        JMenuItem jmiWrap = new JMenuItem("Wrap", KeyEvent.VK_W);
        jmiWrap.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
            }
        });
        jmLayout.add(jmiWrap);

        jmTabs.add(jmLayout);
        jmTabs.addSeparator();

        

        JMenuItem jmiDefaults = new JMenuItem("Defaults");
        jmiDefaults.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                tabbedPane.setTabPlacement(JTabbedPane.TOP);
                tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            }
        });
        KeyStroke ctrlDKeyStroke = KeyStroke.getKeyStroke("control D");
        jmiDefaults.setAccelerator(ctrlDKeyStroke);
        jmTabs.add(jmiDefaults);

        
        jmb.add(jmTabs);

        //JMenu Help
        JMenu jmHelp = new JMenu("Help");
        jmHelp.setMnemonic(KeyEvent.VK_H);

        JMenuItem jmiAbout = new JMenuItem("About", KeyEvent.VK_A);
        jmiAbout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(frame, "Rolodex version 0.1"
                                            +"\n Copyright (c) 2021"
                                            +" T.Vandenberg",
                                             "About", JOptionPane.INFORMATION_MESSAGE, myIcon);
                                    
            }
        });
        jmHelp.add(jmiAbout);
        jmb.add(jmHelp);

        //setting size and finishing frame
        frame.setPreferredSize(new Dimension(400, 175));
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
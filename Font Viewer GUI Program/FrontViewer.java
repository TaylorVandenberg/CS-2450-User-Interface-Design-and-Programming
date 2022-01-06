//
//Name: Vandenberg, Taylor
//Project: #3
//Due: 10/8/21
//Course: CS-2450-01-F21
//Description:
//      Simple font preview program that lets user select a font 
//      and change the size as well as style of it using various 
//      buttons and sliders

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.*;
public class FrontViewer{
    private static void createAndShowGUI(){
        JFrame frame = new JFrame("Front Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //bottom text
        JLabel bottomText = new JLabel("the quick brown fox jumps over the lazy dog 0123456789", 
            SwingConstants.CENTER);
        Border bottomTextBorder = BorderFactory.createEtchedBorder();
        bottomText.setBorder(bottomTextBorder);

        //slider
        JSlider size = new JSlider(JSlider.HORIZONTAL, 8, 20, 10);
        size.setMajorTickSpacing(1);
        size.setMinorTickSpacing(1);
        size.setPaintTicks(true);
        size.setPaintLabels(true);
        bottomText.setFont(new Font(bottomText.getName(), 
                            bottomText.getFont().getStyle(), size.getValue()));
        String sliderTitle = ("Size:");
        Border sliderBorder = BorderFactory.createEtchedBorder();
        Border sliderTitleBorder = BorderFactory.
            createTitledBorder(sliderBorder, sliderTitle);
        size.setBorder(sliderTitleBorder);
        //Slider change listener relocated to below font list code
        
        //font list
        String fonts[]=
            GraphicsEnvironment.getLocalGraphicsEnvironment().
            getAvailableFontFamilyNames();
        JList list = new JList(fonts);
        list.setSelectedIndex(0);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        JScrollPane listScroller = new JScrollPane();
        listScroller.setViewportView(list);
        listScroller.setPreferredSize(new Dimension(150, 20));
        String scrollerTitle = ("Fonts:");
        Border scrollerBorder = BorderFactory.createEtchedBorder();
        Border scrollerTitleBorder = BorderFactory.
            createTitledBorder(scrollerBorder, scrollerTitle);
        listScroller.setBorder(scrollerTitleBorder);

        list.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if (e.getValueIsAdjusting() == false){
                    String userFont = list.getSelectedValue().toString();
                    bottomText.setFont(new Font(userFont, 
                                    bottomText.getFont().getStyle(), size.getValue()));
                }
            }
        });

        //Slider change listener
        size.addChangeListener(new ChangeListener(){
            public void stateChanged(ChangeEvent e){
                JSlider source = (JSlider)e.getSource();
                int textSize = source.getValue();
                bottomText.setFont(new Font(list.getSelectedValue().toString(), 
                                    bottomText.getFont().getStyle(), textSize));
            }
        });

        //JRadio buttons
        JRadioButton regularButton = new JRadioButton("Regular");
        regularButton.setSelected(true);
        JRadioButton italicButton = new JRadioButton("Italic");
        JRadioButton boldButton = new JRadioButton("Bold");
        ButtonGroup group = new ButtonGroup();
        group.add(regularButton);
        group.add(italicButton);
        group.add(boldButton);
        regularButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bottomText.setFont(new Font(list.getSelectedValue().toString(), 
                                            Font.PLAIN, size.getValue()));
            }
        });
        italicButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bottomText.setFont(new Font(list.getSelectedValue().toString(), 
                                            Font.ITALIC, size.getValue()));
            }
        });
        boldButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                bottomText.setFont(new Font(list.getSelectedValue().toString(), 
                                            Font.BOLD, size.getValue()));
            }
        });

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BorderLayout());
        radioPanel.add(regularButton, BorderLayout.NORTH);
        radioPanel.add(italicButton, BorderLayout.CENTER);
        radioPanel.add(boldButton, BorderLayout.SOUTH);

        String radioTitle = ("Style:");
        Border radioBorder = BorderFactory.createEtchedBorder();
        Border radioTitleBorder = BorderFactory.
            createTitledBorder(radioBorder, radioTitle);
        radioPanel.setBorder(radioTitleBorder);

        //Effects button
        JCheckBox allCaps = new JCheckBox("All Caps");
        JPanel capPanel = new JPanel();
        capPanel.add(allCaps);
        String capTitle = ("Effects");
        Border capBorder = BorderFactory.createEtchedBorder();
        Border capTitleBorder = BorderFactory.
            createTitledBorder(capBorder, capTitle);
        capPanel.setBorder(capTitleBorder);

        allCaps.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if (allCaps.isSelected()){
                    bottomText.setText(bottomText.getText().toUpperCase());
                }
                else{
                    bottomText.setText(bottomText.getText().toLowerCase());
                }
            }
        });

        //mnemonics
        regularButton.setMnemonic(KeyEvent.VK_R);
        italicButton.setMnemonic(KeyEvent.VK_I);
        boldButton.setMnemonic(KeyEvent.VK_B);
        allCaps.setMnemonic(KeyEvent.VK_C);  

        //panel setup
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(size, BorderLayout.NORTH);
        panel.add(listScroller, BorderLayout.WEST);
        panel.add(bottomText, BorderLayout.SOUTH);
        panel.add(radioPanel, BorderLayout.CENTER);
        panel.add(capPanel, BorderLayout.EAST);

        //setting size and finishing frame
        frame.setPreferredSize(new Dimension(500, 300));
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
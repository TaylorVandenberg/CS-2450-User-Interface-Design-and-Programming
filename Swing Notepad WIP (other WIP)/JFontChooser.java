

//
//  Name: Vandenberg, Taylor
//  Project: #4
//  Due: October 29, 2021
//  Course: CS-2450-01-f21
//  Description:
//          A swing application that shows different dialog boxes

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.*;

public class JFontChooser {
    
    private Font val;
    
    void setFont (Font newF) {
        val = newF;
    }
    
    Font getFont () {
        return val;
    }
    
    public static Font showDialog (JFrame parent, Font initialValue) {
        
        JFontChooser returnValue = new JFontChooser();
        returnValue.setFont(initialValue);
        JDialog dlg = new JDialog(parent, "Get Value", true);
        
        //slider
        JSlider size = new JSlider(JSlider.HORIZONTAL, 8, 20, 10);
        size.setMajorTickSpacing(1);
        size.setMinorTickSpacing(1);
        size.setPaintTicks(true);
        size.setPaintLabels(true);
        String sliderTitle = ("Size:");
        Border sliderBorder = BorderFactory.createEtchedBorder();
        Border sliderTitleBorder = BorderFactory.
            createTitledBorder(sliderBorder, sliderTitle);
        size.setBorder(sliderTitleBorder);

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

        //JRadio buttons
        JRadioButton regularButton = new JRadioButton("Regular");
        regularButton.setSelected(true);
        JRadioButton italicButton = new JRadioButton("Italic");
        JRadioButton boldButton = new JRadioButton("Bold");
        ButtonGroup group = new ButtonGroup();
        group.add(regularButton);
        group.add(italicButton);
        group.add(boldButton);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BorderLayout());
        radioPanel.add(regularButton, BorderLayout.NORTH);
        radioPanel.add(italicButton, BorderLayout.CENTER);
        radioPanel.add(boldButton, BorderLayout.SOUTH);

        String radioTitle = ("Style:");
        Border radioBorder = BorderFactory.createEtchedBorder();
        Border radioTitleBorder = BorderFactory.createTitledBorder(radioBorder, radioTitle);
        radioPanel.setBorder(radioTitleBorder);

        //Confirm button
        JButton confirmButton = new JButton("Confirm Changes");
        JButton cancelButton = new JButton("Cancel Changes");
        cancelButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                returnValue.setFont(null);
                dlg.setVisible(false);
            }
        });

        confirmButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (regularButton.isSelected())
				returnValue.setFont(new Font(list.getSelectedValue().toString(), Font.PLAIN, size.getValue()));
			else if (boldButton.isSelected())
				returnValue.setFont(new Font(list.getSelectedValue().toString(), Font.BOLD, size.getValue()));
			else
				returnValue.setFont(new Font(list.getSelectedValue().toString(), Font.ITALIC, size.getValue()));
			dlg.setVisible(false);
            }
        });
        JPanel conPanel = new JPanel();
        conPanel.setLayout(new BorderLayout());
        conPanel.add(confirmButton, BorderLayout.WEST);
        conPanel.add(cancelButton, BorderLayout.EAST);
        String capTitle = ("Save");
        Border capBorder = BorderFactory.createEtchedBorder();
        Border capTitleBorder = BorderFactory.
            createTitledBorder(capBorder, capTitle);
        conPanel.setBorder(capTitleBorder);

        

        //panel setup
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(size, BorderLayout.NORTH);
        panel.add(listScroller, BorderLayout.WEST);
        panel.add(radioPanel, BorderLayout.CENTER);
        panel.add(conPanel, BorderLayout.SOUTH);
        
        //setting size and finishing dlg
        dlg.setPreferredSize(new Dimension(500, 300));
        dlg.add(panel);
        dlg.pack();
        dlg.setLocationRelativeTo(parent);
        dlg.setVisible(true);
        
        return returnValue.getFont();
    }
}
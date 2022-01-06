// 
// Name:  Vandenberg, Taylor
// Project # 6
// Due:       12/3
// Course: cs-2450-01-f21 
// 
// Description: 
//  A notepad
// 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GoToDlg {
    private int value;
    private JDialog d;

    public void goToDlg(){
        value = 0;
    }

    void setValue (int value){
        this.value = value;
    }

    int getValue(){
        return value;
    }
    public void showDialog(){
        d = new JDialog();
        d.setSize(200, 110);
        d.setLayout(new BorderLayout());
        d.setModal(true);
        d.setLocationRelativeTo(null);
        JLabel label = new JLabel("Line number:");
        JTextField text = new JTextField();
        d.add(label, BorderLayout.NORTH);
        d.add(text, BorderLayout.CENTER);
        JButton goTo = new JButton("Go To");
        goTo.addActionListener((ae)-> {
            this.setValue(Integer.parseInt(text.getText()));
            d.dispose();
        });

        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                d.setVisible(false);
                d.dispose();
            }
        });
        JPanel f1 = new JPanel();
        f1.setLayout(new BorderLayout());
        f1.add(goTo, BorderLayout.EAST);
        f1.add(cancel, BorderLayout.WEST);
        d.add(f1, BorderLayout.SOUTH);
        d.setVisible(true);
    }
}

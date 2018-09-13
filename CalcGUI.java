import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calc extends JFrame{
    private static String buttons[][] = {
            {"7","8","9","+","*"},
            {"4","5","6","-","ANS"},
            {"1","2","3","/","="}
    };

    private static void main(String[] args){
        Frame frame = new Frame();
    }


    Calc() {
        this.setTitle("Calculator");
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //Create button listener
        /*
        ActionListener listener = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(e.getActionCommand()+" clicked");
            }
        };
        */

        //Buttonpanel
        JPanel buttonPanel = new JPanel();
        for(String[] row:buttons){
            for(String elementInButtonMatrix:row){
                //Create new button
                JButton button = new JButton(elementInButtonMatrix);
                //Set action command name for button
                //button.setActionCommand(elementInButtonMatrix);
                //Add listener
                //button.addActionListener(listener);
                //Add to panel
                buttonPanel.add(button);
            }
        }

        //Displaypanel
        JPanel displayPanel = new JPanel();
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayPanel.add(displayArea);


        this.add(displayPanel, BorderLayout.NORTH);
        this.add(buttonPanel,BorderLayout.CENTER);


        setVisible(true);


    }
}



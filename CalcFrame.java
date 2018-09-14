import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalcFrame extends JFrame{

    private JTextArea numberText;
    JButton button[] = new JButton[16];


    private String firstNum = "";
    private  String secondNum = "";
    private  String temp = "";
    double storage;
    double answer;

    int aritFlag = 0;

    /*
    AritFlag;
        0; No Flag
        1; Plus
        2; Minus
        3; Multiply
        4; Divide
     */

    private static String buttons[][] = {
            {"7","8","9","/"},
            {"4","5","6","*"},
            {"1","2","3","-"},
            {"0","Ans","+","="}
    };

    public static void main(String[] args){
        CalcFrame ex = new CalcFrame();

    }

    public CalcFrame() {

        this.setTitle("Example");
        this.setSize(300, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //Listeners
        ListenForButton lForButton = new ListenForButton();

        //HEYHEYEYJAJAJA
        //TESTER
        JPanel number = new JPanel();

        // Declaring Panels

        JPanel buttonPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        //Setting panel layouts

        buttonPanel.setLayout(new GridLayout(4,4));
        inputPanel.setLayout(new BorderLayout());

        // Add textarea, setting size
        numberText= new JTextArea();
        numberText.setPreferredSize(new Dimension(100,75));


        int i = 0;
        for(String[] row:buttons){
            for(String elementInButtonMatrix:row){
                //Create new button
                button[i] = new JButton(elementInButtonMatrix);
                //Set action command name for button



                //Add listener
                //button.addActionListener(listener);
                //Add to panel
                button[i].addActionListener(lForButton);
                buttonPanel.add(button[i]);
                i++;
            }
        }






        inputPanel.add(numberText, BorderLayout.CENTER);


        //Adding panels to frame

        this.add(inputPanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);

    }

    public class ListenForButton implements ActionListener {

        Arithmetic arit = new Arithmetic();



        public void actionPerformed(ActionEvent e){



            if(e.getSource() == button[15]){

                temp = numberText.getText();
                System.out.println("==== FUNKER");
                System.out.println("Second num :" + secondNum + "\n");
                if (aritFlag == 1) {


                    answer = arit.addNumber(firstNum,secondNum);
                    numberText.setText(temp + " = " + arit.addNumber(firstNum, secondNum));
                }
                if (aritFlag == 2) {

                    answer = arit.subNumber(firstNum,secondNum);
                    numberText.setText(temp + " = " + arit.subNumber(firstNum, secondNum));
                }
                if (aritFlag == 3) {

                    answer = arit.multNumber(firstNum,secondNum);
                    numberText.setText(temp + " = " + arit.multNumber(firstNum, secondNum));
                }
                if (aritFlag == 4) {
                    if(secondNum.equals("0")){
                        numberText.setText("Don't divide by zero buddy");
                    } else {

                        answer = arit.divNumber(firstNum, secondNum);
                        numberText.setText(temp + " = " + arit.divNumber(firstNum, secondNum));
                    }
                }


                firstNum = secondNum = "";


                aritFlag = -1;


            }

            if(e.getSource() == button[14]){

                if(aritFlag == 0) {
                    numberText.append("+");
                    aritFlag = 1;
                }
            }

            if(e.getSource() == button[11]){
                if(aritFlag == 0) {
                    numberText.append("-");
                    aritFlag = 2;
                }
            }

            if(e.getSource() == button[7]){
                if(aritFlag == 0) {
                    numberText.append("*");
                    aritFlag = 3;
                }
            }

            if(e.getSource() == button[3]){
                if(aritFlag == 0) {
                    numberText.append("/");
                    aritFlag = 4;
                }
            }

            if(e.getSource() == button[13]){
                if(storage == 0){
                    storage = answer;
                    System.out.println(answer + " saved to memory");
                    numberText.setText(answer + "saved to memory");
                } else {
                    firstNum = Double.toString(answer);

                    System.out.println(answer + " retrieved from memory");
                }


            }

            if(e.getSource() == button[8]){
                if(aritFlag == 0){
                    firstNum += "1";

                }
                if(aritFlag != 0) {
                    secondNum += 1;
                }

            }

            if(e.getSource() == button[9]){
                if(aritFlag == 0){
                    firstNum += "2";
                }
                if(aritFlag != 0){
                    secondNum += "2";
                }

            }
            if(e.getSource() == button[10]){
                if(aritFlag == 0){
                    firstNum += "3";
                }
                if(aritFlag != 0){
                    secondNum += "3";
                }
            }
            if(e.getSource() == button[4]){
                if(aritFlag == 0){
                    firstNum += "4";
                }
                if(aritFlag != 0){
                    secondNum += "4";
                }
            }
            if(e.getSource() == button[5]){
                if(aritFlag == 0){
                    firstNum += "5";
                }
                if(aritFlag != 0){
                    secondNum += "5";
                }
            }
            if(e.getSource() == button[6]){
                if(aritFlag == 0){
                    firstNum += "6";
                }
                if(aritFlag != 0){
                    secondNum += "6";
                }
            }
            if(e.getSource() == button[0]){
                if(aritFlag == 0){
                    firstNum += "7";
                }
                if(aritFlag != 0){
                    secondNum += "7";
                }
            }

            if(e.getSource() == button[1]){
                if(aritFlag == 0){
                    firstNum += "8";
                }
                if(aritFlag != 0){
                    secondNum += "8";
                }
            }
            if(e.getSource() == button[2]){
                if(aritFlag == 0){
                    firstNum += "9";
                }
                if(aritFlag != 0){
                    secondNum += "9";
                }
            }
            if(e.getSource() == button[12]){
                if(aritFlag == 0){
                    firstNum += "0";
                }
                if(aritFlag != 0){
                    secondNum += "0";
                }
            }

            setText();



        }
    }

    public void setText() {
        if(aritFlag == 0){
            numberText.setText(firstNum + " ");
        }
        if(aritFlag > 0){

            temp = numberText.getText();
            numberText.setText(temp + " " + secondNum + "");
        }
        if(aritFlag == -1){
            aritFlag = 0;
        }

    }

    public void clearText() {
        numberText.setText("");

    }
















}

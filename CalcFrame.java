import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcFrame extends JFrame{

    public JButton oneBut, twoBut, threeBut, fourBut, fiveBut, sixBut, sevenBut,
            eightBut, nineBut, zeroBut, plusBut, minusBut, multBut, divBut, equalsBut;
    JTextArea numberText;

    String firstNum = "";
    String secondNum = "";
    String temp ="";
    int aritFlag = 0;

    /*
    AritFlag;
        0; No Flag
        1; Plus
        2; Minus
        3; Multiply
        4; Divide
     */

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

        JPanel numberPanel = new JPanel();
        JPanel inputPanel = new JPanel();
        JPanel aritPanel = new JPanel();

        //Setting panel layouts

        numberPanel.setLayout(new GridLayout(4,3));
        aritPanel.setLayout(new GridLayout(4,1));
        inputPanel.setLayout(new BorderLayout());

        // Add textarea, setting size
        JTextArea numberText= new JTextArea("Heyhey");
        numberText.setPreferredSize(new Dimension(100,75));



        // Declare buttons, adding to panel

        plusBut = new JButton("+");
        plusBut.addActionListener(lForButton);

        minusBut= new JButton("-");
        minusBut.addActionListener(lForButton);

        multBut = new JButton("*");
        multBut.addActionListener(lForButton);

        divBut = new JButton("/");
        divBut.addActionListener(lForButton);

        equalsBut = new JButton("=");
        equalsBut.addActionListener(lForButton);

        oneBut = new JButton("1");
        oneBut.addActionListener(lForButton);

        twoBut = new JButton("2");
        twoBut.addActionListener(lForButton);

        threeBut = new JButton("3");
        threeBut.addActionListener(lForButton);

        fourBut = new JButton("4");
        fourBut.addActionListener(lForButton);

        fiveBut = new JButton("5");
        fiveBut.addActionListener(lForButton);

        sixBut = new JButton("6");
        sixBut.addActionListener(lForButton);

        sevenBut = new JButton("7");
        sevenBut.addActionListener(lForButton);

        eightBut = new JButton("8");
        eightBut.addActionListener(lForButton);

        nineBut = new JButton("9");
        nineBut.addActionListener(lForButton);

        zeroBut = new JButton("0");
        zeroBut.addActionListener(lForButton);


        //Adding buttons to panel


        numberPanel.add(sevenBut);
        numberPanel.add(eightBut);
        numberPanel.add(nineBut);
        numberPanel.add(divBut);
        numberPanel.add(fourBut);
        numberPanel.add(fiveBut);
        numberPanel.add(sixBut);
        numberPanel.add(multBut);
        numberPanel.add(oneBut);
        numberPanel.add(twoBut);
        numberPanel.add(threeBut);
        numberPanel.add(minusBut);
        numberPanel.add(zeroBut);
        numberPanel.add(plusBut);
        numberPanel.add(equalsBut);

        inputPanel.add(numberText, BorderLayout.CENTER);


        //Adding panels to frame

        this.add(inputPanel, BorderLayout.NORTH);
        this.add(numberPanel, BorderLayout.CENTER);
        this.add(aritPanel, BorderLayout.EAST);

        setVisible(true);
        
    }

    public class ListenForButton implements ActionListener {

        Arithmetic arit = new Arithmetic();

        public void actionPerformed(ActionEvent e){

            if(e.getSource() == equalsBut){


                    System.out.println("Second num :" + secondNum + "\n");
                    if (aritFlag == 1) {


                        temp = Integer.toString((arit.addNumber(firstNum, secondNum)));
                        numberText.setText(temp);
                    }
                    if (aritFlag == 2) {

                        System.out.println( arit.subNumber(firstNum, secondNum));
                    }
                    if (aritFlag == 3) {

                        numberText.setText("" + arit.multNumber(firstNum, secondNum));
                    }
                    if (aritFlag == 4) {

                        numberText.setText("" + arit.divNumber(firstNum, secondNum));
                    }


                    firstNum = secondNum = "";


                aritFlag = 0;
            }

            if(e.getSource() == plusBut){
                System.out.println("Number 1: " + firstNum);
                aritFlag = 1;
            }

            if(e.getSource() == minusBut){
                System.out.println("Number 1: " + firstNum);
                aritFlag = 2;
            }

            if(e.getSource() == multBut){
                aritFlag = 3;
            }

            if(e.getSource() == divBut){
                aritFlag = 4;
            }

            if(e.getSource() == oneBut){
                if(aritFlag == 0){
                    firstNum += "1";

                }
                if(aritFlag != 0) {
                    secondNum += 1;
                }


            }

            if(e.getSource() == twoBut){
                if(aritFlag == 0){
                    firstNum += "2";
                }
                if(aritFlag != 0){
                    secondNum += "2";
                }

            }
            if(e.getSource() == threeBut){
                if(aritFlag == 0){
                    firstNum += "3";
                }
                if(aritFlag != 0){
                    secondNum += "3";
                }
            }
            if(e.getSource() == fourBut){
                if(aritFlag == 0){
                    firstNum += "4";
                }
                if(aritFlag != 0){
                    secondNum += "4";
                }
            }
            if(e.getSource() == fiveBut){
                if(aritFlag == 0){
                    firstNum += "5";
                }
                if(aritFlag != 0){
                    secondNum += "5";
                }
            }
            if(e.getSource() == sixBut){
                if(aritFlag == 0){
                    firstNum += "6";
                }
                if(aritFlag != 0){
                    secondNum += "6";
                }
            }
            if(e.getSource() == sevenBut){
                if(aritFlag == 0){
                    firstNum += "7";
                }
                if(aritFlag != 0){
                    secondNum += "7";
                }
            }

            if(e.getSource() == eightBut){
                if(aritFlag == 0){
                    firstNum += "8";
                }
                if(aritFlag != 0){
                    secondNum += "8";
                }
            }
            if(e.getSource() == nineBut){
                if(aritFlag == 0){
                    firstNum += "9";
                }
                if(aritFlag != 0){
                    secondNum += "9";
                }
            }
            if(e.getSource() == zeroBut){
                if(aritFlag == 0){
                    firstNum += "0";
                }
                if(aritFlag != 0){
                    secondNum += "0";
                }
            }



        }
    }

    public void setText() {
        if(aritFlag == 0){
            numberText.setText(firstNum + " ");
        }
        if(aritFlag != 0){
            numberText.append(secondNum + "");
        }

    }
















}

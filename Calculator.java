



int operator = 0;
String currentNumber;
String newNumber;
int a;
int b;
int answer;
String answerString;

public void actionPerformed(ActionEvent e){
    if(e.getActionCommand().isEqual("1")){
        textOut.setText = (textOut.getText() + b1.getText());
        newNumber = Integer.parseInt(textOut.getText());
        }else if(e.getSource() == addBut){
            operator = 1;
            currentNumber = newNumber;
            textOut.setText = ("");
        }else if(e.getSource() == equaBut){
            b = Integer.parseInt(newNumber);
            a = Integer.parseInt(currentNumber);
            if(operator = 1){
                answer = a+b;
                answerString = Integer.toString(int);
                textOut.setText = answerString;
        }
        }

}
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * @author 10mcleodr
 */


/**
 * Structure:
 * 
 * - Set base values
 * - Load GUI
 *      - Load Buttons
 *      - Load Digit Screen
 *      - Load Frame
 * - Handle inputs
 * - Close.
 */

class aCalculator implements ActionListener {

    static JFrame frame = new JFrame();
    static JTextField calcScreen = new JTextField();
    static Container con = frame.getContentPane();
    static JButton[] buttonArray = new JButton[11];
    static JButton[] operatorArray = new JButton[5];
    String value1 = "", value2 = "";
    Double value1_Double, value2_Double, result;

    public static void main(String[] args) {
        /*
         * Sets the dimensions and text of the calculator buttons.
         */
        setValues();

        /*
         * Sets the bounds (locations) of the buttons on the calculator.
         */
        setBounds();

        /*
         * Constructs a new calculator using the constructor (aCalculator).
         */
        aCalculator newCalc = new aCalculator();

        /*
         * Adds button listeners to the newly constructed calculator.
         */
        newCalc.addListeners();

        /*
         * Loads the calculator frame (GUI)
         */
        loadFrame();
    }

    /* Builds, sets out and loads the JFrame layout for the GUI */
    public static void loadFrame() {
        frame.setLayout(null);
        frame.setSize(250, 325);
        frame.setLocationRelativeTo(null); //Centre's the frame
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("A453 Project - Calculator");
        frame.setVisible(true);
        System.out.println("[A453 Programming Project - Task One: Calculator]");
    }

    /* Adds a set of button listeners*/
    public void addListeners() {
        for (int i = 0; i < buttonArray.length; i++) {
            buttonArray[i].setActionCommand(String.valueOf(i));
            buttonArray[i].addActionListener(this);
        }
        for (int i = 0; i < operatorArray.length; i++) {
            operatorArray[i].addActionListener(this);
        }
        operatorArray[0].setActionCommand("+");
        operatorArray[1].setActionCommand("-");
        operatorArray[2].setActionCommand("*");
        operatorArray[3].setActionCommand("/");
        buttonArray[10].setActionCommand("C");
    }

    /* Set's the values of the JButtons, referenced statically by main method */
    public static void setValues() {
        /*
         * - Set's all the values in the buttonArray[] array to 1,2,3, etc
         * - Set's the size of each button (50x50)
         * - Adds the buttonArray[] buttons to the content pane of the JFrame.
         */
        for (int i = 1; i < (buttonArray.length - 1); i++) {
            buttonArray[i] = new JButton("" + i + "");
            buttonArray[i].setSize(new Dimension(40, 40));
            con.add(buttonArray[i]);
        }
        buttonArray[0] = new JButton("0");
        buttonArray[0].setSize(new Dimension(14, 14));
        buttonArray[10] = new JButton("C");
        buttonArray[10].setSize(new Dimension(14, 14));

        con.add(buttonArray[0]);
        con.add(buttonArray[10]);

        operatorArray[0] = new JButton("+");
        operatorArray[1] = new JButton("-");
        operatorArray[2] = new JButton("*");
        operatorArray[3] = new JButton("/");
        operatorArray[4] = new JButton("=");
        operatorArray[0].setSize(new Dimension(40, 40));
        operatorArray[1].setSize(new Dimension(40, 40));
        operatorArray[2].setSize(new Dimension(40, 40));
        operatorArray[3].setSize(new Dimension(40, 40));
        operatorArray[4].setSize(new Dimension(40, 40));
        con.add(operatorArray[0]);
        con.add(operatorArray[1]);
        con.add(operatorArray[2]);
        con.add(operatorArray[3]);
        con.add(operatorArray[4]);

        calcScreen.setEditable(false);
        calcScreen.setSize(new Dimension(230, 120));
        calcScreen.setHorizontalAlignment(JTextField.CENTER);
        con.add(calcScreen);
    }

    /* Sets the location of each button on the inteface. */
    public static void setBounds() {
        /* setBounds(Double x, Double y, Double width, Double height) */
        buttonArray[0].setBounds(10, 250, 45, 30);
        buttonArray[1].setBounds(10, 210, 45, 30);
        buttonArray[2].setBounds(65, 210, 45, 30);
        buttonArray[3].setBounds(120, 210, 45, 30);
        buttonArray[4].setBounds(10, 170, 45, 30);
        buttonArray[5].setBounds(65, 170, 45, 30);
        buttonArray[6].setBounds(120, 170, 45, 30);
        buttonArray[7].setBounds(10, 130, 45, 30);
        buttonArray[8].setBounds(65, 130, 45, 30);
        buttonArray[9].setBounds(120, 130, 45, 30);
        buttonArray[10].setBounds(65, 250, 45, 30);
        operatorArray[0].setBounds(180, 250, 45, 30);
        operatorArray[1].setBounds(180, 210, 45, 30);
        operatorArray[2].setBounds(180, 170, 45, 30);
        operatorArray[3].setBounds(180, 130, 45, 30);
        operatorArray[4].setBounds(120, 250, 45, 30);
        calcScreen.setBounds(10, 10, 215, 110);
    }

    /* Returns the correct operator as read from the calculator screen */
    public static String getOperator() {
        if (calcScreen.getText().contains("+")) {
            return " + ";
        }
        if (calcScreen.getText().contains("-")) {
            return " - ";
        }
        if (calcScreen.getText().contains("*")) {
            return " * ";
        }
        if (calcScreen.getText().contains("/")) {
            return " / ";
        }
        return "N/A";
    }

    /* Main program logic */
    @Override
    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();

        switch (cmd) {

            case "0":

                if (calcScreen.getText().contains("+") || calcScreen.getText().contains("-") || calcScreen.getText().contains("*") || calcScreen.getText().contains("/")) {
                    if (value2.equals("")) {
                        value2 = "0";
                        calcScreen.setText(value1 + getOperator() + value2);
                    } else {
                        value2 += "0";
                        calcScreen.setText(value1 + getOperator() + value2);
                    }
                } else {
                    if (calcScreen.getText().equals("")) {
                        value1 = "0";
                        calcScreen.setText(value1);
                    } else {
                        value1 += "0";
                        calcScreen.setText(value1);
                    }
                }

                break;

            case "1":
                if (calcScreen.getText().contains("+") || calcScreen.getText().contains("-") || calcScreen.getText().contains("*") || calcScreen.getText().contains("/")) {
                    if (value2.equals("")) {
                        value2 = "1";
                        calcScreen.setText(value1 + getOperator() + value2);
                    } else {
                        value2 += "1";
                        calcScreen.setText(value1 + getOperator() + value2);
                    }
                } else {
                    if (calcScreen.getText().equals("")) {
                        value1 = "1";
                        calcScreen.setText(value1);
                    } else {
                        value1 += "1";
                        calcScreen.setText(value1);
                    }
                }
                break;

            case "2":
                if (calcScreen.getText().contains("+") || calcScreen.getText().contains("-") || calcScreen.getText().contains("*") || calcScreen.getText().contains("/")) {
                    if (value2.equals("")) {
                        value2 = "2";
                        calcScreen.setText(value1 + getOperator() + value2);
                    } else {
                        value2 += "2";
                        calcScreen.setText(value1 + getOperator() + value2);
                    }
                } else {
                    if (calcScreen.getText().equals("")) {
                        value1 = "2";
                        calcScreen.setText(value1);
                    } else {
                        value1 += "2";
                        calcScreen.setText(value1);
                    }
                }
                break;

            case "3":
                if (calcScreen.getText().contains("+") || calcScreen.getText().contains("-") || calcScreen.getText().contains("*") || calcScreen.getText().contains("/")) {
                    if (value2.equals("")) {
                        value2 = "3";
                        calcScreen.setText(value1 + getOperator() + value2);
                    } else {
                        value2 += "3";
                        calcScreen.setText(value1 + getOperator() + value2);
                    }
                } else {
                    if (calcScreen.getText().equals("")) {
                        value1 = "3";
                        calcScreen.setText(value1);
                    } else {
                        value1 += "3";
                        calcScreen.setText(value1);
                    }
                }
                break;

            case "4":
                if (calcScreen.getText().contains("+") || calcScreen.getText().contains("-") || calcScreen.getText().contains("*") || calcScreen.getText().contains("/")) {
                    if (value2.equals("")) {
                        value2 = "4";
                        calcScreen.setText(value1 + getOperator() + value2);
                    } else {
                        value2 += "4";
                        calcScreen.setText(value1 + getOperator() + value2);
                    }
                } else {
                    if (calcScreen.getText().equals("")) {
                        value1 = "4";
                        calcScreen.setText(value1);
                    } else {
                        value1 += "4";
                        calcScreen.setText(value1);
                    }
                }
                break;

            case "5":
                if (calcScreen.getText().contains("+") || calcScreen.getText().contains("-") || calcScreen.getText().contains("*") || calcScreen.getText().contains("/")) {
                    if (value2.equals("")) {
                        value2 = "5";
                        calcScreen.setText(value1 + getOperator() + value2);
                    } else {
                        value2 += "5";
                        calcScreen.setText(value1 + getOperator() + value2);
                    }
                } else {
                    if (calcScreen.getText().equals("")) {
                        value1 = "5";
                        calcScreen.setText(value1);
                    } else {
                        value1 += "5";
                        calcScreen.setText(value1);
                    }
                }
                break;

            case "6":
                if (calcScreen.getText().contains("+") || calcScreen.getText().contains("-") || calcScreen.getText().contains("*") || calcScreen.getText().contains("/")) {
                    if (value2.equals("")) {
                        value2 = "6";
                        calcScreen.setText(value1 + getOperator() + value2);
                    } else {
                        value2 += "6";
                        calcScreen.setText(value1 + getOperator() + value2);
                    }
                } else {
                    if (calcScreen.getText().equals("")) {
                        value1 = "6";
                        calcScreen.setText(value1);
                    } else {
                        value1 += "6";
                        calcScreen.setText(value1);
                    }
                }
                break;

            case "7":
                if (calcScreen.getText().contains("+") || calcScreen.getText().contains("-") || calcScreen.getText().contains("*") || calcScreen.getText().contains("/")) {
                    if (value2.equals("")) {
                        value2 = "7";
                        calcScreen.setText(value1 + getOperator() + value2);
                    } else {
                        value2 += "7";
                        calcScreen.setText(value1 + getOperator() + value2);
                    }
                } else {
                    if (calcScreen.getText().equals("")) {
                        value1 = "7";
                        calcScreen.setText(value1);
                    } else {
                        value1 += "7";
                        calcScreen.setText(value1);
                    }
                }
                break;

            case "8":
                if (calcScreen.getText().contains("+") || calcScreen.getText().contains("-") || calcScreen.getText().contains("*") || calcScreen.getText().contains("/")) {
                    if (value2.equals("")) {
                        value2 = "8";
                        calcScreen.setText(value1 + getOperator() + value2);
                    } else {
                        value2 += "8";
                        calcScreen.setText(value1 + getOperator() + value2);
                    }
                } else {
                    if (calcScreen.getText().equals("")) {
                        value1 = "8";
                        calcScreen.setText(value1);
                    } else {
                        value1 += "8";
                        calcScreen.setText(value1);
                    }
                }
                break;

            case "9":
                if (calcScreen.getText().contains("+") || calcScreen.getText().contains("-") || calcScreen.getText().contains("*") || calcScreen.getText().contains("/")) {
                    if (value2.equals("")) {
                        value2 = "9";
                        calcScreen.setText(value1 + getOperator() + value2);
                    } else {
                        value2 += "9";
                        calcScreen.setText(value1 + getOperator() + value2);
                    }
                } else {
                    if (calcScreen.getText().equals("")) {
                        value1 = "9";
                        calcScreen.setText(value1);
                    } else {
                        value1 += "9";
                        calcScreen.setText(value1);
                    }
                }
                break;

            case "C":
                value1 = "";
                value2 = "";
                value1_Double = 0.0;
                value2_Double = 0.0;
                result = 0.0;
                System.out.println("Memory cleared.");
                calcScreen.setText("");
                break;

            case "+":
                if (value1.equals("")) {
                    return;
                }
                value1_Double = Double.valueOf(value1);
                //System.out.prDoubleln("value1_Double = "+value1_Double);
                calcScreen.setText(value1 + " + ");
                break;

            case "-":
                if (value1.equals("")) {
                    return;
                }
                value1_Double = Double.valueOf(value1);
                //System.out.prDoubleln("value1_Double = "+value1_Double);
                calcScreen.setText(value1 + " - ");
                break;

            case "*":
                if (value1.equals("")) {
                    return;
                }
                value1_Double = Double.valueOf(value1);
                //System.out.prDoubleln("value1_Double = "+value1_Double);
                calcScreen.setText(value1 + " * ");
                break;

            case "/":
                if (value1.equals("")) {
                    return;
                }
                value1_Double = Double.valueOf(value1);
                //System.out.prDoubleln("value1_Double = "+value1_Double);
                calcScreen.setText(value1 + " / ");
                break;

            case "=":
                if (value1.equals("") || value2.equals("")) {
                    return;
                }
                value2_Double = Double.valueOf(value2);

                if (calcScreen.getText().contains("+")) {
                    result = (value1_Double + value2_Double);
                }
                if (calcScreen.getText().contains("-")) {
                    result = (value1_Double - value2_Double);
                }
                if (calcScreen.getText().contains("*")) {
                    result = (value1_Double * value2_Double);
                }
                if (calcScreen.getText().contains("/")) {
                    result = (value1_Double / value2_Double);
                }
                calcScreen.setText("Answer: " + result);
                //System.out.prDoubleln("[DEBUG] Answer: "+result);
                break;
        }
    }
}
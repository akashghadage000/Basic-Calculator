import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicCalculator extends JFrame {
    JTextField t1, t2, t3;
    JButton add, subtract, multiply, divide;

    public BasicCalculator() {
        setTitle("Basic Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel L1 = new JLabel("Number 1:");
        t1 = new JTextField(10);

        JLabel L2 = new JLabel("Number 2:");
        t2 = new JTextField(10);

        JLabel L3 = new JLabel("Result:");
        t3 = new JTextField(10);
        t3.setEditable(false);

        add = new JButton("+");
        subtract= new JButton("-");
        multiply = new JButton("*");
        divide = new JButton("/");

        add.addActionListener(new OperationButtonListener());
        subtract.addActionListener(new OperationButtonListener());
        multiply.addActionListener(new OperationButtonListener());
        divide.addActionListener(new OperationButtonListener());

        add(L1);
       add(t1);
        add(L2);
        add(t2);
        add(L3);
       add(t3);
       add(add);
       add(subtract);
       add(multiply);
        add(divide);
        setVisible(true);
    }

    private class OperationButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            try {
                double num1 = Double.parseDouble(t1.getText());
                double num2 = Double.parseDouble(t2.getText());
                double result = 0;

                if (event.getSource() == add) {
                    result = num1 + num2;
                } else if (event.getSource() == subtract) {
                    result = num1 - num2;
                } else if (event.getSource() == multiply) {
                    result = num1 * num2;
                } else if (event.getSource() == divide) {
                    if (num2 == 0) {
                        t3.setText("Error: Division by zero");
                        return;
                    } else {
                        result = num1 / num2;
                    }
                }

                t3.setText(Double.toString(result));
            } catch (NumberFormatException e) {
                t3.setText("Invalid input! Please enter valid numbers.");
            }
        }
    }

    public static void main(String[] args) {

        BasicCalculator ob=new BasicCalculator();
    }
}


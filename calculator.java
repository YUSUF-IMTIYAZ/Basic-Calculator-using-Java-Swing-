import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator extends JFrame implements ActionListener {
    private JTextField input1, input2, result;
    private JButton addBtn, subBtn, mulBtn, divBtn;

    public calculator() {
        setTitle("Simple Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel("Number 1:"));
        input1 = new JTextField();
        add(input1);

        add(new JLabel("Number 2:"));
        input2 = new JTextField();
        add(input2);

        addBtn = new JButton("Add");
        subBtn = new JButton("Subtract");
        mulBtn = new JButton("Multiply");
        divBtn = new JButton("Divide");

        addBtn.addActionListener(this);
        subBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        divBtn.addActionListener(this);

        add(addBtn);
        add(subBtn);
        add(mulBtn);
        add(divBtn);

        add(new JLabel("Result:"));
        result = new JTextField();
        result.setEditable(false);
        add(result);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(input1.getText());
            double num2 = Double.parseDouble(input2.getText());
            double res = 0;

            if (e.getSource() == addBtn) {
                res = num1 + num2;
            } else if (e.getSource() == subBtn) {
                res = num1 - num2;
            } else if (e.getSource() == mulBtn) {
                res = num1 * num2;
            } else if (e.getSource() == divBtn) {
                if (num2 != 0) {
                    res = num1 / num2;
                } else {
                    result.setText("Error: Divide by zero");
                    return;
                }
            }
            result.setText(String.valueOf(res));
        } catch (NumberFormatException ex) {
            result.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new calculator();
    }
}

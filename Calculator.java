import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JTextField display;
    private double num1 = 0;
    private double num2 = 0;
    private char operator;

    public Calculator() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4));
        frame.add(buttonPanel, BorderLayout.CENTER);

        for (int i = 1; i <= 9; i++) {
            addButton(buttonPanel, String.valueOf(i));
        }
        addButton(buttonPanel, "0");

        addButton(buttonPanel, "+");
        addButton(buttonPanel, "-");
        addButton(buttonPanel, "*");
        addButton(buttonPanel, "/");
        addButton(buttonPanel, "=");
        addButton(buttonPanel, "C");

        frame.setVisible(true);
    }

    private void addButton(Container container, String text) {
        JButton button = new JButton(text);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (text.equals("=")) {
                    calculate();
                } else if (text.equals("C")) {
                    clear();
                } else if ("+-*/".contains(text)) {
                    operator = text.charAt(0);
                    num1 = Double.parseDouble(display.getText());
                    display.setText("");
                } else {
                    display.setText(display.getText() + text);
                }
            }
        });
        container.add(button);
    }

    private void calculate() {
        num2 = Double.parseDouble(display.getText());
        switch (operator) {
            case '+':
                display.setText(String.valueOf(num1 + num2));
                break;
            case '-':
                display.setText(String.valueOf(num1 - num2));
                break;
            case '*':
                display.setText(String.valueOf(num1 * num2));
                break;
            case '/':
                if (num2 != 0) {
                    display.setText(String.valueOf(num1 / num2));
                } else {
                    display.setText("Error: Division by zero");
                }
                break;
        }
    }

    private void clear() {
        display.setText("");
        num1 = 0;
        num2 = 0;
    }

    public static void main(String[] args) {
        new Calculator();
    }
}

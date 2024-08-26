import javax.swing.*;
import java.awt.*;

public class CalculatorApp {
    private JFrame frame;
    private JTextField number1Field;
    private JTextField number2Field;
    private JLabel resultLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CalculatorApp window = new CalculatorApp();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public CalculatorApp() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNumber1 = new JLabel("Number 1:");
        lblNumber1.setBounds(50, 30, 70, 30);
        frame.getContentPane().add(lblNumber1);

        number1Field = new JTextField();
        number1Field.setBounds(130, 30, 100, 30);
        frame.getContentPane().add(number1Field);
        number1Field.setColumns(10);

        JLabel lblNumber2 = new JLabel("Number 2:");
        lblNumber2.setBounds(50, 70, 70, 30);
        frame.getContentPane().add(lblNumber2);

        number2Field = new JTextField();
        number2Field.setBounds(130, 70, 100, 30);
        frame.getContentPane().add(number2Field);
        number2Field.setColumns(10);

        JButton btnAdd = new JButton("Add");
        btnAdd.setBounds(50, 110, 100, 30);
        frame.getContentPane().add(btnAdd);

        JButton btnSubtract = new JButton("Subtract");
        btnSubtract.setBounds(160, 110, 100, 30);
        frame.getContentPane().add(btnSubtract);

        JButton btnMultiply = new JButton("Multiply");
        btnMultiply.setBounds(270, 110, 100, 30);
        frame.getContentPane().add(btnMultiply);

        JButton btnDivide = new JButton("Divide");
        btnDivide.setBounds(50, 150, 100, 30);
        frame.getContentPane().add(btnDivide);

        JButton btnPowerOf = new JButton("Power Of");
        btnPowerOf.setBounds(160, 150, 100, 30);
        frame.getContentPane().add(btnPowerOf);

        JButton btnSqrt = new JButton("Square Root");
        btnSqrt.setBounds(270, 150, 130, 30);
        frame.getContentPane().add(btnSqrt);

        resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(50, 190, 350, 30);
        frame.getContentPane().add(resultLabel);

        // Action listeners for buttons
        btnAdd.addActionListener(e -> performOperation("add"));
        btnSubtract.addActionListener(e -> performOperation("subtract"));
        btnMultiply.addActionListener(e -> performOperation("multiply"));
        btnDivide.addActionListener(e -> performOperation("divide"));
        btnPowerOf.addActionListener(e -> performOperation("power"));
        btnSqrt.addActionListener(e -> performOperation("sqrt"));
    }

    private void performOperation(String operation) {
        String input1 = number1Field.getText();
        String input2 = number2Field.getText();

        try {
            double num1 = Double.parseDouble(input1);
            double result = 0;

            switch (operation) {
                case "add":
                    double num2Add = Double.parseDouble(input2);
                    result = num1 + num2Add;
                    break;
                case "subtract":
                    double num2Subtract = Double.parseDouble(input2);
                    result = num1 - num2Subtract;
                    break;
                case "multiply":
                    double num2Multiply = Double.parseDouble(input2);
                    result = num1 * num2Multiply;
                    break;
                case "divide":
                    double num2Divide = Double.parseDouble(input2);
                    if (num2Divide == 0) {
                        showError("Division by zero is not allowed.");
                        return;
                    }
                    result = num1 / num2Divide;
                    break;
                case "power":
                    double num2Power = Double.parseDouble(input2);
                    result = Math.pow(num1, num2Power);
                    break;
                case "sqrt":
                    if (num1 < 0) {
                        showError("Cannot take the square root of a negative number.");
                        return;
                    }
                    result = Math.sqrt(num1);
                    break;
            }
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            showError("Please enter valid numbers.");
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}

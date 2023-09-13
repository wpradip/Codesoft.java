import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

public class Task4ATMGUI extends JFrame implements ActionListener {
    private JLabel balanceLabel;
    private double accountBalance;

    private BankAccount bankAccount;

    public Task4ATMGUI(BankAccount account) {
        setTitle("ATM designed by Vivek Yadav");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        bankAccount = account;
        accountBalance = bankAccount.getBalance();

        // Create components
        JPanel optionsPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton checkBalanceButton = new JButton("Check Balance");

        withdrawButton.addActionListener(this);
        depositButton.addActionListener(this);
        checkBalanceButton.addActionListener(this);

        optionsPanel.add(withdrawButton);
        optionsPanel.add(depositButton);
        optionsPanel.add(checkBalanceButton);

        balanceLabel = new JLabel("Account Balance: RS " + accountBalance, JLabel.CENTER);

        add(optionsPanel, BorderLayout.CENTER);
        add(balanceLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "Withdraw":
                performWithdraw();
                break;
            case "Deposit":
                performDeposit();
                break;
            case "Check Balance":
                displayBalance();
                break;
        }
    }

    private void performWithdraw() {
        String inputAmount = JOptionPane.showInputDialog(this, "Enter the amount to withdraw:");
        if (inputAmount != null) {
            try {
                double amount = Double.parseDouble(inputAmount);
                if (amount > 0 && amount <= accountBalance) {
                    bankAccount.withdraw(amount);
                    accountBalance = bankAccount.getBalance();
                    JOptionPane.showMessageDialog(this, "Withdrawal Successful");
                } else if (amount > accountBalance) {
                    JOptionPane.showMessageDialog(this, "Insufficient Balance");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid amount");
                }
                updateBalanceLabel();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
            }
        }
    }

    private void performDeposit() {
        String inputAmount = JOptionPane.showInputDialog(this, "Enter the amount to deposit:");
        if (inputAmount != null) {
            try {
                double amount = Double.parseDouble(inputAmount);
                if (amount > 0) {
                    bankAccount.deposit(amount);
                    accountBalance = bankAccount.getBalance();
                    JOptionPane.showMessageDialog(this, "Deposit Successful");
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid amount");
                }
                updateBalanceLabel();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number.");
            }
        }
    }

    private void displayBalance() {
        JOptionPane.showMessageDialog(this, "Current balance: RS " + accountBalance);
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Account Balance: RS " + accountBalance);
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(0.00);
        SwingUtilities.invokeLater(() -> new Task4ATMGUI(bankAccount));
    }
}
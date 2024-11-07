package com.example.ui.totalQuantity;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TotalQuantityForm extends JDialog {

    private static final long serialVersionUID = 1L;
    private final JPanel contentPanel = new JPanel();
    private JTextField txtFood;
    private JTextField txtCeramic;
    private JTextField txtElectronic;

    public TotalQuantityForm(int quantityFood, int quantityCeramic, int quantityElectronic) {
        setBounds(300, 300, 800, 200); // Adjusted size for better appearance
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(0, 4, 0, 0));

        // Total quantity label
        JPanel totalPanel = new JPanel();
        panel.add(totalPanel);
        JLabel lblTotal = new JLabel("Tổng số lượng sản phẩm:");
        totalPanel.add(lblTotal);

        // Food quantity
        JPanel foodPanel = new JPanel();
        panel.add(foodPanel);
        JLabel lblFood = new JLabel("Thực phẩm:");
        foodPanel.add(lblFood);
        txtFood = new JTextField();
        txtFood.setEditable(false);
        foodPanel.add(txtFood);
        txtFood.setColumns(10);
        txtFood.setText(String.valueOf(quantityFood));

        // Ceramic quantity
        JPanel ceramicPanel = new JPanel();
        panel.add(ceramicPanel);
        JLabel lblCeramic = new JLabel("Sành sứ:");
        ceramicPanel.add(lblCeramic);
        txtCeramic = new JTextField();
        txtCeramic.setEditable(false);
        ceramicPanel.add(txtCeramic);
        txtCeramic.setColumns(10);
        txtCeramic.setText(String.valueOf(quantityCeramic));

        // Electronic quantity
        JPanel electronicPanel = new JPanel();
        panel.add(electronicPanel);
        JLabel lblElectronic = new JLabel("Điện máy:");
        electronicPanel.add(lblElectronic);
        txtElectronic = new JTextField();
        txtElectronic.setEditable(false);
        electronicPanel.add(txtElectronic);
        txtElectronic.setColumns(10);
        txtElectronic.setText(String.valueOf(quantityElectronic));

        // Close button
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the dialog
            }
        });
        contentPanel.add(btnClose); // Add the button to the content panel
    }
}

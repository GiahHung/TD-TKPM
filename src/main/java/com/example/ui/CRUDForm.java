package com.example.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.example.database.AddProductDAO;
import com.example.ui.addProduct.AddController;
import com.example.ui.addProduct.AddPresenter;
import com.example.usecase.ViewProductDTO;
import com.example.usecase.createProduct.AddInputDTO;
import com.example.usecase.createProduct.AddUseCase;

import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Panel;
import java.awt.Label;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.TextField;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JComboBox;

public class CRUDForm extends JFrame {
	private JTextField nameField, priceField, quantityField, dvtField,NSXField,HSDField,nhaCCField,NNKField,nhaSXField,BHField,congSuatField;
    private JButton addButton, updateButton,deleteButton;
    private JTable table;
    private DefaultTableModel tableModel;
    private Panel panel_3,dynamicPanel,foodPanel,ceramicPanel,electronicPanel,panel_4,panel_6,panel_5;
    private Label label_6,label_3,label_4,label_5;
    private TextField txtFood,txtCeramic,txtElectronic;
    private JComboBox comboBox;

    public CRUDForm(List<ViewProductDTO> products) {
    
        JFrame frame = new JFrame("Product Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(901, 455);

        frame.getContentPane().setLayout(new BorderLayout());

        // Panel for product input fields
        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Product Information"));

        // Product name
        JLabel label_7 = new JLabel("Product Name:");
        label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
        inputPanel.add(label_7);
        nameField = new JTextField();
        inputPanel.add(nameField);

        // Product price
        JLabel label_8 = new JLabel("Price:");
        label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
        inputPanel.add(label_8);
        priceField = new JTextField();
        inputPanel.add(priceField);

        // Product category
        JLabel label_9 = new JLabel("Category:");
        label_9.setFont(new Font("Tahoma", Font.BOLD, 11));
        inputPanel.add(label_9);
        
        comboBox = new JComboBox<>(new String[]{"food", "ceramic","electronic"});
        inputPanel.add(comboBox);

        // Product quantity
        JLabel label_10 = new JLabel("Quantity:");
        label_10.setFont(new Font("Tahoma", Font.BOLD, 11));
        inputPanel.add(label_10);
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        // Product DVT (unit of measurement)
        JLabel label_11 = new JLabel("DVT:");
        label_11.setFont(new Font("Tahoma", Font.BOLD, 11));
        inputPanel.add(label_11);
        dvtField = new JTextField();
        inputPanel.add(dvtField);
        dynamicPanel = new Panel(new CardLayout());

        // Panel for Software Major
        foodPanel = new Panel(new GridLayout(3, 2));

        // Set preferred size to control height
        Dimension FieldSize = new Dimension(100, 25);  // Adjust height to 25 pixels

        NSXField = new JTextField();
        NSXField.setPreferredSize(FieldSize);
        foodPanel.add(new JLabel("NSX:"));
        foodPanel.add(NSXField);

        HSDField = new JTextField();
        HSDField.setPreferredSize(FieldSize);
        foodPanel.add(new JLabel("HSD:"));
        foodPanel.add(HSDField);

        nhaCCField = new JTextField();
        nhaCCField.setPreferredSize(FieldSize);
        foodPanel.add(new JLabel("Nhà cung cấp:"));
        foodPanel.add(nhaCCField);

        // Panel for Economics Major
        ceramicPanel = new Panel(new GridLayout(2, 2));

        NNKField = new JTextField();
        NNKField.setPreferredSize(FieldSize);
        ceramicPanel.add(new JLabel("Ngày nhập kho:"));
        ceramicPanel.add(NNKField);

        nhaSXField = new JTextField();
        nhaSXField.setPreferredSize(FieldSize);
        ceramicPanel.add(new JLabel("Nhà sản xuất:"));
        ceramicPanel.add(nhaSXField);
        
        electronicPanel = new Panel(new GridLayout(2, 2));

        BHField = new JTextField();
        BHField.setPreferredSize(FieldSize);
        electronicPanel.add(new JLabel("Bảo hành:"));
        electronicPanel.add(BHField);

        congSuatField = new JTextField();
        congSuatField.setPreferredSize(FieldSize);
        electronicPanel.add(new JLabel("Công suất:"));
        electronicPanel.add(congSuatField);

        // Add both panels to the dynamic panel
        dynamicPanel.add(foodPanel, "food");
        dynamicPanel.add(ceramicPanel, "ceramic");
        dynamicPanel.add(electronicPanel, "electronic");

        // Initially show the panel for Software Major
        CardLayout cl = (CardLayout)(dynamicPanel.getLayout());
        cl.show(dynamicPanel, "food");
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCategory = (String) comboBox.getSelectedItem();
                CardLayout cl = (CardLayout) dynamicPanel.getLayout();
                cl.show(dynamicPanel, selectedCategory);
            }
        });
        inputPanel.add(new JLabel("Additional Information:"));
        inputPanel.add(dynamicPanel);

        // Panel for buttons
        JPanel buttonPanel = new JPanel(new FlowLayout());
        addButton = new JButton("Add Product");
        addButton.setBackground(new Color(0, 255, 0));
        updateButton = new JButton("Update Product");
        deleteButton = new JButton("Delete Product");
        deleteButton.setBackground(new Color(255, 0, 0));
        deleteButton.setForeground(new Color(0, 0, 0));

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Adding panels to the form
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(inputPanel, BorderLayout.NORTH);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Column headers for the JTable
        String[] columns = {"Mã", "Tên sản phẩm", "Giá", "Loại", "Số lượng", "DVT"};

        // Create table model
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        // Add product data to the table (if any)
        for (ViewProductDTO product : products) {
            Object[] row = {
                product.getMaMh(),
                product.getName(),
                product.getPrice(),
                product.getCategory(),
                product.getQuantity(),
                product.getDvt()
            };
            tableModel.addRow(row);
        }

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the input panel and table to the frame
        frame.getContentPane().add(topPanel, BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        panel_3 = new Panel();
        frame.getContentPane().add(panel_3, BorderLayout.SOUTH);
        panel_3.setLayout(new GridLayout(0, 1, 0, 0));
        
        label_6 = new Label("Tổng số lượng sản phẩm");
        label_6.setForeground(new Color(0, 0, 0));
        label_6.setFont(new Font("Algerian", Font.BOLD, 13));
        panel_3.add(label_6);
        
        panel_4 = new Panel();
        FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_4);
        
        label_3 = new Label("Thực phẩm:");
        panel_4.add(label_3);
        
        txtFood = new TextField();
        txtFood.setEnabled(false);
        txtFood.setEditable(false);
        panel_4.add(txtFood);
        
        panel_6 = new Panel();
        FlowLayout flowLayout_1 = (FlowLayout) panel_6.getLayout();
        flowLayout_1.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_6);
        
        label_4 = new Label("Sành sứ:");
        panel_6.add(label_4);
        
        txtCeramic = new TextField();
        txtCeramic.setEnabled(false);
        txtCeramic.setEditable(false);
        panel_6.add(txtCeramic);
        
        panel_5 = new Panel();
        FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
        flowLayout_2.setAlignment(FlowLayout.LEFT);
        panel_3.add(panel_5);
        
        label_5 = new Label("Điện máy:");
        panel_5.add(label_5);
        
        txtElectronic = new TextField();
        txtElectronic.setEditable(false);
        txtElectronic.setEnabled(false);
        panel_5.add(txtElectronic);
        
       
        // Button listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddProduct();
                frame.setLocationRelativeTo(null);
               
            }
        });

        // Make the frame visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

   private void handleAddProduct() {
    AddPresenter addPresenter = new AddPresenter();
    AddProductDAO addData = new AddProductDAO();
    AddUseCase addUseCase = new AddUseCase(addData, addPresenter);
    AddController addProductController = new AddController(addUseCase);
    String name = nameField.getText();
    String price = priceField.getText();
    String category = (String) comboBox.getSelectedItem();
    String quantity = quantityField.getText() ;
    String dvt = dvtField.getText();

    if (name.isEmpty() || price.isEmpty() || quantity.isEmpty() || dvt.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        return;
    }
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    try {
        if (category.equals("food")) {
            // Parse Date fields
            Date NSX = dateFormat.parse(NSXField.getText());
            Date HSD = dateFormat.parse(HSDField.getText());
            String nhaCC = nhaCCField.getText();
            AddInputDTO addInputDTO = new AddInputDTO(0, name, Integer.parseInt(price), category, Integer.parseInt(quantity), dvt, NSX, HSD, nhaCC);
            addProductController.execute(addInputDTO);

        } else if (category.equals("ceramic")) {
            Date NNK = dateFormat.parse(NNKField.getText());
            String nhaSX = nhaSXField.getText();
            AddInputDTO addInputDTO = new AddInputDTO(0, name, Integer.parseInt(price), category, Integer.parseInt(quantity), dvt, nhaSX,NNK);
            addProductController.execute(addInputDTO);

        } else if (category.equals("electronic")) {
            String BH = BHField.getText();
            String congSuat = congSuatField.getText();
            AddInputDTO addInputDTO = new AddInputDTO(0, name, Integer.parseInt(price), category, Integer.parseInt(quantity), dvt, BH, congSuat);
            addProductController.execute(addInputDTO);
        }
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Invalid date format. Please use 'yyyy-MM-dd'.");
        return;
    }

    // Reset the form after adding
    
    resetForm();
}

    private void resetForm() {
        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
        dvtField.setText("");
        NSXField.setText("");
        HSDField.setText("");
        nhaCCField.setText("");
        NNKField.setText("");
        nhaSXField.setText("");
        BHField.setText("");
        congSuatField.setText("");
    }

}
   

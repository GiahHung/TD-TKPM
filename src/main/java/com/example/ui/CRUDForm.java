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
import com.example.database.DeleteProductDAO;
import com.example.database.FindProductDAO;
import com.example.database.TotalQuantityDAO;
import com.example.database.UpdateProductDAO;
import com.example.database.ViewProductListDAO;
import com.example.ui.addProduct.AddController;
import com.example.ui.addProduct.AddPresenter;
import com.example.ui.deleteProduct.DeleteProductController;
import com.example.ui.deleteProduct.DeleteProductPresenter;
import com.example.ui.findProduct.FindProductController;
import com.example.ui.findProduct.FindProductPresenter;
import com.example.ui.totalQuantity.TotalQuantityController;
import com.example.ui.totalQuantity.TotalQuantityForm;
import com.example.ui.totalQuantity.TotalQuantityPresenter;
import com.example.ui.updateProduct.UpdateController;
import com.example.ui.updateProduct.UpdatePresenter;
import com.example.usecase.UsecaseControl;
import com.example.usecase.ViewProductDTO;
import com.example.usecase.createProduct.AddInputDTO;
import com.example.usecase.createProduct.AddUseCase;
import com.example.usecase.createProduct.ResponeData;
import com.example.usecase.deleteProduct.DeleteInputDTO;
import com.example.usecase.deleteProduct.DeleteOutputDTO;
import com.example.usecase.deleteProduct.DeleteUsecase;
import com.example.usecase.findProduct.FindProductOutputDTO;
import com.example.usecase.findProduct.FindProductUsecase;
import com.example.usecase.totalQuantity.TotalQuantityInputDTO;
import com.example.usecase.totalQuantity.TotalQuantityUsecase;
import com.example.usecase.updateProduct.UpdateInputDTO;
import com.example.usecase.updateProduct.UpdateUsecase;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Panel;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JComboBox;

public class CRUDForm extends JFrame {
	private JTextField nameField, priceField, quantityField, dvtField,NSXField,HSDField,nhaCCField,NNKField,nhaSXField,BHField,congSuatField;
    private JButton addButton, updateButton,deleteButton;
    private JTable table;
    private DefaultTableModel tableModel;
    private Panel dynamicPanel,foodPanel,ceramicPanel,electronicPanel;
    private JComboBox comboBox;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
   

    public void CRUD(List<ViewProductDTO> products) {
        setTitle("Student Registration Form");
        setSize( 1200, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // JFrame frame = new JFrame("Product Management");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(901, 455);
    
        // frame.getContentPane().setLayout(new BorderLayout());

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
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleUpdateProduct();

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDeleteProduct();
                initializeTable(products);
            }
        });

        // Adding panels to the form
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(inputPanel, BorderLayout.NORTH);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        btnNewButton = new JButton("Tổng số lượng");
        buttonPanel.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 TotalQuantityDAO data = new TotalQuantityDAO();
                 TotalQuantityPresenter presenter = new TotalQuantityPresenter();
                 TotalQuantityUsecase totalQuantityUsecase = new TotalQuantityUsecase(presenter,data );
                 TotalQuantityController totalQuantityController = new TotalQuantityController(totalQuantityUsecase);
                 Set<String> categories = Set.of("food", "ceramic", "electronic");
                 TotalQuantityInputDTO dto = new TotalQuantityInputDTO(categories);
                 totalQuantityController.execute(dto);
                 TotalQuantityForm totalQuantityForm = null;
                 totalQuantityForm = new TotalQuantityForm(presenter.getOutputDTO().getFoodQuantity(),presenter.getOutputDTO().getCeramicQuantity(),presenter.getOutputDTO().getElectronicQuantity());
            }
        });
        
        btnNewButton_1 = new JButton("Sản phẩm sắp hết hạn");
        buttonPanel.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FindProductDAO data = new FindProductDAO();
                FindProductPresenter presenter = new FindProductPresenter();
                FindProductUsecase usecase = new FindProductUsecase(presenter, data);
                FindProductController findProductController = new FindProductController(usecase);
                findProductController.execute();

            }
        });


     initializeTable(products);

     add(topPanel, BorderLayout.NORTH);

        // Button listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddProduct();
               
            }
        });

       
       // frame.setLocationRelativeTo(null);
        //frame.setVisible(true);
    }
    

    private void handleAddProduct() {
        AddPresenter addPresenter = new AddPresenter();
        AddProductDAO addData = new AddProductDAO();
        AddUseCase addUseCase = new AddUseCase(addData, addPresenter);
        AddController addProductController = new AddController(addUseCase);
        
       
        String name = nameField.getText();
        String price = priceField.getText();
        String category = (String) comboBox.getSelectedItem();
        String quantity = quantityField.getText();
        String dvt = dvtField.getText();
    
        // Check for empty fields
        if (name.isEmpty() || price.isEmpty() || quantity.isEmpty() || dvt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thong tin.");
            return;
        }
    
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
        try {
            AddInputDTO addInputDTO;
        
        if (category.equals("food")) {
            Date NSX = dateFormat.parse(NSXField.getText());
            Date HSD = dateFormat.parse(HSDField.getText());
            String nhaCC = nhaCCField.getText();
            addInputDTO = new AddInputDTO(0, name, Integer.parseInt(price), category, Integer.parseInt(quantity), dvt, NSX, HSD, nhaCC);
            
        } else if (category.equals("ceramic")) {
            Date NNK = dateFormat.parse(NNKField.getText());
            String nhaSX = nhaSXField.getText();
            addInputDTO = new AddInputDTO(0, name, Integer.parseInt(price), category, Integer.parseInt(quantity), dvt, nhaSX, NNK);
            
        } else if (category.equals("electronic")) {
            int BH = Integer.parseInt(BHField.getText());
            int congSuat = Integer.parseInt(congSuatField.getText());
            addInputDTO = new AddInputDTO(0, name, Integer.parseInt(price), category, Integer.parseInt(quantity), dvt, BH, congSuat);
            
        } else {
            JOptionPane.showMessageDialog(this, "Invalid category.");
            return;
        }
        
        addProductController.execute(addInputDTO);
        ResponeData res = addPresenter.getResponeData();  
        
        if (res != null && res.getMessage()=="Giá tiền lớn hơn 0, Số lượng lớn hơn bằng 0, bảo hành lớn bàng 0, công suất lớn hơn không" || res.getMessage()=="Giá tiền lớn hơn 0, Số lượng lớn hơn bằng 0 ngày nhập kho trước hôm nay" || res.getMessage()=="Giá tiền lớn hơn 0, Số lượng lớn hơn bằng 0 và NSX phải trước HSD") {
            JOptionPane.showMessageDialog(this, res.getMessage());
        } else {
            JOptionPane.showMessageDialog(this, res.getMessage());
            resetForm();
           
        }
    
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Sử dụng định dạng 'yyyy-MM-dd'.");
            return;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Chỉ nhập số cho giá tiền và số lượng");
            return;
        }
    

    }
    
    private void handleUpdateProduct() {
    int selectedRow = table.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xóa.");
        return;
    }

    int productId = (int) table.getValueAt(selectedRow, 0); // Get product ID from the table
    String name = nameField.getText();
    String price = priceField.getText();
    String category = (String) comboBox.getSelectedItem();
    String quantity = quantityField.getText();
    String dvt = dvtField.getText();

    // Use different fields based on category
    UpdateInputDTO updateInputDTO = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    try {
        if (category.equals("food")) {
            Date NSX = dateFormat.parse(NSXField.getText());
            Date HSD = dateFormat.parse(HSDField.getText());
            String nhaCC = nhaCCField.getText();
            updateInputDTO = new UpdateInputDTO(productId, name, Integer.parseInt(price), category, Integer.parseInt(quantity), dvt, NSX, HSD, nhaCC);
        } else if (category.equals("ceramic")) {
            Date NNK = dateFormat.parse(NNKField.getText());
            String nhaSX = nhaSXField.getText();
            updateInputDTO = new UpdateInputDTO(productId, name, Integer.parseInt(price), category, Integer.parseInt(quantity), dvt, nhaSX, NNK);
        } else if (category.equals("electronic")) {
            int BH = Integer.parseInt(BHField.getText());
            int congSuat = Integer.parseInt(congSuatField.getText());
            updateInputDTO = new UpdateInputDTO(productId, name, Integer.parseInt(price), category, Integer.parseInt(quantity), dvt, BH, congSuat);
        }
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Điền đúng định dạng 'yyyy-MM-dd'.");
        return;
    }catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Chỉ nhập số cho giá tiền và số lượng");
        return;
    }

    // Execute update through controller
    UpdatePresenter updatePresenter = new UpdatePresenter();
    UpdateProductDAO updateData = new UpdateProductDAO();
    UpdateUsecase updateUseCase = new UpdateUsecase(updatePresenter, updateData );
    UpdateController updateController = new UpdateController(updateUseCase);
    updateController.execute(updateInputDTO);
    com.example.usecase.updateProduct.ResponeData res = updatePresenter.getRes();
    if (res != null && res.getMessage()=="Giá tiền lớn hơn 0, Số lượng lớn hơn bằng 0, bảo hành lớn bàng 0, công suất lớn hơn không" || res.getMessage()=="Giá tiền lớn hơn 0, Số lượng lớn hơn bằng 0 ngày nhập kho trước hôm nay" || res.getMessage()=="Giá tiền lớn hơn 0, Số lượng lớn hơn bằng 0 và NSX phải trước HSD") {
        JOptionPane.showMessageDialog(this, res.getMessage());
    } else {
        JOptionPane.showMessageDialog(this, res.getMessage());
        resetForm();
       
    }
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
    private void initializeTable(List<ViewProductDTO> products) {
        String[] columns = {"Mã", "Tên sản phẩm", "Giá", "Loại", "Số lượng", "DVT"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        // Populate table with data
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
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Get the data from the selected row
                    int productId = (int) table.getValueAt(selectedRow, 0);
                    String productName = (String) table.getValueAt(selectedRow, 1);
                    int productPrice = (int) table.getValueAt(selectedRow, 2);
                    String productCategory = (String) table.getValueAt(selectedRow, 3);
                    int productQuantity = (int) table.getValueAt(selectedRow, 4);
                    String productDVT = (String) table.getValueAt(selectedRow, 5);
        
                   
                    ViewProductDTO selectedProduct = products.stream()
                            .filter(p -> p.getMaMh() == productId)
                            .findFirst()
                            .orElse(null);
        
                    if (selectedProduct != null) {
               
                        nameField.setText(productName);
                        priceField.setText(String.valueOf(productPrice));
                        quantityField.setText(String.valueOf(productQuantity));
                        dvtField.setText(productDVT);
                        comboBox.setSelectedItem(productCategory);
        
                        if ("food".equals(productCategory)) {
                            NSXField.setText(String.valueOf(selectedProduct.getnSX()));
                            HSDField.setText(String.valueOf(selectedProduct.gethSD()));
                            nhaCCField.setText(selectedProduct.getNhaCungCap());
                        } else if ("ceramic".equals(productCategory)) {
                            NNKField.setText(String.valueOf(selectedProduct.getNgayNhapKho()));
                            nhaSXField.setText(selectedProduct.getNhaSanXuat());
                        } else if ("electronic".equals(productCategory)) {
                            BHField.setText(String.valueOf(selectedProduct.getBaoHanh()));
                            congSuatField.setText(String.valueOf(selectedProduct.getCongSuat()));
                        }
                    }
                }
            }
        });
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
    private void handleDeleteProduct() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xóa.");
            return;
        }
    
        DeleteProductPresenter deletePresenter = new DeleteProductPresenter();
        DeleteProductDAO deleteData = new DeleteProductDAO();
        DeleteUsecase deleteUseCase = new DeleteUsecase(deletePresenter, deleteData);
        DeleteProductController deleteProductController = new DeleteProductController(deleteUseCase);
    
        // Get the selected product details
        int productId = (int) table.getValueAt(selectedRow, 0);
        String productName = (String) table.getValueAt(selectedRow, 1);
        int productPrice = (int) table.getValueAt(selectedRow, 2);
        String productCategory = (String) table.getValueAt(selectedRow, 3);
        int productQuantity = (int) table.getValueAt(selectedRow, 4);
        String productDVT = (String) table.getValueAt(selectedRow, 5);
    
        DeleteInputDTO deleteInputDTO = new DeleteInputDTO(productId, productName, productPrice, productCategory, productQuantity, productDVT);
        deleteProductController.execute(deleteInputDTO);
        DeleteOutputDTO message= deletePresenter.getOutputDTO();
        JOptionPane.showMessageDialog(this, message.getMessage());
        resetForm();
        
        
    }
    private void clearTable() {
   
            //tableModel.setRowCount(0); // Clear all rows
            ViewListProductPresenter presenter = new ViewListProductPresenter();
        ViewProductListDAO data = new ViewProductListDAO();
        UsecaseControl usecaseControl = new UsecaseControl(presenter, data);
        ViewListProductController viewListProductController = new ViewListProductController(usecaseControl);
        viewListProductController.execute();
        List<ViewProductDTO> viewProductDTOs = presenter.getViewProductDTOs();
        
        CRUD(viewProductDTOs);
        
    }
    
}
   

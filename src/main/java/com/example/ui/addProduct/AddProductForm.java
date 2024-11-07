package com.example.ui.addProduct;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.database.AddProductDAO;
import com.example.database.FindProductDAO;
import com.example.entity.AllCode;
import com.example.ui.findProduct.FindProductController;
import com.example.ui.findProduct.FindProductPresenter;
import com.example.usecase.createProduct.AddInputDTO;
import com.example.usecase.createProduct.AddUseCase;
import com.example.usecase.createProduct.ResponeData;
import com.example.usecase.findProduct.FindProductUsecase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProductForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtQuantity;
	private JTextField txtNSX;
	private JTextField txtHSD;
	private JTextField txtNhaCC;
	private JTextField txtNhaSX;
	private JTextField txtNNK;
	private JTextField txtCongSuat;
	private JTextField txtBH;
	private JComboBox<String> cbCategory,cbDVT;


	public AddProductForm(List<AllCode> keyMapCategory,List<AllCode> keyMapDvt) {
		setBounds(100, 100, 867, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(35, 69, 808, 366);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAddProduct();
			}
		});
		btnAdd.setBackground(new Color(0, 255, 0));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setBounds(539, 308, 85, 29);
		panel_1.add(btnAdd);
		
		
		JButton btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBackground(new Color(255, 69, 0));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setBounds(636, 308, 85, 29);
		panel_1.add(btnCancel);
		
		JLabel lblNewLabel_3 = new JLabel("Số lượng");
		lblNewLabel_3.setBounds(10, 102, 72, 15);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(101, 95, 106, 29);
		panel_1.add(txtQuantity);
		txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtQuantity.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1.setBounds(10, 46, 81, 15);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtName = new JTextField();
		txtName.setBounds(101, 39, 325, 29);
		panel_1.add(txtName);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtName.setColumns(20);
		
		JLabel lblNewLabel_2 = new JLabel("Giá sản phẩm");
		lblNewLabel_2.setBounds(493, 46, 94, 15);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtPrice = new JTextField();
		txtPrice.setBounds(586, 39, 212, 29);
		panel_1.add(txtPrice);
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPrice.setColumns(15);
		
		JLabel lblNewLabel_4 = new JLabel("Đơn vị tính");
		lblNewLabel_4.setBounds(262, 102, 81, 15);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_5 = new JLabel("Loại sản phẩm");
		lblNewLabel_5.setBounds(482, 102, 94, 15);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		cbCategory = new JComboBox();
		cbCategory.setBounds(586, 96, 106, 29);
		panel_1.add(cbCategory);
		cbCategory.removeAllItems();
		for (AllCode code : keyMapCategory) {
			cbCategory.addItem(code.getKeyMap());
		}
		
		cbDVT = new JComboBox();
		cbDVT.setBounds(344, 97, 64, 26);
		panel_1.add(cbDVT);
		cbDVT.removeAllItems();
		for (AllCode code : keyMapDvt) {
			cbDVT.addItem(code.getKeyMap());
		}
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 134, 788, 164);
		panel_1.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Thực phẩm", null, panel_2, null);
		tabbedPane.setForegroundAt(0, new Color(0, 0, 0));
		tabbedPane.setBackgroundAt(0, new Color(51, 255, 102));
		panel_2.setLayout(null);
		
		
		JLabel lblNewLabel_6 = new JLabel("NSX");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(24, 41, 45, 13);
		panel_2.add(lblNewLabel_6);
		
		txtNSX = new JTextField();
		txtNSX.setBounds(64, 35, 155, 28);
		panel_2.add(txtNSX);
		txtNSX.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("HSD");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(274, 41, 45, 13);
		panel_2.add(lblNewLabel_7);
		
		txtHSD = new JTextField();
		txtHSD.setBounds(319, 34, 173, 29);
		panel_2.add(txtHSD);
		txtHSD.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nhà cung cấp");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(24, 97, 103, 13);
		panel_2.add(lblNewLabel_8);
		
		txtNhaCC = new JTextField();
		txtNhaCC.setBounds(121, 90, 155, 29);
		panel_2.add(txtNhaCC);
		txtNhaCC.setColumns(10);
	
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Sành sứ", null, panel_3, null);
		panel_3.setLayout(null);
		
		txtNNK = new JTextField();
		txtNNK.setBounds(146, 40, 179, 29);
		panel_3.add(txtNNK);
		txtNNK.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Ngày nhập kho");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10.setBounds(43, 47, 112, 13);
		panel_3.add(lblNewLabel_10);
		
		txtNhaSX = new JTextField();
		txtNhaSX.setBounds(490, 40, 153, 29);
		panel_3.add(txtNhaSX);
		txtNhaSX.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Nhà sản xuất");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_9.setBounds(400, 42, 102, 24);
		panel_3.add(lblNewLabel_9);
		tabbedPane.setBackgroundAt(1, new Color(153, 102, 51));
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Điện máy", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("Bảo hành");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_12.setBounds(44, 45, 96, 13);
		panel_4.add(lblNewLabel_12);
		
		txtBH = new JTextField();
		txtBH.setBounds(108, 37, 96, 31);
		panel_4.add(txtBH);
		txtBH.setColumns(10);
		
		txtCongSuat = new JTextField();
		txtCongSuat.setBounds(352, 37, 96, 31);
		panel_4.add(txtCongSuat);
		txtCongSuat.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Công suất");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(283, 45, 84, 13);
		panel_4.add(lblNewLabel_11);
		tabbedPane.setBackgroundAt(2, new Color(0, 153, 255));
		
		JPanel panel = new JPanel();
		panel.setBounds(374, 25, 132, 34);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("THÊM SẢN PHẨM");
		lblNewLabel.setForeground(new Color(51, 153, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel);
	}

	private void resetForm() {
        txtName.setText("");
        txtPrice.setText("");
        txtQuantity.setText("");
        txtHSD.setText("");
        txtNNK.setText("");
        txtNhaCC.setText("");
        txtNSX.setText("");
        txtBH.setText("");
        txtCongSuat.setText("");
        txtNhaSX.setText("");
    }
	 private void handleAddProduct() {
        AddPresenter addPresenter = new AddPresenter();
        AddProductDAO addData = new AddProductDAO();
        AddUseCase addUseCase = new AddUseCase(addData, addPresenter);
        AddController addProductController = new AddController(addUseCase);
        
       
        String name = txtName.getText();
        String price = txtPrice.getText();
        String category = (String) cbCategory.getSelectedItem();
        String quantity = txtQuantity.getText();
        String dvt = (String) cbDVT.getSelectedItem();
    
        // Check for empty fields
        if (name.isEmpty() || price.isEmpty() || quantity.isEmpty() || dvt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thong tin.");
            return;
        }
    
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
        try {
            AddInputDTO addInputDTO;
        
        if (category.equals("food")) {
            Date NSX = dateFormat.parse(txtNSX.getText());
            Date HSD = dateFormat.parse(txtHSD.getText());
            String nhaCC = txtNhaCC.getText();
            addInputDTO = new AddInputDTO(0, name, Integer.parseInt(price), category, Integer.parseInt(quantity), dvt, NSX, HSD, nhaCC);
            
        } else if (category.equals("ceramic")) {
            Date NNK = dateFormat.parse(txtNNK.getText());
            String nhaSX = txtNhaSX.getText();
            addInputDTO = new AddInputDTO(0, name, Integer.parseInt(price), category, Integer.parseInt(quantity), dvt, nhaSX, NNK);
            
        } else if (category.equals("electronic")) {
            int BH = Integer.parseInt(txtBH.getText());
            int congSuat = Integer.parseInt(txtCongSuat.getText());
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
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số cho giá tiền và số lượng");
            return;
        }
    

    }
}

package com.example.ui.updateProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.example.database.UpdateProductDAO;
import com.example.entity.AllCode;
import com.example.usecase.getOneProduct.GetOneProductOutputDTO;
import com.example.usecase.updateProduct.UpdateInputDTO;
import com.example.usecase.updateProduct.UpdateUsecase;

public class UpdateProductForm extends JFrame {

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
	private JTextField txtMamh;


	public UpdateProductForm(List<AllCode> category,List<AllCode> dvt,GetOneProductOutputDTO dto) {
	
		setBounds(100, 100, 867, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(35, 69, 808, 366);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleUpdateProduct();
			}
		});
		btnUpdate.setBackground(new Color(0, 255, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setBounds(539, 308, 85, 29);
		panel_1.add(btnUpdate);
		
		
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
		txtQuantity.setText(String.valueOf(dto.getQuantity()));
		
		JLabel lblNewLabel_1 = new JLabel("Tên sản phẩm");
		lblNewLabel_1.setBounds(10, 63, 81, 15);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtName = new JTextField();
		txtName.setBounds(101, 56, 325, 29);
		panel_1.add(txtName);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtName.setColumns(20);
		txtName.setText(dto.getName());
		
		JLabel lblNewLabel_2 = new JLabel("Giá sản phẩm");
		lblNewLabel_2.setBounds(493, 63, 94, 15);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtPrice = new JTextField();
		txtPrice.setBounds(586, 56, 212, 29);
		panel_1.add(txtPrice);
		txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPrice.setColumns(15);
		txtPrice.setText(String.valueOf(dto.getPrice()));
		
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
		for (AllCode code : category) {
			cbCategory.addItem(code.getKeyMap());
		}
		String categoryToSelect = dto.getCategory();
        for (int i = 0; i < cbCategory.getItemCount(); i++) {
        if (cbCategory.getItemAt(i).equals(categoryToSelect)) {
        cbCategory.setSelectedIndex(i);
        break;
        }
        }
		
		cbDVT = new JComboBox();
		cbDVT.setBounds(344, 97, 64, 26);
		panel_1.add(cbDVT);
		cbDVT.removeAllItems();
		for (AllCode code : dvt) {
			cbDVT.addItem(code.getKeyMap());
		}
		String getSelectDVT = dto.getDvt();
		for(int i=0; i< cbDVT.getItemCount(); i++){
			if(cbDVT.getItemAt(i).equals(getSelectDVT)){
				cbDVT.setSelectedIndex(i);
				break;
			}
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
		txtNSX.setText(String.valueOf(dto.getnSX()));
		panel_2.add(txtNSX);
		txtNSX.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("HSD");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(274, 41, 45, 13);
		panel_2.add(lblNewLabel_7);
		
		txtHSD = new JTextField();
		txtHSD.setBounds(319, 34, 173, 29);
		txtHSD.setText(String.valueOf(dto.gethSD()));
		panel_2.add(txtHSD);
		txtHSD.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nhà cung cấp");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(24, 97, 103, 13);
		panel_2.add(lblNewLabel_8);
		
		txtNhaCC = new JTextField();
		txtNhaCC.setBounds(121, 90, 155, 29);
		txtNhaCC.setText(dto.getNhaCungCap());
		panel_2.add(txtNhaCC);
		txtNhaCC.setColumns(10);
	
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Sành sứ", null, panel_3, null);
		panel_3.setLayout(null);
		
		txtNNK = new JTextField();
		txtNNK.setBounds(146, 40, 179, 29);
		txtNNK.setText(String.valueOf(dto.getNgayNhapKho()));
		panel_3.add(txtNNK);
		txtNNK.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Ngày nhập kho");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_10.setBounds(43, 47, 112, 13);
		panel_3.add(lblNewLabel_10);
		
		txtNhaSX = new JTextField();
		txtNhaSX.setBounds(490, 40, 153, 29);
		txtNhaSX.setText(dto.getNhaSanXuat());
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
		txtBH.setText(String.valueOf(dto.getBaoHanh()));
		panel_4.add(txtBH);
		txtBH.setColumns(10);
		
		txtCongSuat = new JTextField();
		txtCongSuat.setBounds(352, 37, 96, 31);
		txtCongSuat.setText(String.valueOf(dto.getCongSuat()));
		panel_4.add(txtCongSuat);
		txtCongSuat.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Công suất");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_11.setBounds(283, 45, 84, 13);
		panel_4.add(lblNewLabel_11);
		tabbedPane.setBackgroundAt(2, new Color(0, 153, 255));
		
		JLabel lblNewLabel_13 = new JLabel("Mã mặt hàng");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_13.setBounds(10, 23, 94, 13);
		panel_1.add(lblNewLabel_13);
		
		txtMamh = new JTextField();
		txtMamh.setEnabled(false);
		txtMamh.setEditable(false);
		txtMamh.setBounds(101, 16, 64, 29);
		txtMamh.setText(String.valueOf(dto.getMaMh()));
		panel_1.add(txtMamh);
		txtMamh.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(374, 25, 132, 34);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("SỬA SẢN PHẨM");
		lblNewLabel.setForeground(new Color(51, 153, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel);
	}
	private void handleUpdateProduct() {

    String productId = txtMamh.getText(); // Get product ID from the table
    String name = txtName.getText();
    String price = txtPrice.getText();
    String category = (String) cbCategory.getSelectedItem();
    String quantity = txtQuantity.getText();
    String dvt =(String) cbDVT.getSelectedItem();

    // Use different fields based on category
    UpdateInputDTO updateInputDTO = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    try {
        if (category.equals("food")) {
            Date NSX = dateFormat.parse(txtNSX.getText());
            Date HSD = dateFormat.parse(txtHSD.getText());
            String nhaCC = txtNhaCC.getText();
            updateInputDTO = new UpdateInputDTO(Integer.parseInt(productId), name, Integer.parseInt(price), category, Integer.parseInt(quantity), dvt, NSX, HSD, nhaCC);
        } else if (category.equals("ceramic")) {
            Date NNK = dateFormat.parse(txtNNK.getText());
            String nhaSX = txtNSX.getText();
            updateInputDTO = new UpdateInputDTO(Integer.parseInt(productId), name, Integer.parseInt(price), category, Integer.parseInt(quantity), dvt, nhaSX, NNK);
        } else if (category.equals("electronic")) {
            int BH = Integer.parseInt(txtBH.getText());
            int congSuat = Integer.parseInt(txtCongSuat.getText());
            updateInputDTO = new UpdateInputDTO(Integer.parseInt(productId), name, Integer.parseInt(price), category, Integer.parseInt(quantity), dvt, BH, congSuat);
        }
    } catch (ParseException e) {
        JOptionPane.showMessageDialog(this, "Điền đúng định dạng 'yyyy-MM-dd'.");
        return;
    }catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Chỉ nhập số cho giá tiền và số lượng");
        return;
    }
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
        this.dispose();
    }

	}
}

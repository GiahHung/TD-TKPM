package com.example.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.example.database.DeleteProductDAO;
import com.example.database.FindProductDAO;
import com.example.database.GetAllCodeDAO;
import com.example.database.GetOneProductDAO;
import com.example.database.TotalQuantityDAO;
import com.example.database.ViewProductListDAO;
import com.example.entity.AllCode;
import com.example.ui.findProduct.FindProductController;
import com.example.ui.findProduct.FindProductPresenter;
import com.example.ui.getAllCode.GetAllCodePresenter;
import com.example.ui.login.LoginForm;
import com.example.ui.totalQuantity.TotalQuantityPresenter;
import com.example.ui.updateProduct.UpdateProductForm;
import com.example.usecase.UsecaseControl;
import com.example.usecase.ViewProductDTO;
import com.example.usecase.findProduct.FindProductUsecase;
import com.example.usecase.getAllCode.GetAllCodeUsecase;
import com.example.usecase.totalQuantity.TotalQuantityInputDTO;
import com.example.usecase.totalQuantity.TotalQuantityUsecase;

public class User extends JFrame {

	private static final long serialVersionUID = 1L;
    private JTextField txtSearch;
	private JTable table;
	private JTextField txtTotal;
	private DefaultTableModel tableModel;


	public User() {
        ViewListProductPresenter presenter = new ViewListProductPresenter();
		ViewProductListDAO data = new ViewProductListDAO();
		UsecaseControl usecaseControl = new UsecaseControl(presenter, data);
		ViewListProductController viewListProductController = new ViewListProductController(usecaseControl);
		viewListProductController.execute();
		GetAllCodeDAO dataCategory = new GetAllCodeDAO();
		GetAllCodePresenter presentCategory = new GetAllCodePresenter();
		GetAllCodeUsecase usecase = new GetAllCodeUsecase(dataCategory,presentCategory);
		usecase.execute("category");
        // Set up main form properties
        setTitle("Clinic Management System");
        setSize(1010, 670);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create MenuBar
        JMenuBar menuBar = new JMenuBar();

        // Create Menu
		JMenuItem mnDanhSchSn = new JMenuItem("Danh sách sản phẩm sắp hết hạn");
		mnDanhSchSn.setBackground(new Color(102, 255, 255));
		mnDanhSchSn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        mnDanhSchSn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FindProductDAO data = new FindProductDAO();
                FindProductPresenter presenter = new FindProductPresenter();
                FindProductUsecase usecase = new FindProductUsecase(presenter, data);
                FindProductController findProductController = new FindProductController(usecase);
                findProductController.execute();
        	}
        });
        menuBar.add(mnDanhSchSn);

        // Set menu bar
        setJMenuBar(menuBar);
        
        JMenuItem exitItem = new JMenuItem("Thoát");
        exitItem.setBackground(new Color(255, 51, 0));
        exitItem.addActionListener(new ActionListener() {
        	  @Override
              public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
			               public void run() {
				            try {
					        LoginForm frame = new LoginForm();
					          frame.setVisible(true);
							  dispose();
				               } catch (Exception e) {
					             e.printStackTrace();
				             }
			                 }
		                 });
              }
        });
        menuBar.add(exitItem);
        getContentPane().setLayout(null);
        
       
        
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				refresh();
        	}
        });
        btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnRefresh.setBounds(866, 133, 83, 21);
        getContentPane().add(btnRefresh);
        
        txtTotal = new JTextField();
        txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtTotal.setEditable(false);
        txtTotal.setBounds(267, 96, 52, 32);
        getContentPane().add(txtTotal);
        txtTotal.setColumns(10);
        TotalQuantityDAO totalData = new TotalQuantityDAO();
        TotalQuantityPresenter totalPresenter = new TotalQuantityPresenter();
        TotalQuantityUsecase totalQuantityUsecase = new TotalQuantityUsecase(totalPresenter, totalData);
        JComboBox cbTotal = new JComboBox();
        cbTotal.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        String category = (String) cbTotal.getSelectedItem();
        TotalQuantityInputDTO dto = new TotalQuantityInputDTO(category);
    
    // Execute the use case
    totalQuantityUsecase.execute(dto);

    // Check if the output DTO is not null before getting the quantity
    if (totalPresenter.getOutputDTO() != null) {
        int total = totalPresenter.getOutputDTO().getQuantity();
        txtTotal.setText(String.valueOf(total));
    } else {
        txtTotal.setText("0"); // Or some default value if needed
    }
}
});
        cbTotal.setBounds(31, 95, 113, 32);
        getContentPane().add(cbTotal);
		cbTotal.removeAllItems();
		for (AllCode code : presentCategory.getCategory()) {
			cbTotal.addItem(code.getKeyMap());
		}
        
        JLabel lblNewLabel = new JLabel("Tổng số lượng:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel.setBounds(154, 99, 116, 21);
        getContentPane().add(lblNewLabel);
        
        txtSearch = new JTextField();
        txtSearch.setBounds(31, 32, 568, 32);
        getContentPane().add(txtSearch);
        txtSearch.setColumns(40);
        
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Search();
        	}
        });
        btnSearch.setBackground(new Color(0, 255, 255));
        btnSearch.setBounds(609, 31, 95, 32);
        getContentPane().add(btnSearch);
        
		initializeTable(presenter.getViewProductDTOs());
        
        
        setVisible(true);
    }

    private void refresh(){
		tableModel.setRowCount(0);
		ViewListProductPresenter presenter = new ViewListProductPresenter();
		ViewProductListDAO data = new ViewProductListDAO();
		UsecaseControl usecaseControl = new UsecaseControl(presenter, data);
		ViewListProductController viewListProductController = new ViewListProductController(usecaseControl);
		viewListProductController.execute();
		for (ViewProductDTO product : presenter.getViewProductDTOs()) {
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
	}
private void initializeTable(List<ViewProductDTO> products) {
String[] columns = {"Mã", "Tên sản phẩm", "Giá", "Loại", "Số lượng", "DVT"};
tableModel = new DefaultTableModel(columns, 0);
table = new JTable(tableModel);

// Wrap table in scroll pane
JScrollPane scrollPane = new JScrollPane(table);
scrollPane.setBounds(31, 164, 940, 415);
getContentPane().add(scrollPane);

// Initialize popup menu with Edit and Delete options
JPopupMenu popupMenu = new JPopupMenu();
JMenuItem edit = new JMenuItem("Sửa");
JMenuItem delete = new JMenuItem("Xóa");
popupMenu.add(edit);
popupMenu.add(delete);
table.setComponentPopupMenu(popupMenu);  // Attach to table

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

// Set preferred column widths and alignment
table.getColumnModel().getColumn(0).setPreferredWidth(50);  // Mã
table.getColumnModel().getColumn(1).setPreferredWidth(200); // Tên sản phẩm
table.getColumnModel().getColumn(2).setPreferredWidth(100); // Giá
table.getColumnModel().getColumn(3).setPreferredWidth(100); // Loại
table.getColumnModel().getColumn(4).setPreferredWidth(80);  // Số lượng
table.getColumnModel().getColumn(5).setPreferredWidth(60);  // DVT

// Center-align certain columns
DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
table.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);

}

private void Search() {
	String searchText = txtSearch.getText().trim().toLowerCase();

	// Clear the table before displaying the search results
	tableModel.setRowCount(0);

	// Search and filter the products
	ViewListProductPresenter presenter = new ViewListProductPresenter();
	ViewProductListDAO data = new ViewProductListDAO();
	UsecaseControl usecaseControl = new UsecaseControl(presenter, data);
	ViewListProductController viewListProductController = new ViewListProductController(usecaseControl);
	viewListProductController.execute();

	for (ViewProductDTO product : presenter.getViewProductDTOs()) {
		String productName = product.getName().toLowerCase();
		String productId = String.valueOf(product.getMaMh());
		
		if (productName.contains(searchText) || productId.contains(searchText)) {
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
	}
	
	if (tableModel.getRowCount() == 0) {
		JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào trùng với \"" + searchText + "\".");
	}
}

}

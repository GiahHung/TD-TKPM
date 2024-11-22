package com.example.ui.findProduct;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.example.usecase.findProduct.FindProductOutputDTO;

public class FindProductForm {
    public FindProductForm(List<FindProductOutputDTO> products) {
        JFrame frame = new JFrame();
        frame.setSize(900, 500);

        JLabel titleLabel = new JLabel("DANH SÁCH SẢN PHẨM CÒN 1 TUẦN HẾT HẠN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); 
        String[] columns = {
                "Mã", "Tên sản phẩm", "Giá", "Loại", "Số lượng ", "DVT", "NSX","HSD","Nhà cung cấp"
        };

        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 0; i < products.size(); i++) {
            FindProductOutputDTO product = products.get(i);
            Object[] row = {
                    i + 1,
                    product.getMaMh(),
                    product.getName(),
                    product.getPrice(),
                    product.getCategory(),
                    product.getQuantity(),
                    product.getDvt(),
                    product.getNSX(),
                    product.getHSD(),
                    product.getNhacc(),
            };
            tableModel.addRow(row);
        }

        JScrollPane scrollPane = new JScrollPane(table);

        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.NORTH); 
        frame.add(scrollPane, BorderLayout.CENTER); 

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

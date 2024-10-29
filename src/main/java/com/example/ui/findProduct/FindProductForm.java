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
 public  void createAndShowGUI(List<FindProductOutputDTO> products) {
        JFrame frame = new JFrame("Student Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);

        // Create title label
        JLabel titleLabel = new JLabel("DANH SÁCH SẢN PHẨM CÒN 1 TUẦN HẾT HẠN", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Padding around the title

        // Column headers for the JTable
        String[] columns = {
                "Mã", "tên sản phẩm", "Giá", "Loại", "Số lượng", "DVT", "NSX","HSD","Nhà cung cấp"
        };

        // Create table model
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);

        // Sample list of students
        //List<Student> students = getStudentList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // Add student data to the table
        for (int i = 0; i < products.size(); i++) {
            FindProductOutputDTO product = products.get(i);
            Object[] row = {
                    product.getMaMh(),
                    product.getName(),
                    product.getPrice(),
                    product.getCategory(),
                    product.getQuantity(),
                    product.getDvt(),
                    sdf.format(product.getNSX()),
                    sdf.format(product.getHSD()),
                    product.getNhacc(),
                    
            };
            tableModel.addRow(row);
        }

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Set up layout for the frame
        frame.setLayout(new BorderLayout());
        frame.add(titleLabel, BorderLayout.NORTH); // Add title label at the top
        frame.add(scrollPane, BorderLayout.CENTER); // Add the table in the center

        // Make the frame visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

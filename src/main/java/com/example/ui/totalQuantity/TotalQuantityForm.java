package com.example.ui.totalQuantity;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class TotalQuantityForm extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtFood;
	private JTextField txtCeramic;
	private JTextField txtElectronic;

	public TotalQuantityForm(int quantityFood,int quantityCeramic,int quantityElectronic){
		setBounds(300, 300, 950, 100);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(0, 4, 0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					JLabel lblNewLabel = new JLabel("Tổng số lượng sản phẩm:");
					panel_1.add(lblNewLabel);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					JLabel lblNewLabel_1 = new JLabel("Thực phẩm:");
					panel_1.add(lblNewLabel_1);
				}
				{
					txtFood = new JTextField();
					txtFood.setEditable(false);
					panel_1.add(txtFood);
					txtFood.setColumns(10);
					txtFood.setText(String.valueOf(quantityFood));
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					JLabel lblNewLabel_2 = new JLabel("Sành sứ");
					panel_1.add(lblNewLabel_2);
				}
				{
					txtCeramic = new JTextField();
					txtCeramic.setEditable(false);
					panel_1.add(txtCeramic);
					txtCeramic.setColumns(10);
					txtCeramic.setText(String.valueOf(quantityCeramic));
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					JLabel lblNewLabel_3 = new JLabel("Điện máy");
					panel_1.add(lblNewLabel_3);
				}
				{
					txtElectronic = new JTextField();
					txtElectronic.setEditable(false);
					panel_1.add(txtElectronic);
					txtElectronic.setColumns(10);
					txtElectronic.setText(String.valueOf(quantityElectronic));
				}
			}
		}
		
	}
}



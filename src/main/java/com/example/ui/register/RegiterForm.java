package com.example.ui.register;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.example.database.ResgisterDAO;
import com.example.ui.login.LoginForm;
import com.example.usecase.ResponseData;
import com.example.usecase.register.ResgisterInputDTO;
import com.example.usecase.register.ResgisterUsecase;
import com.example.usecase.register.ResponeData;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class RegiterForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirm;
	private JLabel lblInfo;

	public RegiterForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 460);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(164, 36, 132, 45);
		contentPane.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(73, 119, 291, 45);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(73, 199, 291, 45);
		contentPane.add(txtPassword);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(73, 87, 72, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(73, 174, 72, 15);
		contentPane.add(lblNewLabel_2);
		
		lblInfo = new JLabel("");
		lblInfo.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblInfo.setForeground(new Color(204, 51, 51));
		lblInfo.setBounds(73, 317, 291, 24);
		contentPane.add(lblInfo);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					register();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setBackground(new Color(255, 51, 0));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegister.setBounds(146, 363, 132, 32);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(73, 254, 132, 13);
		contentPane.add(lblNewLabel_3);
		
		txtConfirm = new JPasswordField();
		txtConfirm.setBounds(73, 275, 291, 44);
		contentPane.add(txtConfirm);
	}

	public void register() throws Exception {
    ResgisterPresenter registerPresenter = new ResgisterPresenter();
    ResgisterDAO registerDAO = new ResgisterDAO();
    ResgisterUsecase registerUsecase = new ResgisterUsecase(registerDAO, registerPresenter);
    ResgisterController registerController = new ResgisterController(registerUsecase);
    if(txtUsername.getText().isEmpty() || txtConfirm.getPassword().length == 0 || txtPassword.getPassword().length == 0){
		lblInfo.setText("Vui lòng điền đầy đủ thông tin");
		return;
	}
    String userName = txtUsername.getText();
    char[] password = txtPassword.getPassword();
    char[] confirm = txtConfirm.getPassword();

    String passwordString = new String(password);
    String confirmString = new String(confirm);
    
    ResgisterInputDTO dto = new ResgisterInputDTO(userName, passwordString, confirmString);

    registerController.execute(dto);
    ResponeData res = registerPresenter.getRes();

    if (res.getMessageConfirm() != null) {
		lblInfo.setText(res.getMessageConfirm());
	} else if (res.getMessageFail() != null) {
		lblInfo.setText(res.getMessageFail());
	} else {
		// Registration successful, open LoginForm and close this form
		new LoginForm().setVisible(true);
		this.dispose();
	}

    
    Arrays.fill(password, '0');
    Arrays.fill(confirm, '0');
}
}

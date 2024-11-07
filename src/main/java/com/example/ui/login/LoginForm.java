package com.example.ui.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.example.database.GetAllCodeDAO;
import com.example.database.LoginDAO;
import com.example.database.ViewProductListDAO;
import com.example.ui.MainForm;
import com.example.ui.UserForm;
import com.example.ui.ViewListProductController;
import com.example.ui.ViewListProductPresenter;
import com.example.ui.getAllCode.GetAllCodePresenter;
import com.example.ui.register.RegiterForm;
import com.example.usecase.UsecaseControl;
import com.example.usecase.getAllCode.GetAllCodeUsecase;
import com.example.usecase.login.LoginInputDTO;
import com.example.usecase.login.LoginOutputDTO;
import com.example.usecase.login.LoginUsecase;
import com.example.usecase.login.ResponeData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblInfo;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 460);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(194, 36, 132, 45);
		contentPane.add(lblNewLabel);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(73, 134, 291, 45);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(73, 226, 291, 45);
		contentPane.add(txtPassword);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(73, 102, 72, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(73, 201, 72, 15);
		contentPane.add(lblNewLabel_2);
		
		lblInfo = new JLabel("");
		lblInfo.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblInfo.setForeground(new Color(204, 51, 51));
		lblInfo.setBounds(73, 281, 291, 24);
		contentPane.add(lblInfo);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBackground(new Color(102, 255, 153));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(73, 347, 132, 32);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegiterForm registerForm = new RegiterForm();
                registerForm.setVisible(true);
                dispose(); 
			}
		});
		btnRegister.setBackground(new Color(255, 51, 0));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegister.setBounds(232, 347, 132, 32);
		contentPane.add(btnRegister);
	}

	public void login() throws Exception{
		LoginPresenter presenter = new LoginPresenter();
		LoginDAO dao = new LoginDAO();
		LoginUsecase loginUsecase = new LoginUsecase(dao, presenter);
		LoginController controller = new LoginController(loginUsecase);
		if(txtUsername.getText().isEmpty() || txtPassword.getPassword().length == 0){
			lblInfo.setText("Vui lòng điền đầy đủ thông tin");
			return;
		}
		String username = txtUsername.getText();
		char[] password = txtPassword.getPassword();
		String passwordString = new String(password);
		LoginInputDTO dto = new LoginInputDTO(username, passwordString);
		controller.execute(dto);
		LoginOutputDTO loginOutputDTO = presenter.getDto();
		ResponeData res = presenter.getRes();
		boolean checkUser = res.getMessageFail() == null;
		if(!checkUser){
			 lblInfo.setText(res.getMessageFail());
		}else{
			ViewListProductPresenter present = new ViewListProductPresenter();
             ViewProductListDAO data = new ViewProductListDAO();
             UsecaseControl usecaseControl = new UsecaseControl(present, data);
             ViewListProductController viewListProductController = new ViewListProductController(usecaseControl);
             viewListProductController.execute();
             GetAllCodeDAO dataCategory = new GetAllCodeDAO();
             GetAllCodePresenter presentCategory = new GetAllCodePresenter();
             GetAllCodeUsecase usecase = new GetAllCodeUsecase(dataCategory,presentCategory);
             usecase.execute("category");
			 Runnable formToShow;
             if ("user".equals(loginOutputDTO.getRole())) {
                 formToShow = () -> new UserForm(present.getViewProductDTOs(), presentCategory.getCategory());
             } else {
                 formToShow = () -> new MainForm(present.getViewProductDTOs(), presentCategory.getCategory());
            }

        // Show the selected form and close the current one
        SwingUtilities.invokeLater(formToShow);
        this.dispose();
			 
             
		}
	}
}

package QL;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;


public class Dangnhap extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JPasswordField passwordField;
    private JTextField txtUsername;
    private JButton btnNewButton_1;
    
    private static String maNhanVien;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {    
                    Dangnhap frame = new Dangnhap();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    } 
    public Dangnhap() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 340, 510);
        setResizable(false);
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            }
        };
        contentPane.setForeground(new Color(128, 128, 64));
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        //Màu
        Color customColor1 = new Color(113, 170, 117);//Màu xanh nhạt
        Color customColor2 = new Color(246, 246, 246);//Màu nền nhập
        
        
        //Nhập Tên tài khoản
        txtUsername = new JTextField();
        txtUsername.setBounds(10, 148, 306, 37);
        txtUsername.setText("Username");
        txtUsername.setBackground(customColor2);
        txtUsername.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUsername.getText().equals("Username")) {
                    txtUsername.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                String input = txtUsername.getText().trim(); // Loại bỏ khoảng trắng
                if (input.isEmpty()) {
                    txtUsername.setText("Username");
                } else {
                    txtUsername.setText(input); // Gán lại giá trị đã được loại bỏ khoảng trắng
                }
            }
        });
        contentPane.setLayout(null);
        txtUsername.setColumns(10);

		/* txtUsername.setBorder(new RoundBorder(10)); */
        contentPane.add(txtUsername);
        
        
        //Nút đăng nhập
        JButton btnNewButton = new JButton("Sign In");
        btnNewButton.setBounds(113, 276, 96, 23);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		//Ex 
				
				  setVisible(false); 
				  Home home = new Home(); 
				  home.setVisible(true);
				 
        		
        	}
        });
        btnNewButton.setBackground(Color.BLACK); 
        btnNewButton.setForeground(SystemColor.textHighlightText);
        contentPane.add(btnNewButton);
        
        //khung màu vàng
        JPanel toppanel = new JPanel();
        toppanel.setBounds(0, 0, 326, 117);
        toppanel.setLayout(null);
        toppanel.setBackground(Color.PINK);
        contentPane.add(toppanel);
        
        
        //Nút quên mật khẩu
        JButton btnNewButton_2 = new JButton("Forgot password?");
        btnNewButton_2.setBounds(175, 244, 141, 23);
        btnNewButton_2.setBackground(new Color(255, 255, 255));
        contentPane.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// THÊM Ở ĐÂY
        	}
        });
        btnNewButton_2.setBorderPainted(false);
        
        
        //Bảng Đăng nhập
        JLabel lblNewLabel = new JLabel("SIGN IN");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(20, 45, 76, 23);
        toppanel.add(lblNewLabel);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBounds(261, 72, 65, 45);
        toppanel.add(panel_1);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(223, 84, 40, 33);
        toppanel.add(panel_2);
        
    
        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 326, 320);
        contentPane.add(layeredPane);
        
        
      
        
        
      //Phần mật khẩu
                // Toggle button for showing/hiding password
                JToggleButton toggleButton = new JToggleButton("");
                toggleButton.setBackground(new Color(246, 246, 246));
                toggleButton.setBounds(270, 203, 39, 23);
                toggleButton.setBorderPainted(false);
                layeredPane.add(toggleButton);
                
                JToggleButton tglbtnNewToggleButton = new JToggleButton("");
                tglbtnNewToggleButton.setBounds(270, 203, 39, 23);
                tglbtnNewToggleButton.setBackground(customColor2);
                tglbtnNewToggleButton.setBorderPainted(false);
                layeredPane.add(tglbtnNewToggleButton);
                

                passwordField = new JPasswordField();
                passwordField.setBounds(10, 196, 306, 37);
                layeredPane.add(passwordField);
                passwordField.setText("Password");
                passwordField.setBackground(customColor2);
                passwordField.setEchoChar((char) 0);
                
                        // Listener for focusing on the password field
                passwordField.addFocusListener(new FocusListener() {
                            @Override
                            public void focusGained(FocusEvent e) {
                                char[] password = passwordField.getPassword();
                                if (password.length > 0 && String.valueOf(password).equals("Password")) {
                                	passwordField.setText("");
                                	passwordField.setEchoChar('*');
                                }
                            }
                
                            @Override
                            public void focusLost(FocusEvent e) {
                                char[] password = passwordField.getPassword();
                                if (password.length == 0) {
                                	passwordField.setText("Password");
                                	passwordField.setEchoChar((char) 0);
                                }
                            }
                        });
                
                        // Listener for the toggle button
                        toggleButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (toggleButton.isSelected()) {
                                	passwordField.setEchoChar((char) 0);
                                    toggleButton.setText("Hide");
                                } else {
                                	passwordField.setEchoChar('*');
                                    toggleButton.setText("Show");
                                }
                            }
                        });
    }
    
}
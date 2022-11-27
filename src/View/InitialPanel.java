package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InitialPanel extends JPanel{
    /**
     * The constant LOGIN_NAME_LABEL.
     */
    public static final String LOGIN_NAME_LABEL = "Between Us";
    /**
     * The constant LOGIN_LABEL.
     */
    public static final String LOGIN_LABEL = "LOG IN";
    /**
     * The constant REGISTER_LABEL.
     */
    public static final String REGISTER_LABEL = "REGISTER";
    /**
     * The constant BTN_LOGIN.
     */
    public static final String BTN_LOGIN = "BTN_LOGIN0";
    /**
     * The constant BTN_REGISTER.
     */
    public static final String BTN_REGISTER = "BTN_REGISTER0";

    /**
     * The Jb login.
     */
    private JButton jbLogin;
    /**
     * The Jb signup.
     */
    private JButton jbSignup;

    public InitialPanel() {

        Font  f1  = new Font(Font.SERIF, Font.PLAIN,  10);

        // Setting the Layout
        setLayout(new BorderLayout(20,30));
        setBorder(new EmptyBorder(10, 10, 10, 10) );//adds margin to panel
        // Change background color
        setBackground(Color.white);
        JLabel jlLoginName = new JLabel(LOGIN_NAME_LABEL);
        // Put label on the middle
        jlLoginName.setHorizontalAlignment(SwingConstants.CENTER);
        jlLoginName.setFont(f1);
        add(jlLoginName, BorderLayout.NORTH);

        // Center panel
        JPanel jpCenter = new JPanel();
        jpCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        jpCenter.setBackground(Color.white);
        // Login button
        jbLogin = new JButton();
        jbLogin.setBackground(Color.blue);
        jbLogin.setForeground(Color.white);
        jbLogin.setFont(f1);
        jbLogin.setText(LOGIN_LABEL);
        jbLogin.setActionCommand(BTN_LOGIN);
        jpCenter.add(jbLogin);

        // Register Button
        jbSignup = new JButton();
        jbSignup.setBackground(Color.blue);
        jbSignup.setForeground(Color.white);
        jbSignup.setFont(f1);
        jbSignup.setText(REGISTER_LABEL);
        jbSignup.setActionCommand(BTN_REGISTER);
        jpCenter.add(jbSignup);
        add(jpCenter, BorderLayout.CENTER);
    }
}

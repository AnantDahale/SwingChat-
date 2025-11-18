import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;

public class Client extends JFrame implements ActionListener {
    JTextField text;
    JPanel a1;
    Box vertical = Box.createVerticalBox();

    Client() {

        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/left_arrow.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        JLabel back = new JLabel(new ImageIcon(i2));
        back.setBounds(5, 20, 25, 25);
        p1.add(back);

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/dogesh.png"));
        Image i5 = i4.getImage().getScaledInstance(40, 55, Image.SCALE_DEFAULT);
        JLabel profile = new JLabel(new ImageIcon(i5));
        profile.setBounds(40, 10, 50, 50);
        p1.add(profile);

        JLabel name = new JLabel("Dogesh Bhai");
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        p1.add(name);

        JLabel status = new JLabel("Active now");
        status.setBounds(110, 35, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.PLAIN, 12));
        p1.add(status);

        a1 = new JPanel();
        a1.setBounds(5, 75, 440, 560);
        a1.setLayout(new BorderLayout());
        add(a1);

        text = new JTextField();
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(text);

        JButton send = new JButton("Send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        add(send);

        setSize(450, 700);
        setLocation(800, 50);
        setUndecorated(true);
        getContentPane().setBackground(Color.white);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String out = text.getText();
        if (out.isEmpty()) return;

        JPanel p2 = formatLabel(out);

        JPanel right = new JPanel(new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);

        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));

        a1.add(vertical, BorderLayout.PAGE_START);

        text.setText("");

        a1.revalidate();
        a1.repaint();
    }

    public static JPanel formatLabel(String out) {

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JLabel label = new JLabel("<html><p style=\"width: 150px\">" + out + "</p></html>");
    label.setFont(new Font("Tahoma", Font.PLAIN, 16));
    label.setBackground(new Color(37, 211, 102));
    label.setOpaque(true);
    label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    panel.add(label);

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    JLabel time = new JLabel(sdf.format(new Date()));  // Use current date/time
    time.setFont(new Font("Tahoma", Font.PLAIN, 12));
    panel.add(time);

    return panel;
}


    public static void main(String[] args) {
        new Client();
    }
}

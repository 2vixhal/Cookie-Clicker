import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//write a program 
public class RockPaperScissorGUI extends JFrame implements ActionListener {
    // player buttons
    JButton rockButton, resetButton;
    // will diaplay the choice of the computer

    JLabel playerScoreLabel;
    // backend obj
    RockPaperScissor rockPaperScissor;
    private int playerScore;

    public RockPaperScissorGUI() {
        super("Cookie Clicker");
        setSize(450, 574);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // initialize the backend obj
        rockPaperScissor = new RockPaperScissor();

        addGuiComponents();
    }

    private void addGuiComponents() {
        // Centered banner label
        int bannerWidth = 300;
        int bannerHeight = 80;
        int bannerX = (getWidth() - bannerWidth) / 2;
        JLabel bannerLabel = new JLabel();
        bannerLabel.setBounds(bannerX, 25, bannerWidth, bannerHeight);
        ImageIcon banner = new ImageIcon("banners.png");
        Image img1 = banner.getImage();
        Image newimg1 = img1.getScaledInstance(bannerLabel.getWidth(), bannerLabel.getHeight(), Image.SCALE_SMOOTH);
        banner = new ImageIcon(newimg1);
        bannerLabel.setIcon(banner);
        add(bannerLabel);

        // Centered rock button
        int buttonWidth = 200;
        int buttonHeight = 200;
        int buttonX = (getWidth() - buttonWidth) / 2;
        rockButton = new JButton();
        rockButton.setBounds(buttonX, 125, buttonWidth, buttonHeight);
        ImageIcon cookie = new ImageIcon("cookie.png");
        Image img = cookie.getImage();
        Image newimg = img.getScaledInstance(rockButton.getWidth(), rockButton.getHeight(), Image.SCALE_SMOOTH);
        cookie = new ImageIcon(newimg);
        rockButton.setIcon(cookie);
        rockButton.addActionListener(this);
        add(rockButton);

        // player score label (already centered horizontally)
        playerScoreLabel = new JLabel("Click: 0");
        playerScoreLabel.setBounds(0, 350, 450, 30);
        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        // Centered reset button
        int resetWidth = 100;
        int resetHeight = 20;
        int resetX = (getWidth() - resetWidth) / 2;
        resetButton = new JButton("Reset");
        resetButton.setBounds(resetX, 500, resetWidth, resetHeight);
        resetButton.setFont(new Font("Dialog", Font.PLAIN, 18));
        resetButton.addActionListener(this);
        add(resetButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String playerChoice = e.getActionCommand().toString();
        rockPaperScissor.playRockPaperScissor(playerChoice);
        playerScoreLabel.setText("Click: " + rockPaperScissor.getPlayerScore());

    }
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * The ProfilePanel class represents a panel that displays profile information.
 * It contains a name, occupation, and picture.
 */
public class ProfilePanel extends JPanel {
    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JLabel pictureLabel;

    /**
     * Constructs a ProfilePanel object with the given name, occupation, and picture.
     *
     * @param name        The name to be displayed.
     * @param occupation  The occupation to be displayed.
     * @param picturePath The file path of the picture to be displayed.
     */
    public ProfilePanel(String name, String occupation, String picturePath) {
        setLayout(new BorderLayout());
        setBackground(new Color(133, 129, 143));

        // Create and configure the name label
        nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create and configure the occupation label
        occupationLabel = new JLabel(occupation);
        occupationLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        occupationLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create and configure the picture label
        ImageIcon pictureIcon = new ImageIcon(picturePath);
        pictureLabel = new JLabel(pictureIcon);
        pictureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pictureLabel.setBorder(new EmptyBorder(30, 30, 30, 30));

        // Add the name label to the north position of the panel
        add(nameLabel, BorderLayout.NORTH);
        // Add the picture label to the center position of the panel
        add(pictureLabel, BorderLayout.CENTER);
        // Add the occupation label to the south position of the panel
        add(occupationLabel, BorderLayout.SOUTH);
    }
}

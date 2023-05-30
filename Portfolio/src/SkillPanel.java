import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class SkillPanel extends JPanel {
    private JScrollPane scrollPane;
    private JPanel contentPanel;

    /**
     * Constructs a SkillPanel object.
     * This panel displays a list of skill paragraphs with associated images.
     */
    public SkillPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 400));
        setBackground(new Color(41, 39, 46));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create a panel to hold the skill paragraphs
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);

        // Create a scroll pane to enable scrolling if the content overflows
        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);

        // Add the scroll pane to the panel
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Adds a skill paragraph with an associated image to the SkillPanel.
     *
     * @param paragraph  The skill paragraph to be displayed.
     * @param imagePath  The path to the image file associated with the skill.
     */
    public void addParagraph(String paragraph, String imagePath) {
        // Create a panel to hold the skill paragraph and image
        JPanel paragraphPanel = new JPanel();
        paragraphPanel.setLayout(new BorderLayout());
        paragraphPanel.setOpaque(false);
        paragraphPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));

        // Load and scale the image
        ImageIcon image = new ImageIcon(imagePath);
        Image scaledImage = image.getImage().getScaledInstance(800, 520, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        // Create a label to display the image
        JLabel imageLabel = new JLabel(scaledImageIcon);
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create a text area to display the skill paragraph
        JTextArea paragraphTextArea = new JTextArea();
        paragraphTextArea.setFont(new Font("font", Font.PLAIN, 24));
        paragraphTextArea.setForeground(Color.WHITE);
        paragraphTextArea.setEditable(false);
        paragraphTextArea.setLineWrap(true);
        paragraphTextArea.setWrapStyleWord(true);
        paragraphTextArea.setText(paragraph);
        paragraphTextArea.setOpaque(false);
        paragraphTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add the image label and paragraph text area to the paragraph panel
        paragraphPanel.add(imageLabel, BorderLayout.NORTH);
        paragraphPanel.add(paragraphTextArea, BorderLayout.CENTER);

        // Add spacing and the paragraph panel to the content panel
        contentPanel.add(Box.createVerticalStrut(15));
        contentPanel.add(paragraphPanel);
        contentPanel.revalidate();

        // Scroll to the top of the scroll pane
        scrollPane.getVerticalScrollBar().setValue(0);
    }
}

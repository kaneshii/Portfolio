import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 * The Main class represents the entry point of the application.
 */
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Self Portfolio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Create instances of different panels
        ProfilePanel profilePanel = new ProfilePanel("MAIN PROFILE", "Mark Joshua Rivera | BSIT - MAA (INF 229)", "myself.png");
        SkillPanel skillPanel = new SkillPanel();
        ProjectPanel projectPanel = new ProjectPanel();

        // Add paragraphs and images to the SkillPanel
        skillPanel.addParagraph("I make illustrations and graphic design with either Photoshop or Illustrator.\nI started illustrating when I found out about streetwear designing, and most of my designs follow that concept.\nMost of my designs are for shirts with a streetwear aesthetic, often featuring girls as the subjects.", "FirstSkill.png");
        skillPanel.addParagraph("I am currently a League of Legends player at AcadArena.\nI represent National University Manila and play as a Marksman Carry (sometimes swapped for Jungler role).\nI am also the team captain for team 2 of NU Manila.", "SecondSkill.png");
        skillPanel.addParagraph("I currently do digital art and previously practiced traditional art.\nAs a hobby back in high school, I enjoyed drawing characters from anime, especially those liked by my crushes.\nNow I focus on digital art and often turn them into fan art based on my friends' favorite characters.", "ThirdSkill.png");

        // Add projects with descriptions and images to the ProjectPanel
        projectPanel.addProject("Shown above are my designs that would've been used as T-shirt designs but sadly was rejected, all of them are made using Photoshop", Arrays.asList("designs2.png","designs3.png"));
        projectPanel.addProject("Shown on the left is my current role for the roster as the team captain, my current season peak of the game and our current jersey for AcadArena League of Legends NU Manila \nShown on the left is one of the latest tournament we joined which is League of Legends Aces(April) and the current active roster for Team 2.\nteam 2 was not able to join Aces for May due to midterms deadlines conflict", Arrays.asList("esports1.png","esports2.png","esports3.png","esports4.png"));
        projectPanel.addProject("Shown above are my traditional drawings which were requested by my first love back in highschool and some friends, \nsame with the digital arts where they gave me a reference picture which is them in order for me to transform them into their requested character", Arrays.asList("drawing1.png","drawing2.png","DigitalArt1.png","DigitalArt2.png","DigitalArt3.png","DigitalArt4.png"));

        // Add panels to the tabbedPane
        tabbedPane.addTab("Profile", profilePanel);
        tabbedPane.addTab("Skills", skillPanel);
        tabbedPane.addTab("Projects", projectPanel);

        frame.add(tabbedPane);
        frame.pack();
        frame.setVisible(true);
    }
}

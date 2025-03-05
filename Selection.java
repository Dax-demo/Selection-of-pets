import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonDemo extends JFrame {
    private JLabel imageLabel;
    private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
    private ButtonGroup group;
    private String[] petNames = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};
    private String[] petImages = {"bird.png", "cat.png", "dog.png", "rabbit.png", "pig.png"};
    
    public RadioButtonDemo() {
        setTitle("RadioButtonDemo");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        
        JPanel panel = new JPanel(new GridLayout(5, 1));
        group = new ButtonGroup();
        
        birdButton = new JRadioButton("Bird");
        catButton = new JRadioButton("Cat");
        dogButton = new JRadioButton("Dog");
        rabbitButton = new JRadioButton("Rabbit");
        pigButton = new JRadioButton("Pig");
        
        group.add(birdButton);
        group.add(catButton);
        group.add(dogButton);
        group.add(rabbitButton);
        group.add(pigButton);
        
        panel.add(birdButton);
        panel.add(catButton);
        panel.add(dogButton);
        panel.add(rabbitButton);
        panel.add(pigButton);
        
        imageLabel = new JLabel();
        updateImage("pig.png");
        
        add(panel);
        add(imageLabel);
        
        birdButton.addActionListener(new PetSelectionListener(0));
        catButton.addActionListener(new PetSelectionListener(1));
        dogButton.addActionListener(new PetSelectionListener(2));
        rabbitButton.addActionListener(new PetSelectionListener(3));
        pigButton.addActionListener(new PetSelectionListener(4));
        
        pigButton.setSelected(true);
    }
    
    private class PetSelectionListener implements ActionListener {
        private int index;
        
        public PetSelectionListener(int index) {
            this.index = index;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            updateImage(petImages[index]);
            JOptionPane.showMessageDialog(null, "You selected: " + petNames[index]);
        }
    }
    
    private void updateImage(String imageName) {
        ImageIcon icon = new ImageIcon(imageName);
        imageLabel.setIcon(icon);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RadioButtonDemo().setVisible(true));
    }
}
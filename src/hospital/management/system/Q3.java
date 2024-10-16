package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



    public class Q3 {
        public static void main(String[] args) {
            // Create a JFrame
            JFrame frame = new JFrame("Event Handling Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create a JButton
            JButton button = new JButton("Click me!");
            button.addActionListener(new ButtonClickListener());

            // Add the button to the frame
            frame.getContentPane().add(button, BorderLayout.CENTER);

            // Set the frame's size and visibility
            frame.setSize(300, 200);
            frame.setVisible(true);
        }
    }

     class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Handle the event
            System.out.println("Button clicked!");
        }
    }


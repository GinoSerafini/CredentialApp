/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package credentialapp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Kyle
 */
public class NavigationMenu {
    public static void main(String[] args) {
       JFrame frame = new JFrame("Main Menu");
        
        JPanel panel = new JPanel();
        
        
        JButton button = new JButton();
        button.setText("Store Credentials");
        
        JButton button2 = new JButton();
        button2.setText("Search Credentials");
        
        JButton button4 = new JButton();
        button4.setText("Update Credentials");
        
        JButton button3 = new JButton();
        button3.setText("Generate Password");
        
        
        panel.add(button);
        panel.add(button4);
        panel.add(button2);
        panel.add(button3);
        
        frame.add(panel);
        frame.setSize(300,200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

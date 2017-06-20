/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.prog3;

import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author rodrigo
 */
public class ImageViewer {
    private JFrame frame;
    
    public ImageViewer() {
        makeFrame();
    }
    
    private void makeFrame() {
        frame = new JFrame("ImageViewer");
        Container contentPane = frame.getContentPane();
        
        JLabel label = new JLabel("Eu sou um label.");
        contentPane.add(label);
        
        frame.pack();
        frame.setVisible(true);
    }
}

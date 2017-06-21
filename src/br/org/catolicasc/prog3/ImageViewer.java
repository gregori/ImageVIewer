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
        // Cria um novo quadro com o título ImageViewer
        frame = new JFrame("ImageViewer");
        
        // Obtém o painel de conteudo (Container) do frame
        Container contentPane = frame.getContentPane();
        
        // Cria um label - objeto de texto
        JLabel label = new JLabel("Eu sou um label.");
        // Adiciona o label ao painel
        contentPane.add(label);
        
        // Organiza e dimensiona os elementos no quadro
        frame.pack();
        
        // Torna o quadro visível
        frame.setVisible(true);
    }
}

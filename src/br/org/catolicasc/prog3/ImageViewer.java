/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.prog3;

import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author rodrigo
 */
public class ImageViewer {
    private JFrame frame;
    private ImagePanel imagePanel;
    
    public ImageViewer() {
        makeFrame();
    }
    
    // ---- implementação das funções de menu ----
    
    /**
     * Abrir arquivo: abre um seletor de arquivos
     * para selecionar um novo arquivo de imagem.
     */
    private void abrirArquivo()
    {
        OFImage image = ImageFileManager.getImage();
        imagePanel.setImage(image);
        frame.pack();
    }
    
    /**
     * Sair do sistema: sai da aplicação.
     */
    private void sair()
    {
        System.exit(0);
    }
    
    // ---- coisas para construir o quadro swing e seus componentes ----
    
    /**
     * Cria o frame Swing e seu conteúdo.
     */
    private void makeFrame()
    {
        frame = new JFrame("ImageViewer");
        makeMenuBar(frame);
        
        Container contentPane = frame.getContentPane();
        
        imagePanel = new ImagePanel();
        contentPane.add(imagePanel);

        // building is done - arrange the components and show        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Create the main frame's menu bar.
     * @param frame   The frame that the menu bar should be added to.
     */
    private void makeMenuBar(JFrame frame)
    {
        final int SHORTCUT_MASK =
            Toolkit.getDefaultToolkit().getMenuShortcutKeyMask();


        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        // create the File manu
        JMenu fileMenu = new JMenu("Arquivo");
        menubar.add(fileMenu);
        
        JMenuItem openItem = new JMenuItem("Abrir");
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, SHORTCUT_MASK));
        openItem.addActionListener(new ActionListener() {
                           public void actionPerformed(ActionEvent e) { 
                               abrirArquivo(); 
                           }
                       });
        fileMenu.add(openItem);

        JMenuItem quitItem = new JMenuItem("Sair");
        quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, SHORTCUT_MASK));
        quitItem.addActionListener(new ActionListener() {
                           public void actionPerformed(ActionEvent e) { 
                               sair(); 
                           }
                       });
        fileMenu.add(quitItem);

    }
}

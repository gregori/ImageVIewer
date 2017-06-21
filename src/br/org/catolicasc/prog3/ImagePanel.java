/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.prog3;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * Um ImagePanel é um componente Swing que pode mostrar uma OFImage.
 * É construido como uma subclasse de JComponent com a funcionalidade
 * de setar uma OFImage que vai ser mostrada na superfície desse componente.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0
 */
public class ImagePanel extends JComponent
{
    // A largura e altura atual desse painel
    private int width, height;

    // Um buffer interno de imagem que é usado para pintar. Para 
    // mostrar a imagem, ela vai ser copiada para a tela.
    private OFImage panelImage;

    /**
     * Cria um ImagePanel novo e vazio.
     */
    public ImagePanel()
    {
        width = 360;    // tamanho aleatório para o painel novo
        height = 240;
        panelImage = null;
    }

    /**
     * Seta a imagem que esse painel deve mostrar.
     * 
     * @param image  The image to be displayed.
     */
    public void setImage(OFImage image)
    {
        if(image != null) {
            width = image.getWidth();
            height = image.getHeight();
            panelImage = image;
            repaint();
        }
    }
    
    /**
     * Limpa a imagem deste painel.
     */
    public void clearImage()
    {
        Graphics imageGraphics = panelImage.getGraphics();
        imageGraphics.setColor(Color.LIGHT_GRAY);
        imageGraphics.fillRect(0, 0, width, height);
        repaint();
    }
    
    // Os métodos a seguir são redefinições dos métodos herdados
    // das superclasses.
    
    /**
     * Diz ao layout manager o tamanho que gostaríamos de ter.
     * (este método é chamado pelos layout managers para posicionar
     * os componentes)
     * 
     * @return The preferred dimension for this component.
     */
    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(width, height);
    }
    
    /**
     * Teste componende deve ser redesenhado. Copia a imagem interna para a tela
     * (Este método é chamado pelo screen painter do Swing
     * toda vez que ele quer mostrar este componente.)
     *  
     * @param g The graphics context that can be used to draw on this component.
     */
    @Override
    public void paintComponent(Graphics g)
    {
        Dimension size = getSize();
        g.clearRect(0, 0, size.width, size.height);
        if(panelImage != null) {
            g.drawImage(panelImage, 0, 0, null);
        }
    }
}

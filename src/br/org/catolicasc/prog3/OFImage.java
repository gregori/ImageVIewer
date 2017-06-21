/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.prog3;

import java.awt.Color;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

/**
 * OFImage é uma classe que define uma imagem no formado OF (objects first)
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0
 */
public class OFImage extends BufferedImage
{
    /**
     * Cria um OFImage copiado de uma BufferedImage
     * @param image The image to copy.
     */
    public OFImage(BufferedImage image)
    {
         super(image.getColorModel(), image.copyData(null), 
               image.isAlphaPremultiplied(), null);
    }

    /**
     * Cria uma OFImage com tamanho específico, sem especificar conteúdo
     * @param width The width of the image.
     * @param height The height of the image.
     */
    public OFImage(int width, int height)
    {
        super(width, height, TYPE_INT_RGB);
    }

    /**
     * Atribui uma cor a um pixel dessa imagem. A cor é representada
     * como um valor (r,g,b).
     * @param x The x position of the pixel.
     * @param y The y position of the pixel.
     * @param col The color of the pixel.
     */
    public void setPixel(int x, int y, Color col)
    {
        int pixel = col.getRGB();
        setRGB(x, y, pixel);
    }
    
    /**
     * Obtem o valor da cor em uma posição de pixel específica.
     * @param x The x position of the pixel.
     * @param y The y position of the pixel.
     * @return The color of the pixel at the given position.
     */
    public Color getPixel(int x, int y)
    {
        int pixel = getRGB(x, y);
        return new Color(pixel);
    }
}


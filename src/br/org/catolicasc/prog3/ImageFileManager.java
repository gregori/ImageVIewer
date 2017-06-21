/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.catolicasc.prog3;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 * ImageFileManager é uma classe utulitária com métodos estáticos
 * para carregar e salvar imagens.
 * 
 * Os arquivos podem estar no formato JPG ou PNG. Para arquivos escritos 
 * por esta classe, o formato é determinado pela constante IMAGE_FORMAT.
 * 
 * @author Michael Kolling and David J Barnes 
 * @version 1.0
 */
public class ImageFileManager
{
    // Uma constante para o formato de imagem que este writer usa para criar.
    // Formatos disponíveis são "jpg" e "png".
    private static final String IMAGE_FORMAT = "jpg";
    private static final JFileChooser fileChooser = 
            new JFileChooser(System.getProperty("user.dir"));
    
    /**
     * Abre um dialogo para escolher arquivos e deixa o usuário escolher uma
     * imagem no sistema de arquivos. Então lê o arquivo do disco e o retorna
     * como uma imagem. Este método pode ler formatos JPG e PNG. Caso haja algum 
     * problema (ex: o arquiv não existe, está em um formato incompatível
     * ou outro erro) o método retorna null.
     * 
     * @return       The image object or null is it was not a valid image file.
     */
    public static OFImage getImage()
    {
        int returnVal = fileChooser.showOpenDialog(null);

        if(returnVal != JFileChooser.APPROVE_OPTION) {
            return null;  // cancelled
        }
        File selectedFile = fileChooser.getSelectedFile();
        return loadImage(selectedFile);
    }

    /**
     * Lê uma imagem do disco e retorna como uma BufferedImage. Este método
     * pode ler arquivos JPG e PNG. Caso haja algum problema o método retorna 
     * null.
     * 
     * @param imageFile  The image file to be loaded.
     * @return           The image object or null is it was not a valid image file.
     */
    public static OFImage loadImage(File imageFile)
    {
        try {
            BufferedImage image = ImageIO.read(imageFile);
            if(image == null || (image.getWidth(null) < 0)) {
                // we could not load the image - probably invalid file format
                return null;
            }
            return new OFImage(image);
        }
        catch(IOException exc) {
            return null;
        }
    }

    /**
     * Escreve uma imagem no disco. O formato é JPG. Caso haja algum problema 
     * o método apenas retorna em silêncio (não emite erros).
     *
     * @param image  The image to be saved.
     * @param file   The file to save to.
     */
    public static void saveImage(OFImage image, File file)
    {
        try {
            ImageIO.write(image, IMAGE_FORMAT, file);
        }
        catch(IOException exc) {
        }
    }
}


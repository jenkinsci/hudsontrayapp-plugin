package org.hudson.trayapp.gui.tray;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;

import javax.swing.ImageIcon;

public class Images {
	public static final BufferedImage HUDSON;
	public static final BufferedImage H0019;
	public static final BufferedImage H2039;
	public static final BufferedImage H4059;
	public static final BufferedImage H6089;
	public static final BufferedImage H80PL;
	public static final BufferedImage BLUE;
	public static final BufferedImage GREY;
	public static final BufferedImage RED;
	public static final BufferedImage YELLOW;
	public static final BufferedImage COLOURRING;
	
	static {
		Toolkit kit = Toolkit.getDefaultToolkit();
		HUDSON = toBufferedImage(kit.getImage(Images.class.getResource("/org/hudson/trayapp/gui/icons/tray/hudson.png")));
		H0019 = toBufferedImage(kit.getImage(Images.class.getResource("/org/hudson/trayapp/gui/icons/tray/00-19.png")));
		H2039 = toBufferedImage(kit.getImage(Images.class.getResource("/org/hudson/trayapp/gui/icons/tray/20-39.png")));
		H4059 = toBufferedImage(kit.getImage(Images.class.getResource("/org/hudson/trayapp/gui/icons/tray/40-59.png")));
		H6089 = toBufferedImage(kit.getImage(Images.class.getResource("/org/hudson/trayapp/gui/icons/tray/60-79.png")));
		H80PL = toBufferedImage(kit.getImage(Images.class.getResource("/org/hudson/trayapp/gui/icons/tray/80+.png")));
		BLUE = toBufferedImage(kit.getImage(Images.class.getResource("/org/hudson/trayapp/gui/icons/tray/blue.png")));
		GREY = toBufferedImage(kit.getImage(Images.class.getResource("/org/hudson/trayapp/gui/icons/tray/grey.png")));
		RED = toBufferedImage(kit.getImage(Images.class.getResource("/org/hudson/trayapp/gui/icons/tray/red.png")));
		YELLOW = toBufferedImage(kit.getImage(Images.class.getResource("/org/hudson/trayapp/gui/icons/tray/yellow.png")));
		COLOURRING = toBufferedImage(kit.getImage(Images.class.getResource("/org/hudson/trayapp/gui/icons/tray/colourring.png")));
	}
	
	public static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage)image;
        }
    
        // This code ensures that all the pixels in the image are loaded
        image = new ImageIcon(image).getImage();
    
        // Determine if the image has transparent pixels; for this method's
        // implementation, see e661 Determining If an Image Has Transparent Pixels
        boolean hasAlpha = hasAlpha(image);
    
        // Create a buffered image with a format that's compatible with the screen
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            // Determine the type of transparency of the new buffered image
            int transparency = Transparency.OPAQUE;
            if (hasAlpha) {
                transparency = Transparency.BITMASK;
            }
    
            // Create the buffered image
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(
                image.getWidth(null), image.getHeight(null), transparency);
        } catch (HeadlessException e) {
            // The system does not have a screen
        }
    
        if (bimage == null) {
            // Create a buffered image using the default color model
            int type = BufferedImage.TYPE_INT_RGB;
            if (hasAlpha) {
                type = BufferedImage.TYPE_INT_ARGB;
            }
            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        }
    
        // Copy image to buffered image
        Graphics g = bimage.createGraphics();
    
        // Paint the image onto the buffered image
        g.drawImage(image, 0, 0, null);
        g.dispose();
    
        return bimage;
    }
	
	// This method returns true if the specified image has transparent pixels
    public static boolean hasAlpha(Image image) {
        // If buffered image, the color model is readily available
        if (image instanceof BufferedImage) {
            BufferedImage bimage = (BufferedImage)image;
            return bimage.getColorModel().hasAlpha();
        }
    
        // Use a pixel grabber to retrieve the image's color model;
        // grabbing a single pixel is usually sufficient
         PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
        }
    
        // Get the image's color model
        ColorModel cm = pg.getColorModel();
        return cm.hasAlpha();
    }
}

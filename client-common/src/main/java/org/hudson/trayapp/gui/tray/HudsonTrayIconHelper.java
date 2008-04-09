package org.hudson.trayapp.gui.tray;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.hudson.trayapp.gui.tray.AnimatedTrayIcon.ImageAndDelay;
import org.hudson.trayapp.gui.tray.AnimatedTrayIcon.LayeredImage;
import org.hudson.trayapp.gui.tray.blue.Blue;
import org.hudson.trayapp.gui.tray.blue.Blue0to19;
import org.hudson.trayapp.gui.tray.blue.Blue20to39;
import org.hudson.trayapp.gui.tray.blue.Blue40to59;
import org.hudson.trayapp.gui.tray.blue.Blue60to79;
import org.hudson.trayapp.gui.tray.blue.Blue80Plus;
import org.hudson.trayapp.gui.tray.blue.BlueAnime;
import org.hudson.trayapp.gui.tray.blue.BlueAnime0to19;
import org.hudson.trayapp.gui.tray.blue.BlueAnime20to39;
import org.hudson.trayapp.gui.tray.blue.BlueAnime40to59;
import org.hudson.trayapp.gui.tray.blue.BlueAnime60to79;
import org.hudson.trayapp.gui.tray.blue.BlueAnime80Plus;
import org.hudson.trayapp.gui.tray.grey.Grey;
import org.hudson.trayapp.gui.tray.grey.Grey0to19;
import org.hudson.trayapp.gui.tray.grey.Grey20to39;
import org.hudson.trayapp.gui.tray.grey.Grey40to59;
import org.hudson.trayapp.gui.tray.grey.Grey80Plus;
import org.hudson.trayapp.gui.tray.grey.Grey60to79;
import org.hudson.trayapp.gui.tray.red.Red;
import org.hudson.trayapp.gui.tray.red.Red0to19;
import org.hudson.trayapp.gui.tray.red.Red20to39;
import org.hudson.trayapp.gui.tray.red.Red40to59;
import org.hudson.trayapp.gui.tray.red.Red60to79;
import org.hudson.trayapp.gui.tray.red.Red80Plus;
import org.hudson.trayapp.gui.tray.red.RedAnime;
import org.hudson.trayapp.gui.tray.red.RedAnime0to19;
import org.hudson.trayapp.gui.tray.red.RedAnime20to39;
import org.hudson.trayapp.gui.tray.red.RedAnime40to59;
import org.hudson.trayapp.gui.tray.red.RedAnime60to79;
import org.hudson.trayapp.gui.tray.red.RedAnime80Plus;
import org.hudson.trayapp.gui.tray.yellow.Yellow;
import org.hudson.trayapp.gui.tray.yellow.Yellow0to19;
import org.hudson.trayapp.gui.tray.yellow.Yellow20to39;
import org.hudson.trayapp.gui.tray.yellow.Yellow40to59;
import org.hudson.trayapp.gui.tray.yellow.Yellow60to79;
import org.hudson.trayapp.gui.tray.yellow.Yellow80Plus;
import org.hudson.trayapp.gui.tray.yellow.YellowAnime;
import org.hudson.trayapp.gui.tray.yellow.YellowAnime0to19;
import org.hudson.trayapp.gui.tray.yellow.YellowAnime20to39;
import org.hudson.trayapp.gui.tray.yellow.YellowAnime40to59;
import org.hudson.trayapp.gui.tray.yellow.YellowAnime60to79;
import org.hudson.trayapp.gui.tray.yellow.YellowAnime80Plus;
import org.hudson.trayapp.model.Job;

public class HudsonTrayIconHelper  {

	public static class HelperImageAndDelay extends ImageAndDelay {
		public HelperImageAndDelay(BufferedImage colourImage, float alpha, BufferedImage healthImage, int delay) {
			super(new LayeredImage(new BufferedImage[] {
					Images.HUDSON, Images.COLOURRING, colourImage, healthImage
				}, new float[] {
					1f, 1f, alpha, 1f
				}), delay);
		}
		
		public HelperImageAndDelay(BufferedImage colourImage, float alpha, int delay) {
			super(new LayeredImage(new BufferedImage[] {
					Images.HUDSON, Images.COLOURRING, colourImage
				}, new float[] {
					1f, 1f, alpha
				}), delay);
		}
	}
	
	public static class StaticImage extends AnimatedTrayIcon {
		public StaticImage(BufferedImage colourImage, BufferedImage healthImage, TrayIconImplementation trayIcon) {
			super(new ImageAndDelay[]{
					new ImageAndDelay(new LayeredImage(new BufferedImage[] {
						Images.HUDSON, Images.COLOURRING, colourImage, healthImage
					}, new float[] {
						1f, 1f, 1f, 1f
					}), 0)
				}, trayIcon);
		}
		
		public StaticImage(BufferedImage colourImage, TrayIconImplementation trayIcon) {
			super(new ImageAndDelay[]{
					new ImageAndDelay(new LayeredImage(new BufferedImage[] {
						Images.HUDSON, Images.COLOURRING, colourImage
					}, new float[] {
						1f, 1f, 1f
					}), 0)
				}, trayIcon);
		}
	}
	
	public static class AnimatedImage extends AnimatedTrayIcon {
		public AnimatedImage(BufferedImage colourImage, BufferedImage healthImage, TrayIconImplementation trayIcon) {
			super(new ImageAndDelay[]{
					new HelperImageAndDelay(colourImage, 0.0f, healthImage, 100),
					new HelperImageAndDelay(colourImage, 0.2f, healthImage, 100),
					new HelperImageAndDelay(colourImage, 0.4f, healthImage, 100),
					new HelperImageAndDelay(colourImage, 0.6f, healthImage, 100),
					new HelperImageAndDelay(colourImage, 0.8f, healthImage, 100),
					new HelperImageAndDelay(colourImage, 1.0f, healthImage, 100),
					new HelperImageAndDelay(colourImage, 0.8f, healthImage, 100),
					new HelperImageAndDelay(colourImage, 0.6f, healthImage, 100),
					new HelperImageAndDelay(colourImage, 0.4f, healthImage, 100),
					new HelperImageAndDelay(colourImage, 0.2f, healthImage, 100),
				}, trayIcon);
		}
		
		public AnimatedImage(BufferedImage colourImage, TrayIconImplementation trayIcon) {
			super(new ImageAndDelay[]{
					new HelperImageAndDelay(colourImage, 0.0f, 100),
					new HelperImageAndDelay(colourImage, 0.2f, 100),
					new HelperImageAndDelay(colourImage, 0.4f, 100),
					new HelperImageAndDelay(colourImage, 0.6f, 100),
					new HelperImageAndDelay(colourImage, 0.8f, 100),
					new HelperImageAndDelay(colourImage, 1.0f, 100),
					new HelperImageAndDelay(colourImage, 0.8f, 100),
					new HelperImageAndDelay(colourImage, 0.6f, 100),
					new HelperImageAndDelay(colourImage, 0.4f, 100),
					new HelperImageAndDelay(colourImage, 0.2f, 100),
				}, trayIcon);
		}
	}
	
	private static class HealthReference {
		private int healthFrom;
		private int healthTo;
		private AnimatedTrayIcon icon;
		
		public HealthReference(int healthFrom, int healthTo, AnimatedTrayIcon icon) {
			this.healthFrom = healthFrom;
			this.healthTo = healthTo;
			this.icon = icon;
		}

		public AnimatedTrayIcon fits(int health) {
			if (healthFrom == -1 && healthTo == -1 && health == -1) {
				return icon;
			} else if (health >= healthFrom && health < healthTo) {
				return icon;
			} else {
				return null;
			}
		}
	}
	
	private static Map COLOURSTOICONREFERENCES = new HashMap();
	public static void prepare(TrayIconImplementation trayIcon){
		Vector vec = new Vector();
		vec.add(new HealthReference(-1,-1, new Red(trayIcon)));
		vec.add(new HealthReference(0,20, new Red0to19(trayIcon)));
		vec.add(new HealthReference(20,40, new Red20to39(trayIcon)));
		vec.add(new HealthReference(40,60, new Red40to59(trayIcon)));
		vec.add(new HealthReference(60,80, new Red60to79(trayIcon)));
		vec.add(new HealthReference(80,101, new Red80Plus(trayIcon)));
		COLOURSTOICONREFERENCES.put(Job.RED, vec);
		vec = new Vector();
		vec.add(new HealthReference(-1,-1, new RedAnime(trayIcon)));
		vec.add(new HealthReference(0,20, new RedAnime0to19(trayIcon)));
		vec.add(new HealthReference(20,40, new RedAnime20to39(trayIcon)));
		vec.add(new HealthReference(40,60, new RedAnime40to59(trayIcon)));
		vec.add(new HealthReference(60,80, new RedAnime60to79(trayIcon)));
		vec.add(new HealthReference(80,101, new RedAnime80Plus(trayIcon)));
		COLOURSTOICONREFERENCES.put(Job.RED_ANIME, vec);
		vec = new Vector();
		vec.add(new HealthReference(-1,-1, new Yellow(trayIcon)));
		vec.add(new HealthReference(0,20, new Yellow0to19(trayIcon)));
		vec.add(new HealthReference(20,40, new Yellow20to39(trayIcon)));
		vec.add(new HealthReference(40,60, new Yellow40to59(trayIcon)));
		vec.add(new HealthReference(60,80, new Yellow60to79(trayIcon)));
		vec.add(new HealthReference(80,101, new Yellow80Plus(trayIcon)));
		COLOURSTOICONREFERENCES.put(Job.YELLOW, vec);
		vec = new Vector();
		vec.add(new HealthReference(-1,-1, new YellowAnime(trayIcon)));
		vec.add(new HealthReference(0,20, new YellowAnime0to19(trayIcon)));
		vec.add(new HealthReference(20,40, new YellowAnime20to39(trayIcon)));
		vec.add(new HealthReference(40,60, new YellowAnime40to59(trayIcon)));
		vec.add(new HealthReference(60,80, new YellowAnime60to79(trayIcon)));
		vec.add(new HealthReference(80,101, new YellowAnime80Plus(trayIcon)));
		COLOURSTOICONREFERENCES.put(Job.YELLOW_ANIME, vec);
		vec = new Vector();
		vec.add(new HealthReference(-1,-1, new Blue(trayIcon)));
		vec.add(new HealthReference(0,20, new Blue0to19(trayIcon)));
		vec.add(new HealthReference(20,40, new Blue20to39(trayIcon)));
		vec.add(new HealthReference(40,60, new Blue40to59(trayIcon)));
		vec.add(new HealthReference(60,80, new Blue60to79(trayIcon)));
		vec.add(new HealthReference(80,101, new Blue80Plus(trayIcon)));
		COLOURSTOICONREFERENCES.put(Job.BLUE, vec);
		vec = new Vector();
		vec.add(new HealthReference(-1,-1, new BlueAnime(trayIcon)));
		vec.add(new HealthReference(0,20, new BlueAnime0to19(trayIcon)));
		vec.add(new HealthReference(20,40, new BlueAnime20to39(trayIcon)));
		vec.add(new HealthReference(40,60, new BlueAnime40to59(trayIcon)));
		vec.add(new HealthReference(60,80, new BlueAnime60to79(trayIcon)));
		vec.add(new HealthReference(80,101, new BlueAnime80Plus(trayIcon)));
		COLOURSTOICONREFERENCES.put(Job.BLUE_ANIME, vec);
		vec = new Vector();
		vec.add(new HealthReference(-1,-1, new Grey(trayIcon)));
		vec.add(new HealthReference(0,20, new Grey0to19(trayIcon)));
		vec.add(new HealthReference(20,40, new Grey20to39(trayIcon)));
		vec.add(new HealthReference(40,60, new Grey40to59(trayIcon)));
		vec.add(new HealthReference(60,80, new Grey60to79(trayIcon)));
		vec.add(new HealthReference(80,101, new Grey80Plus(trayIcon)));
		COLOURSTOICONREFERENCES.put(Job.GREY, vec);
//		vec = new Vector();
//		vec.add(new HealthReference(-1,-1, new GreyAnime(trayIcon)));
//		vec.add(new HealthReference(0,20, new GreyAnime0to19(trayIcon)));
//		vec.add(new HealthReference(20,40, new GreyAnime20to39(trayIcon)));
//		vec.add(new HealthReference(40,60, new GreyAnime40to59(trayIcon)));
//		vec.add(new HealthReference(60,80, new GreyAnime60to79(trayIcon)));
//		vec.add(new HealthReference(80,101, new GreyAnime80Plus(trayIcon)));
//		COLOURSTOICONREFERENCES.put(Job.GREY_ANIME, vec);
	}
	
	public static AnimatedTrayIcon getIcon(Integer colour, int health) {
		AnimatedTrayIcon icon = null;
		List refs = (List) COLOURSTOICONREFERENCES.get(colour);
		if (refs != null) {
			int i = 0;
			for (; icon == null && i < refs.size(); i++) {
				icon = ((HealthReference) refs.get(i)).fits(health);
			}
			if (i == refs.size() && refs.size() > 0) {
				for (i = 0; icon == null && i < refs.size(); i++) {
					icon = ((HealthReference) refs.get(i)).fits(-1);
				}
			}
		}
		return icon;
	}
}

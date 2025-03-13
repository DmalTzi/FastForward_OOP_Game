package utilz;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class LoadSave {
	static final String path = Paths.get(".").toAbsolutePath().normalize().toString();

    public static BufferedImage GetSprite(String des, String fileName) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(String.format("%s/res/%s/%s", path, des, fileName)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

	public static Font GetFont() {
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File(String.format("%s/res/%s/%s", path, "font", "Bauhaus 93 Regular.ttf")));
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return font;
	}

	public static Font GetFont(float size) {
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File(String.format("%s/res/%s/%s", path, "font", "Bauhaus 93 Regular.ttf")));
			return font.deriveFont(Font.TRUETYPE_FONT, size);
		} catch (Exception e) {
			e.printStackTrace();
			return new Font("Arial", Font.PLAIN, (int)size); // Fallback
		}
	}
	
}

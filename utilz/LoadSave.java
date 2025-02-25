package utilz;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class LoadSave {
    public static final String MENU_BACKGROUND = "menu_background.png";

    public static BufferedImage GetSpriteAtlas(String fileName) {
		BufferedImage img = null;
        String path = Paths.get(".").toAbsolutePath().normalize().toString();
		try {
			img = ImageIO.read(new File(path+"/res/Background/" + fileName));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}

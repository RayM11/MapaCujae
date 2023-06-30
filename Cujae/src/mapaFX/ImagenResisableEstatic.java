package mapaFX;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImagenResisableEstatic extends ImageView {

	public ImagenResisableEstatic() {
		
	}

	public ImagenResisableEstatic(String arg0) {
		super(arg0);
		
	}

	public ImagenResisableEstatic(Image arg0, double x, double y) {
		super(arg0);
		
		this.resize(x, y);
	}

}

package be.ictdynamic.training.domain;

import java.awt.*;

/**
 * Created by admin on 10/09/2017.
 */
public class Drawable {
    private Color defaultColor = Color.BLUE;

    public void setDefaultColor(Graphics graphics) {
        graphics.setColor(defaultColor);
    }
}

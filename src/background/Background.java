package background;

import base.GameObject;
import renderer.BackgroundRenderer;

import java.awt.*;

public class Background extends GameObject {
    private BackgroundRenderer renderer;

    public Background() {
        this.renderer = new BackgroundRenderer(Color.BLACK, 480,720);
    }

    @Override
    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}
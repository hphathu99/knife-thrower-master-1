
import background.Background;
import base.GameObjectManager;
import knife.Knife;
import wood.Wood;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {
    private BufferedImage backBuffered;
    private Graphics graphics;

    private Background background;
    private Wood wood;
    private Knife knife;


    public GameCanvas() {
        this.setSize(480, 720);

        this.setupBackBuffered();

        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(480, 720, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.background = new Background();
        GameObjectManager.instance.add(this.background);
        createKnife();
        createWood();
        //this.knife = new Knife();
    }

    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(this.graphics);
        this.wood.render(this.graphics);
        this.knife.render(this.graphics);
        this.repaint();
    }

    public void runAll() {
        this.wood.run();
        this.knife.run();

    }

    private void createKnife(){
        this.knife = new Knife();
        this.knife.position.set(240, 600);
        GameObjectManager.instance.add(knife);
    }

    private void createWood() {
        this.wood = new Wood();
        this.wood.position.set(100, 100);
        GameObjectManager.instance.add(wood);
    }
}


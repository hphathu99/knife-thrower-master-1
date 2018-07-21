package knife;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import physic.BoxCollider;
import renderer.ImageRenderer;
import wood.Wood;

public class Knife extends GameObject {
    public Vector2D velocity;
    public KnifeThrow knifeThrow;
    public BoxCollider boxCollider;

    public Knife() {
        this.renderer = new ImageRenderer("resources/Oblivion_DaedricShortsword.png", 80, 160);
        this.velocity = new Vector2D(0.0f, -10.0f);
        this.knifeThrow = new KnifeThrow();
        this.boxCollider = new BoxCollider(50,100);
    }

    @Override
    public void run() {
        super.run();
        this.knifeThrow.run(this);
        this.boxCollider.position.set(this.position.x - 25, this.position.y - 50);

    }


}

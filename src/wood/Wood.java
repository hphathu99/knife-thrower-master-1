package wood;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import knife.Knife;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

import java.util.Random;

public class Wood extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public Random random;
    public BoxCollider boxCollider;
    public RunHitObject runHitObject;

    public Wood() {
        this.renderer = new ImageRenderer("resources/wood-pattern-new-1080x1920.jpg", 200, 100);
        this.velocity = new Vector2D(3.5f, 0);
        this.random = new Random();
        this.boxCollider = new BoxCollider(200,100);
        this.runHitObject = new RunHitObject(Knife.class);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 100, this.position.y - 50);
        this.backToScreen();

    }

    public void backToScreen() {
        if (this.position.x > 480 + 100) {
            this.position.set(0, this.position.y);
        }
        if (this.position.x < 0) {
            this.position.set(480, this.position.y);
        }
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {

    }
}

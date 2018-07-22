package knife;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;
import wood.Wood;

public class Knife extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public KnifeThrow knifeThrow;
    public BoxCollider boxCollider;
    public RunHitObject runHitObject;

    public Knife() {
        this.renderer = new ImageRenderer("resources/Oblivion_DaedricShortsword.png", 80, 160);
        this.velocity = new Vector2D(0.0f, -10.0f);
        this.knifeThrow = new KnifeThrow();
        this.boxCollider = new BoxCollider(50,100);
        this.runHitObject = new RunHitObject(Wood.class);
    }

    @Override
    public void run() {
        super.run();
        this.knifeThrow.run(this);
        this.boxCollider.position.set(this.position.x - 25, this.position.y - 50);
        this.runHitObject.run(this);
    }

    public void collide(Wood wood) {
        if (this.boxCollider.checkCollision(wood.boxCollider)){
            this.velocity.set(wood.velocity);
            this.position.set(wood.position);
        }
    }


    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.renderer = new ImageRenderer("resources/Oblivion_DaedricShortsword_cut.png", 80, 100);
        this.position.set(((Wood) gameObject).position);
        this.velocity.set(((Wood) gameObject).velocity);
    }
}

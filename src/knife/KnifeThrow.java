package knife;

import base.Vector2D;
import input.KeyboardInput;

public class KnifeThrow {

    public Vector2D velocity;

    public KnifeThrow() {
        this.velocity = new Vector2D();
    }

    public void run(Knife knife){
        if (KeyboardInput.instance.isSpace){
            knife.position.y -= 70f;

        }
    }
}

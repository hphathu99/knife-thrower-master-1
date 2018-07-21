package base;

import knife.Knife;
import physic.BoxCollider;
import wood.Wood;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameObjectManager {

    public static GameObjectManager instance = new GameObjectManager();

    private List<GameObject> list;

    private GameObjectManager() {
        this.list = new ArrayList<>();
    }

    public void add(GameObject gameObject){
        this.list.add(gameObject);
    }
    public void runAll(){
        this.list.forEach(gameObject -> gameObject.run());
    }

    public void renderAll(Graphics graphics){
        this.list.forEach(gameObject -> gameObject.render(graphics));
    }

    public Knife checkCollision(Wood wood){
        return (Knife) this.list
                .stream()
                .filter(gameObject -> gameObject instanceof Wood)
                .filter(gameObject -> {
                    BoxCollider other = ((Knife) gameObject).boxCollider;
                    return wood.boxCollider.checkCollision(other);
                })
                .findFirst()
                .orElse(null);
    }


}
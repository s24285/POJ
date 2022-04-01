package gamers;

import main.Pair;
import main.Unit;

@SuppressWarnings("serial")
public class s24285 extends Unit {

    public s24285(final String id, final Pair position, final double rotate,
                  final CollisionModel model) {
        super(id, position, rotate, model);
        // TODO
    }

    @Override
    public void run() {
        this.enableStopOnWall();
        this.forward();
        this.enableMovement();

        while (true) {
            final int randAngle = -180 + (int) (Math.random() * 360);
            if (this.nearestCollision() <= 2 && nearestCollision() >= 0) {
                if (whatIsInRange() == 3) {
                    this.attackInNextMove();
                } else {
                    rotateBy(90);
                }
            } else {
                rotateBy(randAngle);
            }
        }
    }
}

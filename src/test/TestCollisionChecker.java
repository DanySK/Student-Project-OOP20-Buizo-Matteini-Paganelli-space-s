package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.awt.geom.AffineTransform;
import org.junit.Test;
import spacesurvival.model.collision.CollisionChecker;
import spacesurvival.model.collision.physics.bounding.CircleBoundingBox;
import spacesurvival.model.collision.physics.bounding.RectBoundingBox;
import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.GameObjectUtils;

public class TestCollisionChecker {

    /**
     * Test RectBoundingBox to RectBoundingBox.
     */
    @Test 
    public void testRectToRect1() {

        final RectBoundingBox rbb1 = new RectBoundingBox(new P2d(0, 0), new P2d(10, 10), new AffineTransform());
        final RectBoundingBox rbb2 = new RectBoundingBox(new P2d(5, 5), new P2d(15, 15), new AffineTransform());

        final CollisionChecker checker = new CollisionChecker();

        assertTrue(checker.testRectangleToRectangle(rbb1, rbb2));

    }

    /**
     * Test RectBoundingBox to RectBoundingBox.
     */
    @Test 
    public void testRectToRect2() {

        final RectBoundingBox rbb1 = new RectBoundingBox(new P2d(0, 0), new P2d(10, 10), new AffineTransform());

        final AffineTransform cbbTransform = new AffineTransform();
        cbbTransform.translate(11, 0);
        final RectBoundingBox rbb2 = new RectBoundingBox(new P2d(11, 0), new P2d(20, 10), cbbTransform);
        final CollisionChecker checker = new CollisionChecker();

        assertFalse(checker.testRectangleToRectangle(rbb1, rbb2));

    }

    /**
     * Test RectBoundingBox to rotated RectBoundingBox.
     */
    @Test 
    public void testRectToRotatedRect() {

        final RectBoundingBox rbb1 = new RectBoundingBox(new P2d(0, 0), new P2d(10, 10), new AffineTransform());

        final AffineTransform cbbTransform = new AffineTransform();
        cbbTransform.translate(13, 0);
        cbbTransform.rotate(Math.toRadians(45));
        final RectBoundingBox rbb2 = new RectBoundingBox(new P2d(13, 0), new P2d(20, 10), cbbTransform);
        rbb2.setTransform(cbbTransform);

        final CollisionChecker checker = new CollisionChecker();

        assertTrue(checker.testRectangleToRectangle(rbb1, rbb2));
    }

    /**
     * Test RectBoundingBox to rotated CircleBoundingBox,.
     */
    @Test 
    public void testRectToCircle1() {

        final RectBoundingBox rbb1 = new RectBoundingBox(new P2d(0, 0), new P2d(10, 10), new AffineTransform());
        final AffineTransform cbbTransform = new AffineTransform();
        cbbTransform.translate(5, 5);

        final CircleBoundingBox cbb1 = new CircleBoundingBox(new P2d(5, 5), 10, new AffineTransform());
        final CollisionChecker checker = new CollisionChecker();

        assertTrue(checker.testRectangleToCircle(rbb1, cbb1));
    }

    /**
     * Test RectBoundingBox to rotated CircleBoundingBox.
     */
    @Test 
    public void testRectToCircle2() {

        final RectBoundingBox rbb1 = new RectBoundingBox(new P2d(0, 0), new P2d(10, 10), new AffineTransform());

        final AffineTransform cbbTransform = new AffineTransform();
        cbbTransform.translate(50, 50);
        cbbTransform.rotate(Math.toRadians(45));
        final CircleBoundingBox cbb2 = new CircleBoundingBox(new P2d(50, 50), 10, cbbTransform);

        final CollisionChecker checker = new CollisionChecker();

        assertFalse(checker.testRectangleToCircle(rbb1, cbb2));
    }


    /**
     * Test getRotationAngleInDegrees from an AffineTransform.
     */
    @Test 
    public void testGetAngleDegreesFromAffineTransform() {

        final AffineTransform cbbTransform = new AffineTransform();
        cbbTransform.rotate(Math.toRadians(45));

        final Double degrees = GameObjectUtils.getRotationAngleInDegrees(cbbTransform);

        assertEquals(Double.valueOf(45.0), degrees);
    }

    /**
     * Test getRotationAngleInRadiants from an AffineTransform.
     */
    @Test 
    public void testGetAngleRadiantFromAffineTransform() {

        final AffineTransform cbbTransform = new AffineTransform();
        cbbTransform.rotate(Math.toRadians(5));

        final Double radiants = GameObjectUtils.getRotationAngleInDegrees(cbbTransform);

        assertEquals(Double.valueOf(5.0), radiants);
    }

}

package dgk.prototype.game;

import dgk.prototype.util.SpriteSheet;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;

public class Peasant extends Person {

    private Camera worldCamera;

    private int[][] walkingAnimations;

    private int currentAnim;

    private int animationFrame = 1;

    private long startTime = -1L;
    private long animTime = 150;

    public Peasant(double x, double y) {
        super(SpriteSheet.PEASANT, "Peasant", x, y);

        this.walkingAnimations = new int[4][3];

        walkingAnimations[0][0] = 20;
        walkingAnimations[1][0] = 29;
        walkingAnimations[2][0] = 26;
        walkingAnimations[3][0] = 23;

        walkingAnimations[0][1] = 19;
        walkingAnimations[1][1] = 28;
        walkingAnimations[2][1] = 25;
        walkingAnimations[3][1] = 22;

        walkingAnimations[0][2] = 21;
        walkingAnimations[1][2] = 30;
        walkingAnimations[2][2] = 27;
        walkingAnimations[3][2] = 24;

        currentAnim = walkingAnimations[0][0];

        worldCamera = GameWindow.getInstance().getWorldCamera();
    }

    @Override
    public void render() {
        glEnable(GL_TEXTURE_2D);

        GL11.glMatrixMode(GL_MODELVIEW_MATRIX);
        GL11.glPushMatrix();

        GL11.glScalef(worldCamera.getZoom(), worldCamera.getZoom(), 0);
        GL11.glTranslated(getPosition().x - worldCamera.getPosition().getX(), getPosition().y - worldCamera.getPosition().getY(), 0);

        GameWindow.getInstance().spriteSheet.bindTexture(currentAnim);

        GL11.glBegin(GL11.GL_QUADS);
            GL11.glTexCoord2f(0, 0);
            GL11.glVertex2f(0, 0);

            GL11.glTexCoord2f(1, 0);
            GL11.glVertex2f(64, 0);

            GL11.glTexCoord2f(1, 1);
            GL11.glVertex2f(64, 64);

            GL11.glTexCoord2f(0, 1);
            GL11.glVertex2f(0, 64);
        GL11.glEnd();

        GL11.glPopMatrix();

        glDisable(GL_TEXTURE_2D);
    }

    private void switchAnimFrame() {
        if(animationFrame == 2) {
            animationFrame = 1;
        }else if(animationFrame == 1) {
            animationFrame = 2;
        }
    }

    private void updateStartTime() {
        if(startTime == -1L) {
            startTime = System.currentTimeMillis();
        }
    }

    @Override
    public void onUpdate() {

    }
}

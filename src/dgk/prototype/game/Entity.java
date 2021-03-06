package dgk.prototype.game;

import dgk.prototype.util.Texture;
import dgk.prototype.util.TextureLoader;
import dgk.prototype.util.Vec2D;
import org.lwjgl.opengl.GL11;

public abstract class Entity implements IEntity {

    private int textureId;

    private Vec2D position;

    /**
     * Represents if this Entity has been selected or not by the user.
     */
    protected boolean isSelected;

    public Entity(int textureId, double x, double y) {
        this.textureId = textureId;
        this.position = new Vec2D(x, y);
        this.isSelected = false;
    }

    public Vec2D getPosition() {
        return this.position;
    }

    public int getTextureId() {
        return this.textureId;
    }

    public boolean isSelected() {
        return isSelected;
    }
}

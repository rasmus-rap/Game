package Game.GameStates;

import Game.Engine.DrawImage;
import Game.Engine.Main;
import Game.Engine.ObjectHandler;
import Game.Objects.But_Exit;
import Game.Objects.But_Settings;
import Game.Objects.But_StartGame;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

public class Menu extends GameState {

    final public String[] assets = {
            "Other/Menu.png",
            "Text/Play.png",
            "Text/Settings.png",
            "Text/Exit.png"
    };

    private Main main;

    private ObjectHandler handler;

    private Texture background;

    public Menu(Main main) {
        this.main = main;

        this.handler = new ObjectHandler();
    }

    public void init() {
        try {
            Display.setDisplayMode(new DisplayMode(640, 480));
        } catch (Exception e) {
            e.printStackTrace();
        }

        background = main.manager.get("Other/Menu.png");

        // Add buttons
        handler.addObject(new But_StartGame(8, 200, main.manager));
        handler.addObject(new But_Settings(8, 150, main.manager));
        handler.addObject(new But_Exit(8, 100, main.manager));
    }

    public void render() {
        new DrawImage().Draw(0, -32, background);
        for (int i = 0; i < handler.objects.size(); i++) {
            handler.objects.get(i).render();
        }
    }

    public void update() {

    }
}

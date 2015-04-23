package main;

import model.GameModel;
import view.AppFrame;

/**
 * Application entry-point
 * Responsible for initialising model and view.
 */
public class AppInit {
    public static void main(String[] args) {
        GameModel model = new GameModel(200, 200);
        AppFrame view = new AppFrame(model);
    }
}

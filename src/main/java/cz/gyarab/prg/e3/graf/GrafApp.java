package cz.gyarab.prg.e3.graf;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GrafApp extends Application {
    Graf g;
    Canvas canvas;

    @Override
    public void start(Stage primaryStage) {
        g = Graf.nactiZeSouboru("graf.txt");
        canvas = new Canvas(800, 600);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            vykresliGraf();
            //g.udelejKrok();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE); // Běží pořád dokola
        timeline.play();

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Vizualizace Grafu ze souboru");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void vykresliGraf() {
        System.out.println("kuk");
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(1.5);
        for (var e : g.getE()) {
            gc.setStroke(Color.DARKGRAY);
            gc.strokeLine(e.getVrcholA().getX(), e.getVrcholA().getY(), e.getVrcholB().getX(), e.getVrcholB().getY());
        }

        for (var v : g.getV()) {
            gc.setFill(v.isNavstiven() ? Color.CORNFLOWERBLUE : Color.RED);
            gc.fillOval(v.getX()-3, v.getY()-3, 6, 6);
            gc.fillText(v.getJmeno(), v.getX() - 4, v.getY() - 12);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
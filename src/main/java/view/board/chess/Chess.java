package view.board.chess;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public abstract class Chess {
    private final Color color;

    //棋子的半径不应该硬编码，需要根据整个panel的大小来变化
    public static final int RADIUS = 15; //半径

    private static final int HEIGHT = 30;

    private static final int WEIGHT = 30;

    public Chess(Color color) {
        this.color = color;
    }

    public void drawChess(int x, int y,Graphics graphics){
        ((Graphics2D) graphics).setPaint(getPaint(x,y));
        ((Graphics2D) graphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        ((Graphics2D) graphics).setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT);

        Ellipse2D ellipse = new Ellipse2D.Float(x-RADIUS,y-RADIUS, HEIGHT, WEIGHT);
        ((Graphics2D)graphics).fill(ellipse);
    }

    public void erase(int x, int y,Graphics graphics){
        ((Graphics2D)graphics).clearRect(x-RADIUS,y-RADIUS, HEIGHT, WEIGHT);
    }

    abstract  protected RadialGradientPaint getPaint (int x, int y);

}

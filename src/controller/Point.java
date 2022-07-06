package controller;

public class Point {

   private int x;
   private int y;
    private Point point;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point getPoint() {
        return point;
    }

    public void setX(){
        x = this.x;
    }

    public void setY(){
        y = this.y;
    }

    public int getX() { return x; }

    public int getY() {
        return y;
    }


}

package com.epam.rd.autotasks.figures;

class Triangle extends Figure{

    private final Point point1;
    private final Point point2;
    private final Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        if(point1 == null || point2== null || point3 == null){
            throw new IllegalArgumentException();
        }else if(point1.getX() == point2.getX() && point2.getX() == point3.getX()){
            throw new IllegalArgumentException();
        }else if(point1.getY() == point2.getY() && point2.getY() == point3.getY()){
            throw new IllegalArgumentException();
        }else if((point3.getX() - point1.getX())/(point2.getX() - point1.getX()) == (point3.getY() - point1.getY())/(point2.getY() - point1.getY())){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Point centroid() {
        double x = (point1.getX() + point2.getX() + point3.getX())/3;
        double y = (point1.getY() + point2.getY() + point3.getY())/3;
        return new Point(x, y);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        Figure figure2 = new Triangle(point1, point2, point3);
        if(figure2.getClass().getSimpleName().equals(figure.getClass().getSimpleName())){
            double THRESHOLD = .000000001;
            return Math.abs(figure.centroid().getX() - figure2.centroid().getX()) < THRESHOLD && Math.abs(figure2.centroid().getY() - figure.centroid().getY())  < THRESHOLD;
        }else{
            return false;
        }
    }
}

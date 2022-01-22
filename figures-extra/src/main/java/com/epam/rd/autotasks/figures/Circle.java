package com.epam.rd.autotasks.figures;

class Circle extends Figure{

    private final Point point;
    private final double radius;

    public Circle(Point point, double radius) {
        this.point = point;
        this.radius = radius;
        if(radius <= 0 || point == null){
            throw new IllegalArgumentException();
        }
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public Point centroid() {
        return point;
    }


    @Override
    public boolean isTheSame(Figure figure) {
        Figure figure2 = new Circle(point, radius);
        if(figure2.getClass().getSimpleName().equals(figure.getClass().getSimpleName())){
            double THRESHOLD = .000000001;
            Circle tempCircle = (Circle) figure;
            if(radius - tempCircle.getRadius() < THRESHOLD){
                return Math.abs(figure.centroid().getX() - figure2.centroid().getX()) < THRESHOLD && Math.abs(figure2.centroid().getY() - figure.centroid().getY())  < THRESHOLD;
            }else{
                return false;
            }
        }else{
            return false;
        }

    }
}

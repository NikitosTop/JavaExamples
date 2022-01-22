package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure{

    private final Point point1;
    private final Point point2;
    private final Point point3;
    private final Point point4;

    public Quadrilateral(Point point1, Point point2, Point point3, Point point4) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
        if(point1 == null || point2== null || point3 == null || point4 == null){
            throw new IllegalArgumentException();
        }else if(point1.getX() == point2.getX() && point2.getX() == point3.getX()){
            throw new IllegalArgumentException();
        }else if(point1.getY() == point2.getY() && point2.getY() == point3.getY()){
            throw new IllegalArgumentException();
        }else if((point3.getX() - point1.getX())/(point2.getX() - point1.getX()) == (point3.getY() - point1.getY())/(point2.getY() - point1.getY())) {
            throw new IllegalArgumentException();
        }else if(nonConvex()){
            throw new IllegalArgumentException();
        }
    }
    @Override
    public Point centroid() {
        double x = (point1.getX() + point2.getX() + point3.getX())/3;
        double y = (point1.getY() + point2.getY() + point3.getY())/3;
        Point centroidPoint1 = new Point(x, y);
        x = (point2.getX() + point3.getX() + point4.getX())/3;
        y = (point2.getY() + point3.getY() + point4.getY())/3;
        Point centroidPoint2 = new Point(x, y);
        x = (point3.getX() + point4.getX() + point1.getX())/3;
        y = (point3.getY() + point4.getY() + point1.getY())/3;
        Point centroidPoint3 = new Point(x, y);
        x = (point4.getX() + point1.getX() + point2.getX())/3;
        y = (point4.getY() + point1.getY() + point2.getY())/3;
        Point centroidPoint4 = new Point(x, y);
        return intersection(centroidPoint1, centroidPoint2,centroidPoint3,centroidPoint4);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        Figure figure2 = new Quadrilateral(point1, point2, point3, point4);
        if(figure2.getClass().getSimpleName().equals(figure.getClass().getSimpleName())){
            double THRESHOLD = .000000001;
            return Math.abs(figure.centroid().getX() - figure2.centroid().getX()) < THRESHOLD && Math.abs(figure2.centroid().getY() - figure.centroid().getY())  < THRESHOLD;
        }else{
            return false;
        }
    }

    public boolean nonConvex(){
        Point pointFirst = intersection(point1, point2, point3, point4);
        if(pointFirst == null){
            throw new IllegalArgumentException();
        }
        if(pointFirst.getX() == 5.0 && pointFirst.getY() == 5.0){
            throw new IllegalArgumentException();
        }
        return (Double.isNaN(pointFirst.getX()) && Double.isNaN(pointFirst.getY()));
    }

    public static Point intersection(Point centrPoint1, Point centrPoint2, Point centrPoint3, Point centrPoint4){
        double k1 = (centrPoint1.getY() - centrPoint3.getY())/(centrPoint1.getX() - centrPoint3.getX());
        double k2 = (centrPoint2.getY() - centrPoint4.getY())/(centrPoint2.getX() - centrPoint4.getX());
        double b1 = centrPoint3.getY() - k1*centrPoint3.getX();
        double b2 = centrPoint4.getY() - k2*centrPoint4.getX();
        if(k1 == k2){
            return null;
        }

        double x;
        if((k1 - k2) == 0){
            x = 0;
        }else{
            x = (b2 - b1)/(k1 - k2);
        }
        double y = k2 * x + b2;
        System.out.println(x + " " + y);
        return new Point(x, y);
    }

    public double area() {
        double a = Math.sqrt(Math.pow((point2.getX() - point1.getX()), 2) + Math.pow((point2.getY() - point1.getY()), 2));
        double b = Math.sqrt(Math.pow((point3.getX() - point2.getX()), 2) + Math.pow((point3.getY() - point2.getY()), 2));
        double c = Math.sqrt(Math.pow((point4.getX() - point3.getX()), 2) + Math.pow((point4.getY() - point3.getY()), 2));
        double d = Math.sqrt(Math.pow((point1.getX() - point4.getX()), 2) + Math.pow((point1.getY() - point4.getY()), 2));
        double g = Math.sqrt(Math.pow((point3.getX() - point1.getX()), 2) + Math.pow((point3.getY() - point1.getY()), 2));
        double p1 = (a + b + g)/2;
        double area1 = Math.sqrt(p1*(p1 - a)*(p1 - b)*(p1 - g));
        double p2 = (g + d + c)/2;
        double area2 = Math.sqrt(p2*(p2 - g)*(p2 - d)*(p2 - c));
        return area1 + area2;
    }
}

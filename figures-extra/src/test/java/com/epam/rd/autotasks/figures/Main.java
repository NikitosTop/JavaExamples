package com.epam.rd.autotasks.figures;

import java.security.spec.RSAOtherPrimeInfo;

public class Main {
    public static void main(String[] args) {

        Quadrilateral quadrilateral = new Quadrilateral(new Point(-1, 1), new Point(-1, 0), new Point(1, 0), new Point(1, -1));
        System.out.println(quadrilateral.area());;
    }
}

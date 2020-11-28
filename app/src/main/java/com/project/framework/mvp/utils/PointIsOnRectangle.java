package com.project.framework.mvp.utils;

public class PointIsOnRectangle {
    static float area(double x1, double y1, double x2,
                      double y2, double x3, double y3)
    {
        return (float)Math.abs((x1 * (y2 - y3) +
                x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }
    public static boolean Check(double x1, double y1, double x2, double y2,
                                double x3, double y3, double x4, double y4, double x, double y)
    {
        float A = area(x1, y1, x2, y2, x3, y3)+
                area(x1, y1, x4, y4, x3, y3);
        float A1 = area(x, y, x1, y1, x2, y2);
        float A2 = area(x, y, x2, y2, x3, y3);
        float A3 = area(x, y, x3, y3, x4, y4);
        float A4 = area(x, y, x1, y1, x4, y4);
        return (A == A1 + A2 + A3 + A4);
    }
}

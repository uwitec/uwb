package com.zhilutec.common.utils;

import com.zhilutec.dbs.entities.Coordinate;
import com.zhilutec.dbs.pojos.Circle;

//点在圆内或圆外
public class CircleUtil {

    public static boolean isInCircle(Coordinate coordinate, Circle circle) {
        // 两点间距离公式
        Double result = Math.sqrt(coordinate.getPosX() - circle.getBullseye().getX()) + (coordinate.getPosY() - circle.getBullseye().getY());
        if (result <= circle.getR()) {
            System.out.print("====点在圆内===");
            return true;
        } else {
            System.out.print("====点在圆外====");
            return false;
        }
    }
}

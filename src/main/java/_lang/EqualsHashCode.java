package _lang;

import java.util.Arrays;

public class EqualsHashCode {
    private boolean aBoolean;
    private byte aByte;
    private char aChar;
    private short aShort;
    private int anInt;
    private long aLong;
    private float aFloat;
    private double aDouble;
    private String string;
    private double[] doubles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EqualsHashCode that = (EqualsHashCode) o;

        if (aBoolean != that.aBoolean) return false;
        if (aByte != that.aByte) return false;
        if (aChar != that.aChar) return false;
        if (Double.compare(that.aDouble, aDouble) != 0) return false;
        if (Float.compare(that.aFloat, aFloat) != 0) return false;
        if (aLong != that.aLong) return false;
        if (aShort != that.aShort) return false;
        if (anInt != that.anInt) return false;
        if (!Arrays.equals(doubles, that.doubles)) return false;
        if (!string.equals(that.string)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (aBoolean ? 1 : 0);
        result = 31 * result + (int) aByte;
        result = 31 * result + (int) aChar;
        result = 31 * result + (int) aShort;
        result = 31 * result + anInt;
        result = 31 * result + (int) (aLong ^ (aLong >>> 32));
        result = 31 * result + (aFloat != +0.0f ? Float.floatToIntBits(aFloat) : 0);
        temp = Double.doubleToLongBits(aDouble);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + string.hashCode();
        result = 31 * result + Arrays.hashCode(doubles);
        return result;
    }
}

package by.it.academy.Mk_JD2_88_22.classwork.dto.airports;

public class Coordinates {
    private String x;
    private String y;

    public Coordinates(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public void setX(String x) {
        this.x = x;
    }

    public void setY(String y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x='" + x + '\'' +
                ", y='" + y + '\'' +
                '}';
    }
}

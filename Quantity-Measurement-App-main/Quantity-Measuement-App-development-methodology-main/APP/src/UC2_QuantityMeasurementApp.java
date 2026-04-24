public class UC2_QuantityMeasurementApp {

    public static boolean compareFeet(Double val1, Double val2) {
        Feet f1 = new Feet(val1);
        Feet f2 = new Feet(val2);
        return f1.equals(f2);
    }

    public static boolean compareInches(Double val1, Double val2) {
        Inches i1 = new Inches(val1);
        Inches i2 = new Inches(val2);
        return i1.equals(i2);
    }

    public static void main(String[] args) {
        boolean feetResult = compareFeet(0.0, 0.0);
        System.out.println("Feet Equality: " + feetResult);

        boolean inchResult = compareInches(0.0, 0.0);
        System.out.println("Inches Equality: " + inchResult);
    }
}

class Feet {
    private final Double value;

    public Feet(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feet feet = (Feet) o;
        return Double.compare(feet.value, value) == 0;
    }
}

class Inches {
    private final Double value;

    public Inches(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inches inches = (Inches) o;
        return Double.compare(inches.value, value) == 0;
    }
}
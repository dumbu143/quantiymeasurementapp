public class UC3_Generic_Quantity_Length {

    public enum Unit {
        FEET(12.0),
        INCH(1.0);

        private final double conversionFactor;

        Unit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double convertToBase(double value) {
            return value * this.conversionFactor;
        }
    }

    private final double value;
    private final Unit unit;

    public UC3_Generic_Quantity_Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UC3_Generic_Quantity_Length that = (UC3_Generic_Quantity_Length) o;

        double value1 = this.unit.convertToBase(this.value);
        double value2 = that.unit.convertToBase(that.value);

        return Double.compare(value1, value2) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {
        UC3_Generic_Quantity_Length feetValue = new UC3_Generic_Quantity_Length(1.0, Unit.FEET);
        UC3_Generic_Quantity_Length inchValue = new UC3_Generic_Quantity_Length(12.0, Unit.INCH);

        boolean result = feetValue.equals(inchValue);
        System.out.println("1 Feet equals 12 Inches: " + result);
    }
}
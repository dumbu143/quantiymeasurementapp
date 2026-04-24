public class UC4_Extended_Generic_Quantity {

    public enum Unit {
        FEET(12.0),
        INCH(1.0),
        YARD(36.0),
        CM(0.393701);

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

    public UC4_Extended_Generic_Quantity(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UC4_Extended_Generic_Quantity that = (UC4_Extended_Generic_Quantity) o;

        double value1 = this.unit.convertToBase(this.value);
        double value2 = that.unit.convertToBase(that.value);

        return Math.abs(value1 - value2) < 0.001;
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
        UC4_Extended_Generic_Quantity yard = new UC4_Extended_Generic_Quantity(1.0, Unit.YARD);
        UC4_Extended_Generic_Quantity feet = new UC4_Extended_Generic_Quantity(3.0, Unit.FEET);
        UC4_Extended_Generic_Quantity inch = new UC4_Extended_Generic_Quantity(36.0, Unit.INCH);

        System.out.println("1 Yard == 3 Feet: " + yard.equals(feet));
        System.out.println("1 Yard == 36 Inches: " + yard.equals(inch));

        UC4_Extended_Generic_Quantity cm = new UC4_Extended_Generic_Quantity(1.0, Unit.CM);
        UC4_Extended_Generic_Quantity inchFromCm = new UC4_Extended_Generic_Quantity(0.393701, Unit.INCH);
        System.out.println("1 cm == 0.393701 Inches: " + cm.equals(inchFromCm));
    }
}
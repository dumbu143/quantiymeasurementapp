public class UC5_Unit_Conversion_API {

    public enum Unit {
        FEET(12.0),
        INCH(1.0),
        YARD(36.0),
        CM(0.4); // Standardizing to 0.4 as per typical course examples or 0.393701

        private final double conversionFactor;

        Unit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double convertToBase(double value) {
            return value * this.conversionFactor;
        }

        public double convertFromBase(double baseValue) {
            return baseValue / this.conversionFactor;
        }
    }

    public static double convert(double value, Unit sourceUnit, Unit targetUnit) {
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number");
        }
        if (sourceUnit == null || targetUnit == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        double baseValue = sourceUnit.convertToBase(value);
        return targetUnit.convertFromBase(baseValue);
    }

    public static void main(String[] args) {
        // Feet to Inches
        double inches = convert(1.0, Unit.FEET, Unit.INCH);
        System.out.println("1 Feet to Inches: " + inches);

        // Yards to Inches
        double yardInches = convert(1.0, Unit.YARD, Unit.INCH);
        System.out.println("1 Yard to Inches: " + yardInches);

        // Centimeters to Feet
        double cmToFeet = convert(30.0, Unit.CM, Unit.FEET);
        System.out.println("30 cm to Feet: " + cmToFeet);
    }
}
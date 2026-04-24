public class UC7_Target_Unit_Addition_API {

    public enum Unit {
        FEET(1.0),
        INCH(1.0 / 12.0),
        YARD(3.0),
        CM(1.0 / 30.48);

        private final double factorToBase;

        Unit(double factorToBase) {
            this.factorToBase = factorToBase;
        }

        public double convertToBase(double value) {
            return value * this.factorToBase;
        }

        public double convertFromBase(double baseValue) {
            return baseValue / this.factorToBase;
        }
    }

    private final double value;
    private final Unit unit;

    public UC7_Target_Unit_Addition_API(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

    public static UC7_Target_Unit_Addition_API add(UC7_Target_Unit_Addition_API length1,
                                                   UC7_Target_Unit_Addition_API length2,
                                                   Unit targetUnit) {
        if (length1 == null || length2 == null || targetUnit == null) {
            throw new IllegalArgumentException("Inputs and Target Unit cannot be null");
        }
        if (!Double.isFinite(length1.value) || !Double.isFinite(length2.value)) {
            throw new IllegalArgumentException("Values must be finite numbers");
        }

        double sumInBase = length1.unit.convertToBase(length1.value) +
                length2.unit.convertToBase(length2.value);

        double convertedValue = targetUnit.convertFromBase(sumInBase);

        return new UC7_Target_Unit_Addition_API(convertedValue, targetUnit);
    }

    public static void main(String[] args) {
        // Example: 1 foot + 12 inches with target unit YARDS
        UC7_Target_Unit_Addition_API distance1 = new UC7_Target_Unit_Addition_API(1.0, Unit.FEET);
        UC7_Target_Unit_Addition_API distance2 = new UC7_Target_Unit_Addition_API(12.0, Unit.INCH);

        UC7_Target_Unit_Addition_API result = add(distance1, distance2, Unit.YARD);

        System.out.println("Result: " + result.getValue() + " " + result.getUnit());
    }
}
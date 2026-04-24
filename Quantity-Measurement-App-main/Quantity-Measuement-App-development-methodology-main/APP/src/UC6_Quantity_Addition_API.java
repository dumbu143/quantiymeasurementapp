public class UC6_Quantity_Addition_API {

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

    public UC6_Quantity_Addition_API(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public Unit getUnit() {
        return unit;
    }

    public static UC6_Quantity_Addition_API add(UC6_Quantity_Addition_API length1, UC6_Quantity_Addition_API length2) {
        if (length1 == null || length2 == null) {
            throw new IllegalArgumentException("Length objects cannot be null");
        }
        if (!Double.isFinite(length1.value) || !Double.isFinite(length2.value)) {
            throw new IllegalArgumentException("Values must be finite numbers");
        }

        double sumInBase = length1.unit.convertToBase(length1.value) +
                length2.unit.convertToBase(length2.value);

        double finalValue = length1.unit.convertFromBase(sumInBase);

        return new UC6_Quantity_Addition_API(finalValue, length1.unit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UC6_Quantity_Addition_API that = (UC6_Quantity_Addition_API) o;
        return Math.abs(this.unit.convertToBase(this.value) - that.unit.convertToBase(that.value)) < 0.001;
    }

    public static void main(String[] args) {
        // Example: 1 feet + 12 inches = 2 feet
        UC6_Quantity_Addition_API distance1 = new UC6_Quantity_Addition_API(1.0, Unit.FEET);
        UC6_Quantity_Addition_API distance2 = new UC6_Quantity_Addition_API(12.0, Unit.INCH);

        UC6_Quantity_Addition_API result = add(distance1, distance2);

        System.out.println("Result: " + result.getValue() + " " + result.getUnit());
    }
}
public class UC8_Refactored_Quantity_Measurement {
    private final double value;
    private final LengthUnit unit;

    public UC8_Refactored_Quantity_Measurement(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UC8_Refactored_Quantity_Measurement that = (UC8_Refactored_Quantity_Measurement) o;

        double v1 = this.unit.convertToBaseUnit(this.value);
        double v2 = that.unit.convertToBaseUnit(that.value);

        return Math.abs(v1 - v2) < 0.001;
    }

    public static UC8_Refactored_Quantity_Measurement add(UC8_Refactored_Quantity_Measurement l1,
                                                          UC8_Refactored_Quantity_Measurement l2,
                                                          LengthUnit targetUnit) {
        if (l1 == null || l2 == null || targetUnit == null) {
            throw new IllegalArgumentException("Inputs cannot be null");
        }

        double sumInBase = l1.unit.convertToBaseUnit(l1.value) +
                l2.unit.convertToBaseUnit(l2.value);

        double finalValue = targetUnit.convertFromBaseUnit(sumInBase);

        return new UC8_Refactored_Quantity_Measurement(finalValue, targetUnit);
    }

    public static void main(String[] args) {
        UC8_Refactored_Quantity_Measurement distance1 = new UC8_Refactored_Quantity_Measurement(1.0, LengthUnit.FEET);
        UC8_Refactored_Quantity_Measurement distance2 = new UC8_Refactored_Quantity_Measurement(12.0, LengthUnit.INCH);

        // UC1 - UC4: Equality check
        System.out.println("1 Foot equals 12 Inches: " + distance1.equals(distance2));

        // UC7: Addition with target unit
        UC8_Refactored_Quantity_Measurement result = add(distance1, distance2, LengthUnit.YARD);
        System.out.println("Sum in Yards: " + result.value + " " + result.unit);
    }
}
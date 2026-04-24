public class UC1_Feet_Measurement_Equality {
    private final Double value;

    public UC1_Feet_Measurement_Equality(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UC1_Feet_Measurement_Equality that = (UC1_Feet_Measurement_Equality) o;

        if (this.value == null || that.value == null) {
            return this.value == that.value;
        }

        return Double.compare(that.value, this.value) == 0;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    public static void main(String[] args) {
        UC1_Feet_Measurement_Equality distance1 = new UC1_Feet_Measurement_Equality(0.0);
        UC1_Feet_Measurement_Equality distance2 = new UC1_Feet_Measurement_Equality(0.0);

        boolean isEqual = distance1.equals(distance2);
        System.out.println("Feet Equality Status: " + isEqual);
    }
}
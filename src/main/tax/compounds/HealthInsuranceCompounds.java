package main.tax.compounds;

public class HealthInsuranceCompounds {
    private Double lowerRateInsurance;
    private Double higherRateInsurance;

    public HealthInsuranceCompounds(Double healthInsuranceBasis) {
        this.lowerRateInsurance = (healthInsuranceBasis * 7.75) / 100;
        this.higherRateInsurance = (healthInsuranceBasis * 9) / 100;
    }

    public Double getLowerRateInsurance() {
        return lowerRateInsurance;
    }

    public Double getHigherRateInsurance() {
        return higherRateInsurance;
    }
}

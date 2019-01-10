package main;

public class SocialTaxCompounds {

    private Double pensionTax;
    private Double disabledTax;
    private Double illnessInsurance;
    private Double healthInsuranceBasis;

    public SocialTaxCompounds(Double income) {
        this.pensionTax = (income * 9.76) / 100;
        this.disabledTax = (income * 1.5) / 100;
        this.illnessInsurance = (income * 2.45) / 100;
        this.healthInsuranceBasis = income - pensionTax - disabledTax - illnessInsurance;
    }

    public Double getPensionTax() {
        return pensionTax;
    }

    public Double getDisabledTax() {
        return disabledTax;
    }

    public Double getIllnessInsurance() {
        return illnessInsurance;
    }

    public Double getHealthInsuranceBasis() {
        return healthInsuranceBasis;
    }
}

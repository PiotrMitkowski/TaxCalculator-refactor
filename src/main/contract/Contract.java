package main.contract;

import main.HealthInsuranceCompounds;
import main.SocialTaxCompounds;
import main.TaxCompounds;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Contract {

    private Double income;
    static double exemptedValue = 46.33; // reduced value 46,33 PLN

    Contract(Double income) {
        this.income = income;
    }


    public abstract void run();

    public abstract Double calculateAdvance(Double advanceTax, HealthInsuranceCompounds healthInsuranceCompounds);

    public abstract Double getIncomeCost(Double healthInsuranceBasis);

    ContractTaxSummary calculateTaxes() {
        TaxCompounds taxCompounds = calculateTaxCompounds();
        double taxBasis = calculateTaxBasis(taxCompounds.getSocialTaxCompounds());
        double taxBasis0 = this.round(taxBasis, 2);
        Double advanceTax = calculateBasis(taxBasis0);
        Double advanceTaxOffice = calculateAdvance(advanceTax, taxCompounds.getHealthInsuranceCompounds());
        double advanceTaxOffice0 = this.round(advanceTaxOffice, 2);
        double salary = calculateSalary(taxCompounds.getHealthInsuranceCompounds(), taxCompounds.getSocialTaxCompounds(), advanceTaxOffice0);
        double incomeCost = getIncomeCost(taxCompounds.getSocialTaxCompounds().getHealthInsuranceBasis());
        return new ContractTaxSummary(income, taxCompounds, salary, taxBasis, advanceTax, advanceTaxOffice, exemptedValue, incomeCost);
    }

    private Double calculateBasis(double basis) {
        return (basis * 18) / 100;
    }

    private SocialTaxCompounds calculateSocialTaxes(double basis) {
        return new SocialTaxCompounds(basis);
    }

    private HealthInsuranceCompounds calculateInsurance(double healthInsuranceBasis) {
        return new HealthInsuranceCompounds(healthInsuranceBasis);
    }

    private Double calculateSalary(HealthInsuranceCompounds healthInsuranceCompounds, SocialTaxCompounds socialTaxCompounds, Double advanceTaxOffice) {
        return income - ((socialTaxCompounds.getPensionTax() + socialTaxCompounds.getDisabledTax() + socialTaxCompounds.getIllnessInsurance()) + healthInsuranceCompounds.getHigherRateInsurance() + advanceTaxOffice);
    }

    private TaxCompounds calculateTaxCompounds() {
        SocialTaxCompounds socialTaxCompounds = calculateSocialTaxes(income);
        HealthInsuranceCompounds healthInsuranceCompounds = calculateInsurance(socialTaxCompounds.getHealthInsuranceBasis());
        return new TaxCompounds(socialTaxCompounds, healthInsuranceCompounds);
    }

    private Double calculateTaxBasis(SocialTaxCompounds compounds) {
        return compounds.getHealthInsuranceBasis() - 111.25;
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}

package main.contract;

import main.tax.compounds.HealthInsuranceCompounds;
import main.presenting.Presenter;
import main.tax.compounds.SocialTaxCompounds;
import main.tax.compounds.TaxCompounds;

import java.text.DecimalFormat;

public class ContractTaxSummary {
    private Double income;
    private TaxCompounds taxCompounds;
    private Double salary;
    private Double taxBasis;
    private Double advanceTax;
    private Double advanceTaxOffice;
    private Double exemptedTax;
    private Double exemptedValue;
    private Double incomeCost;

    private DecimalFormat df00 = new DecimalFormat("#.00");


    public ContractTaxSummary(Double income, TaxCompounds taxCompounds, Double salary, Double taxBasis, Double advanceTax, Double advanceTaxOffice, Double exemptedValue, Double incomeCost) {
        this.income = income;
        this.taxCompounds = taxCompounds;
        this.salary = salary;
        this.taxBasis = taxBasis;
        this.advanceTax = advanceTax;
        this.advanceTaxOffice = advanceTaxOffice;
        this.exemptedValue = exemptedValue;
        this.incomeCost = incomeCost;
    }

    public void present(Presenter presenter) {
        SocialTaxCompounds socialTaxCompounds = taxCompounds.getSocialTaxCompounds();
        HealthInsuranceCompounds healthInsuranceCompounds = taxCompounds.getHealthInsuranceCompounds();
        presenter.present("Ordinary contract");
        presenter.present("basis for taxes ", Double.toString(income));
        presenter.present("Pension tax basis ", df00.format(socialTaxCompounds.getPensionTax()));
        presenter.present("Disability tax basis ", df00.format(socialTaxCompounds.getDisabledTax()));
        presenter.present("Illness insurance basis  ", df00.format(socialTaxCompounds.getIllnessInsurance()));
        presenter.present("Health insurance basis: ", Double.toString(socialTaxCompounds.getHealthInsuranceBasis()));
        presenter.present("Health insutance: 9% = ", df00.format(healthInsuranceCompounds.getHigherRateInsurance()), " 7,75% = ", df00.format(healthInsuranceCompounds.getLowerRateInsurance()));
        presenter.present("Constant income tax cost ", Double.toString(incomeCost));
        presenter.present("Tax basis ", Double.toString(taxBasis), " rounded ", df00.format(taxBasis));
        presenter.present("Advance for income tax 18 % = ", Double.toString(advanceTax));
        presenter.present("Exempted value = ", Double.toString(exemptedValue));
        if(exemptedTax != null) {
            presenter.present("Exempted tax = ", df00.format(exemptedTax));
        }
        presenter.present("Advance for the tax office = ", df00.format(advanceTaxOffice), " rounded = ", df00.format(advanceTaxOffice));
        presenter.present();
        presenter.present("Net salary = ", df00.format(salary));
    }

    public Double getAdvanceTax() {
        return advanceTax;
    }

    public void setExemptedTax(Double exemptedTax) {
        this.exemptedTax = exemptedTax;
    }
}

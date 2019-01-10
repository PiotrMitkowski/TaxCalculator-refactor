package main.contract;

import main.HealthInsuranceCompounds;
import main.Logger;

public class OrdinaryContract extends Contract {


    public OrdinaryContract(Double income) {
        super(income);
    }

    @Override
    public void run() {
        ContractTaxSummary contractTaxSummary = calculateTaxes();
        double exemptedTax = contractTaxSummary.getAdvanceTax() - exemptedValue;
        contractTaxSummary.setExemptedTax(exemptedTax);
        contractTaxSummary.present(new Logger());
    }


    @Override
    public Double calculateAdvance(Double advanceTax, HealthInsuranceCompounds healthInsuranceCompounds) {
        return advanceTax - healthInsuranceCompounds.getLowerRateInsurance() - exemptedValue;
    }

    @Override
    public Double getIncomeCost(Double healthInsuranceBasis) {
        return 111.25;
    }
}

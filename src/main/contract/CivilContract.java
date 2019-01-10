package main.contract;

import main.HealthInsuranceCompounds;
import main.Logger;

public class CivilContract extends Contract {

    public CivilContract(Double income) {
        super(income);
    }

    @Override
    public void run() {
        ContractTaxSummary contractTaxSummary = calculateTaxes();
        contractTaxSummary.present(new Logger());
    }

    @Override
    public Double calculateAdvance(Double advanceTax, HealthInsuranceCompounds healthInsuranceCompounds) {
        return advanceTax - healthInsuranceCompounds.getLowerRateInsurance();
    }

    @Override
    public Double getIncomeCost(Double healthInsuranceBasis) {
        return healthInsuranceBasis * 20 / 100;
    }
}

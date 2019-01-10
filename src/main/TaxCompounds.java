package main;

public class TaxCompounds {
    private SocialTaxCompounds socialTaxCompounds;
    private HealthInsuranceCompounds healthInsuranceCompounds;

    public TaxCompounds(SocialTaxCompounds socialTaxCompounds, HealthInsuranceCompounds healthInsuranceCompounds) {
        this.socialTaxCompounds = socialTaxCompounds;
        this.healthInsuranceCompounds = healthInsuranceCompounds;
    }

    public SocialTaxCompounds getSocialTaxCompounds() {
        return socialTaxCompounds;
    }

    public HealthInsuranceCompounds getHealthInsuranceCompounds() {
        return healthInsuranceCompounds;
    }
}

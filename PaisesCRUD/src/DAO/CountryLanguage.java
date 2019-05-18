package DAO;

import java.util.List;

public class CountryLanguage {
    private String countryCode;
    private String language;
    private List<String> isOfficial;
    private float percentage;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(List<String> isOfficial) {
        this.isOfficial = isOfficial;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
    
    
}

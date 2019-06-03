package DAO;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private String code;
    private String name;
    private String continent;
    private String region;
    private float surfaceArea;
    private int indepYear;
    private int population;
    private float lifeExpectancy;
    private float gnp;
    private float gnpOld;
    private String localName;
    private String governmentForm;
    private String headOfState;
    private int capital;
    private String code2;
    private int cities;
    private List<String> languagesOfficial = new ArrayList<>();
    private List<String> languages = new ArrayList<>();
    private List<String> languagesTotal = new ArrayList<>();
    private List<String> governments = new ArrayList<>();
    private List<String> continents = new ArrayList<>();
    private String concatenaOficial = "";
    private String concatenaLanguages = "";
    private String concatenaGovernments = "";
    private String concatenaContinents = "";
     private String concatenaLanguagesTotal = "";

     
    public List<String> getLanguagesTotal() {
        return languagesTotal;
    }

    public void setLanguagesTotal(List<String> languagesTotal) {
        this.languagesTotal = languagesTotal;
    }

    public String getConcatenaLanguagesTotal() {
        return concatenaLanguagesTotal;
    }

    public void setConcatenaLanguagesTotal(String concatenaLanguagesTotal) {
        this.concatenaLanguagesTotal = concatenaLanguagesTotal;
    }

    
    public String getConcatenaContinents() {
        return concatenaContinents;
    }

    public void setConcatenaContinents(String concatenaContinents) {
        this.concatenaContinents = concatenaContinents;
    }
        
    public List<String> getContinents() {
        return continents;
    }

    public void setContinents(List<String> continents) {
        this.continents = continents;
    }    
    
    public String getConcatenaGovernments() {
        return concatenaGovernments;
    }

    public void setConcatenaGovernments(String concatenaGovernments) {
        this.concatenaGovernments = concatenaGovernments;
    }
    
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(int indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public float getGnp() {
        return gnp;
    }

    public void setGnp(float gnp) {
        this.gnp = gnp;
    }

    public float getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(float gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public int getCities() {
        return cities;
    }

    public void setCities(int cities) {
        this.cities = cities;
    }

    public List<String> getLanguagesOfficial() {
        return languagesOfficial;
    }

    public void setLanguagesOfficial(List<String> languagesOfficial) {
        this.languagesOfficial = languagesOfficial;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getGovernments() {
        return governments;
    }

    public void setGovernments(List<String> governments) {
        this.governments = governments;
    }

    public String getConcatenaOficial() {
        return concatenaOficial;
    }

    
    public void setConcatenaOficial(String concatenaOficial) {
        this.concatenaOficial = concatenaOficial;
    }   

    public String getConcatenaLanguages() {
        return concatenaLanguages;
    }

    public void setConcatenaLanguages(String concatenaLanguages) {
        this.concatenaLanguages = concatenaLanguages;
    }
    
    public String adicionarOficial(String valor){
        languagesOfficial.add(valor);
        return valor;
    }
    
    public String adicionar(String valor){
        languages.add(valor);
        return valor;
    }
    
    public String adicionarGovernments(String valor) {
        governments.add(valor);
        return valor;
    }
    
    public String adicionarContinents(String valor) {
        continents.add(valor);
        return valor;
    }
    
    public String adicionarLanguagesTotal(String valor) {
        languagesTotal.add(valor);
        return valor;
    }
    
    public void Concatenar() {
        for (String str : languagesOfficial) {
            if (concatenaOficial.trim().isEmpty()) {
                concatenaOficial = str;
            } else {
                concatenaOficial = concatenaOficial + ", " + str;
            }
        }
    }
    
    public void ConcatenarLanguages() {
        for (String str : languages) {
            if (concatenaLanguages.trim().isEmpty()) {
                concatenaLanguages = str;
            } else {
                concatenaLanguages = concatenaLanguages + ", " + str;
            }
        }
    }
    
    public void ConcatenarGovernments() {
        for (String str : governments) {
            if (concatenaGovernments.trim().isEmpty()) {
                concatenaGovernments = str;
            } else {
                concatenaGovernments = concatenaGovernments + ", " + str;
            }
        }
    }
    
    public void ConcatenarContinents() {
        for (String str : continents) {
            if (concatenaContinents.trim().isEmpty()) {
                concatenaContinents = str;
            } else {
                concatenaContinents = concatenaContinents + ", " + str;
            }
        }
    }
    
    public void ConcatenarLanguagesTotal() {
        for (String str : languagesTotal) {
            if (concatenaLanguagesTotal.trim().isEmpty()) {
                concatenaLanguagesTotal = str;
            } else {
                concatenaLanguagesTotal = concatenaLanguagesTotal + ", " + str;
            }
        }
    }
    
}

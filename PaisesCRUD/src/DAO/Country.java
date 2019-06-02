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
    private List<String> governments = new ArrayList<>();
    private String concatenaOficial = "";
    private String concatenaLanguages = "";
    private final ArrayList<String> formaGovernoEnum = new ArrayList<String>(){
        { add("Asia");
          add("Europe");
          add("North America");
          add("Africa");
          add("Oceania");
          add("Antarctica");
          add("South America");
        }
    };

    public ArrayList<String> getFormaGovernoEnum() {
        
        return formaGovernoEnum;
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
    
}

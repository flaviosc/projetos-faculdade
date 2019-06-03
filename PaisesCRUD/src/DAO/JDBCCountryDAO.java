package DAO;

import java.sql.SQLDataException;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sun.awt.windows.ThemeReader.getEnum;

public class JDBCCountryDAO implements CountryDAO {
    private Conexao con;
    private Statement stmt;
    private Statement stmt2;
    private Statement stmt3;
    private Statement stmt4;
    private Statement stmt5;
    private Statement stmt6;
    private Statement stmt7;
    
    public JDBCCountryDAO() throws SQLDataException, ClassNotFoundException, SQLException {
        con = new Conexao();
        try {
            stmt = (Statement) con.getCon().createStatement();
            stmt2 = (Statement) con.getCon().createStatement();
            stmt3 = (Statement) con.getCon().createStatement();
            stmt4 = (Statement) con.getCon().createStatement();
            stmt5 = (Statement) con.getCon().createStatement();
            stmt6 = (Statement) con.getCon().createStatement();
            stmt7 = (Statement) con.getCon().createStatement();
        } catch (SQLDataException e) {
            throw e;
        }
    }

    //FALTA COLOCAR A LIGUAGEM AQUI
        @Override
        public int alterar(Country country) throws SQLException {
            try {
                return stmt.executeUpdate(
                        "UPDATE country AS c INNER JOIN countrylanguage AS cl "
                                + "set c.LocalName='" + country.getLocalName() + "', "
                                + "c.Name='" + country.getName() + "', "
                                + "c.Continent='" + country.getContinent() + "', "
                                + "c.GovernmentForm='" + country.getGovernmentForm() + "', "
                                + "c.LifeExpectancy='" + country.getLifeExpectancy() + "', "
                                + "c.Code2='" + country.getCode2() + "', " 
                                + "cl.Language='" + country.getLanguages() 
                                + "' WHERE c.Code = '" + country.getCode() 
                                + "' AND c.Code = cl.CountryCode AND cl.IsOfficial = 'T'"
                        
                        
                );
                
            } catch (SQLException e) {
                throw e;
            } finally {
                con.fecharConexao();
            }
        }

    @Override
    public int remover(Country country) throws SQLException {
        try {
            stmt.executeUpdate("DELETE FROM city WHERE CountryCode = '" + country.getCode() + "'");
            stmt.executeUpdate("DELETE FROM countrylanguage WHERE CountryCode = '" + country.getCode() + "'");
            return stmt.executeUpdate("DELETE FROM country WHERE Code = '" + country.getCode() + "'");
            
        } catch (Exception e) {
            throw e;
        } finally {
            con.fecharConexao();
        }
    }
    
    public String Languages(String valor) throws SQLException {
        List<Country> language = new ArrayList<>();
        Country country = new Country();
        String linguagens = "";
        try {
            ResultSet rs4 = stmt4.executeQuery("select language from countrylanguage as cl "
                                            + "inner join country as c on cl.countrycode = c.code "
                                            + "where c.name = '" + valor + "' or c.code = '" + valor + "' order by percentage desc");
            
            while (rs4.next()) {                
                country.adicionar(rs4.getString("language"));
            }
            country.ConcatenarLanguages();
            linguagens = country.getConcatenaLanguages();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return linguagens;
    }
    
    public String Governments() {
        Country country = new Country();
        String governmetsForm = "";
        try {
            ResultSet rs5 = stmt5.executeQuery("select distinct governmentform from country order by governmentform");
            while(rs5.next()) {                
                country.adicionarGovernments(rs5.getString("governmentform"));                
            }
            country.ConcatenarGovernments();
            governmetsForm = country.getConcatenaGovernments();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return governmetsForm;
    }
    
    public String Continents() {
        Country country = new Country();
        String continent = "";
        try {
            ResultSet rs6 = stmt6.executeQuery("select distinct continent from country order by continent");
            while(rs6.next()) {                
                country.adicionarContinents(rs6.getString("continent"));                
            }
            country.ConcatenarContinents();
            continent = country.getConcatenaContinents();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return continent;
    }
    
    public String LanguagesTotal() {
        Country country = new Country();
        String languages = "";
        try {
            ResultSet rs7 = stmt7.executeQuery("select distinct language from countrylanguage order by language");
            while(rs7.next()) {                
                country.adicionarLanguagesTotal(rs7.getString("language"));                
            }
            country.ConcatenarLanguagesTotal();
            languages = country.getConcatenaLanguagesTotal();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return languages;
    }

    //query de quantidade de cidades pelo nome    
    public int Cidades(String valor) throws SQLException {
        int cities = 0;
        try {
            ResultSet rs2 = stmt2.executeQuery("SELECT COUNT(*) FROM city as ct "
                                            + "inner join country as c on ct.countrycode = c.code "
                                            + "where c.name like '%" + valor + "%'");
            while(rs2.next()) {
                Country country = new Country();
                country.setCities(rs2.getInt("COUNT(*)"));               
                
                cities = country.getCities();
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }
    
    //QUERY QUANTIDADE DE CIDADES POR CODIGO
    public int CidadesCode(String code) throws SQLException {
        int cities = 0;
        try {
            ResultSet rs2 = stmt2.executeQuery("SELECT COUNT(*) FROM city as ct "
                                            + "inner join country as c on ct.countrycode = c.code "
                                            + "where c.code like '%" + code + "%'");
            while(rs2.next()) {
                Country country = new Country();
                country.setCities(rs2.getInt("COUNT(*)"));               
                
                cities = country.getCities();
                System.out.println(cities);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }
  
    // QUERY DE LINGUAGES OFICIAIS POR NOME
    public String LinguagemOficial(String nome) throws SQLException {
        Country language = new Country();
        String languages = "";
        try {
            ResultSet rs3 = stmt3.executeQuery("select language from countrylanguage as cl "
                                            + "inner join country as c on cl.countrycode = c.code "
                                            + "where c.name like '%" + nome + "%' and cl.isofficial = 't'");

            while(rs3.next()) {                
               language.adicionarOficial(rs3.getString("language")); 
            }
            language.Concatenar();
            languages = language.getConcatenaOficial();
            System.out.println(languages);
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return languages;
    }
    
    //LINGUAGENS OFICIAIS POR CODIGO
    public String LinguagemOficialCode(String code) throws SQLException {
        Country language = new Country();
        String languages = "";
        try {
            ResultSet rs3 = stmt3.executeQuery("select language from countrylanguage as cl "
                                            + "inner join country as c on cl.countrycode = c.code "
                                            + "where c.code like '%" + code + "%' and cl.isofficial = 't'");

            while(rs3.next()) {                
               language.adicionarOficial(rs3.getString("language")); 
            }
            language.Concatenar();
            languages = language.getConcatenaOficial();
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return languages;
    }
    
    //LISTA POR NOME
    @Override
    public List<Country> listarNome(String nome) throws SQLException {
        List<Country> countries = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("select * from country where name like '%" + nome + "%' order by name");
            while (rs.next()) {
                Country country = new Country();
                
                country.setCode(rs.getString("Code"));
                country.setCode2(rs.getString("Code2"));
                country.setLocalName(rs.getString("LocalName"));
                country.setName(rs.getString("Name"));
                country.setContinent(rs.getString("Continent"));
                country.setLifeExpectancy(rs.getFloat("LifeExpectancy"));
                country.setHeadOfState(rs.getString("HeadOfState"));
                country.setGovernmentForm(rs.getString("GovernmentForm"));
                country.setCities(this.Cidades(nome));
                country.setConcatenaOficial(this.LinguagemOficial(nome));
                country.setConcatenaLanguages(this.Languages(nome));
                country.setConcatenaGovernments(this.Governments());
                country.setConcatenaContinents(this.Continents());
                country.setConcatenaLanguagesTotal(this.LanguagesTotal());
 
                countries.add(country);
            }
         } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }
        return countries;
    }

    //LISTAGEM POR CODIGO 
    @Override
    public List<Country> listarCod(String code) throws SQLException {
         List<Country> countries = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("select * from country where code like '%" + code + "%' order by name");
            while (rs.next()) {
                Country country = new Country();
                
                country.setCode(rs.getString("Code"));
                country.setCode2(rs.getString("Code2"));
                country.setLocalName(rs.getString("LocalName"));
                country.setName(rs.getString("Name"));
                country.setContinent(rs.getString("Continent"));
                country.setLifeExpectancy(rs.getFloat("LifeExpectancy"));
                country.setHeadOfState(rs.getString("HeadOfState"));
                country.setGovernmentForm(rs.getString("GovernmentForm"));
                country.setCities(this.CidadesCode(code));
                country.setConcatenaOficial(this.LinguagemOficialCode(code));
                country.setConcatenaLanguages(this.Languages(code));
                country.setConcatenaGovernments(this.Governments());
                country.setConcatenaContinents(this.Continents());
                country.setConcatenaLanguagesTotal(this.LanguagesTotal());
                
                countries.add(country);
            }
         } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }
        return countries;
    }
    
}

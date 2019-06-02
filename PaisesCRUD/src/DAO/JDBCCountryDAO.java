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
    
    public JDBCCountryDAO() throws SQLDataException, ClassNotFoundException, SQLException {
        con = new Conexao();
        try {
            stmt = (Statement) con.getCon().createStatement();
            stmt2 = (Statement) con.getCon().createStatement();
            stmt3 = (Statement) con.getCon().createStatement();
            stmt4 = (Statement) con.getCon().createStatement();
            stmt5 = (Statement) con.getCon().createStatement();
        } catch (SQLDataException e) {
            throw e;
        }
    }

    @Override
    public int inserir(Country country) throws SQLDataException, SQLException {
       try {
            return stmt.executeUpdate("INSERT INTO country (Code, Name, Continent, Region, SurfaceArea, IndepYear, Population, LifeExpectancy, GNP, GNPOld, LocalName, GovernmentForm, HeadOfState, Capital, Code2) VALUES (" 
                                    + country.getCode() + ",'" 
                                    + country.getName() + "','" 
                                    + country.getContinent()+ "','"
                                    + country.getRegion()+ "','"
                                    + country.getSurfaceArea()+ "','"
                                    + country.getIndepYear()+ "','"
                                    + country.getPopulation()+ "','"
                                    + country.getLifeExpectancy()+ "','"
                                    + country.getGnp()+ "','"
                                    + country.getGnpOld()+ "','"
                                    + country.getLocalName()+ "','"
                                    + country.getGovernmentForm()+ "','"
                                    + country.getHeadOfState()+ "','"
                                    + country.getCapital()+ "','"
                                    + country.getCode2() + "')");
        } catch (SQLException e) {
            throw e;
        } finally {
            con.fecharConexao();
        }
    }

    //FALTA COLOCAR A LIGUAGEM AQUI
        @Override
        public int alterar(Country country) throws SQLException {
            try {
                return stmt.executeUpdate("UPDATE country AS c INNER JOIN countrylanguage AS cl ON c.Code = cl.CountryCode SET c.LocalName = '" 
                                        + country.getLocalName() + "',c.Name = '"
                                        + country.getName() + "', c.Continent = '"
                                        + country.getContinent() + "', c.GovernmentForm = '"
                                        + country.getGovernmentForm() + "', c.LifeExpectancy = '"
                                        + country.getLifeExpectancy() + "', c.Code2 = '"
                                        + country.getCode2() + "', cl.Language = '"
                                        + country.getLanguagesOfficial()+ "' WHERE c.Code = '"
                                        + country.getCode() + "' AND cl.IsOfficial = 'T'") ;
            } catch (SQLException e) {
                throw e;
            } finally {
                con.fecharConexao();
            }
        }

//FALTA APAGAR AS RELAÇÕES
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
            System.out.println("select language from countrylanguage as cl "
                                            + "inner join country as c on cl.countrycode = c.code "
                                            + "where c.name = '" + valor + "' or c.code = '" + valor + "' order by percentage desc");
            ResultSet rs4 = stmt4.executeQuery("select language from countrylanguage as cl "
                                            + "inner join country as c on cl.countrycode = c.code "
                                            + "where c.name = '" + valor + "' or c.code = '" + valor + "' order by percentage desc");
            
            while (rs4.next()) {                
                country.adicionar(rs4.getString("language"));
            }
            country.ConcatenarLanguages();
            linguagens = country.getConcatenaLanguages();
            System.out.println(linguagens);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return linguagens;
    }
    
    public void Governments() {
        try {
            ResultSet rs5 = stmt5.executeQuery("select governmentform from country");
            while(rs5.next()) {
                Country country = new Country();
                country.adicionarGovernments(rs5.getString("governmentform"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
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
                System.out.println(cities);
                
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
                                            + "where c.name like '%" + code + "%' and cl.isofficial = 't'");

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
    
    //LISTA POR NOME
    @Override
    public List<Country> listarNome(String nome) throws SQLException {
        List<Country> countries = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("select * from country where name like '%" + nome + "%' order by name");
            System.out.println("select * from country where name like '%" + nome + "%' order by name");
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
            System.out.println("select * from country where code like '%" + code + "%' order by name");
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

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
            return stmt.executeUpdate("DELETE FROM country WHERE id = " + country.getCode());
        } catch (Exception e) {
            throw e;
        } finally {
            con.fecharConexao();
        }
    }
    
    public void Languages() {
        List<Country> language = new ArrayList<>();
        try {
            ResultSet rs4 = stmt4.executeQuery("select language from countrylanguage");
            while (rs4.next()) {
                Country country = new Country();
                country.adicionar(rs4.getString("language"));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
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
    public void Cidades(String nome) throws SQLException {
        List<Country> countries = new ArrayList<>();
        try {
            ResultSet rs2 = stmt2.executeQuery("SELECT COUNT(*) FROM city as ct "
                                            + "inner join country as c on ct.countrycode = c.code "
                                            + "where c.name like '%" + nome + "%'");
            while(rs2.next()) {
                Country country = new Country();
                country.setCities(rs2.getInt("COUNT(*)"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //QUERY QUANTIDADE DE CIDADES POR CODIGO
    public void CidadesCode(String code) throws SQLException {
        List<Country> countries = new ArrayList<>();
        try {
            ResultSet rs2 = stmt2.executeQuery("SELECT COUNT(*) FROM city as ct "
                                            + "inner join country as c on ct.countrycode = c.code "
                                            + "where c.code like '%" + code + "%'");
            while(rs2.next()) {
                Country country = new Country();
                country.setCities(rs2.getInt("COUNT(*)"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
    // QUERY DE LINGUAGES OFICIAIS POR NOME
    public void LinguagemOficial(String nome) throws SQLException {
        List<Country> countries = new ArrayList<>();
        try {
            ResultSet rs3 = stmt3.executeQuery("select language from countrylanguage as cl "
                                            + "inner join country as c on cl.countrycode = c.code "
                                            + "where c.name like '%" + nome + "%' and cl.isofficial = 't'");
            System.out.println("select language from countrylanguage as cl "
                                            + "inner join country as c on cl.countrycode = c.code "
                                            + "where c.name like '%" + nome + "%' and cl.isofficial = 't'");
            while(rs3.next()) {
                Country language = new Country();              
                language.adicionarOficial(rs3.getString("language")); 
                language.Concatenar();
                System.out.println(language.getLanguagesOfficial());
                countries.add(language);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    //LINGUAGENS OFICIAIS POR CODIGO
    public void LinguagemOficialCode(String code) throws SQLException {
        List<Country> countries = new ArrayList<>();
        try {
            ResultSet rs3 = stmt3.executeQuery("select language from countrylanguage as cl "
                                            + "inner join country as c on cl.countrycode = c.code "
                                            + "where c.code like '%" + code + "%' and cl.isofficial = 't'");
            System.out.println("select language from countrylanguage as cl "
                                            + "inner join country as c on cl.countrycode = c.code "
                                            + "where c.code like '%" + code + "%' and cl.isofficial = 't'");
            while(rs3.next()) {
                Country language = new Country();              
                language.adicionar(rs3.getString("language"));       
                System.out.println(language.getLanguagesOfficial());
                countries.add(language);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    //LISTA POR NOME (FALTA A PORCENTAGEM DE LINGUAS FALADAS)
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
                this.Cidades(nome);
                this.LinguagemOficial(nome);
                this.Governments();
                this.Languages();
          
                //ORDENAÇÃO DAS LÍNGUAS FALADAS POR PERCENTUAL

               // countryLanguage.setPercentage(rs.getFloat("Percentage"));
                countries.add(country);
            }
         } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.fecharConexao();
        }
        return countries;
    }

    //LISTAGEM POR CODIGO (FALTA A PORCENTAGEM DE LINGUAS FALADAS)
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
                
                this.CidadesCode(code);
                this.LinguagemOficialCode(code);
                
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

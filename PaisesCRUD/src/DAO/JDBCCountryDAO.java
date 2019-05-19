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
    
    public JDBCCountryDAO() throws SQLDataException, ClassNotFoundException, SQLException {
        con = new Conexao();
        try {
            stmt = (Statement) con.getCon().createStatement();
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
        public int alterar(Country country, CountryLanguage countryL) throws SQLException {
            try {
                return stmt.executeUpdate("UPDATE country AS c INNER JOIN countrylanguage AS cl ON c.Code = cl.CountryCode SET c.LocalName = '" 
                                        + country.getLocalName() + "',c.Name = '"
                                        + country.getName() + "', c.Continent = '"
                                        + country.getContinent() + "', c.GovernmentForm = '"
                                        + country.getGovernmentForm() + "', c.LifeExpectancy = '"
                                        + country.getLifeExpectancy() + "', c.Code2 = '"
                                        + country.getCode2()+ "', cl.Language = '"
                                        + countryL.getLanguage()+ "' WHERE c.Code = '"
                                        + country.getCode()+ "' AND cl.IsOfficial = 'T'") ;
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

    //query de quantidade de cidades pelo nome    
    public void Cidades(String nome) throws SQLException {
        List<Country> countries = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM city as ct "
                                            + "inner join country as c on ct.countrycode = c.code "
                                            + "where c.name = '%" + nome + "%'");
            while(rs.next()) {
                Country country = new Country();
                country.setCities(rs.getInt("COUNT(*)"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //query quantidade de cidades pelo código
    public void CidadesCode(String code) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM city as ct "
                                        + "inner join country as c on ct.countrycode = c.code "
                                        + "where c.name = '%" + code + "%'");
        Country country = new Country();
        country.setCities(rs.getInt("COUNT(*)"));
    }
  
    // QUERY DE LINGUAGES OFICIAIS
    public void LinguagemOficial(String nome) throws SQLException {
        List<Country> countries = new ArrayList<>();
        String getEnum = new String();
        try {
            ResultSet rs = stmt.executeQuery("select language from countrylanguage as cl "
                                            + "inner join country as c on cl.countrycode = c.code "
                                            + "where c.name = '" + nome + "' and cl.isofficial = 't'");
            while(rs.next()) {
                Country country = new Country();              

                getEnum = rs.getString("IsOfficial");
                country.setLanguagesOfficial(getEnum);
                System.out.println(getEnum);
                
                countries.add(country);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    //FALTA COLOCAR AS LISTAS 
    @Override
    public List<Country> listarNome(String nome) throws SQLException {
        List<Country> countries = new ArrayList<>();
        String getEnum = new String();
        try {
            ResultSet rs = stmt.executeQuery("select * from country where name like '%" + nome + "%' order by name");
            while (rs.next()) {
                Country country = new Country();
                CountryLanguage countryLanguage = new CountryLanguage();
                
                country.setCode(rs.getString("Code"));
                country.setCode2(rs.getString("Code2"));
                country.setLocalName(rs.getString("LocalName"));
                country.setName(rs.getString("Name"));
                country.setContinent(rs.getString("Continent"));
                country.setLifeExpectancy(rs.getFloat("LifeExpectancy"));
                country.setHeadOfState(rs.getString("HeadOfState"));
                Cidades(nome);
                LinguagemOficial(nome);
                
//                NÃO VAI FUNCIONAR PQ ELE SÓ ADICIONA NA LISTA O COUNTRY
//                getEnum = rs.getString("IsOfficial");
//                countryLanguage.setIsOfficial(getEnum);
//                
//                if("T".equals(countryLanguage.getIsOfficial())){
//                    countryLanguage.setLanguage(rs.getString("Language"));
//                }              
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

    //MESMA COISA DA FUNÇÃO ANTERIOR
    @Override
    public List<Country> listarCod(String code) throws SQLException {
        List<Country> countries = new ArrayList<Country>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM country WHERE Code like '%" + code + "%'");
            while (rs.next()) {
                Country country = new Country();
                country.setCode(rs.getString("Code"));
                country.setCode2(rs.getString("Code2"));
                country.setLocalName(rs.getString("LocalName"));
                country.setName(rs.getString("Name"));
               // country.setContinent(rs.getArray("Continent"));
                country.setLifeExpectancy(rs.getFloat("LifeExpectance"));
                //CIDADES
                //LÍNGUA OFICIAL
                //ORDENAÇÃO DAS LÍNGUAS FALADAS POR PERCENTUAL
                country.setHeadOfState(rs.getString("HeadOfState"));
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

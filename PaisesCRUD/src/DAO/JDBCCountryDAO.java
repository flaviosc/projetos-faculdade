package DAO;

import java.sql.SQLDataException;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    //FALTA COLOCAR AS LISTAS 
    @Override
    public List<Country> listarNome(String nome) throws SQLException {
        List<Country> countries = new ArrayList<Country>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM country WHERE nome like '%" + nome + "%'");
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

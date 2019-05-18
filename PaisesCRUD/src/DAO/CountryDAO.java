package DAO;

import java.sql.SQLException;
import java.util.List;

public interface CountryDAO {
    public int inserir(Country country) throws SQLException;
    public int alterar(Country country, CountryLanguage countryL) throws SQLException;
    public int remover(Country country) throws SQLException;
    public List<Country> listarNome(String nome) throws SQLException;
    public List<Country> listarCod(String code) throws SQLException;
}

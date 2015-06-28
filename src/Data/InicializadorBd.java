/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;
import java.sql.Connection;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.derby.jdbc.*;

/**
 *
 * @author Eduardo
 */
public class InicializadorBd {
    
    public static String DB_NAME = "jdbc:derby://localhost:1527/TrabalhoFnal";
    //public static String DATA_SOURCE = "jdbc:derby://localhost:1527/TrabalhoFnal";
    public static String USER_NAME = "usuario";
    public static String PASSWORD = "senha";
    private static DataSource dataSource;

    private static DataSource criarDataSource() throws Exception {
        if (dataSource == null) {
            EmbeddedDataSource ds = new EmbeddedDataSource();
            ds.setDatabaseName(DB_NAME);
            //ds.setDataSourceName(DATA_SOURCE);
            //ds.setCreateDatabase("create");
            ds.setUser(USER_NAME);
            ds.setPassword(PASSWORD);
            dataSource = ds;
        }
        return dataSource;
    }
    
    public static void criarBd() throws Exception {
        try (Connection con = criarDataSource().getConnection();
                Statement sta = con.createStatement()) {
            String sql = "CREATE TABLE Usuarios (\n" +
"idUsuario int PRIMARY KEY GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),\n" +
"Nome varchar(50),\n" +
"CpfCnpj varchar(15),\n" +
"Email varchar(50)\n" +
");\n" +
"\n" +
"CREATE TABLE Leiloes (\n" +
"idLeilao int PRIMARY KEY,\n" +
"DataInicio Date,\n" +
"HoraInicio Time,\n" +
"DataFim Date,\n" +
"HoraFIm Time,\n" +
"Natureza int,\n" +
"FormaLance int,\n" +
"ValorLote Decimal,\n" +
"Usuario_id int\n" +
");\n" +
"\n" +
"CREATE TABLE Bens (\n" +
"idBem int PRIMARY KEY,\n" +
"DescricaoBreve varchar(50),\n" +
"DescricaoCompleta varchar(255),\n" +
"Categoria_id int,\n" +
"Leilao_id int\n" +
");\n" +
"\n" +
"CREATE TABLE CategoriasBens (\n" +
"idCategoria int PRIMARY KEY,\n" +
"NomeCategoria varchar(50)\n" +
");\n" +
"\n" +
"CREATE TABLE Lances (\n" +
"idLance int PRIMARY KEY,\n" +
"Data Date,\n" +
"Hora Time,\n" +
"Valor Decimal,\n" +
"Usuario_id int,\n" +
"Leilao_id int\n" +
");\n" +
"\n" +
"ALTER TABLE Lances ADD CONSTRAINT fk_Lances_Usuarios \n" +
"FOREIGN KEY (Usuario_id) REFERENCES Usuarios(idUsuario);\n" +
"\n" +
"ALTER TABLE Lances ADD CONSTRAINT fk_Lances_Leiloes \n" +
"FOREIGN KEY (Leilao_id) REFERENCES Leiloes(idLeilao);\n" +
"\n" +
"ALTER TABLE Leiloes ADD CONSTRAINT fk_Leiloes_Usuarios \n" +
"FOREIGN KEY (Usuario_id) REFERENCES Usuarios(idUsuario);\n" +
"\n" +
"ALTER TABLE Bens ADD CONSTRAINT fk_Bens_Categorias \n" +
"FOREIGN KEY (Categoria_id) REFERENCES CategoriasBens(idCategoria);\n" +
"\n" +
"ALTER TABLE Bens ADD CONSTRAINT fk_Bens_Leiloes\n" +
"FOREIGN KEY (Leilao_id) REFERENCES Leiloes(idLeilao);";
            sta.executeUpdate(sql);
        }
    }

    public static Connection conectarBd() throws Exception {
        return criarDataSource().getConnection();
    }
}

package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import modelo.Cliente;


public abstract class GenericDAO {

	protected Connection miConexion = null;
	// Carga de driver de conexion con JDBC:

	static {
		// Bloque especial que se ejecuta una unica vez
		// a lo largo de la aplicacion la primera
		// vez que esta clase es usada

		// preparao driver y conexion
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out
					.println("ERROR!! no encuentro el driver-libreria de MySql");
		}
	}// end static

	protected void conectar() {
		try {
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/porta_empresa", "root",
					"jeveris");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out
					.println("ERROR!!! no pude conectarme a la base de datos");
			System.out.println("ERROR!!! comprobar ruta de la base de datos");
			System.out.println("ERROR!!! comprobar nombre y contraseña");
			System.out.println(e.getMessage());
		}
	}// end conectar

	protected void desconectar() {
		try {
			miConexion.close();
		} catch (SQLException e) {
			System.out.println("ERROR!!! no pudde realizar la desconexion");
		}
	}// end desconectar



}// end GenericDAO

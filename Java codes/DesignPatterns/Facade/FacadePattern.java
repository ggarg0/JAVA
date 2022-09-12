package DesignPatterns.Facade;

interface DBConnection {
	abstract String getDBConnection();
}

class MySqlConnection implements DBConnection {
	@Override
	public String getDBConnection() {
		return "MySqlConnection";
	}
}

class OracleConnection implements DBConnection {
	@Override
	public String getDBConnection() {
		return "OracleConnection";
	}
}

class HelperFacade {
	public static DBConnection getDBConnection(String dbType) {
		switch (dbType) {
		case "MYSQL":
			return new MySqlConnection();
		case "ORACLE":
			return new OracleConnection();
		default:
			return null;
		}
	}
}

public class FacadePattern {
	public static void main(String[] args) {
		DBConnection con = HelperFacade.getDBConnection("MYSQL");
		System.out.println(con.getDBConnection());
		con = HelperFacade.getDBConnection("ORACLE");
		System.out.println(con.getDBConnection());
	}
}
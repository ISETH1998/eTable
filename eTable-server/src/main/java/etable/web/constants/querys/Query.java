package etable.web.constants.querys;

public class Query {

	public static String table_configuracion = "TBCONFIGURACIONSISTEMA";
	public static String table_perfilmesa = "TBPERFILMESA";
	public static String table_permisos = "TBPERMISOS";
	public static String table_menuitems = "TBMENUITEMS";
	public static String table_menusubitems = "TBMENUSUBITEMS";
	
	public static String update_configuracion =  
			"UPDATE " + Query.table_configuracion + 
			" SET  CEMPRESA = ? , EMPNOMBRE = ? , EMPDESCRIPCION = ? , EMPEMAIL = ? , EMPCELULAR = ? , EMPLOGO = ? , "
			+ "SIST_RESERVACION_CLIENTE = ? , SIST_ATENCION_CLIENTE = ? , MESAS_COMPUESTAS = ? , AGREGAR_CLIENTE_MANUAL = ? , "
			+ "PAGOS_TARJETA_CREDITO = ? , RESERVACION_PEDIDOS = ? , RESERVAS_ESPECIALES = ? , RESERVAS_NO_SESIONADAS = ? , DATE_CONFIGURADO = ? "
			+ "WHERE CCONFIGURACION = ?";
	
	public static String update_parametros =
			"UPDATE " + Query.table_configuracion +
			" SET CANT_MAX_MESAS = ? , HORARIO_INI_ATENCION = ? , HORARIO_FIN_ATENCION = ? , DIAS_ATENCION = ? , MAX_US_TRAB_CONECTADOS = ?";

	public static String selectFrom(String table) {
		return "SELECT * FROM " + table;
	}
	
	public static String selectFromWhere(String table, String field, int id) {
		return "SELECT * FROM " + table + " WHERE " + field + " = " + id;
	}
}

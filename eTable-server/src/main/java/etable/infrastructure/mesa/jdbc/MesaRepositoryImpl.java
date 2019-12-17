package etable.infrastructure.mesa.jdbc;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import etable.domain.mesa.factory.method.IFabrica;
import etable.domain.mesa.model.Mesa;
import etable.domain.mesa.model.MesaDTO;
import etable.domain.mesa.repository.MesaRepository;
import etable.web.constants.querys.Query;

@Component
public class MesaRepositoryImpl implements MesaRepository{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MesaRowMapper row;
	
	@Autowired
	private IFabrica fabrica;

	@Override
	public List<MesaDTO> getMesas() {
		// TODO Auto-generated method stub
		
		String query = "SELECT * FROM TBMESA AS M INNER JOIN TBESTADOMESA "
				+ "AS N ON M.CESTADOMESA = N.CESTADOMESA INNER JOIN TBPERFILMESA"
				+ " AS T ON M.CPERFILMESA = T.CPERFILMESA" ;
		

		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);
		List<MesaDTO> mesas = row.mapRowMesaDTO(rows);
		return mesas;
	}

	@Override
	public Mesa actualizarMesaById(Mesa mesa, int id) {
		String query = 	"UPDATE " + Query.table_mesa +
	" SET NOMBREMESA = ? , CPERFILMESA = ? , CESTADOMESA = ? WHERE CMESA = ?";
	int update = this.jdbcTemplate.update(query, 
				mesa.getNombremesa(),
				mesa.getCperfilmesa(), 
				mesa.getCestadomesa(), 
				mesa.getCmesa());
		System.out.print("update");
		System.out.print(update);
		if(update == 1) {
			return mesa;
		}
				return null;
			}

	@Override
	public boolean  eliminarMesaById(int id) {
		String query = 	"DELETE FROM " + Query.table_mesa +" WHERE CMESA = ?";

		int success = this.jdbcTemplate.update(query, id);
		if (success >= 0) {
			return true;
		}
		return false;
		
		
	}

	@Override
	public Mesa crearMesa(Mesa mesa) {
		if (this.fabrica.fabricarMesa(mesa) != null) {
			String insertQuery = "insert into "+ Query.table_mesa +"(NOMBREMESA,CPERFILMESA,CESTADOMESA) values (?, ?, ?)";
			int success = this.jdbcTemplate.update( insertQuery, mesa.getNombremesa(),mesa.getCperfilmesa() , mesa.getCestadomesa());
			if (success >= 0) {
				return mesa;
			}	
		}
		return mesa;
		
	}

	@Override
	public Mesa getMesaById(int id) {
		String findMesa = Query.selectFromWhere(Query.table_mesa, "CMESA", id);
		List<Mesa> mesa = this.row.getMesa(this.jdbcTemplate.queryForList(findMesa));
		if (mesa.size() > 0) {
			return mesa.get(0);
		}
		return null;
	}
	

	
	
	
}

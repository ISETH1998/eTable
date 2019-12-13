package etable.application.mesa;

import java.util.List;

import etable.domain.mesa.model.Mesa;
import etable.domain.mesa.model.MesaDTO;
public interface MesaService {

	List<MesaDTO> getMesas();
	Mesa actualizarMesaById(Mesa mesa, int id);
	boolean eliminarMesaById(int id);
	Mesa crearMesa(Mesa mesa) ;

}

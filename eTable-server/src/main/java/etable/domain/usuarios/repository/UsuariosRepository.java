package etable.domain.usuarios.repository;

import java.util.List;

import etable.domain.usuarios.model.TipoUsuario;
import etable.domain.usuarios.model.TipoUsuarioPermiso;

public interface UsuariosRepository {

	TipoUsuario agregarTipoUsuario(TipoUsuario tipoUsuario);
	TipoUsuario getTipoUsuarioById(int ctipousuario);
	List<TipoUsuario> getTiposUsuario();
	TipoUsuario editTipoUsuario(TipoUsuario tipousuario);
	boolean eliminarTipoUsuarioById(TipoUsuario tipousuario);
	
	List<TipoUsuarioPermiso> getPermisosAsignadosDeTipoUsuario(int ctipousuario);
	boolean asignarPermisosParaTipoUsuario(List<TipoUsuarioPermiso> tipouspermisos);
	boolean editarPermisosDeTipoUsuario(List<TipoUsuarioPermiso> tipouspermisos);
	boolean eliminarPermisosDeTipoUsuarioById(int id);
	boolean removerPermisos(List<TipoUsuarioPermiso> tipouspermisos);
}

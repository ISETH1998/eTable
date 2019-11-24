package etable.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import etable.application.permiso.PermisoService;
import etable.domain.permiso.model.Permiso;

@CrossOrigin(origins = "localhost:4200")
@RestController
@RequestMapping({"/api/permiso"})
public class PermisoController {

	@Autowired
	private PermisoService service;
	
	@GetMapping(path = {"/permisos"})
	public List<Permiso> getListPermisos(){
		return this.service.getPermisos();
	}
	
	@GetMapping(path = {"/permisosBySubItem/{id}"})
	public List<Permiso> getListPermisosBySubItem(@PathVariable int id){
		return this.service.getPermisosBySubItem(id);
	}
	
	@PutMapping(path = {"/editarPermiso"})
	public Permiso updatePermisoById(@RequestBody Permiso permiso) {
		return this.service.updatePermisoById(permiso);
	}
	
	@GetMapping(path = {"/{id}"})
	public Permiso getPermisoById(@PathVariable int id) {
		return this.service.getPermisoById(id);
	}
}

package lorislambert.youxgroup_backend_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {
	
	@RequestMapping("/cadastrousuarios")
	public String form() {
		return "cadastro";
	}
	
}

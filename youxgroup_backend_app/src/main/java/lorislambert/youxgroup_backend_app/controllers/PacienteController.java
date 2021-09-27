package lorislambert.youxgroup_backend_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PacienteController {

		@RequestMapping("/cadastropacientes")
		public String form() {
			return "cadastro";
		}
		
}

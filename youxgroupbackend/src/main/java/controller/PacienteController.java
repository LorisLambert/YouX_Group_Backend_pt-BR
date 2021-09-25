package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.ResourceNotFoundException;
import model.Paciente;
import repository.PacienteRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class PacienteController {
	@Autowired
	private PacienteRepository pacienteRepository;
	
	// Lista todos os pacientes
	@GetMapping("/pacientes")
	public List<Paciente> getAllPacientes(){
		return pacienteRepository.findAll();
	}		
	
	// Cria um novo paciente via requisição da API
	@PostMapping("/pacientes")
	public Paciente createPaciente(@RequestBody Paciente paciente) {
		return pacienteRepository.save(paciente);
	}
	
	// Pega um paciente via requisição API e id
	@GetMapping("/pacientes/{id}")
	public ResponseEntity<Paciente> getPacienteById(@PathVariable Long id) {
		Paciente paciente = pacienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Esse id não corresponde a um paciente:" + id));
		return ResponseEntity.ok(paciente);
	}
	
	// Atualiza os dados de um paciente via requisição da API
	
	@PutMapping("/pacientes/{id}")
	public ResponseEntity<Paciente> updatePaciente(@PathVariable Long id, @RequestBody Paciente pacienteDetails){
		Paciente paciente = pacienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Esse id não corresponde a um paciente:" + id));
		
		paciente.setNome(pacienteDetails.getNome());
		paciente.setCpf(pacienteDetails.getCpf());
		paciente.setDataNascimento(pacienteDetails.getDataNascimento());
		paciente.setAltura(pacienteDetails.getAltura());
		paciente.setPeso(pacienteDetails.getPeso());
		paciente.setUf(pacienteDetails.getUf());
		
		Paciente updatedPaciente = pacienteRepository.save(paciente);
		return ResponseEntity.ok(updatedPaciente);
	}
	
	// Apaga um paciente via requisição da API
	@DeleteMapping("/pacientes/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePaciente(@PathVariable Long id){
		Paciente paciente = pacienteRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Esse id não corresponde a um paciente:" + id));
		
		pacienteRepository.delete(paciente);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deletado", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
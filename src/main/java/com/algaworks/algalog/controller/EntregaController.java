package com.algaworks.algalog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.dto.EntregaDTO;
import com.algaworks.algalog.domain.model.input.EntregaInput;
import com.algaworks.algalog.domain.service.EntregaService;
import com.algaworks.algalog.mapper.EntregaMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

	private EntregaService entregaService;
	private EntregaMapper entregaMapper;

	@GetMapping
	public List<EntregaDTO> listar() {
		return entregaMapper.toCollectionDTO(entregaService.listAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntregaDTO> obter(@PathVariable Long id) {
		return entregaService.obter(id).map(entrega -> ResponseEntity.ok(entregaMapper.toDTO(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EntregaDTO solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega novaEntrega = entregaMapper.toEntity(entregaInput);

		Entrega entregaSolicitada = entregaService.solicitar(novaEntrega);

		return entregaMapper.toDTO(entregaSolicitada);
	}
	
	@PutMapping("/{id}/finalizacao")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long id) {
		entregaService.finalizar(id);
	}
}

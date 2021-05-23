package com.algaworks.algalog.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.domain.model.Ocorrencia;
import com.algaworks.algalog.domain.model.dto.OcorrenciaDTO;
import com.algaworks.algalog.domain.model.input.OcorrenciaInput;
import com.algaworks.algalog.domain.service.OcorrenciaService;
import com.algaworks.algalog.mapper.OcorrenciaMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

	private OcorrenciaService ocorrenciaService;
	private OcorrenciaMapper ocorrenciaMapper;

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public OcorrenciaDTO registrar(@PathVariable Long entregaId, @Valid @RequestBody OcorrenciaInput ocorrenciaInput) {
		Ocorrencia ocorrenciaRegistrada = ocorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());
		return ocorrenciaMapper.toDTO(ocorrenciaRegistrada);

	}
	
	@GetMapping()
	public List<OcorrenciaDTO> obter(@PathVariable Long entregaId) {	
		List<Ocorrencia> ocorrencias = ocorrenciaService.listarPorEntrega(entregaId);
		
		List<OcorrenciaDTO> collectionDTO = ocorrenciaMapper.toCollectionDTO(ocorrencias);
		
		return collectionDTO;
	}
	
	
}

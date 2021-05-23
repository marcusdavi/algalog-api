package com.algaworks.algalog.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.Ocorrencia;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OcorrenciaService {
	
	private EntregaService entregaservice;

	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = entregaservice.buscarEntrega(entregaId);
		
		return entrega.adicionarOcorrencia(descricao);
	}
	
	public List<Ocorrencia> listarPorEntrega(Long entregaId) {
		Entrega entrega = entregaservice.buscarEntrega(entregaId);
		return entrega.getOcorrencias();
	}
}

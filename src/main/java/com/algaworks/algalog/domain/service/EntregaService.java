package com.algaworks.algalog.domain.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EntregaService {

	private EntregaRepository entregaRepository;
	private ClienteService clienteService;

	public List<Entrega> listAll() {
		return entregaRepository.findAll();
	}

	@Transactional
	public Entrega solicitar(Entrega entrega) {

		Cliente cliente = clienteService.buscarCliente(entrega.getCliente().getId());

		entrega.setCliente(cliente);
		entrega.setDataPedido(OffsetDateTime.now());
		entrega.setStatus(StatusEntrega.PENDENTE);

		return entregaRepository.save(entrega);
	}

	public Optional<Entrega> obter(Long id) {
		return entregaRepository.findById(id);
	}

	public Entrega buscarEntrega(Long entregaId) {
		return entregaRepository.findById(entregaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada"));

	}

}

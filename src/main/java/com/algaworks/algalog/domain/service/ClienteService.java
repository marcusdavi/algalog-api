package com.algaworks.algalog.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {

	private ClienteRepository clienteRepository;

	public List<Cliente> lista() {
		return clienteRepository.findAll();
	}

	public Optional<Cliente> obter(Long id) {
		return clienteRepository.findById(id);
	}

	@Transactional
	public Cliente adicionar(Cliente cliente) {
		if(verificarEmailJaExistente(cliente.getId(), cliente.getEmail())) {
			throw new NegocioException("Já existe cliente cadastrado com este email.");	
		} else {
			return clienteRepository.save(cliente);
		}
		
	}

	@Transactional
	public Cliente atualizar(Cliente cliente) {
		
		if (!clienteRepository.existsById(cliente.getId())) {
			return null;
		} else {
			if(verificarEmailJaExistente(cliente.getId(), cliente.getEmail())) {
				throw new NegocioException("Já existe cliente cadastrado com este email.");	
			} else {
				return clienteRepository.save(cliente);
			}
		}
	}

	@Transactional
	public Boolean deletar(Long id) {
		if (!clienteRepository.existsById(id)) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean verificarEmailJaExistente(Long id, String email) {
		Optional<Cliente> cliente = clienteRepository.findByEmail(email);

		return cliente.isPresent() && !cliente.get().getId().equals(id);

	}
	
	public Cliente buscarCliente(Long clienteId) {
		return clienteRepository.findById(clienteId)
		.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
	}

}

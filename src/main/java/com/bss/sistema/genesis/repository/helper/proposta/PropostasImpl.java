package com.bss.sistema.genesis.repository.helper.proposta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.bss.sistema.genesis.model.Proposta;
import com.bss.sistema.genesis.repository.filter.PropostaFilter;

//!SEMPRE CRIAR COM NOME PLURAL + IMPL SE NAO NAO ACHA NA CONTROLLER
public class PropostasImpl implements PropostasQueries {

	@PersistenceContext
	private EntityManager manager;
	// Criando a Criteria para Usuario = filtro
	// Pra pegar a criteria do Hibernate precisa de uma transacao , apenas de
	// leitura

	// Para injetar o Entity Manager Usamos o @AutoWired

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Proposta> filtrar(PropostaFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Proposta.class);
		if (filtro != null) {

			if (!StringUtils.isEmpty(filtro.getAde())) {
				criteria.add(Restrictions.eq("ade", filtro.getAde()));
			}

			if (isClientePresente(filtro)) {
				criteria.add(Restrictions.eq("cliente", filtro.getCliente()));
			}
			if (isBancoPresente(filtro)) {
				criteria.add(Restrictions.eq("banco", filtro.getBanco()));
			}

			if (isProdutoPresente(filtro)) {
				criteria.add(Restrictions.eq("produto", filtro.getProduto()));
			}

			if (isTabelaPresente(filtro)) {
				criteria.add(Restrictions.eq("tabela", filtro.getTabela()));
			}

		}
		return criteria.list();
	}

	private boolean isProdutoPresente(PropostaFilter filtro) {
		return filtro.getProduto() != null && filtro.getProduto().getCodigo() != null;
	}

	private boolean isTabelaPresente(PropostaFilter filtro) {
		return filtro.getTabela() != null && filtro.getTabela().getCodigo() != null;
	}

	private boolean isClientePresente(PropostaFilter filtro) {
		return filtro.getCliente() != null && filtro.getCliente().getCodigo() != null;
	}

	private boolean isBancoPresente(PropostaFilter filtro) {
		return filtro.getBanco() != null && filtro.getBanco().getCodigo() != null;

	}

}
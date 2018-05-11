package com.bss.sistema.genesis.repository.helper.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.bss.sistema.genesis.model.Usuario;
import com.bss.sistema.genesis.repository.filter.UsuarioFilter;

public class UsuariosImpl implements UsuariosQueries {

	@PersistenceContext
	private EntityManager manager;
	// Criando a Criteria para Usuario = Filtro
	// Pra pegar a criteria do Hibernate precisa de uma transacao , apenas de
	// leitura

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> filtrar(UsuarioFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Usuario.class);
		if (filtro != null) {
			if (!StringUtils.isEmpty(filtro.getCpf())) {
				criteria.add(Restrictions.eq("cpf", filtro.getCpf()));
			}

			if (!StringUtils.isEmpty(filtro.getNome())) {
				criteria.add(Restrictions.ilike("nome", filtro.getNome(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(filtro.getSobrenome())) {
				criteria.add(Restrictions.ilike("sobrenome", filtro.getSobrenome(), MatchMode.ANYWHERE));
			}

			if (!StringUtils.isEmpty(filtro.getEmail())) {
				criteria.add(Restrictions.ilike("email", filtro.getEmail(), MatchMode.ANYWHERE));
			}

			if (isGrupoPresente(filtro)) {
				criteria.add(Restrictions.eq("grupo", filtro.getGrupo()));
			}
			if (isContaPresente(filtro)) {
				criteria.add(Restrictions.eq("conta", filtro.getConta()));
			}

		}
		return criteria.list();
	}

	private boolean isGrupoPresente(UsuarioFilter filtro) {
		return filtro.getGrupo() != null && filtro.getGrupo().getDescricao() != null;

	}

	private boolean isContaPresente(UsuarioFilter filtro) {
		return filtro.getConta() != null && filtro.getConta().getCodigo() != null;
	}
	
	

}

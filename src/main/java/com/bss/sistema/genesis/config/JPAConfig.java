package com.bss.sistema.genesis.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bss.sistema.genesis.model.Banco;
import com.bss.sistema.genesis.model.Cliente;
import com.bss.sistema.genesis.model.Comissao;
import com.bss.sistema.genesis.model.Conta;
import com.bss.sistema.genesis.model.Equipe;
import com.bss.sistema.genesis.model.Produto;
import com.bss.sistema.genesis.model.Proposta;
import com.bss.sistema.genesis.model.Tabela;
import com.bss.sistema.genesis.model.Usuario;
import com.bss.sistema.genesis.repository.Propostas;
import com.bss.sistema.genesis.storage.FotoStorage;
import com.bss.sistema.genesis.storage.local.FotoStorageLocal;

//Classe Configuracoes do Banco 

@Configuration
@EnableJpaRepositories(basePackageClasses = Propostas.class ,   enableDefaultTransactions = false) // Chamando Propostas.interface = Repository
@EnableTransactionManagement
public class JPAConfig {

	// jdbc/genesisDB = context.xml apontando
	@Bean
	public DataSource dataSource() {
		JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();
		dataSourceLookup.setResourceRef(true);
		return dataSourceLookup.getDataSource("jdbc/genesisDB");

	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		return adapter;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setJpaVendorAdapter(jpaVendorAdapter);
		
		factory.setPackagesToScan(FotoStorage.class.getPackage().getName());
		factory.setPackagesToScan(FotoStorageLocal.class.getPackage().getName());
		factory.setPackagesToScan(Proposta.class.getPackage().getName());
		factory.setPackagesToScan(Usuario.class.getPackage().getName());
		factory.setPackagesToScan(Banco.class.getPackage().getName());
		factory.setPackagesToScan(Equipe.class.getPackage().getName());
		factory.setPackagesToScan(Produto.class.getPackage().getName());
		factory.setPackagesToScan(Tabela.class.getPackage().getName());
		factory.setPackagesToScan(Conta.class.getPackage().getName());
		factory.setPackagesToScan(Cliente.class.getPackage().getName());
		factory.setPackagesToScan(Comissao.class.getPackage().getName());
		factory.afterPropertiesSet();

		return factory.getObject();

	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;

	}
	

	@Bean
	public FotoStorage fotoStorage() {
		return new FotoStorageLocal();
}

}

package com.bss.sistema.genesis.storage.local;

import static java.nio.file.FileSystems.getDefault;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.bss.sistema.genesis.storage.FotoStorage;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.name.Rename;

public class FotoStorageLocal implements FotoStorage {

	private static final Logger logger = LoggerFactory.getLogger(FotoStorageLocal.class);

	// private Path local;
	// private Path localTemporario;

	Path local = Paths.get("C://Users//BRUNO//.genesisfotos");
	Path localTemporario = Paths.get("C://Users//BRUNO//.genesisfotos//temp");

	public FotoStorageLocal() {
		// Versao MAC
		// this(getDefault().getPath(System.getenv("user.home"), ".genesisfotos"));

		// versao windows
		this(getDefault().getPath(System.getProperty("user.home"), ".genesisfotos"));
		System.out.println(">>>>>>>> CRIADO GENESIS + FOTOS ");
	}

	public FotoStorageLocal(Path path) {
		this.local = path;
		criarPastas();
	}

	//Finalmente Salva a Foto e Move ela da pasta TEMP para a PASTA RAIZ
	@Override
	public void salvar(String foto) {
		try {
			// Path sourcePath = localTemporario.resolve(foto);
			// System.out.println("VERIFICAR ONDE VAO ESSES ARQUIVOS" +
			// this.localTemporario.resolve(foto));
			// Path destinationPath = local.resolve(foto);
			// System.out.println("VERIFICAR ONDE VAO ESSES ARQUIVOS" +
			// this.local.resolve(foto));
			// Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
			Files.move(this.localTemporario.resolve(foto), this.local.resolve(foto));
			System.out.println("VERIFICAR ONDE VAO ESSES ARQUIVOS" + this.local.resolve(foto));
			System.out.println("VERIFICAR ONDE VAO ESSES ARQUIVOS" + this.localTemporario.resolve(foto));
			// Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new RuntimeException("Erro movendo a foto para destino final", e);
		}

		try {
			Thumbnails.of(this.local.resolve(foto).toString()).size(40, 68).toFiles(Rename.PREFIX_DOT_THUMBNAIL);
		} catch (IOException e) {
			throw new RuntimeException("Erro gerando thumbnail", e);
		}
	}
	
	/// Salva temporariamente 
	@Override
	public String salvarTemporariamente(MultipartFile[] files) {
		String novoNome = null;
		if (files != null && files.length > 0) {
			MultipartFile arquivo = files[0];
			novoNome = renomearArquivo(arquivo.getOriginalFilename());
			try {
				arquivo.transferTo(new File(
						this.localTemporario.toAbsolutePath().toString() + getDefault().getSeparator() + novoNome));
			} catch (IOException e) {
				throw new RuntimeException("Erro salvando a foto na pasta temporária", e);
			}
		}

		return novoNome;
	}

	@Override
	public byte[] recuperarFotoTemporaria(String nome) {
		try {
			return Files.readAllBytes(this.localTemporario.resolve(nome));
		} catch (IOException e) {
			throw new RuntimeException("Erro lendo a foto temporária", e);
		}
	}

	@Override
	public byte[] recuperar(String nome) {
		try {
			return Files.readAllBytes(this.local.resolve(nome));
		} catch (IOException e) {
			throw new RuntimeException("Erro lendo a foto nao e a temporaria mais", e);
		}
	}

	private void criarPastas() {
		try {
			Files.createDirectories(this.local);
			this.localTemporario = getDefault().getPath(this.local.toString(), "temp");
			Files.createDirectories(this.localTemporario);

			if (logger.isDebugEnabled()) {
				logger.debug("Pastas criadas para salvar fotos.");
				logger.debug("Pasta default: " + this.local.toAbsolutePath());
				logger.debug("Pasta temporária: " + this.localTemporario.toAbsolutePath());
			}
		} catch (IOException e) {
			throw new RuntimeException("Erro criando pasta para salvar foto", e);
		}
	}

	private String renomearArquivo(String nomeOriginal) {
		String novoNome = UUID.randomUUID().toString() + "_" + nomeOriginal;

		if (logger.isDebugEnabled()) {
			logger.debug(String.format("Nome original: %s, novo nome: %s", nomeOriginal, novoNome));
		}

		return novoNome;

	}

}
package record;

import io.ArquivoCSV;

import java.util.ArrayList;
import java.util.List;

import persistence.LivroDao;
import entity.Livro;

public class ArquivoExcel {
	public static void main(String[] args) {
		
		try {
			ArquivoCSV arq = new ArquivoCSV();
			List<Livro> lista = new LivroDao().findAll();
			List<Livro> gravar  = new ArrayList<Livro>();
			for(Livro l : lista){
				Livro l1 = new Livro();
				l1.setIdLivro(l.getIdLivro());
				l1.setNomeLivro(l.getNomeLivro());
				l1.setNomeAutor(l.getNomeAutor());
				l1.setNomeEditora(l.getNomeEditora());
				l1.setDataPublicacao(l.getDataPublicacao());
				gravar.add(l1);
				arq.open(l1);
				arq.write(l1);
				arq.close();
				System.out.println("Dados Gravados");
			}
			
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
	}

}

package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Livro;

public class ExportaDadosCSV {
	
	FileReader fr;
	BufferedReader bf;
	
	public void open(Livro l) throws Exception{
		fr = new FileReader("c:/temp/" + l.getClass().getName() + ".csv");
		bf = new BufferedReader(fr);		
	}
	
	public List<Livro> readFile(Livro l) throws Exception{
		String linha = "";
		List<Livro> lista = new ArrayList<Livro>();
		while((linha = bf.readLine()) != null){
			String colunas[] = linha.split(";");
			Livro l1 = new Livro();
				l1.setIdLivro(new Integer(colunas[0]));
				l1.setNomeLivro(colunas[1]);
				l1.setNomeAutor(colunas[2]);
				l1.setNomeEditora(colunas[3]);
				l1.setDataPublicacao(new Date(colunas[4]));
				lista.add(l1);
		}
		return lista;
	}
	
	public void close() throws Exception{
		bf.close();
		fr.close();
	}

}

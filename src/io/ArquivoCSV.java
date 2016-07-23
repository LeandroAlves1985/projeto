package io;

import java.io.FileWriter;

import entity.Livro;

public class ArquivoCSV implements IArquivo<Livro>{
	
	FileWriter fw;

	@Override
	public void open(Livro l) throws Exception {
		fw = new FileWriter("c:/temp/" + l.getClass().getName() + ".csv", true);
		fw.flush();		
	}

	@Override
	public void write(Livro l) throws Exception {
		fw.write(l.toStringGravar() + "\n");
		fw.flush();		
	}

	@Override
	public void close() throws Exception {
		fw.close();		
	}
	
	

}

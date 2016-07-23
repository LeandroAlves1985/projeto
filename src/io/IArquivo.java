package io;

public interface IArquivo <Livro> {
	
	public void open(Livro l) throws Exception;
	public void write(Livro l) throws Exception;
	public void close() throws Exception;

}

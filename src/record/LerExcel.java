package record;

import io.ExportaDadosCSV;
import persistence.LivroDao;
import entity.Livro;

public class LerExcel {
	public static void main(String[] args) {
		try {
			Livro l = new Livro();	
			ExportaDadosCSV ed = new ExportaDadosCSV();
				ed.open(l);
				System.out.println(ed.readFile(l));
				ed.close();
				System.out.println("Leitura Realizada");
			
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
		
	}

}

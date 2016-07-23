package insert;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import persistence.LivroDao;
import entity.Livro;

public class MainCadastroLivro {
	public static void main(String[] args) {
				
		Livro l1 = new Livro(null, "Java para Iniciantes", new Date("05/08/2012") , "Schildt", "Bookman");
		Livro l2 = new Livro(null, "SQL Curso Pratico", new Date("12/06/2002") , "Celso Henrique Poderoso", "Novatec");
		Livro l3 = new Livro(null, "HTML5 e CSS3", new Date("22/07/2014") , "Murphy Clarck", "AltaBooks");
		Livro l4 = new Livro(null, "Programação em HTML 5", new Date("01/10/2014") , "Freeman Robson", "AltaBooks");
		Livro l5 = new Livro(null, "Programação", new Date("10/11/2010") , "Barry e Griffiths", "AltaBooks");
		Livro l6 = new Livro(null, "Redes de Computadores", new Date("05/03/2010") , "Anderson e Benedetti", "AltaBooks");
		Livro l7 = new Livro(null, "HardWare", new Date("12/08/2001") , "Carlos Morimoto", "Book Express");
		Livro l8 = new Livro(null, "Java", new Date("03/03/2007") , "Sierra e Bates", "AltaBooks");
		
		LivroDao ld = new LivroDao();
		
		try {
			
			ld.create(l1);
			ld.create(l2);
			//ld.create(l3);
			ld.create(l4);
			ld.create(l5);
			ld.create(l6);
			ld.create(l7);
			ld.create(l8);
			
			System.out.println("Dados Gravados");
			
		} catch (Exception e) {
			System.out.println("Erro " + e.getMessage());
		}
		
	}

}

package manager;

import org.jcommon.encryption.SimpleMD5;

import entity.Funcionario;

public class Criptografia {

	public static String criptografaSenha(Funcionario f) {
		SimpleMD5 md5 = new SimpleMD5(f.getSenha(), "");
		return md5.toHexString();
	}
}

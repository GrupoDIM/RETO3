package reto3.controlador;

import java.util.regex.Pattern;

public class Validar {
	public boolean isValidNumberPhone(String tele) {
		return Pattern.compile("^\\d\\d[-\\s]?\\d[\\s\\-]?\\d\\d[-\\s]?\\d[-\\s]?\\d[-\\s]?\\d\\d$").matcher(tele)
				.matches();

	}

	public boolean isValidDni(String dni) {
		return Pattern.compile("[0-9]{7,8}[TRWAGMYFPDXBNJZSQVHLCKE]").matcher(dni).matches();

	}

	public boolean isValidEmail(String mail) {
		return Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$").matcher(mail)
				.matches();
	}

	public boolean isValidPassword(String pass) {
		return Pattern.compile("^(?=.*[0-9])(?=.*[a-z-A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$").matcher(pass)
				.matches();
	}

	public String validarDni(String dni) {
		String ret = null;
		if (isValidDni(dni)) {
			ret = null;
		} else {
			ret = "DNI INVALIDO!!!";
		}
		return ret;
	}

	public String validarEmail(String mail) {
		String ret = null;
		if (isValidEmail(mail)) {
			ret = null;
		} else {
			ret = "EMAIL INVALIDO!!!";
		}
		return ret;
	}

	public String validarTelefono(String tele) {
		String ret = null;
		if (isValidNumberPhone(tele)) {
			ret = null;
		} else {
			ret = "TELEFONO INVALIDO!!!";
		}
		return ret;
	}

	public String validarPasswordCheck1(String pass) {
		String ret = null;
		if (isValidPassword(pass)) {
			ret = null;
		} else {
			ret = "La contraseña invalidada!!. (letras, números y al menos un caracter especial min 8 - max 20)";
		}
		return ret;
	}

	public String validarPasswordCheck2(String pass1, String pass2) {
		String ret = null;
		if (pass1.equals(pass2)) {
			ret = null;
		} else {
			ret = "Las Contraseñas no coinciden , Intetalo de Nueno !!!";
		}
		return ret;
	}

	public boolean validar(String dni, String tele, String email, String pass1, String pass2) {
		boolean ret = false;

		if (isValidDni(dni) && isValidNumberPhone(tele) && isValidEmail(email) && validarPasswordCheck1(pass1) == null
				&& validarPasswordCheck2(pass1, pass2) == null) {
			ret = true;
		}
		return ret;
	}
}

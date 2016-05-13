package mvc;

public class IMCModel {

	public static String calcula(double peso, String op, double altura) {
		double imc;
		String resultado;

		imc = peso/(altura*altura);	
		
		if (imc < 19.1) {
		    resultado = "Abaixo do peso";
		} else if (imc >= 19.1 && imc < 25.8) {
		    resultado = "Peso normal";
		} else if (imc >= 25.8 && imc < 27.3) {
		  resultado = "Marginalmente acima do peso";
		} else if (imc >= 27.3 && imc < 32.3 ) {
		  resultado = "Acima do peso ideal";
		} else {
		  resultado = "Obeso";
		}
		
		return resultado;
	}
}
	
	
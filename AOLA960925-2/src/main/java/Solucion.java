import java.io.*;

public class Solucion {

	/*
	 * Recibe una cade,a, la longitud de la misma y un array.
	 * Compara cada caracter de la cadena con el anterior y lo guarda en el array.
	 * Devuelve un array con los repetidos
	 */
	private static void buscador(String cad, int M, int arr[]) {   

		int len = 0; 
		int i;
		arr[0] = 0; // siempre el primer array es 0
		i = 1;
		
		while (i < M) { //Se recorre toda la cadena
			if (cad.charAt(i) == cad.charAt(len)) { //Se busca si el anterior es igual al actual
				len++;
				arr[i] = len; //Se guarda en el array la posición de los repetidos
				i++;
				}
			else { 
				if (len != 0) {
					len = arr[len-1]; //seste es un caso especial en caso de que exista "AAACAAA" y i=7
				}
				else {
					arr[i] = 0;
					i++;
				}
			}
		}
	}
	
	/*
	 * Recibe la cadena, busca la longitud de la cadena y crea un 
	 * array del tamaño de la cadena. Se van a guardar los caracteres de la
	 * cadena en dicho array
	 */
	public static boolean problema(String cad){
		int n = cad.length(); //Se encuentra la longitud
		int arr[] = new int[n];//Se crea el array
		
		buscador(cad, n, arr);
		
		int len = arr[n-1]; //Se busca la longitud del sufijo más largo (es también el prefijo de cad)
		
		// Si existe un sufijo que es también el prefijo 
		// y longitud del substring que queda divide la longitud total de la cadena,
		//	entonces, cad[0..n-len-1] es el substring que se repite (n/n-len) veces

		if(n>0 && n%(n-len)== 0)
			return true;
		else
			return false;
	}
	
	public static void main () {
		if(problema("AAACAAA"))
			System.out.print("true");
		else
			System.out.println("false");
	}
}

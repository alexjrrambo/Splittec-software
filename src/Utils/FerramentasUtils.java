package Utils;

import java.io.IOException;

public class FerramentasUtils { {

}

//abrir  calculadora
public static void openCalc(){
	exec("calc");

}

//abrir windows media player
public static void openWM(){
	exec("mplayerc");

}

//abrir bloco de notas
public static void openBN(){
	exec("notepad");

}
public static void exec(String exec){

	try {

		Runtime.getRuntime().exec(exec);  

	} catch (IOException ioe) {

		ioe.printStackTrace();

	}
}

}


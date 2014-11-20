import java.util.*;
public class Test {
  public static void main(String[] args) {
	  String separ = "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
	  System.out.println(separ + "Universidad Nacional Autónoma de México\nFacultad de Ingeniería\n\nBienvenido a la calculadora\n\nVersion 1.0\nEquipo: Jaime Zayas\n        Rodolfo Castillo\n"+separ);
	  int opc;
	  do{
		System.out.println("\n\n1)Operacion \n2)Salir \n\nTe recordamos que las operaciones básicas son +, -, *, /, ˆ\nEjemplo: 1+1*(2)\n");
		 opc = Teclado.entero("> ");
		if(opc==2){
			return;
		}else{
		
			//Entrada de datos
			String leer= Teclado.cadena("Operacion:\n > ");
		   

			//Depurar la expresion
			String expr = depurar(leer);
			String[] arrayInfix = expr.split(" ");

			//Declaración de las pilas
			StackString entrada = new StackString(100); //Pila entrada
			StackString temporal = new StackString(100); //Pila temporal para operadores
			StackString salida = new StackString(100); //Pila salida
			Eval f1=new Eval();
			//Añadir la array a la Pila de entrada (E)
			for (int i = arrayInfix.length - 1; i >= 0; i--) {
			  entrada.push(arrayInfix[i]);
			}

			try {
			  //Algoritmo Infijo a Postfijo
			  while (!entrada.emptyStack()) {
				//-------------------------------------------
				//--------------------------------------------
				switch (pref(entrada.dataOnTop())){
				  case 1:
					temporal.push(entrada.pop());
					break;
				  case 2:
					while(!temporal.dataOnTop().equals("(")) {
					  salida.push(temporal.pop());
					}
					temporal.pop();
					entrada.pop();
					break; 
				  case 3:
				  case 4:
					while(pref(temporal.dataOnTop()) >= pref(entrada.dataOnTop())) {
					  salida.push(temporal.pop());
					}
					temporal.push(entrada.pop());
					break; 
				  case 5:
					while(pref(temporal.dataOnTop()) >= pref(entrada.dataOnTop())) {
					  salida.push(temporal.pop());
					}
					temporal.push(entrada.pop());
					break;
				  default:
					salida.push(entrada.pop()); 
				} 
			  } 
			  //Eliminacion de `impurezas´ en la expresion
			  String infix = expr.replace(" ", "");
			  //Mostrar resultados:
			  System.out.println("Expresion Infija: " + infix);
			  System.out.print("Expresion Postfija: ");
			  salida.lstStack();
			  f1.value(salida.getStack());
			  System.out.print("\n");
			}catch(Exception ex){ 
			  System.out.println("Error en la expresión ");
			  System.err.println(ex);
			  System.out.print("\n");
			}
		  }
		}while(opc!=2);
	} 
  //Depurar expresión
  private static String depurar(String s) {
    s = s.replaceAll("\\s+", ""); //Elimina espacios en blanco
    s = "(" + s + ")";
    String simbols = "+-*/()^";
    String str = "";
  
    //Deja espacios entre operadores
    for (int i = 0; i < s.length(); i++) {
      if (simbols.contains("" + s.charAt(i))) {
        str += " " + s.charAt(i) + " ";
      }else str += s.charAt(i);
    }
    return str.replaceAll("\\s+", " ").trim();
  } 

  //Jerarquia de los operadores
  private static int pref(String op) {
    int prf = 0;
    if (op.equals("^")) prf = 5;
    if (op.equals("*") || op.equals("/")) prf = 4;
    if (op.equals("+") || op.equals("-")) prf = 3;
    if (op.equals(")")) prf = 2;
    if (op.equals("(")) prf = 1;
    return prf;
  }
  
}

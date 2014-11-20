import java.math.*;

public class Eval {
  public void value(String str) {   
    
    //Entrada (Expresión en Postfija)
    String expr = str; // 
    String[] post = expr.split(" ");    
    
    //Declaración de las pilas
    StackString entrada = new StackString(100); //Pila entrada
    StackString temporal = new StackString(100);//Pila de operandos

    //Añadir post (array) a la Pila de entrada (E)
    for (int i = post.length - 1; i >= 0; i--) {
      entrada.push(post[i]);
    }

    //Algoritmo de Evaluación Postfija
    String operadores = "+-*/^"; 
    while (!entrada.emptyStack()) {
      if (operadores.contains("" + entrada.dataOnTop())) {
        temporal.push(evaluar(entrada.pop(), temporal.pop(), temporal.pop()) + "");
      }else {
        temporal.push(entrada.pop());
      } 
    }

    //Mostrar resultados:
    System.out.println("\nResultado: " + temporal.dataOnTop());

  }

  private static Double evaluar(String op, String n2, String n1) {
    Double num1 = Double.parseDouble(n1);
    Double num2 = Double.parseDouble(n2);
    if (op.equals("+")) return (num1 + num2);
    if (op.equals("-")) return (num1 - num2);
    if (op.equals("*")) return (num1 * num2);
    if (op.equals("/")) return (num1 / num2);
    if (op.equals("^")) return (Math.pow(num1,num2));
    return 0.0;
  }

}
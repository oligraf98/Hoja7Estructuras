import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Boolean on = true;
        String oracion = "";
        BinaryTree bt  = new BinaryTree<>();
        String opcion;
        HashMap<String, String> d = new HashMap<>();
        System.out.println("Bienvenido al programa");
        System.out.println("Ingrese el numero de la opcion que desea elegir: ");
        do {
            System.out.println(menu());
            opcion = input.nextLine();

            switch (opcion){
                case "1":
                    Boolean run = false;
                    do {
                        System.out.println("Ingrese la direccion del archivo como se muestra en el ejemplo: C:\\\\Users\\\\ejemplo\\\\Desktop\\\\test.txt");
                        System.out.println("Si desea regresar al menu principal escriba el numero '0'");
                        String direccion = input.nextLine();
                        if(direccion.equals("0")){ break; }

                        try {
                            File f = new File(direccion);
                            BufferedReader b = new BufferedReader(new FileReader(f));
                            String readLine;

                            while ((readLine = b.readLine()) != null) {
                                String tupla = readLine.substring(1, readLine.length()-1);
                                String ingles = "";
                                String espanol = "";
                                int cambio = 0;
                                for(int i = 0; i < tupla.length(); i++){
                                    char c = tupla.charAt(i);
                                    if(c == ','){
                                        cambio++;
                                    } else if(cambio == 0){
                                        ingles = ingles + c ;
                                    }else{
                                        espanol = espanol + c;
                                    }

                                }

                                Association<String, String> a = new Association<>(ingles,espanol);
                                bt.insert(a);
                                d.put(ingles, espanol);
                            }
                            System.out.println("La lectura del archivo fue exitosa");
                            System.out.println("A continuacion se despliegara el arbol binario in-order: ");
                            bt.inorder();
                            run = true;
                        } catch (Exception e) {
                            System.out.println("No fue posible la lectura del archivo con la direccion que especifico...\nIntentelo de nuevo!");
                        }
                    } while (!run);


                    break;

                case "2":
                    Boolean go = false;
                    do {
                        System.out.println("Ingrese la direccion del archivo como se muestra en el ejemplo: C:\\\\Users\\\\ejemplo\\\\Desktop\\\\test.txt");
                        System.out.println("Si desea regresar al menu principal escriba el numero '0'");
                        String direccion = input.nextLine();
                        if(direccion.equals("0")){ break; }

                        try {
                            File f = new File(direccion);
                            BufferedReader b = new BufferedReader(new FileReader(f));
                            String readLine;

                            while ((readLine = b.readLine()) != null) {
                                oracion += readLine;
                            }
                            System.out.println("La lectura del archivo fue exitosa");
                            System.out.println("Se encontro el siguiente texto: \n");
                            System.out.println(oracion);
                            oracion = oracion.substring(0, oracion.length()-1);
                            go = true;
                        } catch (Exception e) {
                            System.out.println("No fue posible la lectura del archivo con la direccion que especifico...\nIntentelo de nuevo!");
                        }
                    } while (!go);
                    ArrayList<String> wrds = new ArrayList<>(Arrays.asList(oracion.split(" ")));
                    ArrayList<String> traduc = new ArrayList<>();
                    for (String palabra : wrds){
                        if(d.containsKey(palabra)){
                            traduc.add("*"+d.get(palabra)+"*");
                        }else{
                            traduc.add(palabra);
                        }
                    }
                    String respuesta = "";
                    for(String palabra: traduc){
                        respuesta += " " + palabra;
                    }
                    respuesta += ".";
                    System.out.println("La traduccion de la oracion encontrada es: \n");
                    System.out.println(respuesta);


                    break;
                case "3":
                    System.out.println("Bye.");
                    on = false;
                    break;
                default:
                    System.out.println("La opcion que ingreso no es valida. Intentelo de nuevo!");
                    break;
            }
        }while(on);
    }






    public static String menu(){
        return "\t1. Cargar diccionario\n\t2. Cargar archivo para traducir\n\t3. Salir del programa";
    }
}

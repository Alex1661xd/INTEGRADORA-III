package ui;
import java.util.Scanner;
import model.Controller;

public class Executable {
    private Scanner reader;
    private Controller controller;
    
    public Executable(){
        reader=new Scanner(System.in);
        controller= new Controller();
    }
    public static void main(String[] args) {
        Executable ejecutable= new Executable();
        ejecutable.menu();
    }

    private void menu(){

        System.out.println("Bienvenido a READ-X");

        boolean flagMenu=false;

        while(flagMenu==false){
           
            System.out.println("\n-Ingrese un numero-");
            System.out.println("\n1. Registrar Usuarios");
            System.out.println("2. Gestionar productos");
            System.out.println("3. Comprar producto");
            System.out.println("4. Simulacion de Lectura");
            System.out.println("5. Mi biblioteca de Libros ");
            System.out.println("6. Informes generales");
            System.out.println("7. Salir");

            int optionMenu=reader.nextInt();

            switch(optionMenu){
                case 1:
                    RegistrarUsuarios();
                    break;
                case 2:
                    System.out.println("\n-Ingrese un numero-"); 
                    System.out.println("\n1. Crear un producto bibliografico");
                    System.out.println("2. Modificar producto bibliogtrafico");
                    System.out.println("3. Borrar producto bibliografico");
                    int optionProduct=reader.nextInt();
                    switch(optionProduct){
                        case 1:
                            CreateBibliographic();
                            break;
                        case 2:
                            modificarProducto();
                            break;
                        case 3:
                            borrarProducto();
                            break;
                    }
                    break;

                case 3:
                    ComprarLibro();
                break;
                case 4:
                    simulacionLectura();;
                    break;
                case 8:
                    System.out.println("Hasta luego :)");
                    flagMenu=true;
                    break;
            }
        }


    }

    private void RegistrarUsuarios(){
        System.out.println("\n¿Que tipo de usuario desea registrar?");
        System.out.println("       -Ingrese un numero-");
        System.out.println("\n1.Regular\n2.Premium");
        int optionUser=reader.nextInt();
        System.out.println("-Ingrese su nombre");
        reader.nextLine();
        String nameUser=reader.nextLine();
        System.out.println("-Ingrese su cedula");
        String cedulaUser=reader.nextLine();
        
        if(controller.registrarUsuarios(optionUser, nameUser, cedulaUser)){
            if(optionUser==1){
                System.out.println("         -Usuario registrado con exito-");
                System.out.println("Puedes comprar 5 libros y suscribirte a 2 revistas");
            }else if(optionUser==2){
                System.out.println("\n     -Usuario registrado con exito-");
                System.out.println("Tienes acceso ilimitado a libros y revistas");
            }
        }else{
            System.out.println("Ocurrio un error inesperado");
        }
    }

    private void CreateBibliographic(){
        System.out.println("\n¿Que producto bibliografico desea registrar?");
        System.out.println("1.Libro\n2.Revista");
        int typeBibliographich=reader.nextInt();
        
        if(typeBibliographich==1){
            System.out.println("Ingrese el identificador");
            reader.nextLine();
            String identifier=reader.nextLine();
            System.out.println("Ingrese el nombre del Libro");
            String name=reader.nextLine();
            System.out.println("Ingrese la cantidad de paginas del Libro "+name);
            int cantidadPaginas=reader.nextInt();
            reader.nextLine();
            System.out.println("Ingrese una reseña corta");
            String reseña=reader.nextLine();
            System.out.println("Ingrese la fecha de publicacion");
            System.out.println("Ingrese el dia (En numeros)");
            int diaP=reader.nextInt();
            System.out.println("Ingrese el mes (En numeros)");
            int mesP=reader.nextInt();
            System.out.println("Ingrese el año (En numeros)");
            int añoP=reader.nextInt();
            System.out.println("Ingrese el genero (Con un numero)");
            System.out.println("1.Ciencia Ficcion\n2.Fantasia\n3.Novela Historica");
            int typeGenre=reader.nextInt();
            System.out.println("Ingrese la URL");
            reader.nextLine();
            String URL=reader.nextLine();
            System.out.println("Ingrese el precio de venta");
            double precioVenta=reader.nextDouble();
            System.out.println("Cantidad de ejemplares vendidos");
            int ejemplaresVendidos=reader.nextInt();
            if(controller.registarProductoBiblio(typeBibliographich, identifier, name, cantidadPaginas, reseña, diaP, mesP, añoP, typeGenre, añoP, typeGenre, URL, precioVenta, ejemplaresVendidos, ejemplaresVendidos)){
                System.out.println("\nLibro creado correctamente");
                System.out.println("   -Asi quedo su libro-");
                System.out.println("\n"+controller.mostrarProductobiblio(true,-1));
            }else{
                System.out.println("Ocurrio un problema");
            }
        }else if(typeBibliographich==2){
            System.out.println("Ingrese el identificador");
            reader.nextLine();
            String identifier=reader.nextLine();
            System.out.println("Ingrese el nombre de la revista");
            String name=reader.nextLine();
            System.out.println("Ingrese la cantidad de paginas de la revista "+name);
            int cantidadPaginas=reader.nextInt();
            System.out.println("Ingrese la fecha de publicacion");
            System.out.println("Ingrese el dia (En numeros)");
            int diaP=reader.nextInt();
            System.out.println("Ingrese el mes (En numeros)");
            int mesP=reader.nextInt();
            System.out.println("Ingrese el año (En numeros)");
            int añoP=reader.nextInt();
            System.out.println("Ingrese la URL");
            reader.nextLine();
            String URL=reader.nextLine();
            System.out.println("Ingrese el valor de suscripcion");
            double valorSuscripcion=reader.nextDouble();
            System.out.println("Ingrese con un numero la periocidad de la emision");
            int periocidad=reader.nextInt();
            System.out.println("Ingrese con un numero la Categoria");
            System.out.println("1.Variedades\n2.Diseño\n3.Cientifica");
            int categoria=reader.nextInt();
            if(controller.registarProductoBiblio(typeBibliographich, identifier, name, cantidadPaginas, name, diaP, mesP, añoP, mesP, valorSuscripcion, periocidad, URL, valorSuscripcion, añoP, categoria)){
                System.out.println("Revista creada correctamente");
                System.out.println("Asi quedo su revista");
                System.out.println(controller.mostrarProductobiblio(true,-1));
            }else{
                System.out.println("Ocurrio un error");
            }
        }
    }

    private void modificarProducto(){
        if(controller.mostrarProductobiblio(false,-1).equals("")){
            System.out.println("No hay productos bibliograficos creados");
        }else{
            System.out.println(controller.mostrarProductobiblio(false,-1));    
            System.out.println("¿Que producto desea modificar?-Ingrese un numero");
            int typeProduct=reader.nextInt();
            int nuevoValor=-1;
            double nuevoValor1=-1;
            String nuevoValor2=null;
            if(controller.CalculateType(typeProduct-1)==1){
                System.out.println("\n-Este producto bibliografico es un Libro-");
                System.out.println("\n¿Desea mirar sus caracteristicas? \n1.SI\n2.NO");
                int decisionMostrar=reader.nextInt();
                if(decisionMostrar==1){
                    System.out.println(controller.mostrarProductobiblio(false,typeProduct-1));
                }
                System.out.println("\n¿Que desea modificar?-Marque un numero");
                System.out.println("\n1.Identificador\n2.Nombre\n3.Cantidad de paginas(Numero)\n4.Reseña\n5.Genero\n6.URL");
                System.out.println("7.Precio de venta(Numero)\n8.Ejemplares vendidos(Numero)");
                int opcionNuevoM=reader.nextInt();
                if(opcionNuevoM==1||opcionNuevoM==2||opcionNuevoM==4||opcionNuevoM==6){
                    System.out.println("Ingrese el nuevo valor");
                    reader.nextLine();
                    nuevoValor2=reader.nextLine();
                }else if(opcionNuevoM==3||opcionNuevoM==8){
                    System.out.println("Ingrese el nuevo valor");
                    nuevoValor=reader.nextInt();
                }else if(opcionNuevoM==5){
                    System.out.println("Ingrese con un numero el nuevo genero");
                    System.out.println("1.Ciencia Ficcion\n2.Fantasia\n3.Novela Historica");
                    nuevoValor=reader.nextInt();
                }else{
                    System.out.println("Ingrese el nuevo valor");
                    nuevoValor1=reader.nextDouble();
                }
            
                if(controller.modificarProducto(typeProduct-1, opcionNuevoM, nuevoValor, nuevoValor2, nuevoValor1)){
                    System.out.println("\nSe modifico correctamente");
                    System.out.println("Asi quedo el Libro");
                    System.out.println("\n"+controller.mostrarProductobiblio(false, typeProduct-1));
                }else{
                    System.out.println("Ocurrio un error inesperado :(");
                }
            }else if(controller.CalculateType(typeProduct-1)==2){
                System.out.println("\n-Este producto bibliografico es una Revista-");
                System.out.println("\n¿Desea mirar sus caracteristicas? \n1.SI\n2.NO");
                int decisionMostrar=reader.nextInt();
                if(decisionMostrar==1){
                    System.out.println(controller.mostrarProductobiblio(false,typeProduct-1));
                }
                System.out.println("\n¿Que desea modificar?-Marque un numero");
                System.out.println("\n1.Identificador\n2.Nombre\n3.Cantidad de paginas(Numero)\n4.URL\n5.Valor suscripcion\n6.Periocidad");
                System.out.println("7.Categoria");
                int opcionNuevoM=reader.nextInt();
                System.out.println("Ingrese el nuevo valor");
                if(opcionNuevoM==1||opcionNuevoM==2||opcionNuevoM==4){
                    reader.nextLine();
                    nuevoValor2=reader.nextLine(); 
                }else if(opcionNuevoM==3||opcionNuevoM==6){
                    nuevoValor=reader.nextInt();
                }else if(opcionNuevoM==5){
                    nuevoValor1=reader.nextDouble();
                }else{
                    System.out.println("Ingrese con un numero la nueva categoria");
                    System.out.println("\n1.Variedades\n2.Diseño\n3.Cientifica");
                    nuevoValor=reader.nextInt();
                }
                if(controller.modificarProducto(typeProduct-1, opcionNuevoM, nuevoValor, nuevoValor2, nuevoValor1)){
                    System.out.println("Libro modificado correctamente");
                    System.out.println("    -Asi quedo su libro-");
                    System.out.println(controller.mostrarProductobiblio(false, typeProduct-1));
                }
            }

        }
    }

    private void borrarProducto(){
        int optionBorrar=-1;
        if(controller.mostrarProductobiblio(false, -1).equals("")){
            System.out.println("No hay productos creados");
        }else{
            boolean flag=false;
            while(flag==false){
                System.out.println(controller.mostrarProductobiblio(false, -1));
                System.out.println("¿Que producto desea borrar?");
                optionBorrar=reader.nextInt();
                System.out.println("\nSe va a borrar el siguiente producto");
                System.out.println("\n"+controller.mostrarProductobiblio(true, optionBorrar-1));
                System.out.println("\n¿Confirmar?\n1.SI\n2.NO");
                int confirmar=reader.nextInt();
                if(confirmar==1){
                    flag=true;
                }
            }
            if(flag==true){
                if(controller.borrarProducto(optionBorrar-1)){
                    System.out.println("\nEl producto se borro correctamente");
                }else{
                    System.out.println("Ocurrio un error inesperado :(");
                }
            }
           
            
        }
    }

    private void ComprarLibro(){
        if(controller.mostrarUsuarios(false, -1).equals("")){
            System.out.println("No hay usuarios creados");
        }else{
            System.out.println(controller.mostrarUsuarios(false, -1));
            System.out.println("¿Que usuario desea comprar un Producto?");
            int optionUser=reader.nextInt();
            if(controller.mostrarProductobiblio(false, -1).equals("")){
                System.out.println("No hay productos bibliograficos");
            }else{
                System.out.println(controller.mostrarProductobiblio(false, -1));
                System.out.println("¿Que producto desea comprar o suscribir?");
                int optionProduc=reader.nextInt();
                int decisionConfirm=-1;
                if(controller.CalculateType(optionProduc-1)==1){
                    System.out.println("Vas a comprar un Libro");
                    System.out.println("-¿Confirmar?\n1.SI\n2.NO");
                    decisionConfirm=reader.nextInt();
                }else if(controller.CalculateType(optionProduc-1)==2){
                    System.out.println("Te vas a suscribir a una Revista");
                    System.out.println("-¿Confirmar?\n1.SI\n2.NO");
                    decisionConfirm=reader.nextInt();
                }
                if(decisionConfirm==1){
                String query=controller.comprarProducto(optionUser-1, optionProduc-1);
               if(query.equals("")){
                    System.out.println("Ocurrio un error");
               }else{
                        System.out.println(query);
                        if(controller.generarFactura(optionUser-1, optionProduc-1)){
                            System.out.println("\nAsi quedo su factura");
                            System.out.println(controller.ultimaFacturaCliente(optionUser-1));
                        }
                        
                    }
                }
            }
            }
        }

        private void simulacionLectura(){
            if(controller.mostrarUsuarios(false, -1).equals("")){
                System.out.println("No hay usuarios registrados");
                
            }else{
                System.out.println(controller.mostrarUsuarios(false, -1));
                System.out.println("¿Que usuario desea leer?");
                int optionUser=reader.nextInt();
                System.out.println("¿Desea leer un libro o una revista?");
                System.out.println("1.Libro\n2.Revista");
                int decisionProducto=reader.nextInt();
                int productoLeer=-1;
                String nombreProducto=null;
                int cantidadPaginas=-1;

                if(decisionProducto==1){
                    if(controller.mostrarLibroUsuario(optionUser-1).equals("")){
                        System.out.println("\n-Este usuario no tiene Libros adquiridos-");
                    }else{
                        System.out.println("\nEsta es su biblioteca de Libros: ");
                        System.out.println(controller.mostrarLibroUsuario(optionUser-1));
                        System.out.println("¿Que libro desea leer? (Ingrese un numero)");
                        productoLeer=reader.nextInt();
                        nombreProducto=controller.extraerNombreProductoUsuario(optionUser-1, productoLeer-1, 1);
                        cantidadPaginas=controller.extraerCantidadPaginasProductoUsuario(optionUser-1, productoLeer-1, 1);
                    }
                }else if(decisionProducto==2){
                    if(controller.mostrarRevistaUsuario(optionUser-1).equals("")){
                        System.out.println("\n-Este usuario no tiene Revistas adquiridas-");
                    }else{
                        System.out.println("\nEsta es su biblioteca de Revistas: ");
                        System.out.println(controller.mostrarRevistaUsuario(optionUser-1));
                        System.out.println("¿Que revista desea leer? (Ingrese un numero)");
                        productoLeer=reader.nextInt();
                        nombreProducto=controller.extraerNombreProductoUsuario(optionUser-1, productoLeer-1, 2);
                        cantidadPaginas=controller.extraerCantidadPaginasProductoUsuario(optionUser-1, productoLeer-1, 2);
                    }
                }

                int contadorPaginasRegular=0;
                int paginaActual=1;
                String omitir=null;
                while(paginaActual<cantidadPaginas){
                     if(controller.CalculateTypeUsers(optionUser-1)==1){
                        if(decisionProducto==1){
                           if(contadorPaginasRegular==0||contadorPaginasRegular==20){
                              System.out.println("-ANUNCIO-");
                               System.out.println("Adquiere Disney+ por solo 9.99");
                                System.out.println("Ingrese cualquier tecla para omitir anuncio");
                                if(contadorPaginasRegular==0){
                                    reader.nextLine();
                                }
                                omitir=reader.nextLine();
                            }
                        
                    
                        }else if(decisionProducto==2){
                            if(contadorPaginasRegular==0||contadorPaginasRegular==5){
                                System.out.println("\n        -ANUNCIO-");
                                System.out.println("Adquiere Disney+ por solo 9.99");
                                System.out.println("\nIngrese cualquier tecla para omitir anuncio");
                                if(contadorPaginasRegular==0){
                                    reader.nextLine();
                                }
                                omitir=reader.nextLine();
                            }
                        }
                    }
                    
                    
                    System.out.println("\n\n-Simulacion de Lectura en Curso-");

                    System.out.println("\n\n\n\nLeyendo: "+nombreProducto);
                    System.out.println("Pagina "+paginaActual+" de "+ cantidadPaginas);
                    System.out.println("\n\nIngrese (A) para avanzar");
                    if(paginaActual>1){
                        System.out.println("Ingrese (B) para retroceder");
                    }
                    System.out.println("Ingrese (C) para salir");
                    if(paginaActual==1&&controller.CalculateTypeUsers(optionUser-1)==2){
                        reader.nextLine();
                    }
                    String cambioPagina=reader.nextLine();

                    if(cambioPagina.equals("A")){
                        paginaActual++;
                        contadorPaginasRegular++;
                    }else if(cambioPagina.equals("B")){
                        paginaActual--;
                        contadorPaginasRegular++;
                    }else if(cambioPagina.equals("C")){
                        return;
                    }
                        
                    
                }

                
                
            }
        }
    }




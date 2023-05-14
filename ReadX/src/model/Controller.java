package model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Controller {
    private ArrayList<User> users;
    private ArrayList<BibliographicP>productosBiblio;
    private ArrayList<Factura>facturas;

    public Controller(){
        this.users=new ArrayList<User>();
        this.productosBiblio=new ArrayList<BibliographicP>();
        productosBiblio.add(new Magazine("10920120", "Spider-Man", 100, Calendar.getInstance(), "JHCDUUHUC", CategoryMagazine.CIENTIFICA, 20, 10));
        productosBiblio.add(new Book("12030202", "Caperucita", 100,Calendar.getInstance(), "htpp:/jcjcdnjd", GenreBook.CIENCIA_FICCION, 280.5, 20, "Lindo"));
        users.add(new RegularUser("Luis", "89489380", Calendar.getInstance()));
        users.add(new PremiumUser("Carlos", "00905904", Calendar.getInstance()));
        this.facturas=new ArrayList<Factura>();
    }

    public boolean registrarUsuarios(int optionUser, String nameUser, String idUser ){
        boolean indicador=false;
        Calendar fechaVinculacion=Calendar.getInstance();
        if(indicador==false){
                 
            if(optionUser==1){
                users.add(new RegularUser(nameUser, idUser, fechaVinculacion)); 
                indicador=true;
                return indicador;
                
            }else if(optionUser==2){
                users.add(new PremiumUser(nameUser, idUser, fechaVinculacion));
                indicador=true;
                return indicador;
                    }
                    
                }
            return indicador;
        }
        
        
    

    public boolean registarProductoBiblio(int TypeBiblio,String identifier,String name,int cantidadPaginas,String reseña,int diaP,int mesP,int añoP,int typeGenre, double valorsuscripcion,int periocidad, String URL, double precioventa, int ejemplaresVendidos, int categoria){
        boolean indicador=false;
        Calendar fechaPublicacion=new GregorianCalendar(diaP, mesP-1, añoP);
        GenreBook genero=null;
        CategoryMagazine category=null;
        if(indicador==false){
            if(TypeBiblio==1){
                if(typeGenre==1){
                    genero=GenreBook.CIENCIA_FICCION;
                }else if(typeGenre==2){
                    genero=GenreBook.FANTASIA;
                }else if(typeGenre==3){
                    genero=GenreBook.NOVELA_HISTORICA;
                }
                productosBiblio.add(new Book(identifier, name, cantidadPaginas, fechaPublicacion, URL, genero, precioventa, ejemplaresVendidos, reseña));
                indicador=true;
                    
            }else if(TypeBiblio==2){
                if(categoria==1){
                        category=CategoryMagazine.VARIEDADES;
                    }else if(categoria==2){
                        category=CategoryMagazine.DISEÑO;
                    }else if(categoria==3){
                        category=CategoryMagazine.CIENTIFICA;
                    }
                    productosBiblio.add(new Magazine(identifier, name, cantidadPaginas, fechaPublicacion, URL, category, valorsuscripcion, periocidad));
                    indicador=true;
                    }
                }
                return indicador;
            }
        
        
        
    

    public String mostrarProductobiblio(boolean indicador, int numero){
        String msg="";
            //*Ultimo producto bibliografico creado */
        if(indicador==true&&numero==-1){
                    if(productosBiblio.get(productosBiblio.size()-1) instanceof Book){
                        msg+=((Book)productosBiblio.get(productosBiblio.size()-1)).toString();
                        return msg;
                    }else if(productosBiblio.get(productosBiblio.size()-1) instanceof Magazine){
                        msg+=((Magazine)productosBiblio.get(productosBiblio.size()-1)).toString();
                        return msg;
                    }
                }
            
            //*Todos los productos bibliograficos */
        else if(indicador==false&&numero==-1){
            for(int i=0;i<productosBiblio.size();i++){
                    if(productosBiblio.get(i) instanceof Book){
                        msg+="\n"+(i+1)+". "+((Book)productosBiblio.get(i)).toStringMin();
                    }else if(productosBiblio.get(i) instanceof Magazine){
                        msg+="\n"+(i+1)+". "+((Magazine)productosBiblio.get(i)).toStringMin();
                    }
                }
            }
        
            //*Producto en posicion exacta */
        if(numero!=-1){
                if(productosBiblio.get(numero) instanceof Book){
                    msg=((Book)productosBiblio.get(numero)).toString();
                }else if(productosBiblio.get(numero) instanceof Magazine){
                    msg=((Magazine)productosBiblio.get(numero)).toString();
                }
            }
            return msg;
        }
        
        
    

    public boolean modificarProducto(int posicionProducto,int opcionNuevoM,int nuevoValor,String nuevoValor1,double nuevoValor2){
        boolean indicador=false;
        GenreBook nuevoGenero=null;
        if(indicador==false){
        if(productosBiblio.get(posicionProducto) instanceof Book){
            if(opcionNuevoM==1){
                ((Book)productosBiblio.get(posicionProducto)).setIdentifier(nuevoValor1);
                indicador=true;
            }else if(opcionNuevoM==2){
                ((Book)productosBiblio.get(posicionProducto)).setName(nuevoValor1);
                indicador=true;
            }else if(opcionNuevoM==4){
                ((Book)productosBiblio.get(posicionProducto)).setReview(nuevoValor1);
                indicador=true;
            }else if(opcionNuevoM==6){
                ((Book)productosBiblio.get(posicionProducto)).setURL(nuevoValor1);
                indicador=true;
            }else if(opcionNuevoM==3){
                ((Book)productosBiblio.get(posicionProducto)).setNumberPages(nuevoValor);
                indicador=true;
            }else if(opcionNuevoM==5){
                if(nuevoValor==1){
                    nuevoGenero=GenreBook.CIENCIA_FICCION;
                }else if(nuevoValor==2){
                    nuevoGenero=GenreBook.FANTASIA;
                }else{
                    nuevoGenero=GenreBook.NOVELA_HISTORICA;
                }
                ((Book)productosBiblio.get(posicionProducto)).setGenre(nuevoGenero);
                indicador=true;
            }else if(opcionNuevoM==7){
                ((Book)productosBiblio.get(posicionProducto)).setPrice(nuevoValor2);
                indicador=true;
            }else if(opcionNuevoM==8){
                ((Book)productosBiblio.get(posicionProducto)).setSoldCopies(nuevoValor);
                indicador=true;
            }
            indicador=true;
        }else if(productosBiblio.get(posicionProducto) instanceof Magazine){
            if(opcionNuevoM==1){
                ((Magazine)productosBiblio.get(posicionProducto)).setIdentifier(nuevoValor1);
                indicador=true;
            }else if(opcionNuevoM==2){
                ((Magazine)productosBiblio.get(posicionProducto)).setName(nuevoValor1);
                indicador=true;
            }else if(opcionNuevoM==3){
                ((Magazine)productosBiblio.get(posicionProducto)).setNumberPages(nuevoValor);
                indicador=true;
            }else if(opcionNuevoM==4){
                ((Magazine)productosBiblio.get(posicionProducto)).setURL(nuevoValor1);
                indicador=true;
            }else if(opcionNuevoM==5){
                ((Magazine)productosBiblio.get(posicionProducto)).setSubscriptionValue(nuevoValor2);
                indicador=true;
            }else if(opcionNuevoM==6){
                ((Magazine)productosBiblio.get(posicionProducto)).setPeriocity(nuevoValor2);
                indicador=true;
            }else if(opcionNuevoM==7){
                CategoryMagazine categoria=null;
                if(nuevoValor==1){
                    categoria=CategoryMagazine.VARIEDADES;
                }else if(nuevoValor==2){
                    categoria=CategoryMagazine.DISEÑO;
                }else if(nuevoValor==3){
                    categoria=CategoryMagazine.CIENTIFICA;
                }
                ((Magazine)productosBiblio.get(posicionProducto)).setCategory(categoria);
                indicador=true;
            }
        }
    }
        return indicador;
    }

    public boolean borrarProducto(int posicionProducto){
        boolean indicador=false;
        if(indicador==false){
            productosBiblio.remove(posicionProducto);
            indicador=true;
        }

        return indicador;
    }

    public int CalculateType(int posicionProducto){
        
        if(productosBiblio.get(posicionProducto) instanceof Book){
            return 1;
        }else if(productosBiblio.get(posicionProducto)instanceof Magazine){
            return 2;
        }

        return -1;
    }

    public int CalculateTypeUsers(int posicionUsuario){
        
        if(users.get(posicionUsuario) instanceof RegularUser){
            return 1;
        }else if(users.get(posicionUsuario)instanceof PremiumUser){
            return 2;
        }

        return -1;
    }

    public String mostrarUsuarios(boolean indicador, int numero){
        String msg="";
            //*Ultimo usuario creado */
        if(indicador==true&&numero==-1){
                    if(users.get(users.size()-1) instanceof RegularUser){
                        msg+=((RegularUser)users.get(users.size()-1)).toString();
                        return msg;
                    }else if(users.get(users.size()-1) instanceof PremiumUser){
                        msg+=((PremiumUser)users.get(users.size()-1)).toString();
                        return msg;
                    }
                }
            
            //*Todos los usuarios creados */
        else if(indicador==false&&numero==-1){
            for(int i=0;i<users.size();i++){
                    if(users.get(i) instanceof RegularUser){
                        msg+="\n"+(i+1)+". "+((RegularUser)users.get(i)).toStringMin();
                    }else if(users.get(i) instanceof PremiumUser){
                        msg+="\n"+(i+1)+". "+((PremiumUser)users.get(i)).toStringMin();
                    }
                }
            }
        
            //*Usuario en posicion exacta */
        if(numero!=-1){
                if(users.get(numero) instanceof RegularUser){
                    msg=((RegularUser)users.get(numero)).toString();
                }else if(users.get(numero) instanceof PremiumUser){
                    msg=((PremiumUser)users.get(numero)).toString();
                }
            }
            return msg;
    }

    public String comprarProducto(int optionUser, int optionLibro){
       
        String msg="";
        if(users.get(optionUser) instanceof RegularUser){
            if(productosBiblio.get(optionLibro)instanceof Book){
                        Book libroComprado=((Book)productosBiblio.get(optionLibro));
                        int ejemplaresVendidos= ((Book)productosBiblio.get(optionLibro)).getSoldCopies();
                        for(int i=0;i<((RegularUser)(users.get(optionUser))).getBooks().length;i++){
                            if(((RegularUser)users.get(optionUser)).getBooks()[i]==null){
                                ((RegularUser)users.get(optionUser)).getBooks()[i]=libroComprado;    
                                ((Book)productosBiblio.get(optionLibro)).setSoldCopies(ejemplaresVendidos+1);
                                msg="\n-Libro comprado exitosamente-";
                                return msg;
                            }

                        }
            }else if(productosBiblio.get(optionLibro)instanceof Magazine){
                            Magazine revistaComprada=((Magazine)productosBiblio.get(optionLibro));
                            for(int i=0;i<((RegularUser)(users.get(optionUser))).getMagazines().length;i++){
                                if(((RegularUser)users.get(optionUser)).getMagazines()[i]==null){
                                    ((RegularUser)users.get(optionUser)).getMagazines()[i]=revistaComprada;    
                                    int cantidadActivas=((Magazine)productosBiblio.get(optionLibro)).getNumberActives();
                                    ((Magazine)productosBiblio.get(optionLibro)).setNumberActives(cantidadActivas+1);
                                    msg="\nRevista suscrita correctamente";
                                    return msg;
                                }else{
                                    return msg; 
                                }
                                
                            }
            }

            return "Alcanzaste el limite de compras o suscrpciones";
            
        }else if(users.get(optionUser) instanceof PremiumUser){
            if(productosBiblio.get(optionLibro)instanceof Book){
                Book libroComprado=((Book)productosBiblio.get(optionLibro));
                ((PremiumUser)users.get(optionUser)).getBooks().add(libroComprado);
                int ejemplaresVendidos= ((Book)productosBiblio.get(optionLibro)).getSoldCopies();
                ((Book)productosBiblio.get(optionLibro)).setSoldCopies(ejemplaresVendidos+1);
                msg="\n-Libro comprado exitosamente-";
                return msg;
                    
            }else if(productosBiblio.get(optionLibro)instanceof Magazine){
                    Magazine revistaComprada=((Magazine)productosBiblio.get(optionLibro));
                    ((PremiumUser)users.get(optionUser)).getMagazines().add(revistaComprada);    
                    int cantidadActivas=((Magazine)productosBiblio.get(optionLibro)).getNumberActives();
                    ((Magazine)productosBiblio.get(optionLibro)).setNumberActives(cantidadActivas+1);      
                    msg="\nRevista suscrita correctamente-";
                    return msg; 
                    
                }
        }

        return msg;
    }

    public boolean generarFactura(int opcionUser, int opcionProducto){
        boolean indicador=false;
        String nameP=null;
        Calendar fechatransaccion=Calendar.getInstance();
        Double montoPagado=null;
        String identificador=null;
        String nameClient=null;
        if(indicador==false){
            if(productosBiblio.get(opcionProducto) instanceof Book){
                nameP=((Book)productosBiblio.get(opcionProducto)).getName();
                montoPagado=((Book)productosBiblio.get(opcionProducto)).getPrice();
                identificador=((Book)productosBiblio.get(opcionProducto)).getIdentifier();
            }else if(productosBiblio.get(opcionProducto) instanceof Magazine){
                nameP=((Magazine)productosBiblio.get(opcionProducto)).getName();
                montoPagado=((Magazine)productosBiblio.get(opcionProducto)).getSubscriptionValue();
                identificador=((Magazine)productosBiblio.get(opcionProducto)).getIdentifier();
            }
            
            if(users.get(opcionUser)instanceof PremiumUser){
                nameClient=((PremiumUser)users.get(opcionUser)).getNameUser();
                ((PremiumUser)users.get(opcionUser)).getFacturas().add(new Factura(nameClient,montoPagado, fechatransaccion, identificador, nameP));
                    indicador=true;
           }else if(users.get(opcionUser)instanceof RegularUser){
                nameClient=((RegularUser)users.get(opcionUser)).getNameUser();
                for(int i=0;i<6;i++){
                    if(((RegularUser)users.get(opcionUser)).getFacturas()[i]==null){
                        ((RegularUser)users.get(opcionUser)).getFacturas()[i]=new Factura(nameClient,montoPagado, fechatransaccion, identificador, nameP);
                        indicador=true;
                        return indicador;
                    }
                    
                }
           }
           facturas.add(new Factura(nameClient,montoPagado, fechatransaccion, identificador, nameP));
        }
        return indicador;
        
    }

    public String ultimaFacturaCliente(int opcionUser){
        String msg="";

        if(users.get(opcionUser) instanceof RegularUser){
            for(int i=0;i<7;i++){
                if(((RegularUser)users.get(opcionUser)).getFacturas()[i]==null){
                    msg=((RegularUser)users.get(opcionUser)).getFacturas()[i-1].toString();
                    return msg;
                }
            }
        }else if(users.get(opcionUser) instanceof PremiumUser){
            msg=((PremiumUser)users.get(opcionUser)).getFacturas().get(facturas.size()-1).toString();
        }
        return msg;
    }

    public String mostrarLibroUsuario(int opcionUser){
        String msg="";

        if(users.get(opcionUser)instanceof RegularUser){
            for(int i=0;i<((RegularUser)users.get(opcionUser)).getBooks().length;i++){
                if(((RegularUser)users.get(opcionUser)).getBooks()[i]!=null){
                    msg+="\n"+(i+1)+". "+((RegularUser)users.get(opcionUser)).getBooks()[i].toStringMin();
                }  
            }
        }else if(users.get(opcionUser)instanceof PremiumUser){
            for(int i=0;i<((PremiumUser)users.get(opcionUser)).getBooks().size();i++){
                msg+="\n"+(i+1)+". "+((PremiumUser)users.get(opcionUser)).getBooks().get(i).toStringMin();
            }            
        }
        return msg;
    }

    public String mostrarRevistaUsuario(int opcionUser){
        String msg="";

        if(users.get(opcionUser)instanceof RegularUser){
            for(int i=0;i<((RegularUser)users.get(opcionUser)).getMagazines().length;i++){
                if(((RegularUser)users.get(opcionUser)).getMagazines()[i]!=null){
                    msg+="\n"+(i+1)+". "+((RegularUser)users.get(opcionUser)).getMagazines()[i].toStringMin();
                }  
            }
        }else if(users.get(opcionUser)instanceof PremiumUser){
            for(int i=0;i<((PremiumUser)users.get(opcionUser)).getMagazines().size();i++){
                msg+="\n"+(i+1)+". "+((PremiumUser)users.get(opcionUser)).getMagazines().get(i).toStringMin();
            }            
        }
        return msg;
    }

    public String extraerNombreProductoUsuario(int opcionUusario,int producto, int decision){
        String name="";

        if(decision==1){
            if(users.get(opcionUusario)instanceof RegularUser){
                name=((RegularUser)users.get(opcionUusario)).getBooks()[producto].getName();
            }else if(users.get(opcionUusario)instanceof PremiumUser){
                name=((PremiumUser)users.get(opcionUusario)).getBooks().get(producto).getName();
            }
            
        }else if(decision==2){
            if(users.get(opcionUusario)instanceof RegularUser){
                name=((RegularUser)users.get(opcionUusario)).getMagazines()[producto].getName();
            }else if(users.get(opcionUusario)instanceof PremiumUser){
                name=((PremiumUser)users.get(opcionUusario)).getMagazines().get(producto).getName();
            }
        }
        

        return name;
    }

    public int extraerCantidadPaginasProductoUsuario(int opcionUusario, int producto, int decision){
        int cantidadPaginas=-1;

        if(decision==1){
            if(users.get(opcionUusario)instanceof RegularUser){
                cantidadPaginas=((RegularUser)users.get(opcionUusario)).getBooks()[producto].getNumberPages();
            }else if(users.get(opcionUusario)instanceof PremiumUser){
                cantidadPaginas=((PremiumUser)users.get(opcionUusario)).getBooks().get(producto).getNumberPages();
            }
            
        }else if(decision==2){
            if(users.get(opcionUusario)instanceof RegularUser){
                cantidadPaginas=((RegularUser)users.get(opcionUusario)).getMagazines()[producto].getNumberPages();
            }else if(users.get(opcionUusario)instanceof PremiumUser){
                cantidadPaginas=((PremiumUser)users.get(opcionUusario)).getMagazines().get(producto).getNumberPages();
            }
        }

        return cantidadPaginas;
    }
    

    }


        
    


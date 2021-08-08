package misiontic.reto;

public class Factura{

    Juguete [] lista;

    public Factura(Juguete lista []){
        this.lista = lista;
    }

    // Metodos
    public void mostrarTotales(){
    // Calculo de totales
    double totalJuguetes = 0;
    double totalJuguetesBebe = 0;
    double totalJuguetesLego = 0;
    for (Juguete juguete:lista){
        double precio = juguete.calcularPrecio();
        totalJuguetes = totalJuguetes + precio;
        if (juguete.getClass() == JugueteBebe.class){
            totalJuguetesBebe = totalJuguetesBebe + precio;
        }else if (juguete.getClass() == JugueteLego.class){
            totalJuguetesLego = totalJuguetesLego + precio;
        }
    }

    System.out.println("El precio total de los juguetes es de " + totalJuguetes);
    System.out.println("La suma del precio de los JuguetesBebe es de " + totalJuguetesBebe);
    System.out.print("La suma del precio de los JuguetesLego es de " + totalJuguetesLego);
    }
}
   
class Juguete{
    // Constantes
    private final static String MARCA="Hasbro";
    private final static String PAIS_ORIGEN="China";
    private final static double PRECIO_BASE=10000.0;
    // Atributos
    private String marca;
    private String paisOrigen;
    private Double precioBase;
    // Constructores
    public Juguete(){
        marca = MARCA;
        paisOrigen = PAIS_ORIGEN;
        precioBase = PRECIO_BASE;
    }

    public Juguete (String marca){
        this.marca = marca;
        paisOrigen = PAIS_ORIGEN;
        precioBase = PRECIO_BASE;
    }

    public Juguete (String marca, String paisOrigen, double precioBase){
        this.marca = marca;
        this.paisOrigen = paisOrigen;
        this.precioBase = precioBase;
    }
    
    // Calculos
    public double calcularPrecio(){
        double precioFinal = precioBase;
        if (marca.equals("Hasbro")){
            precioFinal = precioFinal - (precioFinal * 0.5);
        }else{
            precioFinal = precioFinal - (precioFinal * 0.25);
        }
        if (paisOrigen.equals("China")){
            if ((precioFinal - 5000) > 0){
                precioFinal = precioFinal - 5000;
                return precioFinal;
            }
            else {
                return precioFinal;
            }
        }else{
            if ((precioFinal - 2500) > 0){
                precioFinal = precioFinal - 2500;
                return precioFinal;
            }
            else {
                return precioFinal;
            }
        }
    }

    // getters/setters de ser necesarios
    public static String getMarca() {
        return MARCA;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public static String getPaisOrigen() {
        return PAIS_ORIGEN;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }
}
    
class JugueteBebe extends Juguete{  

    // Constantes
    private final static String MATERIAL="Plastico";

    // Atributos
    private String material;

    // Constructores
    public JugueteBebe(){
        material = MATERIAL;
    }

    public JugueteBebe(String material){
        this.material = material;
    } 

    public JugueteBebe(String marca, String paisOrigen, double precioBase, String material){
        super(marca, paisOrigen, precioBase);
        this.material = material;
    } 
   
    // Metodos
    public double calcularPrecio(){
    double precioFinal = super.calcularPrecio();
    if (material.equals("Plastico")){
        precioFinal = precioFinal + 10000;
    }
    return precioFinal;
    }

    // getters/setters de ser necesarios
    public static String getMaterial() {
        return MATERIAL;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
   }

class JugueteLego extends Juguete{
    // Constantes
    private final static int NUMERO_FICHAS = 100;

    // Atributos
    private int numero_fichas;

    // Constructores
    public JugueteLego(){
        numero_fichas = NUMERO_FICHAS;
    }

    public JugueteLego(int numero_fichas){
        this.numero_fichas = numero_fichas;
    }

    public JugueteLego(String marca, String paisOrigen, double precioBase, int numero_fichas){
        super(marca, paisOrigen, precioBase);
        this.numero_fichas = numero_fichas;
    }
   
    // Metodos
    public double calcularPrecio(){
        double precioFinal = super.calcularPrecio();
        if (numero_fichas < 100){
            precioFinal = precioFinal + 15000;
        }else{
            precioFinal = precioFinal + 20000;
        }
        return precioFinal;
        }

    // getters/setters de ser necesarios
    public static int getNumeroFichas() {
        return NUMERO_FICHAS;
    }

    public void setNumero_fichas(int numero_fichas) {
        this.numero_fichas = numero_fichas;
    }
}
   

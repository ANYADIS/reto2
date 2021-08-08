package misiontic.reto;

public class Reto2 {
    public static void main(String[] args){
        // Caso de Prueba 1
        Juguete juguetes[]=new Juguete[5];
        juguetes[0]=new Juguete("Hasbro", "China", 30000);
        juguetes[1]=new JugueteBebe("Barbie", "Colombia", 75000, "Plastico");
        juguetes[2]=new JugueteLego(500);
        juguetes[3]=new Juguete();
        juguetes[4]=new JugueteBebe("Plastilina");
        Factura solucion = new Factura(juguetes);
        solucion.mostrarTotales(); 
    }
            
}
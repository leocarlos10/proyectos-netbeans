
package maquinaexpendedora;


public class MaquinaExpendedora {

    String[][] nombresGolosinas = {
 
            {"KitKat", "Chicles de fresa", "Lacasitos", "Palotes"},
 
            {"Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix"},
 
            {"Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta"},
 
            {"Lacasitos", "Crunch", "Milkybar", "KitKat"}
 
 };

    double[][] precio = {
 
  {1000, 200, 500, 950},
 
  {1800, 100, 120, 100},
 
  {1750, 130, 120, 800},
 
  {1500, 110, 720, 350}
 
};
    

    int[][] cantidad = {
 
  {5, 5, 5, 5},
 
  {5, 5, 5, 5},
 
  {5, 5, 5, 5},
 
  {5, 5, 5, 5}
 
};
    
    public void setPedirGol () {
        String pos = pgo.getText();
    }

    public void confGol (String [][] nombresGolosinas, String posicion, String nm) {
        boolean valid;
        boolean num;
        if (posicion.length() != 2) {
            valid = false;
        }
        
        try {
            Integer.parseInt(nm);
            num = true;
        } catch (NumberFormatException n) {
            num = false;
        }
            
            
        
    
    }

        }

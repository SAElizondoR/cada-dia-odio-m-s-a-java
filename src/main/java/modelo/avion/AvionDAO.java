/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package modelo.avion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AvionDAO {
    
    private ArrayList<Avion> arravion=new ArrayList<>();
    
    public AvionDAO() throws FileNotFoundException {
        File fileaviones= new File("aviones.txt");
        Scanner scanav=new Scanner(fileaviones);
        int id;
        int numpasajeros;
        String modelo;
             
        while(scanav.hasNextLine()) {
            id=Integer.parseInt(scanav.nextLine());
            modelo=scanav.nextLine();
            numpasajeros=Integer.parseInt(scanav.nextLine());
            
            Avion avion=new Avion(id,modelo,numpasajeros);
            arravion.add(avion);
        }
    }
    
    public boolean agregarAvion(Avion avion) {
        if (estaId(avion.getId())) {
            return false;
        }
        arravion.add(avion);
        return true;
    }
    
    private boolean estaId(int id) {
        return arravion.stream().anyMatch(a -> (a.getId() == id));
    }
    
    public ArrayList<Avion> getArrayAvion() {
        return arravion;
    }
    
}

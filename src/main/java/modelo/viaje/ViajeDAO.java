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
package modelo.viaje;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import modelo.avion.*;

public class ViajeDAO {
    
    private ArrayList<Viaje> arrviaje=new ArrayList<>();
    
    public ViajeDAO(AvionDAO avionDAO) throws FileNotFoundException, ParseException {
        File fileviajes= new File("viajes.txt");
        Scanner scanviaje=new Scanner(fileviajes);
        int id;
        int idavion;
        Avion avion;
        String origen;
        String destino;
        Date dateorigen;
        Date datedestino;
        SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-YYYY HH:mm:ss");  
        String dateorigens;
        String datedestinos;
        int asientosdisponibles;
             
        while(scanviaje.hasNextLine()) {
            id=Integer.parseInt(scanviaje.nextLine());
            idavion=Integer.parseInt(scanviaje.nextLine());
            avion = avionDAO.buscarAvion(idavion);
            origen=scanviaje.nextLine();
            destino=scanviaje.nextLine();
            dateorigens=scanviaje.nextLine();
            datedestinos=scanviaje.nextLine();
            dateorigen=formatter.parse(dateorigens);
            datedestino=formatter.parse(datedestinos);
            asientosdisponibles=Integer.parseInt(scanviaje.nextLine());
            
            Viaje viaje=new Viaje(id,avion,origen,destino,dateorigen,datedestino,asientosdisponibles);
            arrviaje.add(viaje);
        }
    }
    
    public boolean agregarViaje(Viaje viaje) {
        if (estaIdViaje(viaje.getId()) || !avionValido(viaje)) {
            return false;
        }
        arrviaje.add(viaje);
        return true;
    }
    
    public boolean estaIdViaje(int id) {
        return arrviaje.stream().anyMatch(v -> (v.getId() == id));
    }
    
    public boolean avionValido(Viaje viaje) {
        return arrviaje.stream().filter(v -> (v.getAvion().getId() == viaje.getAvion().getId()))
                .noneMatch(v ->(v.getDateorigen().compareTo(viaje.getDatedestino()) <= 0 &&
                        v.getDatedestino().compareTo(viaje.getDateorigen()) >= 0));
    }
    
    public Viaje buscarViaje(int id) {
        for (Viaje v: arrviaje) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }
    
    public ArrayList<Viaje> getArrayViaje () {
        return arrviaje;
    }
    
}

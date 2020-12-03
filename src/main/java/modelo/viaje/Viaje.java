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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.avion.Avion;

public class Viaje {
    
    private int id;    private Avion avion;
    private String origen;
    private String destino;
    private Date dateorigen = new Date();
    private Date datedestino = new Date();
    private int asientosdisponibles;

    public Viaje(int id, Avion avion, String origen, String destino, Date dateorigen, Date datedestino, int asientosdisponibles) {
        this.id=id;
        this.avion = avion;
        this.origen=origen;
        this.destino=destino;
        this.dateorigen=dateorigen;
        this.datedestino=datedestino;
        this.asientosdisponibles=asientosdisponibles;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the avion
     */
    public Avion getAvion() {
        return avion;
    }

    /**
     * @param avion the idavion to set
     */
    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    /**
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    /**
     * @return the asientosdisponibles
     */
    public int getAsientosdisponibles() {
        return asientosdisponibles;
    }

    /**
     * @param asientosdisponibles the asientosdisponibles to set
     */
    public void setAsientosdisponibles(int asientosdisponibles) {
        this.asientosdisponibles = asientosdisponibles;
    }
    
    public void setDateorigen(Date origen)
    {
        this.dateorigen=origen;
    }
    
    public void setDatedestino(Date destino)
    {
        this.datedestino=destino;
    }
    
     DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");  
     String strdate;
     
    public String getDateorigen()
    {
        strdate = dateFormat.format(dateorigen); 
        return strdate;
    }
    
    public String getDatedestino()
    {
        strdate = dateFormat.format(datedestino); 
        return strdate;
    }
    
}

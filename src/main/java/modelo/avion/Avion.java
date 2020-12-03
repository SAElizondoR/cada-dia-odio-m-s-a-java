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

public class Avion {
        
    private int id;
    private String modelo;
    private int numpasajeros;

    public Avion() {
        
    }
    
    public Avion(int id, String modelo, int numpasajeros)
    {
        this.id=id;
        this.modelo=modelo;
        this.numpasajeros=numpasajeros;
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
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the numpasajeros
     */
    public int getNumpasajeros() {
        return numpasajeros;
    }

    /**
     * @param numpasajeros the numpasajeros to set
     */
    public void setNumpasajeros(int numpasajeros) {
        this.numpasajeros = numpasajeros;
    }

}

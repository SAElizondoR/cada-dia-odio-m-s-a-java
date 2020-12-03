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
package modelo.cliente;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClienteDAO {
    
    protected ArrayList<Cliente> arrcliente=new ArrayList<>();
    
    public ClienteDAO() throws FileNotFoundException {
        File fileclientes = new File("clientes.txt");
        Scanner scanclie = new Scanner(fileclientes);
        int id;
        String nombre;
        String apellidop;
        String apellidom;
        String curp;
        String rfc;
        String direccion;
             
        while(scanclie.hasNextLine()) {
            id=Integer.parseInt(scanclie.nextLine());
            nombre=scanclie.nextLine();
            apellidop=scanclie.nextLine();
            apellidom=scanclie.nextLine();
            curp=scanclie.nextLine();
            rfc=scanclie.nextLine();
            direccion=scanclie.nextLine();
            
            Cliente cliente=new Cliente(id,nombre,apellidop,apellidom,curp,rfc,direccion);
            arrcliente.add(cliente);
        }
    }
    
    public boolean agregarCliente(Cliente cliente) {
        if (estaId(cliente.getId())) {
            return false;
        }
        arrcliente.add(cliente);
        return true;
    }
    
    public boolean modificarCliente(Cliente cliente) {
        for (Cliente c: arrcliente) {
            if(estaId(cliente.getId())) {
                c = cliente;
                return true;
            }
        }
        return false;
    }
    
    private boolean estaId(int id) {
        for(Cliente c: arrcliente) {
            if(c.getId() == id) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Cliente> getArrayCliente () {
        return arrcliente;
    }
    
}

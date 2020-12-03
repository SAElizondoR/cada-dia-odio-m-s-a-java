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
package modelo.boleto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.cliente.*;
import modelo.viaje.*;

public class BoletoDAO {
    
    private ArrayList<Boleto> arrboleto=new ArrayList<>();
    
    public BoletoDAO(ViajeDAO viajeDAO, ClienteDAO clienteDAO) throws FileNotFoundException {
        File fileboletos= new File("boletos.txt");
        Scanner scanboleto=new Scanner(fileboletos);
        int id;
        int idviaje;
        int idcliente;
        Viaje viaje;
        Cliente cliente;
  
        while(scanboleto.hasNextLine())
        {
            id = Integer.parseInt(scanboleto.nextLine());
            idcliente = Integer.parseInt(scanboleto.nextLine());
            cliente = clienteDAO.buscarCliente(idcliente);
            idviaje = Integer.parseInt(scanboleto.nextLine());
            viaje = viajeDAO.buscarViaje(idviaje);
            
            Boleto boleto = new Boleto(id, cliente, viaje);
            arrboleto.add(boleto);
        }
    }
    
    public boolean venderBoleto(Boleto boleto, ViajeDAO viajeDAO) {
        if (estaIdBoleto(boleto.getId())) {
            return false;
        }
        Viaje viaje = viajeDAO.buscarViaje(boleto.getViaje().getId());
        viaje.reducirAsientos();
        arrboleto.add(boleto);
        return true;
    }
    
    public boolean estaIdBoleto(int id) {
        return arrboleto.stream().anyMatch(b -> (b.getId() == id));
    }
    
    public ArrayList<Boleto> getArrayBoleto() {
        return arrboleto;
    }
    
}

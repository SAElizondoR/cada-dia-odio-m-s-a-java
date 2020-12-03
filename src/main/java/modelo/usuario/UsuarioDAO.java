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
package modelo.usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuarioDAO {
    
    private ArrayList<Usuario> arrusuario=new ArrayList<>();
    
    public UsuarioDAO() throws FileNotFoundException {
        File fileusuarios= new File("usuarios.txt");
        Scanner scanusu=new Scanner(fileusuarios);
        int id;
        String email;
        String password;
             
        while(scanusu.hasNextLine()) {
            id=Integer.parseInt(scanusu.nextLine());
            email=scanusu.nextLine();
            password=scanusu.nextLine();
            
            Usuario usu=new Usuario(id,email,password);
            arrusuario.add(usu);
        }
    }
    
    public boolean agregarUsuario(Usuario usuario) {
        if (estaIdUsuario(usuario.getId())) {
            return false;
        }
        arrusuario.add(usuario);
        return true;
    }
    
    public boolean modificarCliente(Usuario usuario) {
        for (int i = 0; i < arrusuario.size(); i++) {
            if(arrusuario.get(i).getId() == usuario.getId()) {
                arrusuario.set(i, usuario);
                return true;
            }
        }
        return false;
    }
    
    public boolean estaIdUsuario(int id) {
        return arrusuario.stream().anyMatch(u -> (u.getId() == id));
    }
    
    public Usuario buscarUsuario(int id) {
        for (Usuario u: arrusuario) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }
    
    public ArrayList<Usuario> getArrayUsuario() {
        return arrusuario;
    }
    
}

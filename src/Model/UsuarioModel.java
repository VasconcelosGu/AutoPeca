package Model;

public class UsuarioModel extends VendedorModel {
    public void logaUsuario(int id, String email, String nome_usuario, String nome) {
         this.id_vendedor = id;
         this.email = email;
         this.nome_usuario = nome_usuario;
         this.nome = nome;
    }
}

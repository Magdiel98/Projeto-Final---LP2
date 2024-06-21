package entity;

//Informações de um usuário é obtida após o cadastro
public abstract class Usuario extends Entity{

   protected String nome;
   protected String sobrenome;
   protected String email;
   protected String senha;

  public Usuario(String nome, String sobrenome, String email, String senha)
   {
      this.nome = nome;
      this.sobrenome = sobrenome;
      this.email = email;
      this.senha = senha;
   }

   public String getNome()
   {
       return this.nome;
   }

   public String getSobrenome()
   {
       return this.sobrenome;
   }

   public String getEmail()
   {
       return this.email;
   }

   public String getSenha()
   {
       return this.senha;
   }

}

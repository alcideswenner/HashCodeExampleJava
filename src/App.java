import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class App {
    public String usuario;
    public String senha;     
    public String email;
    
    public App(String usuario, String senha, String email) {
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof App)) {
            return false;
        }
        App app = (App) o;
        return Objects.equals(usuario, app.usuario) && Objects.equals(senha, app.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, senha);
    }

    public static void main(String[] args) throws Exception {
    App a=new App("wenner","1234","a@gmail.com");
    App a1=new App("alcides","12388","a1@gmail.com");
    App a3=new App("wenner","1234","a2@gmail.com");
    App a4=new App("sss","1234","a3@gmail.com");
    App a5=new App("alcides","12388","ad@gmail.com");
    App a6=new App("ttytt","1234","agg@gmail.com");
    App a7=new App("s","1234","a6@gmail.com");
    App a8=new App("alcsffides","12388","a8@gmail.com");
    App a9=new App("ffftt","1234","ae8@gmail.com");

    List<App>dados=new ArrayList<>();
    dados=Arrays.asList(a,a1,a3,a4,a5,a6,a7,a8,a9);

    List<App> user = dados.stream()
    .filter(e->{
        try{
            if(e.getUsuario().equals("alcsffides")&&e.getSenha().equals("12388")){
                e.setEmail("jacque2@gmail.com");
                return true;
            }
        }catch(Exception e2){
        return false;
        }
        return false;
    }).distinct()  
    .collect(Collectors.toList());
    if(!user.isEmpty())
        System.out.println("Usuário logado "+user.get(0).getEmail());
    else
        System.out.println("Usuário não existente");
    }
}

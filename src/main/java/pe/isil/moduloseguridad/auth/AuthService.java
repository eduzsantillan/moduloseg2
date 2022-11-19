package pe.isil.moduloseguridad.auth;

public interface AuthService {

    AuthDTO login(String email,String password);
    AuthDTO register(AuthUser authUser);


}

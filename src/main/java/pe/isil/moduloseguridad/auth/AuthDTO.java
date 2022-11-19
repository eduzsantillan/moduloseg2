package pe.isil.moduloseguridad.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthDTO {

    private String code;
    private String message;
    private Object data;

    public static AuthDTO buildWhenLoginOk(AuthUser user){
        return AuthDTO.builder()
                .code("200")
                .message("Login Exitoso")
                .data(user)
                .build();
    }

    public static AuthDTO buildWhenError(String error){
        return AuthDTO.builder()
                .code("500")
                .message("Ocurrio un error ".concat(error) )
                .build();
    }

    public static AuthDTO buildWhenIsInactive(){
        return AuthDTO.builder()
                .code("401")
                .message("User inactivo")
                .build();
    }

    public static AuthDTO buildWhenEmailPasswordIncorrect(){
        return AuthDTO.builder()
                .code("403")
                .message("Correo o password incorrecto")
                .build();
    }

    public static AuthDTO buildWhenEmailIsTaken(){
        return AuthDTO.builder()
                .code("510")
                .message("Usuario ya esta registrado")
                .build();
    }

    public static AuthDTO buildWhenRegisterSucceed(){
        return AuthDTO.builder()
                .code("200")
                .message("Usuario registrado correctamente")
                .build();
    }

}

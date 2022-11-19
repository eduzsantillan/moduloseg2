package pe.isil.moduloseguridad.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private AuthUserRepository authUserRepository;


    @Override
    public AuthDTO login(String email, String password) {
        try{
            Optional<AuthUser> userToFind = authUserRepository
                    .findAuthUserByEmailAndPassword(email,password);
            if(userToFind.isPresent()){
                if(userToFind.get().getIsActived()){
                    return AuthDTO.buildWhenLoginOk(userToFind.get());
                }else{
                    return AuthDTO.buildWhenIsInactive();
                }
            }else{
                return AuthDTO.buildWhenEmailPasswordIncorrect();
            }
        }catch (Exception e){
            return AuthDTO.buildWhenError(e.getMessage());
        }
    }

    @Override
    public AuthDTO register(AuthUser authUser) {
        try{
            Optional<AuthUser> authUserToFind = authUserRepository
                    .findAuthUserByEmail(authUser.getEmail());
            if(authUserToFind.isPresent()){
                return AuthDTO.buildWhenEmailIsTaken();
            }else{

                authUserRepository.save(authUser);
                return AuthDTO.buildWhenRegisterSucceed();
            }
        }catch(Exception e){
            return AuthDTO.buildWhenError(e.getMessage());
        }
    }
}

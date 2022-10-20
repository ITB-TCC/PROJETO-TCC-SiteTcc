package com.itb.tcc.amazbook.amazbook.modules.user.service;


import com.itb.tcc.amazbook.amazbook.exceptions.SuccessResponse;
import com.itb.tcc.amazbook.amazbook.exceptions.ValidationException;
import com.itb.tcc.amazbook.amazbook.modules.livro.model.Livro;
import com.itb.tcc.amazbook.amazbook.modules.user.dto.UsuarioRequest;
import com.itb.tcc.amazbook.amazbook.modules.user.dto.UsuarioResponse;
import com.itb.tcc.amazbook.amazbook.modules.user.model.Usuario;
import com.itb.tcc.amazbook.amazbook.modules.user.repository.UsuarioRepository;
import com.itb.tcc.amazbook.amazbook.utils.ErrorUtil;
import com.itb.tcc.amazbook.amazbook.utils.SuccessUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private Set<Livro> livros = new HashSet<>();

    public List<UsuarioResponse> findAll() {
        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioResponse::of)
                .collect(Collectors.toList());
    }

    public Usuario findById(Integer id) {
        validateInformedId(id);
        return usuarioRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException(ErrorUtil.ID_EMPTY));
    }

    public UsuarioResponse updateUser(UsuarioRequest usuarioRequest, Integer id) {
        validateClienteDataInformed(usuarioRequest);
        validateInformedId(id);

        Usuario usuario = Usuario.of(usuarioRequest);
        usuario.setId(id);

        String passwordCripto = new BCryptPasswordEncoder().encode(usuarioRequest.getSenha());
        usuario.setSenha(passwordCripto);

        usuarioRepository.save(usuario);
        return UsuarioResponse.of(usuario);

    }

    public UsuarioResponse findByIdResponse(Integer id) {
        return UsuarioResponse
                .of(findById(id));
    }

    public SuccessResponse deleteById(Integer id){
        validateInformedId(id);
        usuarioRepository
                .deleteById(id);
        return SuccessResponse.create(SuccessUtil.DELETE_SUCCESS);

    }

    public UsuarioResponse findByIdEmail(String email) {
        Usuario usuario = usuarioRepository.findByIdEmail(email);
        return UsuarioResponse.of(usuario);
    }

    public UsuarioResponse save(UsuarioRequest usuarioRequest){
        validateClienteDataInformed(usuarioRequest);

        String passwordCripto = new BCryptPasswordEncoder().encode(usuarioRequest.getSenha());
        usuarioRequest.setSenha(passwordCripto);

        Usuario usuario = usuarioRepository.save(Usuario.of(usuarioRequest));
        return UsuarioResponse.of(usuario);
    }

    private void validateClienteDataInformed(UsuarioRequest usuarioRequest) {
        if(isEmpty(usuarioRequest.getNome())){
            throw new ValidationException(ErrorUtil.CLIENTE_NAME_EMPTY);
        }

        if(isEmpty(usuarioRequest.getLogin())){
            throw new ValidationException(ErrorUtil.CLIENTE_EMAIL_EMPTY);
        }
        if(isEmpty(usuarioRequest.getSenha())){
            throw new ValidationException(ErrorUtil.CLIENTE_PASSWORD_EMPTY);
        }
    }
    private void validateInformedId(Integer id) {
        if(isEmpty(id)){
            throw new ValidationException(ErrorUtil.ID_EMPTY);
        }
    }
}

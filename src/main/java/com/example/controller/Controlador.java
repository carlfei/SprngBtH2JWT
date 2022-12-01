package com.example.controller;
import com.example.service.ServiceExample;
import com.example.model.Libros;
import com.example.repository.Biblioteca;
import com.example.dto.UserDat;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/home")
@Api(tags = "home")
@RequiredArgsConstructor
public class Controlador {


    private final ServiceExample serviceExample;

    private final ModelMapper modelMapper;
    List<Libros> libros = new ArrayList<>();

    @PostMapping("/signin")
    @ApiOperation(value = "${Controlador.signin}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something  wrong"), //
            @ApiResponse(code = 422, message = "No valid username/password")})
    public String login(//
                        @ApiParam("Username") @RequestParam String username, //
                        @ApiParam("Password") @RequestParam String password) {
        return serviceExample.signin(username, password);
    }


    @PostMapping("/signup")
    @ApiOperation(value = "${Controlador.signup}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use")})
    public String signup(@ApiParam("Signup User") @RequestBody UserDat user) {
        return serviceExample.signup(modelMapper.map(user, Libros.class));
    }


    /*

    @DeleteMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${Controlador.delete}", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public String delete(@ApiParam("Username") @PathVariable String username) {
        serviceExample.delete(username);
        return username;
    }

    @GetMapping(value = "/{username}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${Controlador.search}", response = UserResponseDTO.class, authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public UserResponseDTO search(@ApiParam("Username") @PathVariable String username) {
        return modelMapper.map(userService.search(username), UserResponseDTO.class);
    }

    @GetMapping(value = "/me")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    @ApiOperation(value = "${UserController.me}", response = UserResponseDTO.class, authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public UserResponseDTO whoami(HttpServletRequest req) {
        return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
    }

    @GetMapping("/refresh")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public String refresh(HttpServletRequest req) {
        return userService.refresh(req.getRemoteUser());
    }

*/


    /*
    @GetMapping("/list/{id}")
    public List<Libros> listar(@PathVariable(value = "id") Long id){

        return (biblioteca.findById(id)).stream().collect(Collectors.toList());

    }
    @GetMapping("/listAdd/{id}/{titulo}/{autor}")
    public List<Libros> anyadir(@PathVariable(value = "id") Long id,
                               @PathVariable(value = "titulo") String titulo,
                               @PathVariable(value = "autor") String autor){
                             libros.add(new Libros(id,titulo,autor));
                             biblioteca.saveAll(libros);


        return libros
                .stream()
                .collect(Collectors.toList());

    }
*/


}

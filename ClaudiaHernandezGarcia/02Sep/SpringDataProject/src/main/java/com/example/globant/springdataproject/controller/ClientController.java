package com.example.globant.springdataproject.controller;

import com.example.globant.springdataproject.dto.ClientDTO;
import com.example.globant.springdataproject.dto.ResponseDTO;
import com.example.globant.springdataproject.service.ClientService;
import com.example.globant.springdataproject.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;

import static com.example.globant.springdataproject.utils.Constants.CLIENT_ADDED_SUCCESSFULLY;
import static com.example.globant.springdataproject.utils.Constants.CLIENT_DELETED_SUCCESSFULLY;
import static com.example.globant.springdataproject.utils.Constants.CLIENT_EDITED_SUCCESSFULLY;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO<ClientDTO>> addClient(@RequestBody ClientDTO clientDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, CLIENT_ADDED_SUCCESSFULLY, clientService.addClient(clientDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDTO<List<ClientDTO>>> getClients() {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, "", clientService.getClients());
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/get/{clientId}")
    public ResponseEntity<ResponseDTO<ClientDTO>> getClient(@PathVariable Long clientId) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, "", clientService.getClient(clientId));
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{clientId}")
    public ResponseEntity<ResponseDTO<ClientDTO>> deletePetByID(@PathVariable Long clientId) {
        clientService.deleteClientByID(clientId);
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, CLIENT_DELETED_SUCCESSFULLY, null);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PatchMapping("/{clientId}")
    public ResponseEntity<ResponseDTO<ClientDTO>> editPetByID(@PathVariable Long clientId, @RequestBody ClientDTO clientDTO) {
        ResponseDTO responseDTO = new ResponseDTO(Constants.ResponseConstants.SUCCESS, CLIENT_EDITED_SUCCESSFULLY, clientService.editClientByID(clientId, clientDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}

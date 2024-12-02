package com.example.IPL.Player.IPL.Controller;

import com.example.IPL.Player.IPL.DTO.PlayerDTO;
import com.example.IPL.Player.IPL.Entity.Player;
import com.example.IPL.Player.IPL.Exception.ResourceNotFoundException;
import com.example.IPL.Player.IPL.Service.PlayerService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class PlayerController {
    @Autowired
    PlayerService playerservice;

    @Autowired
    ModelMapper modelMapper;




//PostMapping
    @PostMapping("/create")
    ResponseEntity<String> create(@RequestBody  @Valid PlayerDTO playerDTO){
        playerservice.create(playerDTO);
        return new ResponseEntity<>("Created Sucessfully", HttpStatus.CREATED);
    }

    //GetMapping
    @GetMapping("/getPlayer.json")
    ResponseEntity<List<PlayerDTO>> getPlayer(){
        List<Player> players=playerservice.getPlayer();
        List<PlayerDTO> playerDTOs = players.stream()
                .map(player -> modelMapper.map(player, PlayerDTO.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(playerDTOs, HttpStatus.OK);

    }



    //Retrieve Specific Records
    @GetMapping("/getplayer.json/{id}")
    public ResponseEntity<PlayerDTO> getPlayerRecordOnId(@PathVariable Long id) {
        Optional<Player> player = Optional.ofNullable(playerservice.getPlayerRecordOnId(id))
                .orElse(Optional.empty());
        if (player.isEmpty()) {
            throw new ResourceNotFoundException("Player with ID " + id + " not found");
        }
        PlayerDTO playerDTO = modelMapper.map(player.get(), PlayerDTO.class);
        return new ResponseEntity<>(playerDTO, HttpStatus.OK);
    }


    //Update Record
    @PutMapping("/update")
    ResponseEntity<PlayerDTO> updatePlayer(@RequestBody PlayerDTO playerDTO){
        Player player=playerservice.updatePlayer(playerDTO);
        if(player==null){
            throw new ResourceNotFoundException("Player with ID  not found");
        }
        PlayerDTO playerdto=modelMapper.map(player,PlayerDTO.class);
        return new ResponseEntity<>(playerdto,HttpStatus.FOUND);
    }

    @DeleteMapping("/deletePlayer")
    ResponseEntity<String> deletePlayerById(@RequestBody PlayerDTO playerDTO){
        playerservice.deletePlayerById(playerDTO);
        return new ResponseEntity<>("Deleted Sucessfully",HttpStatus.OK);
    }

}

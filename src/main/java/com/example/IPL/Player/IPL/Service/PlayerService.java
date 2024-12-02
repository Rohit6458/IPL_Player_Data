package com.example.IPL.Player.IPL.Service;

import com.example.IPL.Player.IPL.DTO.PlayerDTO;
import com.example.IPL.Player.IPL.Entity.Player;
import com.example.IPL.Player.IPL.Reposistory.PlayerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    PlayerRepo playerrepo;

    @Autowired
    ModelMapper modelMapper;

    public void create(PlayerDTO playerDTO) {
    Player player=modelMapper.map(playerDTO,Player.class);
        playerrepo.save(player);
    }

    public List<Player> getPlayer() {
        List<Player> player= (List<Player>) playerrepo.findAll();
        return player;
    }

    public Optional<Player> getPlayerRecordOnId(Long id) {
        Optional<Player> player=playerIsExists(id);
        if(player.isEmpty()){
            return Optional.empty();
        }
        return player;
    }

    Optional<Player> playerIsExists(Long Id){
        return playerrepo.findById(Id);
    }

    public Player updatePlayer(PlayerDTO playerDTO) {
        Optional<Player> player=playerrepo.findById(playerDTO.getId());
        if(player.isEmpty()){
            return null;
        }
        Player player1=modelMapper.map(playerDTO,Player.class);
        player1.setName(playerDTO.getName());
        player1.setRole(playerDTO.getRole());
        player1.setTeam(playerDTO.getTeam());
        playerrepo.save(player1);
        return player1;

    }

    public void deletePlayerById(PlayerDTO playerDTO) {
        Player player=modelMapper.map(playerDTO,Player.class);
        playerrepo.deleteById(Long.valueOf(player.getId()));

    }
}

package com.example.IPL.Player.IPL.Reposistory;

import com.example.IPL.Player.IPL.Entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo extends CrudRepository<Player, Long> {
}

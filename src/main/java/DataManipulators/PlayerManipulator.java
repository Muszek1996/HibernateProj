package DataManipulators;

import DataManipulators.CrudRepo.PlayerRepository;
import Entity.PlayerEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class PlayerManipulator {

    private final PlayerRepository playerRepository;

    @Autowired
    PlayerManipulator(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public Long addPlayer(Long steamid, String nickname, byte vacBanned, Double accountValue ){
        PlayerEntity playerEntity = new PlayerEntity(steamid,nickname,vacBanned, accountValue);
        playerRepository.save(playerEntity);
        return steamid;
    }

    public PlayerEntity getBySteamId(Long steamId) {
        return playerRepository.findById(steamId).get();
    }

    public void updatePlayer(Long steamid, String nickname, byte vacBanned, Double accountValue ) {
        PlayerEntity g = playerRepository.findById(steamid).get();
        if (steamid != 0) {
            g.setSteamid(steamid);
        }
        if (nickname.length() != 0) {
            g.setNickname(nickname);
        }
            g.setVacBanned(vacBanned);
        if (!accountValue.isNaN()) {
            g.setAccountValue(accountValue);
        }
        playerRepository.save(g);
    }

    public void deleteById(Long steamid) {
        playerRepository.deleteById(steamid);
    }





}

package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private long id;
    private String userName;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    private List<GamePlayer> gamePlayer;

    public void addGamePlayer(GamePlayer gameplayer) {
        gameplayer.setPlayer(this);
        gamePlayer.add(gameplayer);
    }
    public List <Game> getGames()
    {
        return  gamePlayer.stream().map(sub -> sub.getGame()).collect(toList());
    }
    public Player (){}


    public Player(String name) {
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<GamePlayer> getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(List<GamePlayer> gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public long getId() {
        return id;
    }
}
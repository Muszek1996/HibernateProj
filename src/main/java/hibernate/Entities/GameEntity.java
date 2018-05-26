package hibernate.Entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "game", schema = "steam")
public class GameEntity {
    private long appid;
    private String name;
    private double price;
    private byte gamepadSupport;

    public GameEntity(){
        this.players = new HashSet<PlayerEntity>();
    }


    @ManyToMany(mappedBy = "games", cascade = {CascadeType.ALL})
    private Set<PlayerEntity> players;


    public Set<PlayerEntity> getPlayers() {
        return players;
    }

    public void setPlayers(Set<PlayerEntity> players) {
        this.players = players;
    }


    @Id
    @Column(name = "appid", nullable = false)
    public long getAppid() {
        return appid;
    }

    public void setAppid(long appid) {
        this.appid = appid;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "gamepadSupport", nullable = false)
    public byte getGamepadSupport() {
        return gamepadSupport;
    }

    public void setGamepadSupport(byte gamepadSupport) {
        this.gamepadSupport = gamepadSupport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameEntity that = (GameEntity) o;
        return appid == that.appid &&
                Double.compare(that.price, price) == 0 &&
                gamepadSupport == that.gamepadSupport &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(appid, name, price, gamepadSupport);
    }

    @Override
    public String toString() {
        return "GameEntity{" +
                "appid=" + appid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", gamepadSupport=" + gamepadSupport +
                ", players=" + players +
                '}';
    }
}

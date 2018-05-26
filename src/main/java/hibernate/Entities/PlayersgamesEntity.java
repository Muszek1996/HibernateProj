package hibernate.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "playersgames", schema = "steam", catalog = "")
public class PlayersgamesEntity {
    private int id;
    private long steamid;
    private long appid;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "steamid", nullable = false)
    public long getSteamid() {
        return steamid;
    }

    public void setSteamid(long steamid) {
        this.steamid = steamid;
    }

    @Basic
    @Column(name = "appid", nullable = false)
    public long getAppid() {
        return appid;
    }

    public void setAppid(long appid) {
        this.appid = appid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayersgamesEntity that = (PlayersgamesEntity) o;
        return id == that.id &&
                steamid == that.steamid &&
                appid == that.appid;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, steamid, appid);
    }

    @Override
    public String toString() {
        return "PlayersgamesEntity{" +
                "id=" + id +
                ", steamid=" + steamid +
                ", appid=" + appid +
                '}';
    }
}

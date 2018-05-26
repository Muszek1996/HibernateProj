package hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "player", schema = "steam", catalog = "")
public class PlayerEntity {
    private long steamid;
    private String nickname;
    private byte vacBanned;
    private double accountValue;

    @Id
    @Column(name = "steamid", nullable = false)
    public long getSteamid() {
        return steamid;
    }

    public void setSteamid(long steamid) {
        this.steamid = steamid;
    }

    @Basic
    @Column(name = "nickname", nullable = false, length = 32)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "vacBanned", nullable = false)
    public byte getVacBanned() {
        return vacBanned;
    }

    public void setVacBanned(byte vacBanned) {
        this.vacBanned = vacBanned;
    }

    @Basic
    @Column(name = "accountValue", nullable = false, precision = 0)
    public double getAccountValue() {
        return accountValue;
    }

    public void setAccountValue(double accountValue) {
        this.accountValue = accountValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerEntity that = (PlayerEntity) o;
        return steamid == that.steamid &&
                vacBanned == that.vacBanned &&
                Double.compare(that.accountValue, accountValue) == 0 &&
                Objects.equals(nickname, that.nickname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(steamid, nickname, vacBanned, accountValue);
    }

    @Override
    public String toString() {
        return "PlayerEntity{" +
                "steamid=" + steamid +
                ", nickname='" + nickname + '\'' +
                ", vacBanned=" + vacBanned +
                ", accountValue=" + accountValue +
                '}';
    }
}

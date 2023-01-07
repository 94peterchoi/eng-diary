package ed.englishdiary.diary.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Account {
    @Id @GeneratedValue
    private Long id;

    private String username;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account acoount = (Account) o;

        if (id != null ? !id.equals(acoount.id) : acoount.id != null) return false;
        if (username != null ? !username.equals(acoount.username) : acoount.username != null) return false;
        return password != null ? password.equals(acoount.password) : acoount.password == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}

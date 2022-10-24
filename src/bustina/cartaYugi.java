package bustina;

import java.util.Objects;

public class cartaYugi {
    private String nome;
    private int ATK;
    private int DEF;

    public cartaYugi() {
    }

    public cartaYugi(String nome, int ATK, int DEF) {
        this.nome = nome;
        this.ATK = ATK;
        this.DEF = DEF;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getATK() {
        return this.ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDEF() {
        return this.DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public cartaYugi nome(String nome) {
        setNome(nome);
        return this;
    }

    public cartaYugi ATK(int ATK) {
        setATK(ATK);
        return this;
    }

    public cartaYugi DEF(int DEF) {
        setDEF(DEF);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof cartaYugi)) {
            return false;
        }
        cartaYugi cartaYugi = (cartaYugi) o;
        return Objects.equals(nome, cartaYugi.nome) && ATK == cartaYugi.ATK && DEF == cartaYugi.DEF;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, ATK, DEF);
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", ATK='" + getATK() + "'" +
            ", DEF='" + getDEF() + "'" +
            "}";
    }

}

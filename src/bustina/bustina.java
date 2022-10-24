package bustina;

import java.util.Arrays;
import java.util.Objects;

public class bustina {
    private cartaYugi[] bustina = new cartaYugi[5];
    private  String Expansion;

    public cartaYugi[] getBustina() {
        return bustina;
    }

    public void setBustina(cartaYugi[] bustina) {
        this.bustina = bustina;
    }
    public bustina(){

    }
    public bustina(cartaYugi[] bustina) {
        this.bustina = bustina;
    }

    public String getExpansion() {
        return Expansion;
    }

    public void setExpansion(String expansion) {
        Expansion = expansion;
    }

    public bustina(cartaYugi[] bustina, String expansion) {
        this.bustina = bustina;
        Expansion = expansion;
    }

    @Override
    public String toString() {
        return "bustina{" +
                "bustina=" + Arrays.toString(bustina) +
                ", Expansion='" + Expansion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        bustina bustina1 = (bustina) o;
        return Arrays.equals(bustina, bustina1.bustina) && Objects.equals(Expansion, bustina1.Expansion);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(Expansion);
        result = 31 * result + Arrays.hashCode(bustina);
        return result;
    }
}

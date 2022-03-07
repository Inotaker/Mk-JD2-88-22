package by.it.academy.Mk_JD2_88_22.classwork.dto.airports;

public class City {
    private String en;
    private String ru;

    public String getRu() {
        return ru;
    }

    public String getEn() {
        return en;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    public void setEn(String en) {
        this.en = en;
    }

    @Override
    public String toString() {
        return "City{" +
                "en='" + en + '\'' +
                ", ru='" + ru + '\'' +
                '}';
    }
}

package by.it.academy.Mk_JD2_88_22.classwork.dto.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.time.LocalDate;
import java.util.Objects;

public class Passport {
    private String id;
    private String idCitizen;
    private String address;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private LocalDate createDate;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Passport(@JsonProperty("id") String id,
                    @JsonProperty("id_citizen") String idCitizen,
                    @JsonProperty("address") String address,
                    @JsonProperty("create_date") LocalDate createDate) {
        this.id = id;
        this.idCitizen = idCitizen;
        this.address = address;
        this.createDate = createDate;
    }

    public Passport() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(String idCitizen) {
        this.idCitizen = idCitizen;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(id, passport.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id='" + id + '\'' +
                ", idCitizen='" + idCitizen + '\'' +
                ", address='" + address + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}

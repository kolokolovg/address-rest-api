package com.guyvernk.address.restapi;

import javax.persistence.*;

@Entity
@Table(name = "_countries", schema = "geodata")
public class CountriesEntity {
    private int countryId;
    private String titleRu;

    @Id
    @Column(name = "country_id")
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "title_ru")
    public String getTitleRu() {
        return titleRu;
    }

    public void setTitleRu(String titleRu) {
        this.titleRu = titleRu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountriesEntity that = (CountriesEntity) o;

        if (countryId != that.countryId) return false;
        if (titleRu != null ? !titleRu.equals(that.titleRu) : that.titleRu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryId;
        result = 31 * result + (titleRu != null ? titleRu.hashCode() : 0);
        return result;
    }
}

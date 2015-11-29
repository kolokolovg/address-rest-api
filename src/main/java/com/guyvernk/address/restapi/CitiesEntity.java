package com.guyvernk.address.restapi;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Entity
@Table(name = "_cities", schema = "geodata")
public class CitiesEntity {
    private int cityId;
    private int countryId;
    private byte important;
    private Integer regionId;
    private String titleRu;
    private String areaRu;
    private String regionRu;

    @Id
    @Column(name = "city_id")
    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "country_id")
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "important")
    public byte getImportant() {
        return important;
    }

    public void setImportant(byte important) {
        this.important = important;
    }

    @Basic
    @Column(name = "region_id")
    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    @Basic
    @Column(name = "title_ru")
    public String getTitleRu() {
        return titleRu;
    }

    public void setTitleRu(String titleRu) {
        this.titleRu = titleRu;
    }

    @Basic
    @Column(name = "area_ru")
    public String getAreaRu() {
        return areaRu;
    }

    public void setAreaRu(String areaRu) {
        this.areaRu = areaRu;
    }

    @Basic
    @Column(name = "region_ru")
    public String getRegionRu() {
        return regionRu;
    }

    public void setRegionRu(String regionRu) {
        this.regionRu = regionRu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CitiesEntity that = (CitiesEntity) o;

        if (cityId != that.cityId) return false;
        if (countryId != that.countryId) return false;
        if (important != that.important) return false;
        if (regionId != null ? !regionId.equals(that.regionId) : that.regionId != null) return false;
        if (titleRu != null ? !titleRu.equals(that.titleRu) : that.titleRu != null) return false;
        if (areaRu != null ? !areaRu.equals(that.areaRu) : that.areaRu != null) return false;
        if (regionRu != null ? !regionRu.equals(that.regionRu) : that.regionRu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cityId;
        result = 31 * result + countryId;
        result = 31 * result + (int) important;
        result = 31 * result + (regionId != null ? regionId.hashCode() : 0);
        result = 31 * result + (titleRu != null ? titleRu.hashCode() : 0);
        result = 31 * result + (areaRu != null ? areaRu.hashCode() : 0);
        result = 31 * result + (regionRu != null ? regionRu.hashCode() : 0);
        return result;
    }
}

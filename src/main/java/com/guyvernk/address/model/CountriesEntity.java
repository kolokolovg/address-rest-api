package com.guyvernk.address.model;

import org.apache.solr.analysis.LowerCaseFilterFactory;
import org.apache.solr.analysis.StandardFilterFactory;
import org.apache.solr.analysis.StandardTokenizerFactory;
import org.apache.solr.analysis.StopFilterFactory;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;

@AnalyzerDef(name = "countrytokenanalyzer",tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
        filters = {
                @TokenFilterDef(factory = StandardFilterFactory.class),
                @TokenFilterDef(factory = LowerCaseFilterFactory.class),
                @TokenFilterDef(factory = StopFilterFactory.class,params = {
                        @org.hibernate.search.annotations.Parameter(name = "ignoreCase", value = "true") }) })
@Analyzer(definition = "countrytokenanalyzer")
@Indexed
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
    @Field(name = "title",index= Index.YES, analyze= Analyze.YES, store= Store.NO)
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

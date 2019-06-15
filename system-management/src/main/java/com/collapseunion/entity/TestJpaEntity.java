package com.collapseunion.entity;

import com.collapseunion.dto.TestJpaDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.commons.lang.StringUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * JPA 测试实体
 *
 * @author CloudSen
 */
@Entity
@ToString
@Setter
@Accessors(chain = true)
@Table(name = "test_jpa", schema = "public", catalog = "euclid")
public class TestJpaEntity implements Serializable {
    private String id;
    private String name;
    private Date createDate;
    private Date updateDate;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getCreateDate() {
        return createDate;
    }

    @Basic
    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")
    public Date getUpdateDate() {
        return updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestJpaEntity that = (TestJpaEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, createDate, updateDate);
    }

    public TestJpaEntity copyValueFromDto(TestJpaDto testJpaDto) {
        if (StringUtils.isNotEmpty(testJpaDto.getName())) {
            this.name = testJpaDto.getName();
        }
        return this;
    }
}

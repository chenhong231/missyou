package com.lin.eshopping.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ApiModel(description = "Banner实体类", value = "Banner对象")
public class Banner extends BaseEntity{
    @Id
    @ApiModelProperty(notes = "id of banner", name = "id", required = true, value = "test id")
    private Long id;

    @ApiModelProperty(notes = "name of banner", name = "name", required = true, value = "test name")
    private String name;

    @ApiModelProperty(notes = "description of banner", name = "description", required = true, value = "test description")
    private String description;

    @ApiModelProperty(notes = "title of banner", name = "title", required = true, value = "test title")
    private String title;

    @ApiModelProperty(notes = "img of banner", name = "img", required = true, value = "test img")
    private String img;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "bannerId")
    private List<BannerItem> items;
}

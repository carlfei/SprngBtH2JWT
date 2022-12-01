package com.example.dto;


import com.example.model.LibrosRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserRes {
    @ApiModelProperty(position = 0)
    private Integer id;
    @ApiModelProperty(position = 1)
    private String username;

    @ApiModelProperty(position = 3)
    List<LibrosRole> librosRole;



}

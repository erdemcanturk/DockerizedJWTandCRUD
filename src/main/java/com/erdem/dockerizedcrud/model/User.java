package com.erdem.dockerizedcrud.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@ApiModel(value = "User Api model documentation", description = "Model")
@Table(name = "users")

public class User {
    @ApiModelProperty(value = "Unique id field of user object")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "username field of user object")
    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;

    @ApiModelProperty(value = "password field of user object")
    @Column(name = "password", nullable = false)
    private String password;

    @ApiModelProperty(value = "name field of user object")
    @Column(name = "name", nullable = false)
    private String name;

    @ApiModelProperty(value = "createTime field of user object")
    @Column(name = "create_time")
    private LocalDateTime createTime;





}

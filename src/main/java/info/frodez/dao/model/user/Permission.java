package info.frodez.dao.model.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * @description 用户权限表
 * @table tb_permission
 * @date 2019-01-13
 */
@Data
@Entity
@Table(name = "tb_permission")
public class Permission implements Serializable {
    
    /** 
     * 主键ID
     */
    @Id
    @NotNull
    @Column(name = "id")
    private Long id;

    /** 
     * 创建时间
     */
    @NotNull
    @Column(name = "create_time")
    private Date createTime;

    /** 
     * 类型  0:ALL  1:GET  2:POST  3:DELETE  4:PUT
     */
    @NotNull
    @Column(name = "type")
    private Byte type = 0;

    /** 
     * 权限名称
     */
    @NotNull
    @Column(name = "name", length = 100)
    private String name;

    /** 
     * 地址
     */
    @NotNull
    @Column(name = "url", length = 255)
    private String url;

    /** 
     * 描述
     */
    @Column(name = "description", length = 1000)
    private String description;

    private static final long serialVersionUID = 1L;
}
package frodez.dao.param.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * 用户登录请求参数
 * @author Frodez
 * @date 2018-12-02
 */
@Data
@NoArgsConstructor
@ApiModel(description = "用户登录请求参数")
public class DoLogin implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户名
	 */
	@NotBlank
	@Length(min = 3, max = 25)
	@ApiModelProperty(value = "用户名", required = true)
	private String username;

	/**
	 * 密码
	 */
	@NotBlank
	@Length(min = 8, max = 30)
	@ApiModelProperty(value = "密码", required = true)
	private String password;

}

package info.frodez.config.mybatis.generator;

import info.frodez.config.mybatis.DataMapper;
import java.util.List;
import org.joda.time.LocalDate;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.XmlElement;

/**
 * mybatis-generator参数配置插件
 * @author Frodez
 * @date 2018-11-13
 */
public class CustomSettingsPlugin extends PluginAdapter {

	/**
	 * 基础Mapper全限定名,请务必保证正确!
	 */
	private static final String MAPPER_NAME = DataMapper.class.getName();

	/**
	 * 配置生成的Mapper接口
	 * @param interfaze
	 * @param topLevelClass
	 * @param introspectedTable
	 * @author Frodez
	 * @date 2018-12-13
	 */
	@Override
	public boolean clientGenerated(Interface i, TopLevelClass klass, IntrospectedTable table) {
		// 获取实体类
		FullyQualifiedJavaType entity = new FullyQualifiedJavaType(table.getBaseRecordType());
		// import接口
		i.addImportedType(new FullyQualifiedJavaType(MAPPER_NAME));
		i.addSuperInterface(new FullyQualifiedJavaType(MAPPER_NAME + "<" + entity.getShortName() + ">"));
		// import实体类
		i.addImportedType(entity);
		// import Spring Repository注解
		i.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper"));
		i.addImportedType(new FullyQualifiedJavaType("org.springframework.stereotype.Repository"));
		i.addAnnotation("@Mapper");
		i.addAnnotation("@Repository");
		i.addJavaDocLine("/**");
		i.addJavaDocLine(" * @description " + (table.getRemarks() == null ? "" : table.getRemarks()));
		i.addJavaDocLine(" * @table " + table.getFullyQualifiedTable());
		i.addJavaDocLine(" * @date " + LocalDate.now().toString());
		i.addJavaDocLine(" */");
		return true;
	}

	// 开启验证
	@Override
	public boolean validate(List<String> arg0) {
		return true;
	}

	// 生成实体类
	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
		IntrospectedTable introspectedTable) {
		return true;
	}

	// 不生成setter
	@Override
	public boolean modelSetterMethodGenerated(Method method, TopLevelClass topLevelClass,
		IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable,
		ModelClassType modelClassType) {
		return false;
	}

	// 不生成getter
	@Override
	public boolean modelGetterMethodGenerated(Method method, TopLevelClass topLevelClass,
		IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable,
		ModelClassType modelClassType) {
		return false;
	}

	// 下面所有return false的方法都不生成。这些都是基础的CURD方法，使用通用Mapper实现
	@Override
	public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, TopLevelClass topLevelClass,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientInsertMethodGenerated(Method method, TopLevelClass topLevelClass,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientInsertSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, TopLevelClass topLevelClass,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method,
		TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method,
		TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method,
		TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientDeleteByPrimaryKeyMethodGenerated(Method method, Interface interfaze,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientInsertMethodGenerated(Method method, Interface interfaze,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientInsertSelectiveMethodGenerated(Method method, Interface interfaze,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientSelectAllMethodGenerated(Method method, Interface interfaze,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientSelectAllMethodGenerated(Method method, TopLevelClass topLevelClass,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientSelectByPrimaryKeyMethodGenerated(Method method, Interface interfaze,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeySelectiveMethodGenerated(Method method, Interface interfaze,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeyWithBLOBsMethodGenerated(Method method, Interface interfaze,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean clientUpdateByPrimaryKeyWithoutBLOBsMethodGenerated(Method method, Interface interfaze,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean sqlMapBaseColumnListElementGenerated(XmlElement element,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean sqlMapDeleteByPrimaryKeyElementGenerated(XmlElement element,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean sqlMapInsertElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean sqlMapInsertSelectiveElementGenerated(XmlElement element,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean sqlMapSelectAllElementGenerated(XmlElement element,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean sqlMapSelectByPrimaryKeyElementGenerated(XmlElement element,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean sqlMapUpdateByPrimaryKeySelectiveElementGenerated(XmlElement element,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean sqlMapUpdateByPrimaryKeyWithBLOBsElementGenerated(XmlElement element,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean sqlMapUpdateByPrimaryKeyWithoutBLOBsElementGenerated(XmlElement element,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean providerGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean providerApplyWhereMethodGenerated(Method method, TopLevelClass topLevelClass,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean providerInsertSelectiveMethodGenerated(Method method, TopLevelClass topLevelClass,
		IntrospectedTable introspectedTable) {
		return false;
	}

	@Override
	public boolean providerUpdateByPrimaryKeySelectiveMethodGenerated(Method method,
		TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		return false;
	}

}

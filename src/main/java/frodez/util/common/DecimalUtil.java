package frodez.util.common;

import frodez.util.constant.setting.DefDecimal;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DecimalUtil {

	/**
	 * 标准化
	 * @author Frodez
	 * @date 2019-01-28
	 */
	public static BigDecimal normalize(BigDecimal decimal) {
		Objects.requireNonNull(decimal);
		return decimal.setScale(DefDecimal.PRECISION, DefDecimal.ROUND_MODE);
	}

	/**
	 * 标准化
	 * @author Frodez
	 * @date 2019-01-28
	 */
	public static BigDecimal normalize(Integer value) {
		Objects.requireNonNull(value);
		return new BigDecimal(value).setScale(DefDecimal.PRECISION, DefDecimal.ROUND_MODE);
	}

	/**
	 * 标准化
	 * @author Frodez
	 * @date 2019-01-28
	 */
	public static BigDecimal normalize(Double value) {
		Objects.requireNonNull(value);
		return new BigDecimal(value).setScale(DefDecimal.PRECISION, DefDecimal.ROUND_MODE);
	}

	/**
	 * 标准化
	 * @author Frodez
	 * @date 2019-01-28
	 */
	public static BigDecimal normalize(Long value) {
		Objects.requireNonNull(value);
		return new BigDecimal(value).setScale(DefDecimal.PRECISION, DefDecimal.ROUND_MODE);
	}

	/**
	 * 标准化
	 * @author Frodez
	 * @date 2019-01-28
	 */
	public static BigDecimal normalize(String value) {
		Objects.requireNonNull(value);
		return new BigDecimal(value).setScale(DefDecimal.PRECISION, DefDecimal.ROUND_MODE);
	}

	/**
	 * 批量相加并标准化,第一个数为被加数
	 * @author Frodez
	 * @date 2019-01-28
	 */
	public static BigDecimal add(BigDecimal first, BigDecimal... args) {
		return add(true, first, args);
	}

	/**
	 * 批量相加,第一个数为被加数
	 * @param normalized 是否进行标准化, true为进行标准化,false为不进行标准化
	 * @author Frodez
	 * @date 2019-01-28
	 */
	public static BigDecimal add(boolean normalized, BigDecimal first, BigDecimal... args) {
		BigDecimal result = first;
		for (int i = 0; i < args.length; i++) {
			result = result.add(args[i]);
		}
		if (normalized) {
			return DecimalUtil.normalize(result);
		}
		return result;
	}

	/**
	 * 批量相减并标准化,第一个数为被减数
	 * @author Frodez
	 * @date 2019-01-28
	 */
	public static BigDecimal subtract(BigDecimal first, BigDecimal... args) {
		return subtract(true, first, args);
	}

	/**
	 * 批量相减,第一个数为被减数
	 * @param normalized 是否进行标准化, true为进行标准化,false为不进行标准化
	 * @author Frodez
	 * @date 2019-01-28
	 */
	public static BigDecimal subtract(boolean normalized, BigDecimal first, BigDecimal... args) {
		BigDecimal result = first;
		for (int i = 0; i < args.length; i++) {
			result = result.subtract(args[i]);
		}
		if (normalized) {
			return DecimalUtil.normalize(result);
		}
		return result;
	}

	/**
	 * 批量相乘并标准化,第一个数为被乘数
	 * @author Frodez
	 * @date 2019-01-28
	 */
	public static BigDecimal multiply(BigDecimal first, BigDecimal... args) {
		return multiply(true, first, args);
	}

	/**
	 * 批量相乘,第一个数为被乘数
	 * @param normalized 是否进行标准化, true为进行标准化,false为不进行标准化
	 * @author Frodez
	 * @date 2019-01-28
	 */
	public static BigDecimal multiply(boolean normalized, BigDecimal first, BigDecimal... args) {
		BigDecimal result = first;
		for (int i = 0; i < args.length; i++) {
			result = result.multiply(args[i]);
		}
		if (normalized) {
			return DecimalUtil.normalize(result);
		}
		return result;
	}

	/**
	 * 批量相除并标准化,第一个数为被除数
	 * @author Frodez
	 * @date 2019-01-28
	 */
	public static BigDecimal divide(BigDecimal first, BigDecimal... args) {
		return divide(true, first, args);
	}

	/**
	 * 批量相除,第一个数为被除数
	 * @param normalized 是否进行标准化, true为进行标准化,false为不进行标准化
	 * @author Frodez
	 * @date 2019-01-28
	 */
	public static BigDecimal divide(boolean normalized, BigDecimal first, BigDecimal... args) {
		BigDecimal result = first;
		int precision = args.length + DefDecimal.PRECISION;
		for (int i = 0; i < args.length; i++) {
			result = result.divide(args[i], precision, DefDecimal.ROUND_MODE);
		}
		if (normalized) {
			return DecimalUtil.normalize(result);
		}
		return result;
	}

}

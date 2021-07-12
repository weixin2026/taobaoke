package com.jjld.coupon.framework.enums;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通用枚举，适用于true/false的场景
 *
 * @author SongFei
 * @date 2019/11/18 23:12
 */
@Getter
@AllArgsConstructor
public enum YesOrNoEnum {

    /**
     * 是
     */
    YES(1, "是"),

    /**
     * 否
     */
    NO(0, "否");

    private Integer value;
    private String desc;

    public static YesOrNoEnum transform(Integer value) {
        if (value == null) {
            return null;
        }
        for (YesOrNoEnum anEnum : YesOrNoEnum.values()) {
            if (Objects.equals(anEnum.value, value)) {
                return anEnum;
            }
        }
        return null;
    }

}

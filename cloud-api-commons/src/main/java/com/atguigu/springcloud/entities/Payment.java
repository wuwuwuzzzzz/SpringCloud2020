package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: wxz
 * @Date: 2022/9/15 14:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 流水
     */
    private String serial;
}

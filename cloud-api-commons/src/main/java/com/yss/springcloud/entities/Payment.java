package com.yss.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: ymx
 * @date: 2022/8/27
 * @description: 实体类Payment
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment  implements Serializable {
    private Long id;
    private String serial;
}

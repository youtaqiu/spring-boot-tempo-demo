package me.youm.demo.tempo.order.model;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author youta
 */
@Data
@Accessors(chain = true)
public class OrderVO {

    private String userId;

    private String orderNo;

    private Integer orderState;

    private String username;
}

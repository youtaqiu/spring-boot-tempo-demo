package me.youm.demo.tempo.order.service;

import lombok.AllArgsConstructor;
import me.youm.demo.tempo.api.UserClient;
import me.youm.demo.tempo.model.UserInfo;
import me.youm.demo.tempo.order.domain.Order;
import me.youm.demo.tempo.order.domain.OrderRepo;
import me.youm.demo.tempo.order.model.OrderVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import cn.hutool.core.util.IdUtil;


/**
 * @author youta
 */
@Service
@AllArgsConstructor
public class OrderService {

    private final UserClient userClient;
    private final OrderRepo orderRepo;

    public OrderVO one(String orderNo) {
        Order order = orderRepo.findByOrderNo(orderNo)
                .orElse(orderRepo.save(Order.builder()
                        .orderNo(orderNo)
                        .orderState(1)
                        .userId(IdUtil.objectId())
                        .build()));
        UserInfo userInfo = this.userClient.findByUserId(order.getUserId());
        var orderVO = new OrderVO();
        BeanUtils.copyProperties(order,orderVO);
        orderVO.setUsername(userInfo.getUserName());
        return orderVO;
//        return orderRepo.findByOrderNo(orderNo)
//                .switchIfEmpty(orderRepo.save(Order.builder()
//                        .orderNo(orderNo)
//                        .userId(IdUtil.simpleUUID())
//                        .build()))
//                .flatMap(order ->
//                        this.userClient.findByUserId(order.getUserId())
//                                .map(userInfo ->
//                                        BeanUtil.copyProperties(order, OrderVO.class)
//                                                .setUsername(userInfo.getUsername()))
//                );
    }
}

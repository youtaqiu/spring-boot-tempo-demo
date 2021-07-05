package me.youm.demo.tempo.order.web;

import lombok.AllArgsConstructor;
import me.youm.demo.tempo.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author youta
 */
@RestController
@RequestMapping("order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("{orderNo}")
    public HashMap<Object, Object> test(@PathVariable("orderNo") String orderNo){
        if (orderNo.length() < 5) {
            throw new IllegalArgumentException("Illegal argument value");
        }
        var map = new HashMap<>();
        map.put("result",orderService.one(orderNo));
        return map;
    }
}

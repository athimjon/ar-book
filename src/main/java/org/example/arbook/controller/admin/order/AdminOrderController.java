package org.example.arbook.controller.admin.order;

import lombok.RequiredArgsConstructor;
import org.example.arbook.model.dto.response.order.AcceptedOrderRes;
import org.example.arbook.model.dto.response.order.OrderRes;
import org.example.arbook.service.interfaces.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.example.arbook.util.ApiConstants.*;

/**
 * Admin Controller for handling order endpoints.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(API + V1 + ADMIN + ORDER)
public class AdminOrderController {

    private final OrderService orderService;

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderRes> getOrderRes(@PathVariable Long orderId) {
        System.out.println("ishladi");
        OrderRes order = orderService.getOrderRes(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/accepted/{orderId}")
    public ResponseEntity<AcceptedOrderRes> getAcceptedOrderRes(@PathVariable Long orderId) {
        System.out.println("ishladi");
        AcceptedOrderRes order = orderService.getAcceptedOrderRes(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/by-name/{orderName}")
    public ResponseEntity<OrderRes> getOrderResByName(@PathVariable String orderName) {
        OrderRes order = orderService.getOrderResByName(orderName);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/accept/{orderId}")
    public ResponseEntity<AcceptedOrderRes> acceptOrder(@PathVariable Long orderId) {
        AcceptedOrderRes acceptOrder = orderService.acceptOrderAndGetQrCodes(orderId);
        return new ResponseEntity<>(acceptOrder, HttpStatus.ACCEPTED);
    }

    @PutMapping("/decline/{orderId}")
    public ResponseEntity<OrderRes> declineOrder(@PathVariable Long orderId) {
        OrderRes order = orderService.declineOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.ACCEPTED);
    }
}

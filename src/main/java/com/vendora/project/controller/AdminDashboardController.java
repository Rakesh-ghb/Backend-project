package com.vendora.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendora.project.dto.AdminDashboardResponse;
import com.vendora.project.entity.Order;
import com.vendora.project.entity.Payment;
import com.vendora.project.entity.User;
import com.vendora.project.repository.OrderRepository;
import com.vendora.project.repository.PaymentRepository;
import com.vendora.project.repository.ProjectRepository;
import com.vendora.project.repository.UserRepository;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminDashboardController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private PaymentRepository paymentRepo;

    // ==========================
    // ADMIN DASHBOARD STATS
    // ==========================
    @GetMapping("/dashboard")
    public AdminDashboardResponse dashboard() {

        return new AdminDashboardResponse(
            userRepo.count(),
            projectRepo.count(),
            orderRepo.count(),
            paymentRepo.count()
        );
    }

    // ==========================
    // GET ALL USERS
    // ==========================
    @GetMapping("/users")
    public List<User> users() {
        return userRepo.findAll();
    }

    // ==========================
    // GET ALL ORDERS
    // ==========================
    @GetMapping("/orders")
    public List<Order> orders() {
        return orderRepo.findAll();
    }

    // ==========================
    // GET ALL PAYMENTS
    // ==========================
    @GetMapping("/payments")
    public List<Payment> payments() {
        return paymentRepo.findAll();
    }
}

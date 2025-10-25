package com.example.help.center.subsciption.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.help.center.subsciption.entity.SubscriptionPlan;
import com.example.help.center.subsciption.service.SubscriptionPlanService;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionPlanController {

    private final SubscriptionPlanService subscriptionPlanService;

    public SubscriptionPlanController(SubscriptionPlanService subscriptionPlanService) {
        this.subscriptionPlanService = subscriptionPlanService;
    }

    @GetMapping
    public ResponseEntity<List<SubscriptionPlan>> getAllPlans() {
        return ResponseEntity.ok(subscriptionPlanService.getAllPlans());
    }

    @PostMapping
    public ResponseEntity<String> createPlan(@RequestBody SubscriptionPlan plan) {
        subscriptionPlanService.createPlan(plan);
        return ResponseEntity.ok("Subscription plan created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePlan(@PathVariable Long id, @RequestBody SubscriptionPlan plan) {
        plan.setId(id);
        subscriptionPlanService.updatePlan(plan);
        return ResponseEntity.ok("Plan updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlan(@PathVariable Long id) {
        subscriptionPlanService.deletePlan(id);
        return ResponseEntity.ok("Plan deleted successfully");
    }
}

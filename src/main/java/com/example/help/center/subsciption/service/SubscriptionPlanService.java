package com.example.help.center.subsciption.service;

import java.util.List;

import com.example.help.center.subsciption.entity.SubscriptionPlan;

public interface SubscriptionPlanService {
    void createPlan(SubscriptionPlan plan);
    SubscriptionPlan getPlanById(Long id);
    List<SubscriptionPlan> getAllPlans();
    void updatePlan(SubscriptionPlan plan);
    void deletePlan(Long id);
}


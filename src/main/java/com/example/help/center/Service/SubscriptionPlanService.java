package com.example.help.center.Service;

import com.example.help.center.entity.SubscriptionPlan;
import java.util.List;

public interface SubscriptionPlanService {
    void createPlan(SubscriptionPlan plan);
    SubscriptionPlan getPlanById(Long id);
    List<SubscriptionPlan> getAllPlans();
    void updatePlan(SubscriptionPlan plan);
    void deletePlan(Long id);
}


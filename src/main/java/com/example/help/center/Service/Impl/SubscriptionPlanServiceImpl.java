package com.example.help.center.Service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.help.center.Repository.SubscriptionPlanRepository;
import com.example.help.center.Service.SubscriptionPlanService;
import com.example.help.center.entity.SubscriptionPlan;

import java.util.List;

@Service
@Transactional
public class SubscriptionPlanServiceImpl implements SubscriptionPlanService {

    private final SubscriptionPlanRepository mapper;

    public SubscriptionPlanServiceImpl(SubscriptionPlanRepository mapper) {
        this.mapper = mapper;
    }

    @Override
    public void createPlan(SubscriptionPlan plan) {
        mapper.insert(plan);
    }

    @Override
    public SubscriptionPlan getPlanById(Long id) {
        return mapper.findById(id);
    }

    @Override
    public List<SubscriptionPlan> getAllPlans() {
        return mapper.findAll();
    }

    @Override
    public void updatePlan(SubscriptionPlan plan) {
        mapper.update(plan);
    }

    @Override
    public void deletePlan(Long id) {
        mapper.delete(id);
    }
}

package com.example.lab14.specs;

import com.example.lab14.entity.Manufacture;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ManufactureSpec {
    public static Specification<Manufacture> sortBy(String attributeName) {
        return new Specification<Manufacture>() {
            @Override
            public Predicate toPredicate(Root<Manufacture> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.orderBy(criteriaBuilder.asc(root.get(attributeName)));
                return null;
            }
        };
    }
}

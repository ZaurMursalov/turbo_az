package com.example.msturboaz.specification;

import com.example.msturboaz.entity.CarEntity;
import com.example.msturboaz.model.request.CarSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CarSpecification implements Specification<CarEntity> {
    private final CarSearchRequest carCriteria;
    private static final String AMOUNT="amount";
    private static final String DESCRIPTION="description";

    @Override
    public Predicate toPredicate(Root<CarEntity> root,
                                 CriteriaQuery<?> query,
                                 CriteriaBuilder criteriaBuilder) {

        List<Predicate>predicates=new ArrayList<>();
        if (carCriteria!=null){
            if (carCriteria.getAmountFrom()!=null){
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(AMOUNT),
                        carCriteria.getAmountFrom()));
            }
            if (carCriteria.getAmountTo()!=null){
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(AMOUNT),
                        carCriteria.getAmountTo()));
            }
            if (StringUtils.hasText(carCriteria.getDescription()));


        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}

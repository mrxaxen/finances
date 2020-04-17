/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.finances.specifications;

import hu.elte.finances.entities.Transaction;
import hu.elte.finances.entities.metamodels.Transaction_;
import java.util.ArrayList;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author Xaxen
 */
public class TransactionSpecification implements Specification<Transaction> {
    
    private final Transaction criteria;
    
    public TransactionSpecification(Transaction criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Transaction> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        ArrayList<Predicate> predicates = new ArrayList<>();
        if(criteria.getCreationDate() != null) {            
            predicates.add(builder.equal(root.get(Transaction_.creationDate), criteria.getCreationDate()));
        }
        if(criteria.getChange() != null) {
            predicates.add(builder.equal(root.get(Transaction_.change), criteria.getChange()));
        }
        return predicates.isEmpty() ? null : getPred(predicates, builder);
    }
    
    private Predicate getPred(ArrayList<Predicate> predicates, CriteriaBuilder builder) {
        Predicate result = null;
        for(Predicate p : predicates) {
            result = builder.and(p);
        }
        return result;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.finances.entities.metamodels;

import hu.elte.finances.entities.Transaction;
import hu.elte.finances.entities.User;
import java.util.Date;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Transaction.class)
public class Transaction_ {
    public static volatile SingularAttribute<Transaction, Integer> id;
    public static volatile SingularAttribute<Transaction, User> user;
    public static volatile SingularAttribute<Transaction, Date> creationDate;
    public static volatile SingularAttribute<Transaction, Integer> change;
}

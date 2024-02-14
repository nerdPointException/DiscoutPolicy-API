package api.discount.domain.discountPolicy;

import api.discount.domain.ShoppingCartItem;
import api.discount.model.Money;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
@Getter
public abstract class DiscountCondition {

    @Id
    @GeneratedValue
    @Column(name = "discount_condition_id")
    private Long id;

    protected abstract boolean isSatisfying(ShoppingCartItem target);

    public abstract Money decideDiscountRange(ShoppingCartItem target);

}

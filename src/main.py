import math

# Declared important variables
product_A = 20
product_B = 40
product_C = 50
quantity_A = 0
quantity_B = 0
quantity_C = 0
wrap_gift = ""

# Method for flat 10 discount
def flat_10_discount(total_cart_amount):
    print(f"Flat 10 discount applicable and discount amount is: ${10}")
    return total_cart_amount - 10

# Method for bulk 5 discount
def bulk_5_discount(amount):
    discounted_5_amount = amount - (amount * 5 / 100)
    print(f"Bulk 5 discount applicable and discounted amount is: ${discounted_5_amount}")
    return discounted_5_amount

# Method for bulk 10 discount
def bulk_10_discount(amount):
    discounted_10_amount = amount - (amount * 10 / 100)
    print(f"Bulk 10 discount applicable and discounted amount is: ${discounted_10_amount}")
    return discounted_10_amount

# Method for tiered 50 discount
def tiered_50_discount():
    discounted_amount_A = 0
    discounted_amount_B = 0
    discounted_amount_C = 0

    if quantity_A > 15:
        extra_quantity_A = quantity_A - 15
        amount_A = product_A * extra_quantity_A
        discounted_amount_A = amount_A - (amount_A * 50 / 100)
        print(f"Tiered 50 discount applicable and discounted amount of A is: ${discounted_amount_A}")

    if quantity_B > 15:
        extra_quantity_B = quantity_B - 15
        amount_B = product_B * extra_quantity_B
        discounted_amount_B = amount_B - (amount_B * 50 / 100)
        print(f"Tiered 50 discount applicable and discounted amount of B is: ${discounted_amount_B}")

    if quantity_C > 15:
        extra_quantity_C = quantity_C - 15
        amount_C = product_C * extra_quantity_C
        discounted_amount_C = amount_C - (amount_C * 50 / 100)
        print(f"Tiered 50 discount applicable and discounted amount of C is: ${discounted_amount_C}")

    return discounted_amount_A + discounted_amount_B + discounted_amount_C

# Method for calculating cart amount
def cart_amount():
    amount_A = product_A * quantity_A
    amount_B = product_B * quantity_B
    amount_C = product_C * quantity_C
    total_cart_amount = amount_A + amount_B + amount_C
    total_quantity = quantity_A + quantity_B + quantity_C
    amount_with_flat_10_discount = 0
    amount_with_bulk_5_discount = 0
    amount_with_bulk_10_discount = 0
    total_amount_with_tiered_50_discount = 0

    print(f"Product name is A and quantity is {quantity_A} and total amount of A is: ${amount_A}")
    print(f"Product name is B and quantity is {quantity_B} and total amount of B is: ${amount_B}")
    print(f"Product name is C and quantity is {quantity_C} and total amount of C is: ${amount_C}")
    print(f"Subtotal amount is: ${total_cart_amount}")

    if total_cart_amount > 200:
        amount_with_flat_10_discount = flat_10_discount(total_cart_amount)

    if 10 < quantity_A <= 20:
        amount_with_bulk_5_discount += bulk_5_discount(amount_A)

    if 10 < quantity_B <= 20:
        amount_with_bulk_5_discount += bulk_5_discount(amount_B)

    if 10 < quantity_C <= 20:
        amount_with_bulk_5_discount += bulk_5_discount(amount_C)

    if quantity_A > 20:
        amount_with_bulk_10_discount += bulk_10_discount(amount_A)

    if quantity_B > 20:
        amount_with_bulk_10_discount += bulk_10_discount(amount_B)

    if quantity_C > 20:
        amount_with_bulk_10_discount += bulk_10_discount(amount_C)

    if total_quantity > 30 and (quantity_A > 15 or quantity_B > 15 or quantity_C > 15):
        total_amount_with_tiered_50_discount = tiered_50_discount()

    return discount_applied(amount_with_flat_10_discount, amount_with_bulk_5_discount, amount_with_bulk_10_discount,
                             total_amount_with_tiered_50_discount)

# Method for calculating which discount is best applicable
def discount_applied(amount_with_flat_10_discount, amount_with_bulk_5_discount, amount_with_bulk_10_discount,
                     total_amount_with_tiered_50_discount):
    if amount_with_bulk_5_discount > amount_with_bulk_10_discount and amount_with_bulk_5_discount > total_amount_with_tiered_50_discount:
        print("Discount applicable is bulk 5")
        return amount_with_flat_10_discount - amount_with_bulk_5_discount
    elif amount_with_bulk_10_discount > amount_with_bulk_5_discount and amount_with_bulk_10_discount > total_amount_with_tiered_50_discount:
        print("Discount applicable is bulk 10")
        return amount_with_flat_10_discount - amount_with_bulk_10_discount
    print("Discount applicable is tiered 50")
    return amount_with_flat_10_discount - total_amount_with_tiered_50_discount

# Method for wrap_gift_amount
def wrap_gift_amount():
    total_gift_wrap_fee = quantity_A + quantity_B + quantity_C
    print(f"Total gift wrapping fee is: ${total_gift_wrap_fee}")
    return total_gift_wrap_fee

# Method for shipping fee amount
def shipping_fee():
    total_quantity = quantity_A + quantity_B + quantity_C
    total_shipping_fee = 5 * (math.ceil(total_quantity / 10.0) * 10)
    print(f"Shipping fee: ${total_shipping_fee}")
    return total_shipping_fee

# Method which calculates the total amount
def zennode():
    global quantity_A, quantity_B, quantity_C
    quantity_A = int(input("Enter the quantity for Product A: "))
    quantity_B = int(input("Enter the quantity for Product B: "))
    quantity_C = int(input("Enter the quantity for Product C: "))
    global wrap_gift
    wrap_gift = input("Want to wrap as a gift? Y for Yes, N for No: ")
    
    cart_amt = cart_amount()
    total_gift_wrap_fee = 0
    total_shipping_fee = 0

    if wrap_gift.upper() == "Y":
        total_gift_wrap_fee = wrap_gift_amount()

    total_shipping_fee = shipping_fee()
    total_amount = int(cart_amt + total_shipping_fee + total_gift_wrap_fee)
    print(f"Total amount is: ${total_amount}")

if __name__ == "__main__":
    zennode()

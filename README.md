# VendingMachine

There are three available options in Vending Machine: coke, gum or chips, when customer wish to get one of this product, customer is required to
insert amount of money in decimal. 

For instance, after running it on IntelliJ IDEA 15.0.3, here's what it looks like after running it:

```
Which product that you want? write cola chips or gum
```

Input would be one of them, take as an example cola:

```
Please insert this amount: 1.45
```

This returns change if too much money is provided, or ask for more money if insufficient funds have been inserted.
The change will be of denominations 1p, 2p, 5p, 10p, 20p, 50p, £1, £2.

ps: synchronized method for adding product is available for future use (eg other thread trying to add at the same time)

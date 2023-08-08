"""Practice Exercise -1
Make a class that represents a bank account. Create four methods named set_details, display, withdraw and deposit.
In the set_details method, create two instance variables : name and balance. The default value for balance should be zero.
In the display method, display the values of these two instance variables.
Both the methods withdraw and deposit have amount as parameter. Inside withdraw, subtract the amount from balance and inside deposit,
add the amount to the balance. Create two instances of this class and call the methods on those instances."""

#course
class BankAccount:
    def set_details(self, name, balance=0):
        self.name = name
        self.balance = balance

    def display(self):
        print(self.name, self.balance)

    def withdraw(self, amount):
        self.balance -= amount

    def deposit(self, amount):
        self.balance += amount


a1 = BankAccount()
a1.set_details('Mike', 200)

a2 = BankAccount()
a2.set_details('Tom')

a1.display()
a2.display()

a1.withdraw(100)
a2.deposit(500)

a1.display()
a2.display()

#gpt
"""class BankAccount:

    def set_details(self, name):
        self.name = name
        self.balance = 0

    def display(self):
        print("Account Holder's Name:", self.name)
        print("Balance:", self.balance)

    def withdraw(self, amount):
        if amount <= self.balance:
            self.balance -= amount
        else:
            print("Insufficient balance!")

    def deposit(self, amount):
        self.balance += amount

# Crear dos instancias de la clase BankAccount
b1 = BankAccount()
b2 = BankAccount()

# Establecer detalles y realizar transacciones en la primera cuenta
b1.set_details("Account 1")
b1.display()
b1.deposit(1000)
b1.display()
b1.withdraw(500)
b1.display()

# Establecer detalles y realizar transacciones en la segunda cuenta
b2.set_details("Account 2")
b2.display()
b2.deposit(500)
b2.display()
b2.withdraw(200)
b2.display()"""


"""class BankAccount:

    def set_details(self, name):
        self.name=name
        self.balance=0
    def display(self):
        print("Names' account ", self.name, "\nIts balance ", self. balance)

    def withdraw(self,new_balance):
        self.balance-=new_balance
    def deposit(self,new_balance):
        self.balance += new_balance
b1=BankAccount()
b2=BankAccount()"""


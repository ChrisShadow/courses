"""Class variable is defined outside any method in contrast the instance variable which it is defines for every objecto of the class
To make a method that needs to access instance variables"""
"""With class methods, it only works with class variables. The factory method gives an alternative way to initialize instances by a list, dict...
To make a method that needs to use only class variables"""
"""static method with decorator, to make one that needs to use neither class nor instance variables. Like a regular function
but it belongs to the class namespace(definitions of class"""

#Practice Exercise - 3
"""1. This is a function to find the highest common factor of two numbers   

     def hcf(x,y):
            x=abs(x)
            y=abs(y)
            smaller = y if x>y else x
            s = smaller
            while s>0:
                if x%s==0 and y%s==0:
                    break
                s-=1
            return s

Make it a static method in the Fraction class that you had written in earlier exercise."""
#Teacher answers
"""
@staticmethod
def hcf(x, y):
    x = abs(x)
    y = abs(y)
    smaller = y if x > y else x
    s = smaller
    while s > 0:
        if x % s == 0 and y % s == 0:
            break
        s -= 1
    return s
"""

"""2. In your Fraction class, write a private instance method _reduce that reduces a fraction to its lowest terms. 
To reduce a Fraction to its lowest terms you have to divide the numerator and denominator by the highest common factor. 
Call this method in __init__and also call it on the resultant fraction in methods multiply and add."""
"""
    class Fraction:
        def __init__(self,nr,dr=1):
            self.nr = nr
            self.dr = dr
            if self.dr < 0:  
                self.nr *= -1
                self.dr *= -1
            self._reduce()
     
        def show(self):
            print(f'{self.nr}/{self.dr}')
     
        def multiply(self,other):
            if isinstance(other,int):
                other = Fraction(other)
            f = Fraction(self.nr * other.nr , self.dr * other.dr)
            f._reduce()
            return f
            
        def add(self,other):
            if isinstance(other,int):
                other = Fraction(other)
            f = Fraction(self.nr * other.dr + other.nr * self.dr, self.dr * other.dr)
            f._reduce()
            return f
     
        def _reduce(self):
            h = Fraction.hcf(self.nr, self.dr)
            if h == 0:
                return
            
            self.nr //= h
            self.dr //= h
            
        @staticmethod
        def hcf(x,y):
            x=abs(x)
            y=abs(y)
            smaller = y if x>y else x
            s = smaller
            while s>0:
                if x%s==0 and y%s==0:
                    break
                s-=1
            return s
     
           
    f1 = Fraction(6,36)
    f1.show()
    f2 = Fraction(2,-12)
    f2.show()
    f3 = f1.multiply(f2)
    f3.show()
    f3 = f1.add(f2)
    f3.show()
    f3 = f1.add(5) 
    f3.show()
    f3 = f1.multiply(5) 
    f3.show()
"""

"""3. In the following class SalesPerson, add two class variables named total_revenue and names. The variable names 
should be a list that contains names of all salespersons and total_revenue should contain the total sales amount of all 
the salespersons. 

    class SalesPerson:   
        def __init__(self,name,age):
            self.name = name
            self.age = age
            self.sales_amount = 0
     
        def make_sale(self,money):
            self.sales_amount += money
     
        def show(self):
            print(self.name, self.age, self.sales_amount)
     
    s1 = SalesPerson('Bob', 25)
    s2 = SalesPerson('Ted', 22)
    s3 = SalesPerson('Jack', 27)
     
    s1.make_sale(1000)
    s1.make_sale(1200)
    s2.make_sale(5000)
    s3.make_sale(3000)
    s3.make_sale(8000)
     
    s1.show()
    s2.show()
    s3.show()"""
"""
    class SalesPerson:    
        total_revenue = 0
        names = []
        
        def __init__(self,name,age):
            self.name = name
            self.age = age
            self.sales_amount = 0
            SalesPerson.names.append(name)
     
        def make_sale(self,money):
            self.sales_amount += money
            SalesPerson.total_revenue += money
     
        def show(self):
            print(self.name, self.age, self.sales_amount)
     
    s1 = SalesPerson('Bob', 25)
    s2 = SalesPerson('Ted', 22)
    s3 = SalesPerson('Jack', 27)
                
    s1.make_sale(1000)
    s1.make_sale(1200)
    s2.make_sale(5000)
    s3.make_sale(3000)
    s3.make_sale(8000)
     
    s1.show()
    s2.show()
    s3.show()
     
    print(SalesPerson.total_revenue)
    print(SalesPerson.names)

"""
    
""" 4. Add a class variable named domains to the following Employee class. Make this class variable 
a set and it should store all domain names used by employees.

    class Employee:    
        def __init__(self,name,email):
            self.name = name
            self.email = email
       
       def display(self):
            print(self.name, self.email)
                
    e1 = Employee('John','john@gmail.com')
    e2 = Employee('Jack','jack@yahoo.com')
    e3 = Employee('Jill','jill@outlook.com')
    e4 = Employee('Ted','ted@yahoo.com')
    e5 = Employee('Tim','tim@gmail.com')
    e6 = Employee('Mike','mike@yahoo.com')"""
"""
    class Employee:
        domains = set()
        
        def __init__(self,name,email):
            self.name = name
            self.email = email
            domain = email[email.index('@')+1 : ]
            Employee.domains.add(domain)
       
        def display(self):
            print(self.name, self.email)
                 
    e1 = Employee('John','john@gmail.com')
    e2 = Employee('Jack','jack@yahoo.com')
    e3 = Employee('Jill','jill@outlook.com')
    e4 = Employee('Ted','ted@yahoo.com')
    e5 = Employee('Tim','tim@gmail.com')
    e6 = Employee('Mike','mike@yahoo.com')
     
    print(Employee.domains)
"""
    

"""5. In the following Employee class, add a class variable named allowed_domains.

    allowed_domains = {'yahoo.com', 'gmail.com', 'outlook.com'}

Whenever an email is assigned, if the domain named is not in allowed_domains, raise a RuntimeError.

    class Employee:
     
        def __init__(self,name,email):
            self.name = name
            self.email = email
     
        def display(self):
            print(self.name, self.email)
     
    e1 = Employee('John','john@gmail.com')
    e2 = Employee('Jack','jack@yahoo.com')
    e3 = Employee('Jill','jill@outlook.com')
    e4 = Employee('Ted','ted@yahoo.com')
    e5 = Employee('Tim','tim@xmail.com')"""
"""
    class Employee:
        allowed_domains = {'yahoo.com', 'gmail.com', 'outlook.com'}
        
        def __init__(self,name,email):
            self.name = name
            self.email = email
       
        def display(self):
            print(self.name, self.email)
     
        @property
        def email(self):
            return self._email
     
        @email.setter
        def email(self, new_email):
            domain = new_email[new_email.index('@')+1 : ]
            if domain in Employee.allowed_domains:
                self._email = new_email
            else:
                raise RuntimeError(f'Domain {domain} is not allowed')
                
    e1 = Employee('John','john@gmail.com')
    e2 = Employee('Jack','jack@yahoo.com')
    e3 = Employee('Jill','jill@outlook.com')
    e4 = Employee('Ted','ted@yahoo.com')
    e5 = Employee('Tim','tim@xmail.com')
    e5.display()
     
    e4.email = 'ted@ymail.com'
    e4.display()
     
    e3.email = 'jill@gmail.com'
    e3.display()
"""
    

"""6. The following program shows implementation of Stack Abstract data type using list. In a stack, elements 
are pushed and popped from one end of the stack which is called the top of the stack.

This implementation has no maximum limit on the size of the stack. You have to introduce a maximum limit by 
adding a class variable named MAX_SIZE. In the push method, before inserting a new element, check the size
 of the stack and raise a RuntimeError if the stack is full. 

    class Stack:        
        def __init__(self):
            self.items = []
     
        def is_empty(self):
            return self.items == []
     
        def size(self):
            return len(self.items)
     
        def push(self, item):
            self.items.append(item)
     
        def pop(self):
            if self.is_empty():
                raise RuntimeError("Stack is empty")
            return self.items.pop()
        
        def display(self):
            print(self.items)
     
    if __name__ == "__main__":
        st = Stack()
     
        while True:
            print("1.Push") 
            print("2.Pop") 
            print("3.Peek") 
            print("4.Size")
            print("5.Display") 
            print("6.Quit")
             
            choice = int(input("Enter your choice : "))
     
            if choice == 1:
                x=int(input("Enter the element to be pushed : "))
                st.push(x) 
            elif choice == 2:
                x=st.pop() 
                print("Popped element is : " , x) 
            elif choice == 3:
                print("Element at the top is : " , st.peek()) 
            elif choice == 4:
                print("Size of stack " , st.size()) 
            elif choice == 5:
                st.display()         
            elif choice == 6:
              break;
            else:
              print("Wrong choice") 
            print() """

"""
class Stack:
    MAX_SIZE = 5

    def __init__(self):
        self.items = []

    def is_empty(self):
        return self.items == []

    def size(self):
        return len(self.items)

    def push(self, item):
        if self.size() == Stack.MAX_SIZE:
            raise RuntimeError('Stack is full')
        self.items.append(item)

    def pop(self):
        if self.is_empty():
            raise RuntimeError("Stack is empty")
        return self.items.pop()

    def display(self):
        print(self.items)

    def peek_top(self):
        if not self.is_empty():
            return self.items[len(st.items)-1]
        else:
            raise RuntimeError("Stack is empty")

    def peek_down(self):
        if not self.is_empty():
            return self.items[0]
        else:
            raise RuntimeError("Stack is empty")


if __name__ == "__main__":
    st = Stack()
while True:
    try:
        print("1.Push")
        print("2.Pop")
        print("3.Peek top")
        print("4.Size")
        print("5.Display")
        print("6.Peek down")
        print("7.Quit")

        choice = int(input("Enter your choice : "))

        if choice == 1:
            x = int(input("Enter the element to be pushed : "))
            st.push(x)
        elif choice == 2:
            x = st.pop()
            print("Popped element is : ", x)
        elif choice == 3:
            print("Element at the top is : ", st.peek_top())
        elif choice == 4:
            print("Size of stack ", st.size())
        elif choice == 5:
            st.display()
        elif choice == 6:
            print("Element at the bottom is : ", st.peek_down())
        elif choice == 7:
            break
        else:
            print("Wrong choice")
        print()
    except (Exception, OSError) as error:
        print(error,"\nIntente de vuelta\n")
    #finally:
        #continue
"""

"""7. Class variables with immutable values can be used as defaults for instance variables. In the 
following BankAccount class, add an instance variable named bank in the __init__method. Add a class variable 
bank_name that will be used as default argument in the __init__  method for bank parameter.

    class BankAccount:
     
        def __init__(self, name, balance=0):
            self.name = name
            self.balance = balance
            
        def display(self):
             print(self.name, self.balance)
     
        def withdraw(self, amount):
            self.balance -= amount
     
        def deposit(self, amount):
            self.balance += amount
        
    a1 = BankAccount('Mike', 200)
    a2 = BankAccount('Tom')
     
    a1.display()
    a2.display()"""
"""
    class BankAccount:
     
        bank_name = 'ABC bank, XYZ Street, New Delhi'
     
        def __init__(self, name, balance=0, bank=bank_name):
            self.name = name
            self.balance = balance
            self.bank = bank
     
        def display(self):
             print(self.name, self.balance, self.bank)
     
        def withdraw(self, amount):
            self.balance -= amount
     
        def deposit(self, amount):
            self.balance += amount
        
    a1 = BankAccount('Mike', 200, 'PQR Bank Delhi')
    a2 = BankAccount('Tom')
     
    a1.display()
    a2.display()
"""

"""
Note
Note that here we could use the class variable bank_name without preceding it with the class name.

Any statements that are written inside the class methods, have to use the fully qualified class variable name, for example MyCLass.x.

Any statement that is at the class level, i.e. outside the class methods should use simply the variable name, not the fully qualified name.

For example -

    class MyClass():
          x = 6
          y = x + 10       

  So here you need to use it as x, not as MyClass.x
"""
#Practice Exercise - 2

"""1.In the BankAccount class that you had created in the previous exercise, delete the set_details() method and create an __init__ method."""


"""2.Create a class named Book with an __init__ method.Inside the __init__ method, create the instance variables isbn, title, author, publisher, pages, price, copies.
Create these four instance objects from this class .
    book1 = Book('957-4-36-547417-1', 'Learn Physics', 'Stephen', 'CBC', 350, 200, 10)
    book2 = Book('652-6-86-748413-3', 'Learn Chemistry', 'Jack', 'CBC', 400, 220, 20)
    book3 = Book('957-7-39-347216-2', 'Learn Maths', 'John', 'XYZ', 500, 300, 5)
    book4 = Book('957-7-39-347216-2', 'Learn Biology', 'Jack', 'XYZ', 400, 200, 6)
Write a method display that prints the isbn, title, price and number of copies of the book."""


"""3.For the Book class that you have created, write a method named in_stock that returns True if number of copies is more than zero, otherwise it returns False.
Create another method named sell that decreases the number of copies by 1 if the book is in stock, otherwise it prints
the message that the book is out of stock."""


"""4.Create a list named books that contains the 4 Book instance objects that you have created in question
2.Iterate over this list using a for loop and call display() for each object in the list.
Write a list comprehension to create another list that contains title of books written by Jack."""


"""5.In the Book class , create a property named price such that the price of a book cannot be less than 50 or more than 1000."""


"""6.Make a class Fraction that contains two instance variables, nr and dr (nr stands for numerator and dr for denominator).
Define an __init__ method that provides values for these instance variables.Make the denominator optional by providing a default argument of 1.
In the __init__ method, make the denominator positive if it is negative.For example - 2 / -3 should be
changed to 2 / 3 and 2 / -3 to - 2 / 3. Write a method named show that prints numerator, then '/' and then the
denominator."""


"""7.Define a method named multiply that multiples two Fraction instance objects.For multiplying two fractions, you have
to multiply the numerator with numerator and denominator with the denominator. Inside the method, create
a newinstance object that is the¡ product of the two fractions and return it.Write your method in such
a way that it supports multiplication of a Fraction by an integer also.Similarly define a method named add
to add two Fraction instance objects.Sum of two fractions n1 / d1 and n2 / d2 is (n1 * d2 + n2 * d1) / (d1 * d2).This method
should also support addition of a Fraction by an
integer. Test your fraction class with this code.
f1 = Fraction(2, 3)
f1.show()
f2 = Fraction(3, 4)
f2.show()
f3 = f1.multiply(f2)
f3.show()
f3 = f1.add(f2)
f3.show()
f3 = f1.add(5)
f3.show()
f3 = f1.multiply(5)
f3.show()
The output that you should get is given below.
2 / 3
3 / 4
6 / 12
17 / 12
17 / 3
10 / 3"""


"""8.For the following class Product, create a read only property named selling_price that is calculated by 
deducting discount from the marked_price.The instance variable discount represents discount in percent.
class Product():
    def __init__(self, id, marked_price, discount):
        self.id = id
        self.marked_price = marked_price
        self.discount = discount

    def display(self):
        print(self.id, self.marked_price, self.discount)
        
p1 = Product('X879', 400, 6)
p2 = Product('A234', 100, 5)
p3 = Product('B987', 990, 4)
p4 = Product('H456', 800, 6)"""


"""9.Suppose after some time, you want to give an additional 2 % discount on a product,
if its price is above 500. To incorporate this change, implement discount as a property in your Product class."""


"""10.Write a Circle class with an instance variable named radius and a method named area.Create two more attributes named diameter and 
circumference and make them behave as read only attributes.Perform data validation on radius, user should not be allowed
to assign a negative value to it. For a circle
diameter = 2 * radius
circumference = 2 * 3.14 * radius
area = 3.14 * radius * radius"""
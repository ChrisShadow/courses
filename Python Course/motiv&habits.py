#La Motiviación es lo que te pone en marcha, el hábito es lo que hace que sigas"
while True: 
    motivation = input("Are you in a good mood to start a project? (Y or N): ")
    if motivation != 'Y' and motivation != 'y':
        print("See you soon!")
        break
    
    habits = input("Enter 1 as your first habit: ")
    try:
        habitN = int(habits)  # Convertir el input a un número entero
        if habitN > 0:
            habitN += 1  # Incrementar el valor de habitN
            print(f"Keep it up! Your next habit is habit #{habitN}.")
        else:
            print("Just start your habit!")
            break
    except ValueError:  # Capturar errores de conversión
        print("Must be only a number. Try again!")
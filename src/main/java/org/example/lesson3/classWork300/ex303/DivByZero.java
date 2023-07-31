package org.example.lesson3.classWork300.ex303;

// 1. Создайте класс исключения, который будет выбрасываться при делении на 0.
// Исключение должно отображать понятное для пользователя сообщение об ошибке.
class DivByZero extends ArithmeticException{
    public DivByZero() {
        super("Деление на 0 запрещено ");
    }
}

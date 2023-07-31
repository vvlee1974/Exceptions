package org.example.lesson3.classWork300.ex303;

// 2. Создайте класс исключений, которое будет возникать при обращении к пустому элементу в массиве ссылочного типа.
// Исключение должно отображать понятное для пользователя сообщение об ошибке.
 class NullPointerArray extends NullPointerException{

    public NullPointerArray(int index) {
        super("Обращение к пустому элементу в массиве запрещено, индекс элемента " + index);
    }

    public NullPointerArray() {
        super("Обращение к пустому элементу в массиве запрещено");
    }
}

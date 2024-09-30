public class Main {
    public static void main(String[] args) {
        // Создаем потоки для "Яйца" и "Курицы"
        Thread eggThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("");
            }
        });

        Thread chickenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("");
            }
        });

        // Запускаем оба потока
        eggThread.start();
        chickenThread.start();

        // Ожидаем окончания потоков без использования join сразу
        while (true) {
            // Проверяем состояние потоков и выводим результат перед завершением одного из них
            if (!eggThread.isAlive() && chickenThread.isAlive()) {
                System.out.println("Курица появилась раньше");
                break;
            }
            if (!chickenThread.isAlive() && eggThread.isAlive()) {
                System.out.println("Яйцо появилось раньше");
                break;
            }
            if (!eggThread.isAlive() && !chickenThread.isAlive()) {
                // Если оба потока завершены одновременно
                System.out.println("Спор не имеет конца!");
                break;
            }
        }

        // Дополнительно вызываем join() для завершения работы программы корректно
        try {
            eggThread.join();
            chickenThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
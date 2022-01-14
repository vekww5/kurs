package ru.rsatu;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class RunProject {
    public static void main(String ... args) {
        System.out.println("Запуск проекта");
        Quarkus.run(args);
    }
}

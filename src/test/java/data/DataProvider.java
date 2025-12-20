package data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProvider {

    public static Stream<Arguments> viewInfoAboutAnimals() {
        return Stream.of(
                Arguments.of(
                        "Медведь", "https://ru.wikipedia.org/wiki/%D0%9C%D0%B5%D0%B4%D0%B2%D0%B5%D0%B6%D1%8C%D0%B8",
                        "Медвежьи", "Медведи всеядны, хорошо лазают и плавают, быстро бегают, могут стоять и проходить короткие расстояния на задних лапах."
                ),
                Arguments.of(
                        "Игуана", "https://ru.wikipedia.org/wiki/%D0%98%D0%B3%D1%83%D0%B0%D0%BD%D0%BE%D0%B2%D1%8B%D0%B5",
                        "Игуановые", "Игуановые распространены в Северной, Центральной и Южной Америке, на Антильских, Галапагосских островах и островах Фиджи."
                ),
                Arguments.of(
                        "Мамонт", "https://ru.wikipedia.org/wiki/%D0%9C%D0%B0%D0%BC%D0%BE%D0%BD%D1%82%D1%8B",
                        "Мамонты", "Они достигали высоты 5,5 метров и массы тела 14—15 тонн; таким образом, мамонты были в два раза тяжелее самых крупных современных наземных млекопитающих — африканских слонов."
                )
        );
    }
}

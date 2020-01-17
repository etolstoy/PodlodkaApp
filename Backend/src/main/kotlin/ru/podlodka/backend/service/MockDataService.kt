package ru.podlodka.backend.service

import org.springframework.stereotype.Service
import ru.podlodka.backend.models.Link
import ru.podlodka.backend.models.Person
import ru.podlodka.backend.models.ShowEpisode
import ru.podlodka.backend.repositories.ShowEpisodeRepository

@Service
class MockDataService(val showEpisodeRepository: ShowEpisodeRepository) {
    // Генерация семпловых данных
    fun mockData(): String {
        showEpisodeRepository.deleteAll()
        for (i in 1..20) {
            val guests = listOf<Person>(generatePerson())

            val episode = ShowEpisode(
                    id = generateRandomString(),
                    name = generateEpisodeName(),
                    number = i,
                    created = 1576571350,
                    length = 6372,
                    desc = generateRandomString(),
                    hosts = generateHosts(),
                    guests = guests,
                    links = generateLinks(),
                    src = "https://soundcloud.com/podlodka/podlodka-126-osoznannost",
                    categories = emptyList(),
                    selections = emptyList()
            )
            showEpisodeRepository.insert(episode)
        }
        return "ok";
    }

    fun generatePerson(): Person {
        return Person(
                generateRandomString(),
                generatePersonName(),
                generateRandomString(),
                generateCompany(),
                generatePhoto()
        )
    }

    private fun generatePhoto(): String {
        return "https://pbs.twimg.com/profile_images/1189904323767078913/jO5X2gDG_400x400.jpg"
    }

    fun generateRandomString(): String {
        return java.util.UUID.randomUUID().toString()
    }

    fun generatePersonName(): String {
        val names = listOf<String>("Иван", "Егор", "Владимир", "Петр", "Алексей", "Сергей", "Вячеслав", "Денис", "Борис", "Николай", "Эдуард")
        val surnames = listOf<String>("Иванов", "Петров", "Толстой", "Цыганов", "Кателла", "Путин", "Аскорбинов", "Гейтс", "Джобс", "Талеб", "Обама")

        return names.shuffled().take(1)[0] + " " + surnames.shuffled().take(1)[0]
    }

    fun generateCompany(): String {
        val names = listOf<String>("Авито", "Яндекс", "JetBrains", "Туту", "Роскачество", "Mail.Ru", "Утконос")
        return names.shuffled().take(1)[0]
    }

    fun generateEpisodeName(): String {
        val part1 = listOf<String>("Теория", "Практика", "Особенности", "Применение", "Боль и ужасы", "Судьба", "Использование")
        val part2 = listOf<String>("Go ", "Rust", "Swift", "Kotlin", "баз данных", "эмпатии", "эмоционального интеллекта", "тестирования", "программирования", "языков программирования", "инцидент-менеджмента", "осознанности", "жизни", "PHP", "фронтенда")

        return part1.shuffled().take(1)[0] + " " + part2.shuffled().take(1)[0]
    }

    fun generateLinks(): List<Link> = listOf<Link>(
            Link(
                    id = generateRandomString(),
                    name = "iTunes",
                    url = "https://apple.co/2Tr7vBf"
            ),
            Link(
                    id = generateRandomString(),
                    name = "Сайт",
                    url = "podlodka.io/128"
            ),
            Link(
                    id = generateRandomString(),
                    name = "Я.Музыка",
                    url = "http://bit.ly/2ZuiYm4"
            )
    )

    fun generateHosts(): List<Person> = listOf<Person>(
            Person(
                    generateRandomString(),
                    "Егор Толстой",
                    generateRandomString(),
                    "Авито",
                    "https://pbs.twimg.com/profile_images/1189904323767078913/jO5X2gDG_400x400.jpg"
            ),
            Person(
                    generateRandomString(),
                    "Стас Цыганов",
                    generateRandomString(),
                    "Туту",
                    "https://pbs.twimg.com/profile_images/1189904323767078913/jO5X2gDG_400x400.jpg"
            ),
            Person(
                    generateRandomString(),
                    "Катя Петрова",
                    generateRandomString(),
                    "Авито",
                    "https://pbs.twimg.com/profile_images/1189904323767078913/jO5X2gDG_400x400.jpg"
            ),
            Person(
                    generateRandomString(),
                    "Евгений Кателла",
                    generateRandomString(),
                    "Яндекс",
                    "https://pbs.twimg.com/profile_images/1189904323767078913/jO5X2gDG_400x400.jpg"
            )
    )
}
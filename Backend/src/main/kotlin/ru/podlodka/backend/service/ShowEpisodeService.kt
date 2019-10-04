package ru.podlodka.backend.service

import ru.podlodka.backend.repositories.ShowEpisodeRepository
import org.springframework.stereotype.Service
import ru.podlodka.backend.models.ShowEpisode
import ru.podlodka.backend.models.Person
import ru.podlodka.backend.models.Link

@Service
class ShowEpisodeService(val showEpisodeRepository: ShowEpisodeRepository){

    fun getAllShowEpisodes(): Collection<ShowEpisode> {
        return showEpisodeRepository.findAll();
    }

    fun getShowEpisodeDetailById(id: String): ShowEpisode? {
        val episode = showEpisodeRepository.findById(id);
        if(!episode.isPresent) {
            throw Exception("ShowEpisode id=$id not found")
        }
        return episode.get();
    }

    // Генерация семпловых данных
    fun mockData(): String {
        showEpisodeRepository.deleteAll()
        for (i in 1..20) {
            val guests = listOf<Person>(generatePerson())

            val episode = ShowEpisode(
                    id = generateRandomString(),
                    name = generateEpisodeName(),
                    number = i,
                    description = generateRandomString(),
                    hosts = generateHosts(),
                    guests = guests,
                    links = generateLinks(),
                    src = "https://soundcloud.com/podlodka/podlodka-126-osoznannost"
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
                generateCompany()
        )
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
                    "Авито"
            ),
            Person(
                    generateRandomString(),
                    "Стас Цыганов",
                    generateRandomString(),
                    "Туту"
            ),
            Person(
                    generateRandomString(),
                    "Катя Петрова",
                    generateRandomString(),
                    "Авито"
            ),
            Person(
                    generateRandomString(),
                    "Евгений Кателла",
                    generateRandomString(),
                    "Яндекс"
            )
    )
}